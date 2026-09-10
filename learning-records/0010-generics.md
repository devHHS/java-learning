# 0010 — generics

- **날짜**: 2026-08-24
- **레슨**: [lessons/0010-generics.html](../lessons/0010-generics.html)
- **문법 기초 큐**: 9/11 완료

## 배운 것

- generics 없이 `Object`로 뭐든 담으면 타입 오류가 컴파일 타임이 아니라 런타임에 `ClassCastException`으로 터진다.
- `class PagedResult<T>`처럼 클래스 자체를 타입 매개변수(type parameter)로 정의하는 법, `new PagedResult<Item>(...)`처럼 실제 타입(type argument)을 채워 쓰는 법.
- generic method: `public static <T> T firstOrNull(...)` — `<T>`는 return type 앞에 선언한다.
- Spring Data JPA `JpaRepository<Receipt, Long>` / Quarkus Panache `PanacheRepository<Person>`가 이 개념의 실전 사용례라는 것 — `T`는 관리할 entity, 두 번째 자리(`ID`)는 그 entity의 primary key 타입.

## 확인된 이해도

- **hands-on**: `PagedResult.java`(constructor + getter 2개 TODO), `PageUtils.java`(generic static method `firstOrNull` TODO), `Runner.java`(완성본 없이 처음부터 직접 작성).
  - `PagedResult`: 처음에 constructor에서 `this.totalCount = totalCount;`를 빠뜨렸다가, "getTotalCount() 호출하면 뭐가 나올까(int 기본값)"라는 질문에 스스로 원인을 찾아 고침.
  - `PageUtils.firstOrNull`: `isEmpty()` 체크 → `null` 또는 `get(0)` 로직, `<T>` 위치까지 한 번에 정확히 작성.
  - `Runner.java`: item 4개 생성 → `PagedResult<Item>` 생성(totalCount를 실제 개수보다 크게 잡아 "전체는 더 많다" 상황 반영) → `firstOrNull` 호출 → 빈 리스트 케이스까지 스스로 추가 테스트. 요구사항 4단계를 빠짐없이 커버함.
- **퀴즈 품질 이슈를 학습자가 직접 잡아냄**: 초안의 퀴즈 3문항 중 2번(빈칸 채우기인데 정답이 빈칸에 들어갈 말이 아니라 질문 속 단어로 잘못 걸려있던 것), 3번(정답이 질문 문장 안에 그대로 노출돼 있던 것 + 본문은 "primary key"로 가르쳤는데 정답은 인용문 속 "identifier"로 걸려있던 것)을 스스로 지적해서 수정함. 문제를 발견하는 과정 자체가 generics 개념을 다시 짚는 효과가 있었음.

## 파생된 작업 — practice 폴더 구조 변경

- hands-on 중 `practice/0009-collections/Runner.java`와 `practice/0010-generics/Runner.java`가 (둘 다 default package) IDE 전체 빌드 시 class 이름 충돌 발생. 학습자가 "package 선언으로 근본 해결"을 요청.
- `.idea/java-learning.iml`에서 레슨 폴더 각각이 독립 Sources Root로 등록돼 있다는 걸 확인 → 단순 `package` 선언만으론 안 되고, 레슨 폴더 안에 `p{번호}` 물리 하위 폴더를 만들어 그 안에 파일을 넣어야 IntelliJ가 인식함.
- `practice/` 전체 레슨 폴더(0002~0010)에 이 구조를 일괄 적용. 기존 레슨(0003~0006) 본문에서 정확한 파일 경로를 언급하던 곳도 `p{번호}/` 세그먼트를 추가해 갱신. 자세한 내용은 `NOTES.md`의 "practice 폴더 package 규칙" 항목.
- **앞으로 새 레슨의 practice 파일은 처음부터 `practice/{레슨폴더}/p{번호}/` 안에 만들고 `package p{번호};`를 선언할 것.**

## 다음에 참고할 것

- **세션 종료 시 학습자가 "오늘 한 것에 대해 이해를 제대로 못 했다"고 직접 평가함.** hands-on(TODO 3개, Runner 작성)은 다 해냈지만 개념이 아직 단단하지 않다고 판단 — 다음 세션은 **exception handling(다음 큐 항목)으로 바로 넘어가지 말고 generics 복습 레슨을 먼저 진행**한다. 0003 때와 같은 패턴 (NOTES.md "복습 세션" 참고).
- 복습 레슨은 `PagedResult<T>`가 아닌 다른 도메인(예: `ApiResponse<T>`, `Result<T>` 같은 실무 패턴)으로, 시작 코드 없이 재연습.
- 문법 기초 큐가 이제 하나(lambda와 stream)만 남았는데, 그건 0009에서 이미 실전으로 써본 상태라 처음부터 가르치지 말고 정리 위주로 가볍게 진행할 것 (NOTES.md에 기록됨).
