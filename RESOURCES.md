# RESOURCES

지식 습득에 쓰는 고신뢰 자료 목록. 레슨은 여기 있는 자료를 인용한다.

## Java 문법

- [Oracle Java Tutorials — Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html) — 공식 문서. variable, primitive type 8종의 근거.
- [Oracle Java Tutorials — Summary of Variables](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variablesummary.html) — variable 선언 정리.
- [Oracle Java Tutorials — Control Flow Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html) — if/for/while 공식 정리.
- [Oracle Java Tutorials — The switch Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html) — classic switch와 fallthrough 근거.
- [Oracle Java Tutorials — Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html) — class, field, method, constructor 정의.
- [Oracle Java Tutorials — Creating Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html) — new, default constructor 근거.
- [Oracle Java Tutorials — Controlling Access to Members of a Class](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) — private/package-private/protected/public 4단계, "가장 제한적인 레벨을 써라" 원칙.
- [Oracle Java Tutorials — Understanding Class Members](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html) — static field/method 정의, static method가 instance member에 접근 못 하는 이유, static final 상수.
- [Oracle Java Tutorials — Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html) — extends, 무엇이 상속되는지(public/protected는 됨, private/constructor는 안 됨), super.
- [Oracle Java Tutorials — Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html) — virtual method invocation, 선언 타입이 아니라 실제 object 타입의 override된 method가 실행되는 원리.
- [Oracle Java Tutorials — Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html) — interface를 "contract"로 정의하는 근거, implements와 instantiate 불가 규칙.
- [Oracle Java Tutorials — Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html) — abstract class/method 정의, interface와의 field/구현/다중 implements 차이, 언제 뭘 쓰는지 공식 가이드라인.
- [Oracle Java Tutorials — Introduction to Collections](https://docs.oracle.com/javase/tutorial/collections/intro/index.html) — collections framework의 정의 (interfaces/implementations/algorithms).
- [Oracle Java Platform SE 8 — List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) — ordered, 중복 허용 근거.
- [Oracle Java Platform SE 8 — Set](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html) — 중복 불허 근거.
- [Oracle Java Platform SE 8 — Map](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html) — key-value, key 중복 불가 근거.
- [Oracle Java Tutorials — Generic Types](https://docs.oracle.com/javase/tutorial/java/generics/types.html) — generic class/type parameter 정의, generics 없을 때 ClassCastException 근거.
- [Oracle Java Tutorials — Generic Methods](https://docs.oracle.com/javase/tutorial/java/generics/methods.html) — method 단위 generics 문법(`<T>`가 return type 앞에 옴).
- [Oracle Java Tutorials — Unchecked Exceptions: The Controversy](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html) — checked/unchecked를 나누는 판단 기준("복구 가능하면 checked, 아니면 unchecked").
- [Oracle Java Tutorials — The catch or Specify Requirement](https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html) — checked exception의 정의, catch-or-specify 근거.
- [Oracle Java Tutorials — How to Throw Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html) — `throw` statement 문법, `throws`와의 관계 근거.

## Spring / Quarkus (문법 큐 이후 본격 사용, 지금은 bridge로만)

- [Spring Data JPA Reference — Core Concepts](https://docs.spring.io/spring-data/jpa/reference/repositories/core-concepts.html) — `Repository<T, ID>`가 domain class와 id 타입을 type argument로 받는다는 근거.
- [Quarkus Guides — Hibernate ORM with Panache](https://quarkus.io/guides/hibernate-orm-panache) — `PanacheRepository<Entity>` 패턴, generics의 Quarkus 다리로 사용.
- [Spring Framework Reference — @ExceptionHandler](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-exceptionhandler.html) — controller/service에서 던진 exception을 HTTP 응답으로 매핑하는 근거, exception handling의 Spring 다리.
- [Quarkus Guides — Writing REST services (exception mapping)](https://quarkus.io/guides/rest/) — `@ServerExceptionMapper` 근거, exception handling의 Quarkus 다리.

## 아직 필요

- Spring Boot 공식 문서 (레슨이 Spring 개념으로 넘어갈 때 추가)
- BigDecimal / 금액 처리 공식 레퍼런스 (generics 큐 이후 필요)

## 커뮤니티 (wisdom)

- 아직 탐색 전. 사용자가 실전 질문을 시작하면 Stack Overflow, r/javahelp, 국내 개발자 커뮤니티(OKKY 등) 후보 검토.
