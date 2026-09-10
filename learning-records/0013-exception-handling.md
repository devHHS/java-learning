# 0013 — exception handling (checked vs unchecked)

- **날짜**: 2026-09-06
- **레슨**: [lessons/0013-exception-handling.html](../lessons/0013-exception-handling.html)
- **문법 기초 큐**: **진행 중, 아직 체크 안 함** (10/11 항목, 다음 세션에 이어서 진행 필요)

## 배운 것 / 겪은 것

- **checked/unchecked 개념 자체가 처음엔 전혀 안 잡혔음.** 레슨 본문(3, 4번 섹션)을 읽고, `MyUncheckedThing`/`MyCheckedThing` 코드 대조, `instanceof` hierarchy 데모까지 보여줬는데도 "아직도 이해가 안 가"가 반복됨. 최종적으로 막힌 지점을 짚어보니 **"check"라는 단어 자체가 뭘 가리키는지**부터 안 잡혀 있었음 (1번 → 2, 3번도 연쇄적으로 막힘).
- **효과 있었던 재접근**: 지난 세션(0012)의 raw type 경험("`<>` 없으면 컴파일러가 타입 안 막아줌")을 "check"의 정의로 그대로 재활용 — "컴파일러가 미리 확인해주냐 안 해주냐"를 raw type 때 이미 겪은 것과 동일한 개념으로 연결하니 그 지점은 바로 이해함. **본인이 최근에 실제로 겪은 컴파일러 동작을 새 용어의 정의로 재활용하는 게 이 학습자에게 잘 통함** — 완전히 새로운 비유보다 효과적.
- 이후 단계적 확인 질문(잔액 부족 → checked인 이유 설명, `InsufficientBalanceException`이 뭘 상속해야 하는지, unchecked면 `throws`가 필요 없는 이유)에는 전부 정확하게 답함. 마지막엔 checked/unchecked + extends + throw/throws를 하나로 엮어서 정확하게 자기 말로 요약함.
- **개념 이해 이후에도 코드 작성에서 별도의 어려움을 겪음**: `try`/`catch`의 실행 모델 자체를 "try 실패하면 대안으로 다른 동작을 catch에 넣는다"로 오해 — 예외를 던지는 호출을 `catch` 안에 넣고 안 던지는 호출을 `try`에 넣는 실수를 반복함(같은 실수를 3번 반복 후 수정). "catch는 try 안에서 실패한 그 코드 자체를 처리하는 것"이라는 실행 흐름 설명 후에야 올바른 구조로 고침.
- 그 외 코드 실수들 (전부 본인이 결국 스스로 고침, 힌트 후):
  - `EmployeeService.save`에서 `return store.put(...)` — `Map.put`이 새로 넣은 값이 아니라 이전 값을 반환한다는 것 모르고 씀.
  - `findByIdOrThrow`에서 `store.get(id).getId()`로 존재 여부 확인 — 존재 안 하면 `NullPointerException`이 먼저 터지는 구조. `containsKey`로 수정.
  - `validateDepartment`에서 `store.containsValue(department)` — 파라미터 검증인데 엉뚱하게 store를 조회하는 로직을 만듦. 스펙 재확인 후 `store` 없이 `null`/`isBlank()` 체크로 수정.
  - IntelliJ가 자동完성해준 catch block 기본 템플릿(`throw new RuntimeException(e)`)을 그대로 둬서 예외를 다시 던지는 실수 — "catch에서 메시지 출력"이라는 원래 목표와 다름을 지적 후 수정.

## 확인된 이해도

- **개념(구술)**: checked/unchecked 정의, 판단 기준(복구 가능성), `extends`로 그 판단을 표현하는 것, `throw` vs `throws` — 최종적으로 전부 정확하게 스스로 종합해서 설명함.
- **코드(hands-on)**: `Employee`, `EmployeeNotFoundException`(unchecked), `InvalidEmployeeDataException`(checked), `EmployeeService`(save/findByIdOrThrow/validateDepartment), `Runner` 전부 시작 코드 없이 작성 → 최종적으로 컴파일·실행 성공, 출력 정확 (`Kim` / `Employee with id 2 does not exist` / `Department cannot be null`).
- **학습자 본인 판단**: "오늘은 여기까지, 다음에 이어서 하자" — generics 때의 "다음으로 넘어가자"와 다른 반응. 이번 항목은 완결됐다고 보지 않고 **다음 세션에 이 주제를 이어갈 것으로 판단**.

## 다음에 참고할 것

- **MISSION.md 큐 체크박스, exception handling 아직 체크하지 말 것.** 다음 세션에서 이 주제를 어떻게 이어갈지(복습 라운드로 갈지, 이어서 새 내용을 조금 더 볼지) 학습자와 먼저 확인.
- **개념 설명 시 새로운 비유를 만들기보다, 최근에 직접 겪은 컴파일러 동작(raw type 등)을 새 용어의 정의로 재활용하는 방식이 효과적** — NOTES.md의 "비유보다 코드 트레이스" 원칙에 한 가지를 추가: 코드 트레이스도 **완전히 새로운 예제보다, 학습자가 최근 세션에서 직접 겪은 사례를 재활용**하는 게 더 잘 통함.
- **try/catch를 처음 가르칠 때, "catch는 try에서 실패한 바로 그 코드를 처리하는 것"이라는 실행 모델을 코드 작성 전에 먼저 명시적으로 설명할 것.** "성공하면 A, 실패하면 B" 같은 일반적인 조건 분기와 헷갈려서 예외 던지는 호출을 catch 안에 넣는 실수가 나왔음 — 다음에 try/catch를 새로 가르칠 일이 있으면 이 오해를 먼저 방지할 것.
- IntelliJ의 자동 catch block 템플릿이 기본으로 `throw new RuntimeException(e)`를 넣어준다는 것도 참고 — 학습자가 의도치 않게 이걸 그대로 두는 경우가 생길 수 있으니, try/catch 관련 레슨에서 "IDE가 자동으로 채워준 코드도 의도와 맞는지 확인" 습관을 짚어줄 것.
