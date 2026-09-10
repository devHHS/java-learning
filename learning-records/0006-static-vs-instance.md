# 0006 — static vs instance

- **날짜**: 2026-08-14
- **레슨**: [lessons/0006-static-vs-instance.html](../lessons/0006-static-vs-instance.html)
- **문법 기초 큐**: 5/11 완료

## 배운 것

- instance field(object마다 따로) vs static field(class 전체가 공유하는 하나).
- `main`이 `static`이어야 하는 이유 — JVM이 프로그램을 시작할 때 아직 만들어진 object가 없어서, object 없이 부를 진입점이 필요함.
- static method 안에서는 `this`를 못 쓴다 — 가리킬 instance 자체가 없기 때문.
- static + final = 상수 (재대입 시 컴파일 에러).
- Quarkus Panache의 static finder(`Person.findAll()`)와 Spring Data JPA의 instance repository(`repository.findAll()`) 차이 — Spring은 repository가 DI 대상 object이길 원해서 instance 방식.

## 확인된 이해도

- 퀴즈 3개 정답. Q3(`this`)는 처음엔 몰랐으나, "지금 막 작성한 constructor의 `this.id = nextId`가 뭘 가리키는지" 힌트를 받은 뒤 스스로 답을 도출함 — static method엔 "이 object"가 없어서 `this`가 무의미하다는 연결까지 이해함.
- **hands-on**: `practice/0006-static-vs-instance/Ticket.java`의 TODO 3곳(constructor에서 `id`/`nextId` 처리, `subject` 대입, `getCreatedCount()` static method 추가)을 스스로 완성. 별도 실습 중 착오 없이 한 번에 정확히 구현.
- 실행 결과로 직접 확인: `t1`/`t2`/`t3`의 `id`는 1, 2, 3으로 각자 다르지만 `getCreatedCount()`는 셋이 공유한 하나의 `nextId`에서 나온 값(3)이라는 걸 눈으로 봄.

## 다음에 참고할 것

- 다음 큐 항목: inheritance와 polymorphism.
- static counter 패턴(`nextId`)은 invoice-app에서 DB 연결 전 mock repository를 만들 때 재사용 가능 — MISSION.md의 "invoice-app에 바로 적용" 섹션에 이미 언급됨.
- Q3에서 한 번에 못 떠올린 것 외에는 착오 없이 매끄럽게 진행 — 별도 복습 세션 없이 다음 큐 항목으로 바로 진행 가능해 보임.
