# 0011 — review: generics

- **날짜**: 2026-08-26
- **레슨**: [lessons/0011-review-generics.html](../lessons/0011-review-generics.html)
- **문법 기초 큐**: 진행 아님 (0010 재확인, 큐는 9/11 유지)

## 배운 것 / 재확인된 것

- 0010의 4개 recall 퀴즈(type parameter, type argument, generic method `<T>` 위치, `ClassCastException`)를 전부 힌트 없이 맞힘.
- `class ApiResponse<T>` + `success(T data)`/`error(String message)` static factory method 두 개를 스펙만 보고 거의 완성으로 작성함. 유일한 실수는 `success()`에 안 쓰는 `errorMessage` 파라미터를 남겨둔 것 — 두 번째 지적에서 스스로 제거함.
- **새로 확정된 이해**: class의 `<T>`(instance-level)와 static method 앞의 `<T>`(그 method만의 선언)는 이름이 같아도 서로 다른 선언이라는 것. 처음엔 "같은 것"이라 답했으나, `static context`에서 class의 `T`를 그대로 쓰면 `non-static type variable T cannot be referenced from a static context` 컴파일 에러가 난다는 걸 직접 보고, 원인(static은 instance가 없어 class의 T를 알 수 없음)을 스스로 정확히 재진술함.

## 확인된 이해도

- **hands-on**: `Product.java`, `ApiResponse.java`, `Runner.java` 모두 시작 코드 없이 작성 → 컴파일·실행까지 확인, 출력 예상과 일치 (`true / Keyboard / false / Product not found / true`).
- 0010 때보다 힌트 없이 맞힌 비중은 늘었으나, 학습자 본인은 여전히 "완벽하지 않다"고 판단함.

## 다음에 참고할 것

- **학습자가 스스로 완벽하지 않다고 판단, 내일 generics 복습을 한 번 더 진행하기로 함.** 이번엔 두 가지를 같이: ① hands-on 코드 작성 복습(또 다른 도메인), ② 말로 직접 풀어서 설명하는 복습(코드 없이 개념을 구술로). lambda와 stream(문법 기초 큐 마지막 항목)으로 넘어가는 건 그 이후로 미룸.
