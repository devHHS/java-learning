# 0015 — lambda와 stream (문법 기초 큐 11/11, 마지막 항목)

- **날짜**: 2026-09-11 (레슨 자체는 2026-09-10에 생성, hands-on은 오늘 진행)
- **레슨**: [lessons/0015-lambda-stream.html](../lessons/0015-lambda-stream.html)
- **문법 기초 큐**: 11/11 hands-on은 완료. **구술 복습(2026-09-12) 결과, 학습자가 "복습 라운드를 한 번 더" 필요하다고 판단 — generics처럼 여러 라운드가 필요한 항목으로 확정. 큐 체크 자체는 유지, 다음 라운드(hands-on, 다른 도메인 + 이번엔 진짜 직접 작성) 세션에서 최종 확정.**

## 이번 세션에서 있었던 것 (일반 패턴과 다른 점)

- **hands-on 코드를 학습자가 아닌 AI가 작성함.** 처음엔 "너가 코드를 작성하는데 TODO 한곳 한곳 단계별로 하자"로 시작 → 확인 질문(AskUserQuestion)으로 "AI가 작성" 의도임을 확인.
- **`Runner.java`(실행 코드)도 AI가 작성.** 이건 0008에서 학습자가 명시적으로 "직접 작성하겠다"고 정했던 방침과 반대 방향. 이번에도 다시 확인 질문을 거쳐 "이번 세션은 예외로 AI가 작성"이라는 답을 받음.
- 즉, **오늘 세션은 방침의 영구적 변경이 아니라 1회성 예외로 처리함.** 다음 레슨부터는 기존 방침(hands-on/Runner 모두 학습자 직접 작성)으로 복귀하는 게 기본값 — 학습자가 다시 명시적으로 "AI가 작성"을 요청하지 않는 한.

## 진행 내용

- `EmployeeAnalytics.java` TODO 3곳: `activeEmployeeNames`(filter+map+collect), `sortedBySalaryDesc`(sorted+`Comparator.comparingDouble().reversed()`), `totalPayrollReduce`(reduce)/`totalPayrollSum`(mapToDouble().sum()) — AI가 단계별로 작성하며 각 줄 설명.
- `Runner.java` — AI가 작성 (Employee 5명, active 3/inactive 2 섞음).
- 컴파일·실행까지 직접 확인 (`javac`/`java`로 AI가 실행) — 결과 검증: active 3명만 필터링됨, salary 내림차순 정확, reduce와 mapToDouble().sum() 결과 일치(14,900,000).
- **학습자가 능동적으로 짚은 것**: lambda parameter 이름이 `e`가 아니어도(`a` 등) 동작하는지 스스로 질문 — 임의(arbitrary) 식별자라는 답을 받고 넘어감. IntelliJ가 `filter(e -> e.isActive())`를 `filter(Employee::isActive)`로 자동 변경한 것도 학습자 쪽에서 발생 — method reference 개념(0015 본문에서 이미 배운 `Employee::getSalary`)과 동일한 패턴이라 설명만 확인.
- `Employee`에 `toString()`이 없어 `sortedBySalaryDesc` 결과가 기본 `Object.toString()`(hashcode)으로 찍히는 문제를 AI가 먼저 짚었고, 학습자 요청으로 `toString()` 추가 후 재실행해 정렬 결과를 눈으로 확인함.

## 구술 복습 결과 (2026-09-12)

Q1~Q4, 코드 없이 말로만 진행:

- **Q1** (filter/map의 functional interface 이름 — Predicate/Function): 첫 시도에 정확.
- **Q2** (`reduce(0.0, (acc, salary) -> acc + salary)`의 identity/accumulator 역할): 처음엔 `sortedBySalaryDesc`(정렬)와 혼동해서 "0.0으로 단위 맞추고 오름차순 정렬"이라고 답함 — reduce가 정렬과 무관하다는 걸 트레이스(acc: 0.0 → 5000000 → 11100000 → 14900000, 어제 결과와 일치)로 짚어준 뒤 정확히 재답변, identity/accumulator 용어까지 스스로 말함.
- **Q3** (`mapToDouble` vs `map` — 왜 `map`+`sum()`은 안 되고 `mapToDouble`+`sum()`은 되는지): "전체적으로 모르겠다"(4번 선택, 후보 나열식 질문에 답함). generics(0010~0012에서 이미 단단해진 개념)를 다리로 연결 — "`Stream<T>`는 generic이라 `T`가 primitive를 못 받아서 `double`이 `Double`로 boxing됨 → `Stream<Double>`은 숫자 전용이 아니라 `.sum()`이 없음 vs `DoubleStream`은 boxing 없이 숫자 전용이라 `.sum()`이 있음"을 설명하자 바로 정확하게 자기 말로 재정리함.
- **Q4** (method reference로 바꿀 수 있는 lambda의 조건 — "파라미터 하나를 그대로 받아 메서드 하나만 호출"): 첫 시도에 정확.

**학습자 자기 판단**: Q1, Q4는 힌트 없이 통과했지만 Q2, Q3는 힌트(트레이스, generics 연결) 이후에야 정확해짐 — 이를 근거로 "복습 라운드를 한 번 더" 필요하다고 판단. **다음 라운드는 다음 세션(날짜 미정)으로 미루고, 오늘은 여기까지.**

## 다음에 참고할 것

- **다음 세션에서 복습 라운드 진행**: generics 패턴(0011, 0012)을 따라 ① 다른 도메인으로 hands-on 코드 작성 — **이번엔 AI가 아니라 학습자가 직접 작성** (0015 hands-on은 AI가 대신 썼던 예외 세션이었으므로, 복습 라운드는 오히려 "진짜 직접 작성"이 필요), ② 구술 복습 반복.
- 복습 라운드에서 특히 다시 확인할 것: reduce의 identity/accumulator를 sorted와 헷갈리지 않는지, `map` vs `mapToDouble`(generic vs primitive-specialized stream, boxing) 구분을 힌트 없이 스스로 설명할 수 있는지. 이 두 개가 이번 라운드에서 막혔던 지점.
- 복습까지 통과하면 큐 완료 최종 확정, MISSION.md의 "다음 세션 방향(복습 한 번 더 vs Spring 개념으로 전환)"을 학습자와 논의.
- **패턴 관찰**: 문법 큐 마지막 항목에서 처음으로 "AI가 코드를 작성"하는 예외가 나옴. 지금까지(0001~0014) 전부 학습자가 직접 작성 → 리뷰 흐름이었던 것과 대비. 다음에도 비슷한 요청("너가 작성해")이 나오면, 확인 질문 없이 바로 기본값(직접 작성)으로 진행하지 말고 이번처럼 의도를 먼저 확인할 것 — 단, 한 번 확인했으니 다음엔 좀 더 가볍게 물어봐도 됨.
- lambda/stream도 generics처럼 **여러 라운드가 필요한 항목**으로 분류됨. 두 항목의 공통점: "완전히 새로운 문법/개념"(generics의 type parameter, stream의 함수형 연산)이라기보다 **기존에 알던 것(loop, 조건문)을 다른 방식으로 표현하는 개념**인데도 오히려 이런 것들이 이 학습자에게는 더 여러 라운드가 필요했다 — try/catch(1라운드로 충분)와 대비. 확정하긴 이르지만, "제어 흐름의 변형"이라고 1라운드로 끝날 거라 예단하지 말 것.
