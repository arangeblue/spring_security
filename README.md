# SPRINGBOOT SECURITY 

- springboot security란 보안에 관련하여 서비스를 제공해주는 spring기반의 하위 프레임워크
- 인증과 권한에 관한 서비스 제공
- 인증(Authentication)과 권한(Authorization)
  - 인증 : 사용자가 누구인지 확인하는 작업
  - 권한 : 특정 사용자가 서비스에 접근하거나 사용할 수 있는 권한이 있는지 확인하는 작업
  


## springboot security 사용하는 이유

- 로그인 폼을 생성 및 로그아웃 처리
- 모든 url에 대한 인증처리
- 보안 서비스 제공
  - csrf 공격 방어
  - session fixation 공격 방어
  - 요청 헤더 보안
    - http strict transport security
    - 캐시 컨트롤
    - X-Content-Type-options
    - X-XSS-Protection
    - 클릭 재킹 방지를 위한 X-FRAME-Options
- 서블릿 API메서드와 통합
  - HttpServletRequest#getRemoteUser()
  - HttpServletRequest.html#getUserPrincipal()
  - HttpServletRequest.html#isUserInRole(java.lang.String)
  - HttpServletRequest.html#login(java.lang.String, java.lang.String)
  - HttpServletRequest.html#logout() 



## 페이지 구성

1. 로그인
2. 회원가입
3. 유저 전용
4. 관리자 전용



## 의존성 및 프로젝트 버전

- 프로젝트 구성
1. VScode
2. Gradle
    - V2.5.5
    - 11 java
    - jar


- 의존성

1. Web
2. Jpa
3. Thymeleaf
4. Lombok
5. H2

