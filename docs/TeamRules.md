# 작업규칙

## 첫 시작
```bash
# 1. VS Code에서 터미널 열기
- 방법 1: 상단 메뉴 바에서 [Terminal] -> **[New Terminal]**을 선택합니다.
- 방법 2: 단축키 Ctrl + `(백틱)을 누르면 하단에 터미널이 바로 나타납니다.

# 2. GitHub 프로젝트 복제
- GitHub 프로젝트 가져오기
git clone https://github.com/kws0315/AIBE5_Team5.git

- 복제된 프로젝트 폴더로 이동
cd AIBE5_Team5

# 4. 작업 브랜치로 이동하기 및 브랜치 설정
- git checkout [작업브랜치]명

# 5. 최신 브랜치 내용을 가져온다.
- git pull origin [작업브랜치명]
```

---

## GitHub Push방법
```bash
# 1. 현재 작업하던 파일들을 담기
    - git add .
    - 특정 파일만 보낼때: git add [파일1] [파일2] [파일3]
# 2. 커밋 규칙에 맞춰서 보내기
    - git commit -m " [기능분류]: [파일명] - [작업내용] - [날짜] "
# 3. 반드시 본인이 작업하는 브랜치에 push하고 문제 없을 경우에 feat에는 merge
    - git push
```

---

## 1. 매일 작업 전 최신 feature 내용 가져오기
```bash
git fetch origin
git checkout [작업브랜치]
git merge origin/feature
```

## 2. 커밋 메시지 기본 형식
```text
[기능분류]: [작성내용] - [날짜]
```
- **기능분류:** 작업의 성격
- **수정/작성내용:** 추가·수정한 작업 내용을 간단히 요약
- **수정/작성일:** 작업을 완료한 날짜 (YYYY-MM-DD)

#### 기능분류(Type)

| 타입     | 의미          |
| ------ | ------------- |
| feat   | 새로운 기능 추가  |
| docs   | 문서 작성 / 수정 |
| fix    | 버그 수정       |
| refact | 코드 리팩토링    |

#### Commit 규칙 상세

```text
[기능분류]: [파일명] - [작업내용] - [날짜]
```
- 작성내용 앞에 작업한 파일명 명시
- 작업내용을 중심으로 간단히 작성

```text
# 예시
git commit -m "feat: index.js - 로그인 추가 - 26.01.22"
git commit -m "feat: Header.js - 헤더구현 - 26.01.22"
git commit -m "feat: Header.js, index.js - 헤더로 메인화면 돌아가는 기능 구현 - 26.01.22"
```

## 3. 작업 종료시 / PR 제출 전
```text
# Slack 혹은 Zoom으로 팀장에게 작업완료를 알리며 PR 제출
# 자신이 작업한 기능의 정상작동 확인 후 PR 제출
# 충돌 발생 시, 해결 후 PR 제출
```

## 4. PR 규칙
```t
# PR 대상 브랜치 → 항상 feature
# PR 제목/설명 작성 필수
# PR 전에 개인 브랜치가 feature 최신 반영 상태인지 확인

# Pull Request 진행 절차
1. 본인이 작업하는 브랜치에서 기능 개발을 진행한다.
2. 작업이 완료되면 작업 브랜치에 push한다.
3. push한 내용을 **feature 브랜치를 대상으로 Pull Request를 생성**
4. PR의 제목에 **기능분류**에 맞게 작업 내용 및 변경 사항을 간단히 설명한다.
5. 팀장이 PR을 리뷰하고 승인(Approve)한다.
6. 승인 완료 후 feature 브랜치에 병합(Merge)된다.
```

# 5. 브랜치 규칙
```t
# main 브랜치
  - 배포 전용 브랜치로 사용한다.
  - **팀장만 push 및 merge 권한**을 가진다.
  - 개인 작업 및 직접적인 수정은 금지한다.

# feature 브랜치
  - 모든 작업 브랜치에서 작업한 내용을 통합하는 테스트 브랜치이다.
  - 작업브랜치에서 **직접 push는 불가**하다.
  - 반드시 **Pull Request(PR)** 를 통해서만 병합할 수 있다.
  - PR은 **팀장의 승인(Approve) 후에만 merge 가능**하다.

# 가능 브랜치
  - 각 팀원은 본인에게 할당된 브랜치에서만 작업한다.
  - 작업 완료 후 feature 브랜치를 대상으로 PR을 생성한다.
  - 매일 작업 완료 후 각자 작업한 내용을 push한다.

# main, feature 브랜치는 보호 브랜치로 설정한다.
  - 보호 브랜치에는 다음 규칙을 적용한다.
  - 직접적인 push 금지
  - Pull Request 없이 merge 금지
  - 팀장 승인 필수
```

---

## API 규칙
- Github Repository에 올라가선 안되는 개인정보, 데이터, API KEY는 **.gitignore**에 올리고 Slack에 적용사항 애기해주기
- API KEY는 반드시 비공개처리하여 타인에게 공유하시면 안됩니다. (잘못하면 다른사람이 API를 마음대로 써서 돈 청구됨)

---

## 개인 브랜치 초기화 방법
```bash
# 1. 본인이 작업하는 브랜치로 이동
git checkout [작업브랜치]

# 2. 원격 브랜치 최신 정보 가져오기
git fetch origin

# 3. feature의 내용으로 병합하기
git merge origin/feature

# 4. Repository에 있는 작업 브랜치에 적용하기
git push origin [작업브랜치]
```

---