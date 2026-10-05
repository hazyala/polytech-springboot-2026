# Spring Boot MVC 수업과 BookMarket

Spring MVC·Thymeleaf·검증·인증 수업 예제와 도서·장바구니 웹앱.

| 프로젝트 | 구현 |
|---|---|
| [BookMarket](BookMarket/README.md) | 도서 목록·상세·필터·등록·이미지와 세션 장바구니 |
| [2026Example](2026Example/README.md) | Controller·form binding·validation·exception·Security 챕터 실습 |

두 폴더는 각자 Gradle wrapper를 갖는 독립 Spring Boot 프로젝트다. root 통합 build는 없다. Java toolchain은 둘 다 21이고 Boot 버전은 BookMarket 4.0.3, 2026Example 4.0.4다.

BookMarket의 의존성과 설정에는 JDBC/MySQL이 있지만 현재 `BookRepositoryImpl`은 ArrayList, `CartRepositoryImpl`은 Map을 사용한다. “MySQL로 도서와 장바구니를 저장하는 서비스”로 소개하지 않는다. 실행 준비와 코드의 현재 데이터 저장 방식을 하위 README에 구분했다.

수업 기록과 기능 구현을 설명하는 저장소이며 실제 결제·주문 서비스나 운영 배포는 없다.
