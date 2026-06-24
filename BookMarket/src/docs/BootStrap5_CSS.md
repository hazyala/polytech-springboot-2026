># Bootstrap 5(부트스트랩 5) 프레임워크
>> **부트스트랩은 클래스 이름만으로 디자인을 쉽게 적용할 수 있도록 직관적인 약자를 사용
코드에 사용된 CSS 클래스들의 약자와 의미**
---
### 1. 여백 (Spacing)

> 패딩(`p`)과 마진(`m`)의 방향과 크기를 지정합니다.

* `p-5`: Padding (안쪽 여백) 크기 5
* `py-4`, py-5: Padding Y-axis (위, 아래 안쪽 여백) 크기 4 및 5
* `pb-3`: Padding Bottom (아래쪽 안쪽 여백) 크기 3
* `pt-3`: Padding Top (위쪽 안쪽 여백) 크기 3
* `mb-4`: Margin Bottom (아래쪽 바깥 여백) 크기 4
* `mt-4`: Margin Top (위쪽 바깥 여백) 크기 4

### 2. 그리드 및 레이아웃 (Grid & Layout)

> 화면의 뼈대를 잡고 영역을 나눕니다.

* `container`: 중앙에 정렬되는 반응형 고정 너비 컨테이너
* `container-fluid`: 화면 전체 너비(100%)를 차지하는 꽉 찬 컨테이너
* `row`: 그리드 시스템에서 가로 행(Row)
* `col-md-8`, `col-md-12`: Column Medium. 중간 크기 화면(md, 보통 태블릿 이상)에서 전체 12칸 중 각각 8칸, 12칸을 차지하는 열

### 3. 텍스트 및 글꼴 (Typography)

> 글자의 크기, 굵기, 정렬, 색상을 지정합니다.

* `fs-4`: Font Size (글꼴 크기) 4단계
* `fw-bold`: Font Weight Bold (글꼴 굵게)
* `display-5`: 일반 제목(h1~h6)보다 더 크고 얇게 강조되는 디스플레이용 제목 5단계
* `text-center`: 텍스트 가운데 정렬
* `text-decoration-none`: 텍스트 꾸밈 없음 (주로 `<a>` 태그의 밑줄을 제거할 때 사용)
* `text-body-emphasis`: 본문 텍스트 강조 색상 (주로 더 짙은 검은색/흰색)
* `text-body-secondary`: 본문 텍스트 보조 색상 (주로 약간 흐린 회색)

### 4. 플렉스박스 정렬 (Flexbox)

> 요소들을 유연하게 배치하고 정렬합니다.

* `d-flex`:Display Flex (해당 요소를 플렉스 컨테이너로 만듦)
* `align-items-center`:플렉스 요소들을 교차축(수직) 중앙에 정렬
* `align-items-md-stretch`:중간 크기(md) 화면 이상에서 플렉스 요소들을 교차축 방향으로 꽉 차게 늘림(Stretch)

### 5. 배경, 테두리 및 크기 (Background, Border, Size)

* `bg-body-tertiary`:Background. 본문 테마 기준 3차(Tertiary) 배경색 (일반적으로 매우 옅은 회색)
* `border-top`, `border-bottom`:각각 위쪽, 아래쪽에 테두리(Border) 선을 추가
* `rounded-3`:모서리 둥글게(Border Radius) 크기 3단계
* `h-100`:Height 100% (높이를 부모 요소의 100%로 꽉 채움)