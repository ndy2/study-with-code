### Spring Event 예제 
참고 - https://github.com/tongnamuu/SpringEvent

- step0 - project setting 간단한 User 생성, 조회 애플리케이션
- step1 - event 없이 깡 service 주입 사용
- step2 - ApplicationEvent & ApplicationListener
- step3 - @EventListener & PojoEvent 방식

## `@EventListener`!
기존의 Spring event 방식 (step2) 에서는

이벤트 객체는 ApplicationEvent 를 구현하고 이벤트 리스너는  ApplicationListener 를 구현해야 해서 Pojo 방식의 구현이 불가능 하였습니다.

Spring 4 버전 이상으로 오라오며 어노테이션 방식의 (step3) 이벤트 처리를 지원하는데 그 핵심이 되는 어노테이션이 
`@EventListener` 입니다

EventListener 어노테이션의 JavaDoc 을 읽어 봅시다.
```javadoc
method 를 application 의 event 로 지정하는 어노테이션이다.

지정 메서드가 단 하나의 Event 타입을 처리하게 하고 싶으면 
해당 메서드의 인자를 대상 Event 타입 하나로 지정하면 된다.

지정 메서드가 여러개의 Event 타입을 처리하게 하고 싶다면
classes 로 지정해주면 된다. 이때 대상 메서드의 인자를 정의 할 수 없다.
-> 사실 별로 좋은 설계 같지 않다. 굳이 필요하다면 상속 계층 을 고려하자
```

```javadoc
Event 는 ApplicationEvent 혹은 임의의 Object 모두 가능하다.
```

```javadoc
EventListener 메서드의 호출을 내부적으로 `EventListenerMethodProcessor`에 의해서 이루어 진다. 
```

```javadoc
EventListener 메서드가 void 가 아닌 타입의 리턴을 가진다면
대상 메서드의 리턴은 새로운 이벤트로서 동작한다.

리턴 타입이 배열 혹은 컬렉션이라면 각 원소가 새로운 이벤트로서 발행된다.
```

...

```javadoc
event 를 비동기 처리하고 싶으면 Spring의 @Async 어노테이션과 함께 사용하면 된다.
이때 두가지 주의사항에 유념하자
1. 비동기 이벤트 리스너가 예외를 던진다면 호출자에게 전달되지 않는다.
2. 비동기 이벤트 리스너의 메서드의 반환값으로 새로운 이벤트를 발행할 수 없다.
   만약 메서드의 처리 이후 추가적인 이벤트 발행이 필요한 경우 ApplicationEventPublisher 를 통해 수동으로 발행해야 한다.
```

꽤 흥미로운 내용이 많은것 같다.

특히 리턴으로 새로운 이벤트를 발행할 수 있다는 점과
@Async 와 함께 사용할때의 주의 점이 인상적이다.
---

### `@TransactionalEventListener`
요 어노테이션의 javadoc 도 읽어보자

```javadoc
TransactionPhase 에 따라 호출 되는 `EventLisner` 임
요 인터페이스를 구현 한 것과 같음 TransactionalApplicationListener
```

TransactionPhase 에 따라 정교하게 이벤트를 적용하고 싶다면 사용할 수 있다.

`TransactionPhase`
- AFTER_COMMIT (기본값) - 트랜잭션이 성공적으로 마무리(commit)됬을 때 이벤트 실행
- AFTER_ROLLBACK – 트랜잭션이 rollback 됬을 때 이벤트 실행
- AFTER_COMPLETION – 트랜잭션이 마무리 됬을 때(commit or rollback) 이벤트 실행
- BEFORE_COMMIT - 트랜잭션의 커밋 전에 이벤트 실행

