# Spring MVC 챕터 실습

날짜·챕터별 Controller에서 parameter·form binding·validation·exception·Security를 확인하는 독립 Spring Boot 프로젝트.

`controller/`의 Chap·EX 예제와 `domain/`의 Member·Person·Product 및 custom validator, `templates/`의 각 화면을 함께 읽는다. 모든 endpoint가 하나의 제품 기능으로 연결된 앱은 아니다.

Java 21, Spring Boot 4.0.4, Thymeleaf, MVC, Validation, Security, Lombok을 사용한다. `application.properties`의 multipart 임시 경로는 `D:/upload`다. root 통합 빌드는 없으므로 이 폴더의 wrapper를 사용한다.

```bash
cd 2026Example
bash gradlew bootRun
```

저장소 루트 기준이다. route는 각 Controller annotation을 보고 선택하며 auth 조건은 `configure/SecurityConfiguration.java`를 확인한다. 외부 API·JPA/DB를 사용하는 서비스로 소개하지 않는다. `src/test/`에는 기본 Spring context test가 있다.
