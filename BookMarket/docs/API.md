# BookMarket HTTP/API

모든 경로 앞에 context path `/BookMarket`을 붙인다. `SecurityConfig`는 `/books/add`에 ADMIN을 요구하고 나머지는 permitAll, CSRF는 비활성화되어 있다. 장바구니 세션 ID는 사용자 인증과 별개다.

## 도서·로그인

| Method | Path | Request | Response |
|---|---|---|---|
| GET | `/home` | 없음 | welcome HTML |
| GET | `/books`, `/books/all` | 없음 | 목록 HTML |
| GET | `/books/book` | query id | 상세 HTML |
| GET | `/books/{category}` | category | 목록 HTML / 예외 화면 |
| GET | `/books/filter/{bookFilter}` | matrix variables category, publisher | 교집합 목록 HTML |
| GET | `/books/add` | ADMIN session | 등록 폼 HTML |
| POST | `/books/add` | ADMIN, Book multipart form | 오류 폼 또는 목록 redirect |
| GET | `/books/download` | query file | application/download 파일 |
| GET | `/login`, `/loginfailed` | 없음 | 로그인/실패 화면 |
| POST | `/login` | username, password form | Security 로그인, 등록 화면 redirect |
| GET / POST | `/logout` | Controller / Security 경로 | 로그아웃 페이지 / Security logout |

Book form 주요 필드: bookId, name, unitPrice, author, description, publisher, category, unitsInStock, releaseDate, condition, bookImage. bookId는 isbn+숫자 pattern과 커스텀 검사, name은 4~50자, unitPrice는 필수·0 이상·정수 8자리/소수 2자리 규칙이다. 커스텀 BookValidator와 UnitsInStockValidator 조건도 적용된다. 자동 JSON 오류 schema는 없다.

## 장바구니

| Method | Path | Request | Response |
|---|---|---|---|
| GET | `/cart` | HTTP session | 해당 session ID 경로 redirect |
| GET | `/cart/{cartId}` | path ID | cart HTML |
| POST | `/cart` | Cart JSON | 생성 Cart JSON, 기본 200 |
| PUT | `/cart/{cartId}` | path ID | 조회 Cart JSON, 기본 200 |
| PUT | `/cart/book/{bookId}` | bookId + 현재 session | 추가, 204 |
| DELETE | `/cart/book/{bookId}` | bookId + 현재 session | 제거, 204 |
| DELETE | `/cart/{cartId}` | cartId | 장바구니 제거, 204 |

Cart JSON에는 cartId, cartItems map, grandTotal이 있다. CartItem은 book, quantity, totalPrice를 표현한다. `PUT /cart/{cartId}`는 실제 소스의 조회 method이며 의미를 바꿔 문서화하지 않는다. create/delete의 중복·미존재 오류는 repository 예외를 따른다. 다른 cartId 접근을 본인 session으로 제한하는 별도 인증 검사는 현재 없다.

[Controller 소스](../src/main/java/pollytech/aisw/bookmarket/controller/) · [SecurityConfig](../src/main/java/pollytech/aisw/bookmarket/config/SecurityConfig.java) · [Book](../src/main/java/pollytech/aisw/bookmarket/domain/Book.java)
