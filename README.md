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

## MESSAGE

1. SecurityMessageConfig.java : message 설정 코드를 작성
2. resource / message 폴더에 message.properties 파일 생성 및 메세지 설정
3. 적용



## Security TEST

1. 테스팅
- @WithMockUser : 간단하게 유저정보와 role를 입력한 후 특정 페이지를 요청했을 때 반응을 확인할 수 있다(모든 인스턴스에서 동작하지 않을 수 있음)
  - username : user의 이름 파라미터
  - password : user의 비밀번호 파라미터
  - roles : user의 권한객체 파라미터
- @WithAnonymousUser : 익명의 유저가 특정 페이지를 요청했을 때 반응을 볼 수 있다.
- @WithUserDetails : 지정한 사용자 이름으로(실제 사용자가 존재해야 함) 계정을 조회한 후에 UserDetails 객체를 조회하여 보안 컨텍스트를 로드, withMockUser보다 좀 더 섬세한 작업이 가능하다.
  - value : 지정한 사용자의 이름 파라미터
  - userDetailsServiceBeanName : UserDetails 조회 서비스의 빈 이름( 하나만 존재한다면 생략가능 )
  - setupBefore 


2. 어노테이션을 만들어서 테스트에 적용
   - WithMockAdmin.java


