# 0012 — review: generics (repository 패턴, 두 개의 type parameter)

- **날짜**: 2026-08-31
- **레슨**: [lessons/0012-review-generics-repository.html](../lessons/0012-review-generics-repository.html)
- **문법 기초 큐**: 진행 아님 (0010/0011 재확인, 세 번째이자 마지막 라운드, 큐는 9/11 유지)

## 배운 것 / 재확인된 것

- `InMemoryRepository<T, ID>` — 처음으로 **type parameter 두 개**를 쓰는 class를 작성. `Map<ID, T> store` 필드, `save`/`findById`/`deleteById`/`count` 전부 시작 코드 없이 완성. class-level `<T, ID>`와 0011의 static method-level `<T>`를 구분해서, instance method 앞엔 `<T>`를 다시 선언하지 않는 이유를 스스로 주석에 정확히 적음.
- `deleteById`에서 `store.remove(id) != null` 대신 `containsKey`로 먼저 확인 — value가 null일 수 있다는 이유로 스펙에 없던 더 정확한 방식을 스스로 택함.
- **실수 하나 발견**: `Runner`에서 `new InMemoryRepository()`처럼 diamond(`<>`) 없이 raw type으로 생성 → `javac -Xlint:unchecked`가 경고를 냄. 다만 실제 위험도는 낮았음(왼쪽 변수가 이미 `<Employee, Long>`로 선언돼 있어 이후 호출은 계속 체크됨) — 이 구분(raw type이 정말 위험한 건 **변수 선언 자체**가 raw일 때, 즉 이후 모든 method 호출의 인자/반환이 체크 안 되는 경우)을 코드 대조(컴파일 성공 vs 컴파일 에러)로 직접 확인시킴.
- **Part 2 구술 복습 (코드 없이, 5문항 전부 정확히 도달)**:
  1. type parameter/argument 차이를 그 단어 없이 설명 — 한 번에 정확.
  2. 왜 type parameter가 두 개 필요한지 — 첫 답은 구현 사실 재진술("Map으로 두 개 정의했으니까")이라 설계 관점으로 리다이렉트, 이후 "entity 타입과 ID 타입은 서로 다른 정보"라는 정확한 이유 + Order의 UUID/String ID라는 구체적 반례까지 스스로 제시.
  3. `findById`가 `Object`를 반환했다면 — 캐스팅 필요, `ClassCastException` 위험까지 한 번에 정확.
  4. class의 `<T, ID>` vs static method의 `<T>` — 한 번에 정확 (0011에서 확인한 static context 원리를 그대로 재사용).
  5. `Employee`/`Receipt` = entity, `Long` = primary key 타입 대응 — 첫 답은 Q3 답변 재진술과 섞여서 다시 물어야 했지만, cheatsheet 용어(entity/primary key)로 정확히 재답변.

## 확인된 이해도

- hands-on: `Employee.java`, `InMemoryRepository.java`, `Runner.java` 전부 시작 코드 없이 작성 → 컴파일·실행 확인 (`Kim` / `true` / `true` / `2`, 예상과 일치), 이후 raw type 수정까지 반영.
- 구술 복습 5문항 모두 정확한 이해에 도달 (2문항은 재질문/리다이렉트 필요했지만 최종 답은 정확).
- **학습자 본인 판단**: "이번엔 단단해진 것 같다" — 0010(생성자+static method), 0011(static factory method), 0012(two type parameters + repository 패턴) 세 라운드를 거친 뒤 처음으로 스스로 확신을 표현함.

## 다음에 참고할 것

- **generics 복습 루프 종료.** 다음 세션부터 문법 기초 큐 10번째 항목인 **exception handling (checked vs unchecked)**으로 진행.
- generics는 이 학습자에게 세 라운드가 필요했던 개념이었다 — 다른 큐 항목에서도 첫 라운드에 "완벽하지 않다"는 자기평가가 나오면, 도메인을 바꿔 반복하는 이 패턴(hands-on 새 도메인 + 구술 복습)을 다시 쓸 것.
- raw type / diamond operator(`<>`)는 애초 큐에 없던 주제지만 실수로 자연스럽게 나와서 다뤘음 — [reference/java-generics-cheatsheet.html](../reference/java-generics-cheatsheet.html)에 "type parameter 두 개" 섹션으로 반영해둠. 별도 레슨으로 만들 필요는 없음, cheatsheet 참고로 충분.
