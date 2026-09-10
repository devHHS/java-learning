# 0009 — collections (List, Set, Map)

- **날짜**: 2026-08-18
- **레슨**: [lessons/0009-collections.html](../lessons/0009-collections.html)
- **문법 기초 큐**: 8/11 완료

## 배운 것

- List(순서 보장, 중복 허용) / Set(중복 불허) / Map(key-value, key 중복 불가) 세 가지 collection interface.
- 대표 구현체: `ArrayList`, `HashSet`, `HashMap` — 0008의 "interface는 계약, 구현은 class" 개념이 여기서 바로 재사용됨.
- 언제 뭘 쓰는가: 순서+중복 허용 필요 → List, 중복 제거만 필요 → Set, id로 빠른 조회 → Map.

## 확인된 이해도

- **hands-on**: `Catalog.java`(TODO 2개: `uniqueCategories`, `indexById`)와 `Runner.java`(이번엔 완성본 없이, 학습자가 처음부터 전부 작성 — 0008에서 요청한 "실행 코드도 직접 작성" 반영).
  - `Runner.java`: List 생성, Product 5개(category 중복 포함) 추가, 두 method 호출 및 결과 출력까지 **한 번에 정확히** 작성. 착오 없음.
  - `Catalog.java`: for문 버전을 주석으로 남겨두고, 실제로는 **stream/lambda**(`stream().map().collect(Collectors.toSet())`, `Collectors.toMap()`)로 구현 — 아직 문법 큐에 없는 내용을 스스로 가져와 씀. 요청해서 stream()/map()/collect() 각 단계를 자기 말로 설명하게 했고, 정확했음(복붙이 아니라 이해하고 쓴 것으로 판단).

## 다음에 참고할 것

- 다음 큐 항목: generics.
- **lambda와 stream(큐 마지막 항목)은 이미 실전에서 써본 상태** — 나중에 그 항목 갈 때 처음부터 가르치지 말고 정리/복습 위주로 가볍게 진행할 것. NOTES.md에도 기록함.
- "실행 코드 직접 작성" 방식(0008 피드백)이 이번에 처음 적용됐고 문제 없이 잘 됨 — 계속 이 방식 유지.
