# 0002 — control flow

- **날짜**: 2026-08-05
- **레슨**: [lessons/0002-control-flow.html](../lessons/0002-control-flow.html)
- **문법 기초 큐**: 2/11 완료

## 배운 것

- if/for/while은 Quarkus 경험으로 이미 알고 있어 복습만 하고 넘어감.
- classic switch의 fallthrough 위험 (break 누락 시 다음 case로 흘러 내려감).
- switch expression (Java 14+, `->` 문법, `yield`) — statement가 아니라 expression이라 값을 반환하고, fallthrough가 구조적으로 불가능.

## 확인된 이해도

- 퀴즈 3개 정답.
- 전이 질문(invoice-app 연체 수수료율을 status별로 반환하는 로직 설계)에서 "값을 반환해야 하니 switch expression"이라고 정확한 근거로 선택함. classic switch와 expression의 용도 구분(실행 vs 값 생성)을 실제 시나리오에 적용 가능함을 확인.
- **hands-on 연습 추가 (2026-08-05, 첫 시도)**: `practice/0002-control-flow/LogLevel.java` — `getLogLevelSeverity(String)`를 switch expression으로 작성. 첫 시도에서 문법 오류 3종(case arm 구분자로 콤마 사용, 타입 불일치 `String`/`int`, 미사용 `return 0` 잔여)을 냈으나, 컴파일 에러 메시지를 같이 읽은 뒤 스스로 전부 수정하여 정상 동작 확인 (`javac`/`java`로 직접 컴파일·실행). IntelliJ에서 디렉토리를 Sources Root로 지정해야 한다는 것도 함께 익힘.

## 다음에 참고할 것

- 다음 큐 항목: class와 object, constructor.
- switch expression의 pattern matching(레코드 패턴 등, Java 21+)은 아직 다루지 않음 — class/object 이후 필요 시점에 재검토.
