# 0014 — review: exception handling

- **날짜**: 2026-09-07
- **레슨**: [lessons/0014-review-exception-handling.html](../lessons/0014-review-exception-handling.html)
- **문법 기초 큐**: **exception handling 체크 완료.** 큐 10/11.

## 배운 것 / 재확인된 것

- **Quick recall (하루 뒤)**: checked/unchecked 관련 용어 3문항 전부 정확히 기억. 개념은 하루가 지나도 유지됨 — 0013 마지막에 도달한 이해가 storage strength까지 갔다는 신호.
- **try/catch 실행 흐름 예측 (Part 2)**: 코드를 실행하지 않고 두 스니펫의 출력을 예측하게 함. 스니펫 B는 0013의 실수(예외 나는 호출이 `catch` 안에 있는 경우)와 정확히 같은 모양으로 설계 — 학습자가 정확히 예측했고("try 안에서 실패하지 않았으니까 catch가 실행될 이유가 없어"), 이유까지 정확하게 설명함.
- **Hands-on (Order/Payment 도메인, 힌트 없이)**: `Order`, `OrderNotFoundException`(unchecked), `InsufficientBalanceException`(checked), `OrderService`(save/findByIdOrThrow/validate), `Runner` 전부 시작 코드 없이 작성. `findByIdOrThrow`는 처음부터 `containsKey`로 정확하게 작성(0013에서 겪었던 NPE 실수 재발 없음). `Runner`의 두 `try/catch` 블록 모두 **힌트 없이 첫 시도에** 올바른 구조(예외 나는 호출이 `try` 안)로 작성 — 0013에서 반복했던 실수가 완전히 사라짐.
- method 이름을 스펙(`processPayment`)과 다르게 `validate`로 지었음 — 기능은 정확했고, 이름 자체는 문제 삼지 않음.

## 확인된 이해도

- 0013에서 미완이었던 두 지점(checked/unchecked 개념, try/catch 실행 모델) 모두 이번 세션에서 힌트 없이 정확하게 재현함.
- **학습자 본인 판단**: "단단해진 것 같아, 다음으로 넘어가자" — generics 때와 마찬가지로 복습 라운드 이후 확신을 표현. exception handling은 이번 한 번의 복습으로 충분했음 (generics는 3라운드 필요했던 것과 대비됨).

## 다음에 참고할 것

- **MISSION.md 큐 체크 완료, 다음은 lambda와 stream (큐 11/11, 마지막 항목).** 단, NOTES.md에 이미 기록된 대로 0009(collections)에서 학습자가 lambda/stream을 이미 실전에서 써본 적 있으므로, 완전히 새로 가르치기보다 정리/복습 위주로 가볍게 진행할 것.
- **개념 습득 후 "코드 없이 예측하기"가 실행 모델 오해를 고치는 데 효과적이었음.** 0013에서 코드를 직접 쓰다가 반복했던 실수를, 코드 작성 전에 읽기 전용 예측 연습으로 먼저 교정하니 hands-on에서 재발하지 않음 — 앞으로 "코드 작성 전 실행 흐름이 오해될 만한 개념"이 나오면 이 패턴(정답 모양 + 오해를 그대로 재현한 오답 모양, 둘 다 예측시키기)을 먼저 시도할 것.
- exception handling은 개념(1일 소요) → 복습 1라운드(다음 날)로 총 2세션 만에 안정화됨. generics(3라운드)보다 빠름 — 이 학습자에게는 "완전히 새로운 추상 개념"(generics)보다 "이미 알고 있는 조건문/제어흐름의 변형"(try/catch)이 더 빨리 안정화되는 경향일 수 있음. 확정하기엔 이르지만 다음에 비슷한 패턴이 보이면 참고.
