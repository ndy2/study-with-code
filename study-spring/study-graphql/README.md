## 참고

https://danawalab.github.io/spring/2022/06/06/Spring-for-GraphQL.html

https://spring.io/projects/spring-graphql#learn


```graphql
{
  bookById(id: "book-1") {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

```json
{
  "data": {
    "bookById": {
      "id": "book-1",
      "name": "Harry Potter and the Philosopher's Stone",
      "pageCount": 223,
      "author": {
        "id": "author-1",
        "firstName": "Joanne",
        "lastName": "Rowling"
      }
    }
  }
}
```