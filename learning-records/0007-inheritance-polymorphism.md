# 0007 — inheritance and polymorphism

- **날짜**: 2026-08-15
- **레슨**: [lessons/0007-inheritance-polymorphism.html](../lessons/0007-inheritance-polymorphism.html)
- **문법 기초 큐**: 6/11 완료

## 배운 것

- `extends`로 상속, 무엇이 물려지는지(public/protected는 됨, private/constructor는 안 됨).
- `protected` — 0005에서 미뤘던 부분을 subclass 접근 맥락에서 완결.
- `super(...)` — 부모 constructor를 자식 constructor 첫 줄에서 호출.
- overriding — 부모와 signature가 같은 instance method를 재정의.
- polymorphism — 선언 타입이 아니라 실제 object 타입의 override된 method가 실행됨 (virtual method invocation).
- 이미 써본 `IllegalArgumentException`이 `RuntimeException`을 상속받은 class라는 걸 인지 — inheritance를 몰랐을 때도 이미 쓰고 있었다는 연결.

## 확인된 이해도

- polymorphism 개념을 한 번에 이해하지 못해 **세 번 다른 방식으로 재설명**함:
  1. 상자/라벨 비유
  2. 코드 트레이스(`a.send()` vs `b.send()`, 같은 타입 다른 출력)
  3. 학습자가 직접 자기 말로 요약("리스트 타입은 Notification, 실제 작동은 new로 정의된 것") → 정확히 맞아서 확인만 해줌.
  - 비유보다 **최소 코드 + 실행 결과 대조**가 이 학습자에게 더 잘 통했다. 다음에 어려운 개념 나오면 비유보다 코드 트레이스를 먼저 시도할 것.
- `super`도 추가로 쉽게 설명 요청 — `Notification`/`EmailNotification` 코드에서 "이미 부모가 하는 일을 또 안 쓰고 불러쓰는 것"으로 설명하니 바로 이해함.
- **hands-on**: `practice/0007-inheritance-polymorphism/`의 `EmailNotification.java`, `SmsNotification.java` TODO를 스스로 채움. `NotificationDemo.java`(완성 제공)를 실행하려다 "`Notification.java`엔 `main`이 없는데 어떻게 실행하냐"는 질문 — **부모 class와 실행 진입점(entry point)이 있는 class가 다를 수 있다**는 걸 짚어줌.
- `SmsNotification.send()`에서 괄호 닫는 기호(`)`) 누락 버그를 직접 발견 못했으나, 지적 후 스스로 고쳐서 정상 출력 확인함.
- 최종 실행 결과 3줄 모두 정상 — polymorphism이 실제로 동작하는 걸 눈으로 확인함.

## 다음에 참고할 것

- 다음 큐 항목: interface와 abstract class — "언제 inheritance 대신 interface/abstract class를 쓰는가"로 자연스럽게 이어짐. 0007 레슨 본문에도 이 질문을 다음 큐로 미룬다고 명시해둠.
- **개념 설명 방식 선호**: 비유 하나로 안 끝나면 코드 트레이스로 전환하는 게 효과적. 이 학습자는 추상적 비유보다 실제 코드 실행 결과 비교를 더 빨리 흡수함 — NOTES.md에 추가 필요.
- IntelliJ에서 "main 없는 파일은 실행 못 한다"는 실행 메커니즘 자체가 아직 완전히 체화되지 않은 것으로 보임 — 다음 hands-on에서도 "어느 파일을 실행해야 하는지" 명시적으로 안내할 것.
