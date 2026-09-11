# 0015 — lambda와 stream (문법 기초 큐 11/11, 마지막 항목)

- **날짜**: 2026-09-11 (레슨 자체는 2026-09-10에 생성, hands-on은 오늘 진행)
- **레슨**: [lessons/0015-lambda-stream.html](../lessons/0015-lambda-stream.html)
- **문법 기초 큐**: 11/11 전부 완료. **단, 이해도 자가평가(구술 복습)는 다음 세션(2026-09-12)으로 미룸 — 이 레코드는 잠정 상태.**

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

## 다음에 참고할 것

- **2026-09-12 세션에서 구술 복습(코드 없이 말로 설명)을 먼저 진행할 것.** 특히 이번엔 학습자가 코드를 직접 타이핑하지 않았으므로(AI가 작성), 다른 큐 항목들보다 storage strength 확인이 더 중요하다 — "이해했다"는 자기 판단을 코드 작성이 아니라 순수 구술로만 확인하게 됨.
  - 확인 포인트: ① `filter`/`map`이 받는 lambda의 functional interface 이름(Predicate/Function)을 스스로 말할 수 있는지, ② `reduce(0.0, (acc, salary) -> acc + salary)`에서 `0.0`과 accumulator 각각의 역할, ③ `mapToDouble`이 `map`과 다른 이유(DoubleStream, boxing 없음), ④ method reference(`Employee::getSalary`)가 lambda와 동일하다는 것.
  - 구술 복습에서 막히면, generics 때처럼 **직접 코드를 처음부터 작성하는 라운드를 하나 더 넣는 것**을 고려 (이번엔 AI가 대신 써줬으니, 오히려 "이번엔 진짜 직접" 라운드가 필요할 가능성 있음).
- 구술 복습까지 통과하면 큐 완료 확정, MISSION.md의 "다음 세션 방향(복습 한 번 더 vs Spring 개념으로 전환)"을 학습자와 논의.
- **패턴 관찰**: 문법 큐 마지막 항목에서 처음으로 "AI가 코드를 작성"하는 예외가 나옴. 지금까지(0001~0014) 전부 학습자가 직접 작성 → 리뷰 흐름이었던 것과 대비. 다음에도 비슷한 요청("너가 작성해")이 나오면, 확인 질문 없이 바로 기본값(직접 작성)으로 진행하지 말고 이번처럼 의도를 먼저 확인할 것 — 단, 한 번 확인했으니 다음엔 좀 더 가볍게 물어봐도 됨.
