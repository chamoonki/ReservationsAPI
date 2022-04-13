# API
## Swagger
1 [Reuqest Mapping URL] (http://localhost:8300/swagger-ui.html) <br>
2 SwaggerConfig.java <br>
- Swagger에 관련된 환경설정 클래스 <br>

## ORM (Hibernate / Jpa / Dsl) 
1 테이블 생성
- 테이블 기능정의서에 수기되어있는 모델로 테이블 생성하였습니다.
- 개발하면서 수정가능하며 테이블 컬럼 type 및 size 변경이 필요할 수 있습니다. 

## 인증 (Oauth2.0 사용)
1 AuthorizationServerConfiguration.java
- 인증서버 환경설정 클래스 
- 토큰 발급 및 client 허용 환경설정
- 차후 인증서버 분리

2 OAuth2SecurityConfiguration.java
- 토큰 발급 허용 사용자 환경설정 (현재 메모리 유저로 되어있음)
- 차후 jdbc 연동 하여 변경
- 차후 인증서버 분리

3 ResourceServerConfiguration.java
- 리소스 서버 환경설정
- 리소스 자원에 대한 허용 권한 설정

4 인증서버 아키텍처
- 리소스 서버 / 인증 서버 통합되어있는 상태
- 차후 리소스 자원서버 분리 하여 인증 로직 변경 해야됨

## 개발 주의사항
1 인증관련 <br>
- 리소스 서버 / 인증 서버가 통합되어 있어 토큰을 강제로 적용된 상태
- 토큰 정보는 DB에 저장되어 있다.
- 토큰 ID는 로컬에서 개발하므로 각각 한명씩 발급 받아야 되는 상항 (인증서버가 리소스 서버에 포함된 소스이므로 로컬에서 각자 돌리면 각자 인증토큰값이 달라짐)
- 스프링 부트 서버 런 시 자동으로 admin/user 권한을 가진 토큰이 발급됩니다.
- 로컬 개발시 각자 토큰 ID 수정해야될 클래스 ( DevProjectApplication.java : 45,49번째 줄 / AuthServiceImpl.java : 76번째 줄)
- 토큰 예시 ( 차문기 : [dev_admin_token] / 김민기 : [mk_dev_admin_token] / 김태준 : [tj_dev_admin_token] )

2 공유관련 <br>
- 항상 개발전에 git 에서 pull을 한번 해주고 커밋된 소스가 있는지 확인후 작업 시작해주시기 바랍니다.
- 비상주 개발이므로 각자 개발된 부분에 대해 commit messgae를 상세히 적어주고 상세히 적기 불편할경우 프로젝트 단톡방에 공유 부탁드립니다.
- DevProjectApplication.java 는 되도록이면 commit 하지말아주세요. (부트 런 시 토큰을 발급하는데 각자 id가 다르기 때문에 헷갈릴 수 있습니다.)

3 DB관련 <br>
- application.properties 소스에 spring.jpa.hibernate.ddl-auto 값을 create로 변경시 테이블 데이터 삭제되고 재 생성되니 update로 유지 (중요!)




