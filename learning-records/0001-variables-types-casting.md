# 0001 — variables, types, type casting

- **날짜**: 2026-08-04
- **레슨**: [lessons/0001-variables-types-casting.html](../lessons/0001-variables-types-casting.html)
- **문법 기초 큐**: 1/11 완료

## 배운 것

- primitive type 8종 (`byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`)과 각각의 실무 용도.
- widening(자동)과 narrowing(수동 캐스팅 필요) 캐스팅의 차이.
- `double`이 이진 부동소수점이라 10진 소수를 정확히 표현 못 해 돈 계산에 부적합하다는 것. → invoice-app 금액은 이후 `BigDecimal`로 전환 필요 (아직 미착수).

## 확인된 이해도

- 퀴즈 3개 정답.
- 전이 질문(`int totalItems * double avgPrice`를 `int`에 대입)에 대해 스스로 "narrowing이라 캐스팅 필요"라고 정확히 설명함. 단순 암기가 아니라 widening/narrowing 규칙을 실제 상황에 적용할 수 있음을 확인.

## 다음에 참고할 것

- `BigDecimal`은 아직 안 배움 — collections/generics 큐 이후, invoice-app에서 금액 다룰 때 실제로 필요해지는 시점에 도입 예정 (RESOURCES.md에 메모됨).
- 다음 큐 항목: control flow (if/switch/for/while), 복습 위주로 빠르게.
