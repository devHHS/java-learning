# 0008 — interface and abstract class

- **날짜**: 2026-08-16
- **레슨**: [lessons/0008-interface-abstract-class.html](../lessons/0008-interface-abstract-class.html)
- **문법 기초 큐**: 7/11 완료

## 배운 것

- interface — "계약(contract)". 몸통 없는 method signature만, field는 사실상 상수만, `implements`로 구현, 여러 개 동시에 가능.
- abstract class — 몸통 있는 method(공유 코드)와 몸통 없는 abstract method(강제)를 섞어서 가질 수 있음. `extends`는 하나만.
- 핵심 차이: abstract class는 자식들에게 **코드를 나눠줄 수 있고**, interface는 나눠줄 코드가 없음(계약만).
- `extends`는 하나, `implements`는 여러 개 — 한 class가 여러 계약(interface)을 동시에 만족해야 할 때 interface가 abstract class로 대체 안 되는 이유.
- Oracle의 "언제 abstract class / 언제 interface" 공식 가이드라인.

## 확인된 이해도

- 처음 코드 대조(0007 방식 그대로 재시도)로 설명했으나 **이번엔 통하지 않음** — "abstract, interface. 그래도 이해를 못 했어 초등학생에게 설명하듯이 다시 설명해"라고 명시적으로 요청.
  - **시험지 비유**(interface = 백지 시험지, abstract class = 선생님이 반쯤 풀어준 시험지)로 전환한 뒤에야 "이제 이해됐어"라는 반응.
  - **NOTES.md의 "비유보다 코드 트레이스" 원칙이 이번엔 반대로 작동함** — 0007(polymorphism)은 코드 대조가 통했지만, 0008(interface vs abstract class)은 비유가 먼저 통하고 코드는 그 다음 확인 단계로 써야 이해가 됨. 개념마다 어느 쪽이 먼저 통하는지 다를 수 있다는 신호. 다음에 새 개념 도입 시, 학습자가 코드 대조에 "이해 못 했다"고 하면 바로 쉬운 비유로 전환할 것 (역방향도 시도해볼 것).
- 비유 이해 후에도 "그러면 그냥 다 abstract로 하면 안 돼?"라는 핵심 질문을 스스로 제기 — Java의 단일 extends 제약과 다중 implements를 코드(`extends PaymentMethod implements Auditable`)로 보여주자 바로 납득.
- **hands-on**: `CardPayment.java`, `BankTransferPayment.java`의 TODO(`extends`, `super(accountId)`, `process()` override)를 스스로 작성.
  - `CardPayment`: 로직은 정확. `System.out.print`(개행 없음) 사용 — `println`으로 고치도록 안내.
  - `BankTransferPayment`: 로직 정확, 오타 하나("계좌이제" → "계좌이체") 수정.
  - `Demo.java`(완성 제공)를 실행해 `validate()`는 부모 코드 그대로 공유되고 `process()`만 다르게 동작하는 걸 출력으로 직접 확인함.

## 다음에 참고할 것

- **중요한 프로세스 피드백**: "다음 레슨부터는 실행하는 코드(main/Demo)도 직접 작성하게 해줘 — 그래야 제대로 안다"고 명시적으로 요청함. 지금까지는 Demo/실행 class를 완성 제공했는데, 0009부터는 이것도 TODO로 돌릴 것. NOTES.md에 기록함.
- 다음 큐 항목: collections (List, Map, Set).
- 개념 설명 순서: 비유 vs 코드 트레이스 중 뭐가 먼저 통할지 예측하지 말고, 하나 시도해서 안 통하면 바로 반대로 전환하는 유연함이 필요함 — 이번에 두 번째 전환(코드→비유)이 새로 나타난 패턴.
