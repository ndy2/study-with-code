
findByUserId 의 호출당 1초의 sleep 을 걸어두고 
아래의 실행 코드를 통해 소요 시간을 확인해보자

실행 코드 
```java
@EventListener(ApplicationReadyEvent.class)
	public void runApp() {
		addressRepository.insert("user1", "서울");
		addressRepository.insert("user2", "평양");
		final StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		System.out.println(addressRepository.findByUserId("user1"));
		System.out.println(addressRepository.findByUserId("user2"));

		System.out.println(addressRepository.findByUserId("user1"));
		System.out.println(addressRepository.findByUserId("user2"));
		stopWatch.stop();

		System.out.println("time = " + stopWatch.getTotalTimeSeconds());
	}

```

실행 결과 
```
time = 4.013845375
```


### 4.1 @Cacheable
- cache 를 추가하는 가장 간단한 방법은 @Cacheable 어노테이션을 추가하는 것
- 그리고 캐쉬 저장소의 이름을 인자로 추가하면 된다.

`@Cacheable("addresses")` 을 findByUserId 메서드에 추가
```java
@Cacheable("addresses")
public String findByUserId(String userId) {
    sleep();
    return store.get(userId);
	}
```

```
time = 2.013845375
```

### 4.2 @CacheEvict
- 모든 메서드에 @Cacheable 을 추가하면 어떤 문제가 있을까?
- 문제는 크기이다. 자주 사용하지 않는 값들 까지 캐쉬해버리고 싶지는 않다.
- 캐쉬는 종종 커지고 오래되고 사용하지 않는 데이터를 보관하고 있고는 한다.

@CacheEvict 어노테이션을 통해 제거할 값을 명시하여 fresh 한 값들이 캐쉬에 다시 로드 되도록 지정할 수 있다.

```java
@CacheEvict(value="addresses", allEntries=true)
public String findByUserId(String userId) {
    sleep();
    return store.get(userId);
	}
```
```java
time = 4.021833542
```

- 캐쉬는 적절한 시점에 제거되어야 한다.
- @CacheEvict 는 기본적으로 메소드의 키 값에 해당하는 캐시만 제거하낟.
- 캐시에 저장된 값을 모두 제거할 필요가 있다면 allEntries 엘리먼트를 true 로 지정한다.


### 4.3 @CachePut
- @CacheEvict 는 사용하지 않는 entry 를 제거하여 거대한 cache 에서 원하는 entry 를 조회하는 오버헤드를 줄인다.
- 우리는 너무 많은 데이터를 캐쉬에서 제거하고 싶지는 않다.
- 대신, 변경하는 시점에 선택적으로 엔트리를 업데이트 하고 싶다.
- @Cacheable 은 method 의 실행을 skip 하는 반면 @CachePut 을 실제 메서드를 호출하고 결과를 캐쉬에 저장한다.

```java
@CachePut("addresses")
public String findByUserId(String userId) {
    sleep();
    return store.get(userId);
}
```
```java
time = 4.016494792
```

- 드물지만 메소드를 캐시에 값을 저장하는 용도로만 사용하기 위해 @CachePut 을 이용한다.