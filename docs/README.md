# 만화책 대여점 CLI

자바 CLI를 이용해서 만화책을 등록, 대여, 반납 등을 구현한 자바 CLI 프로젝트

---

## 📌 프로젝트 개요

- 

---

## 📌 프로젝트 기획서

- **Figma:** https://www.figma.com/design/iSbu7heQg9bfYgt5UUo2LL/AIBE5-3%EC%B0%A8-5%ED%8C%80_%EC%82%BC%EC%82%BC%EC%98%A4%EC%98%A4?node-id=15-69&t=XZRfJcyegtUA8yhR-0

---

## 🛠 기술 스택

#### Backend
- Java
- Spring

#### DataBase
- MySQL

#### Design
- Figma

---

## 👥 팀원 소개

|  이름  |  역할  |  담당 기능  |
|-------|-------|-----------|
| 고완석  |  팀장  |           |
| 이소연  |  팀원  |           |
| 정재운  |  팀원  |           |
| 김재준  |  팀원  |           |

---

## ✨ 주요 기능

#### 📌 만화책 등록 / 삭제 / 조회

## ▶️ 로컬 실행 방법 (Local Run)

본 프로젝트는 GitHub Action을 통해서 배포되어 <링크입력>에서 실행할 수 있습니다.


## 📂 디렉토리 구조

```bash
📦 Comic Rental CLI
 ┣ 📂 src
 ┣ 📂 docs                          # 프로젝트를 위한 각종 문서폴더
 ┃ ┃ ┗ 📜 *.png                    
 ┃ ┃ ┣ 📜 Header.tsx                # 상단 네비게이션 헤더 컴포넌트
 ┃ ┃ ┣ 📜 TravelModal.tsx           # 여행 계획 관련 모달 컴포넌트
 ┃ ┃ ┣ 📜 SharePlanModal.tsx        # 여행 계획 공유 모달
 ┃ ┃ ┗ 📜 ReviewModal.tsx           # 여행 후기 작성/수정 모달 컴포넌트
 ┃ ┣ 📂 pages
 ┗ 📜 README.md            
```
---

## 🤝 Team Convention

### 🔹 커밋 규칙

본 프로젝트는 커밋 메시지를 통해 **작업 내용과 변경 이력을 명확히 파악**할 수 있도록 아래 규칙을 따릅니다.


### 📌 커밋 메시지 기본 형식

```text
[기능분류]: [작성내용] - [날짜]
```
- **기능분류:** 작업의 성격
- **수정/작성내용:** 추가·수정한 작업 내용을 간단히 요약
- **수정/작성일:** 작업을 완료한 날짜 (YYYY-MM-DD)

#### 기능분류(Type)

=======
| 타입     | 의미          |
| ------ | ------------- |
| feat   | 새로운 기능 추가  |
| docs   | 문서 작성 / 수정 |
| fix    | 버그 수정       |
| refact | 코드 리팩토링    |

### Commit 규칙 상세

```text
[기능분류]: [파일명] - [작업내용] - [날짜]
```
- 작성내용 앞에 작업한 파일명 명시
- 작업내용을 중심으로 간단히 작성


=======
```text
# 예시
git commit -m "feat: Login/index.js - 로그인 추가 - 26.01.22"
git commit -m "feat: components/Header.js - 헤더구현 - 26.01.22"
git commit -m "feat: component/Header.js, Home/index.js - 헤더로 메인화면 돌아가는 기능 구현 - 26.01.22"
```

---

### 🔹 브랜치 전략

본 프로젝트는 아래와 같은 브랜치 구조를 사용합니다.

#### 📌 브랜치 구조

```text
main      (배포 브랜치)
 ↑
feature   (통합 브랜치)
 ↑
t1 ~ t7   (작업 브랜치)
```

#### 📌 Pull Request(PR) 정책

본 프로젝트는 안정적인 코드 통합과 배포를 위해  
Pull Request 기반 협업 방식을 사용합니다.


- **main 브랜치**
  - 배포 전용 브랜치로 사용한다.
  - **팀장만 push 및 merge 권한**을 가진다.
  - 개인 작업 및 직접적인 수정은 금지한다.

- **feature 브랜치**
  - 작업 브랜치에서 작업한 내용을 통합하는 브랜치이다.
  - 작업 브랜치에서 **직접 main으로의 push**는 불가하다.
  - 반드시 **Pull Request(PR)** 를 통해서만 병합할 수 있다.
  - PR은 **팀장의 승인(Approve) 후에만 merge 가능**하다.

- **작업 브랜치 (t1 ~ t7)**
  - 각 팀원은 본인에게 할당된 브랜치에서만 작업한다.
  - 작업 완료 후 feature 브랜치를 대상으로 PR을 생성한다.


#### 📌 Pull Request 진행 절차

1. 작업 브랜치(t1 ~ t7)에서 기능 개발을 진행한다.
2. 작업 완료 후 **feature 브랜치를 대상으로 Pull Request를 생성**한다.
3. PR에는 작업 내용 및 변경 사항을 간단히 설명한다.
4. 팀장이 PR을 리뷰하고 승인(Approve)한다.
5. 승인 완료 후 feature 브랜치에 병합된다.


#### 📌 브랜치 보호 규칙

- **main, feature 브랜치는 보호 브랜치로 설정**한다.
- 보호 브랜치에는 다음 규칙을 적용한다.
  - 직접 push 금지
  - Pull Request 없이 merge 금지
  - 팀장 승인 필수

--- 

### 🔹 트러블 슈팅 & 해결 방식
... 추후 프로젝트 개발 중 발생한 문제 작성할 예정 ...

