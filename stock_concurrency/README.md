# 인프런 - [재고 시스템으로 알아보는 동시성 이슈 해결 방법](https://www.inflearn.com/course/%EB%8F%99%EC%8B%9C%EC%84%B1%EC%9D%B4%EC%8A%88-%EC%9E%AC%EA%B3%A0%EC%8B%9C%EC%8A%A4%ED%85%9C/dashboard)
## 한정된 재고 내에서 여러명이 동시에 상품 주문을 하는 경우?!

### 상황
- 100개의 재고를 가진 상품을 여러명이 동시에 주문
- 정확하게 100개의 상품만 판매되어야 한다.

### 해결 방법
1. Application 레벨에서 해결
2. RDBMS 레벨에서 해결 : MySQL에서 제공하는 Lock을 사용
3. NoSQL 레벨에서 해결 : Redis를 사용
