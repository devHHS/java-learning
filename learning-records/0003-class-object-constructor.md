# 0003 — class, object, constructor

- **날짜**: 2026-08-10
- **레슨**: [lessons/0003-class-object-constructor.html](../lessons/0003-class-object-constructor.html)
- **문법 기초 큐**: 3/11 완료

## 배운 것

- class(설계도) / object(`new`로 생성된 실체) / constructor(생성 시점에 실행, field 초기화) 개념.
- constructor를 하나라도 직접 선언하면 default constructor는 자동 생성되지 않는다.
- constructor에서 invariant를 검증해 잘못된 상태의 object가 아예 생성되지 못하게 막는 패턴(fail fast) — `Money(currency, amountInCents)`에서 음수 금액이면 `IllegalArgumentException`.

## 확인된 이해도

**hands-on 연습**: `practice/0003-class-object-constructor/Money.java` — `amountInCents`(int), `currency`(String) field를 가진 value object. 첫 시도부터 완성까지 여러 라운드의 디버깅을 스스로 진행:

1. `add()`가 `if` 블록 밖의 `throw`문으로 항상 예외를 던지는 구조적 버그 — 힌트(if/else 필요성) 후 스스로 `if-else`로 분기 수정.
2. 되돌아간 시행착오: `add()`가 예외 object를 `return`하는 잘못된 방향으로 갔다가, "반환 vs 던지기"의 차이를 짚어준 뒤 `throw`로 재수정.
3. constructor에서 `this.currency = currency;`만 있고 `this.amountInCents = amountInCents;`가 누락된 버그를 실행 결과(항상 0)로 발견 — field 대입 누락이 원인임을 스스로 찾지 못해 힌트 필요했음. **field 초기화를 빠뜨리면 int는 기본값 0으로 조용히 남는다**는 것을 실제 버그로 체감.
4. `amountInCents += other.amountInCents`가 새 object를 만드는 동시에 원본 object를 변형시키는 부작용을 인지 — `+=`와 `+`의 차이(대입 vs 순수 계산)를 실제 코드에서 구분.
5. `System.out.print(moneyObject)`가 `toString()` 미구현 시 주소값 비슷한 문자열을 출력한다는 것을 인지하고 `.amountInCents`로 우회.
6. **실행 순서 오개념**: `System.out.print(...)` 줄을 주석 처리하면 관련 예외도 안 날 거라 생각했으나, `new Money("EUR", -10)` 같은 **object 생성 자체가 그 줄에서 바로 실행**되어 print와 무관하게 예외가 던져진다는 것을 직접 확인. constructor 실행 시점 = 그 줄이 실행되는 시점이라는 게 아직 완전히 체화되지 않았던 지점 — 이번에 명시적으로 짚어줌.

최종적으로 세 가지 요구 케이스(정상 생성+더하기, 음수 금액 생성 시 예외, 통화 불일치 시 예외)를 각각 별도 실행으로 직접 확인함.

## 다음에 참고할 것

- 다음 큐 항목: access modifiers (public/private/protected).
- **관찰**: field 초기화 누락, 제어 흐름(if 밖으로 코드가 흘러가는 것), object 생성 시점과 부수효과(`+=`) 관련해서 각각 한 번씩 힌트가 필요했다. 두세 라운드 디버깅 끝에는 스스로 원인을 찾아 고쳤음 — 처음 접하는 개념일수록 첫 힌트 후엔 빠르게 따라옴.
- `toString()` 오버라이드는 다루지 않음 — access modifiers/static 이후 자연스러운 지점에서 다시 등장시킬 것.
- try-catch 없이 예외 케이스를 하나씩 주석 처리하며 테스트하는 방식이 다소 번거로웠음 — exception handling 큐 항목에서 try-catch를 배우면 이 워크플로우 자체가 개선된다는 걸 그때 짚어줄 것.
