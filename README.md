# MyBatis CRUD 실습

## 📌 0. 목표
MyBatis를 이용해 기본적인 CRUD 기능을 구현한다.
데이터 모델링을 수행하고, 작성한 SQL 스크립트를 기반으로 CRUD를 구현한다.
또한, 팀원과 함께 branch와 merge를 활용한 협업 방식도 연습하는 것을 목표로 한다.

---

## ⚙️ 1. 프로젝트 세팅 

- **프로젝트 명**: `mybatis-crud-practice`
- **패키지 구조**
```
mybatis-crud-practice/
└── src/
└── main/
└── java/
└── ex)employee/
├── common/
├── controller/
├── model/
│ ├── dao/
│ ├── dto/
│ └── service/
└── run/
```
---

## 🎯 2. 주제 및 설계

- 주제는 자유롭게 정한다.
- 최소 4개의 테이블을 설계한다.
- 모든 테이블 간에 적어도 하나 이상의 연관관계(1:N, N:M 등)를 반드시 설정한다.

---

## 🧱 3. 데이터베이스

- 스크립트는 별도로 정리하여 관리한다.
- 각 테이블에는 적절한 제약조건을 설정한다.
- 외래 키를 활용하여 무결성을 보장한다.

---

## 🗂️ 4. 기능 요구사항

- 핵심 테이블 1~2개에 대해 다음의 CRUD 기능을 구현한다:

| 기능       | 설명                  |
|------------|-----------------------|
| Create     | 새 데이터 등록         |
| Read (All) | 전체 데이터 목록 조회  |
| Read (One) | 단건 조회 (상세 보기)  |
| Update     | 기존 데이터 수정       |
| Delete     | 데이터 삭제            |

- CRUD 대상 테이블은 팀 내에서 협의하여 선정한다.
- chap04(Dynamic Query) ~ 05(Mapper Elements)에서 배운 방식을 적용한다.
- ❗❗ **단, 전체 조회 및 상세 조회 시, 연관 테이블과의 조인 결과를 포함한다.**

---

## ✅ 5. 사용 기술

- **Java**
- **MySQL**
- **MyBatis**
  - SQL 쿼리는 XML 파일에 작성한다.
  - Mapper 인터페이스는 Java로 구현한다.

---

## 📜 6. 작업 완료 후

- Team Git Organization에 push 한다.
- pull request와 merge를 통해 협업을 진행한다.
- 팀원 간의 코드 리뷰 후, 실습을 마무리한다.