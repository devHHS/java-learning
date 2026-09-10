# 0005 — access modifiers

- **날짜**: 2026-08-12
- **레슨**: [lessons/0005-access-modifiers.html](../lessons/0005-access-modifiers.html)
- **문법 기초 큐**: 4/11 완료

## 배운 것

- private/package-private/protected/public 4단계와 "가장 제한적인 레벨을 써라" 원칙.
- field가 열려있으면 constructor의 fail-fast 검증(0003에서 배운 것)을 우회해 잘못된 상태로 만들 수 있다는 것 — access modifier와 invariant를 연결지어 이해.
- getter 패턴: 읽기는 열고, setter는 의도적으로 안 만들어 immutable 유지.

## 확인된 이해도

- 퀴즈 3개 정답.
- **hands-on**: 기존 `Money.java`의 field를 `private`로 바꾸고 getter 추가, `main`도 getter를 쓰도록 수정.
- 실습 중 두 단계 착오를 스스로 겪고 수정함:
  1. `money1.amountInCents(-999)`처럼 field를 method인 것처럼 괄호로 호출 — "Method call expected" 에러를 보고 대입 연산자(`=`)로 수정.
  2. `private` 제한을 확인하려던 코드를 `Money` class 자신의 `main` 안에 넣어서 컴파일이 그냥 통과되는 걸 보고 의아해함 — "같은 class 안에서는 private도 허용된다"는 규칙을 다시 짚어준 뒤, 별도 `MoneyTest.java`를 만들어 다른 class에서 접근을 시도해 실제 `'amountInCents' has private access in 'Money'` 에러를 직접 확인함.
- 두 번째 착오는 access modifier의 "같은 class 안에서는 예외"라는 세부 규칙이 처음엔 없었던 것으로 보이나, 실제 컴파일 에러 비교(같은 class vs 다른 class)로 명확히 체화됨.

## 다음에 참고할 것

- 다음 큐 항목: static vs instance.
- protected는 이번에 깊이 안 다룸 — inheritance 큐 항목에서 subclass 예제와 함께 다시 다룰 것.
- `MoneyTest.java` (다른 package/class에서의 접근 테스트용)가 practice 폴더에 남아있음 — 향후 static 레슨 등에서 재활용 가능.
