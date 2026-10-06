# Spring MVC 입력·검증·권한 실습

query·path·form 입력을 Controller에 연결하고 검증 오류·예외·로그인 권한을 Thymeleaf 화면에서 확인한 Spring Boot 수업 프로젝트.

## 구현한 예제

| 위치 | 처리 내용 |
|---|---|
| `controller/Chap05_01Controller` | RequestParam·PathVariable·MatrixVariable 값 읽기, Model 전달 |
| `controller/Chap09_*` | Member·Person 폼 binding, Bean Validation과 custom validator |
| `controller/Chap10_01Controller` | 로그인·권한별 페이지와 로그아웃 |
| `controller/Chap11_01Controller`·`exception/` | 예외 발생과 화면 오류 처리 |
| `controller/EX*`·`Chap07_*`·`Chap13_*` | 챕터별 MVC 입력·화면 예제 |

Java 21, Spring Boot 4.0.4, Thymeleaf, Validation, Security, Lombok을 사용한다. `domain/`은 폼 객체·validator, `templates/`는 챕터별 화면이다. 별도 사용자 DB 대신 Security의 `InMemoryUserDetailsManager`에 guest·manager·admin 계정을 등록한다.

## 실행과 첫 예제

저장소 루트에서:

```bash
cd 2026Example
bash gradlew bootRun
```

기본 주소 localhost:8080에서 `/chap0501?id=guest&pwd=sample`로 query 값을 전달하는 예제를 볼 수 있다. 폼 로그인 화면은 `/exam10_01/exam05`, 계정은 `SecurityConfiguration`의 `guest / g1234`, `manager / m1234`, `admin / a1234`다. 역할별 URL 규칙도 같은 설정에 있다.

`application.properties`의 multipart 임시 경로는 `D:/upload`다. 파일 입력 예제에는 해당 환경에 맞는 폴더가 필요하다. `src/test/`에는 Spring context test가 있다.
