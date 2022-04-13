# API
## Settings
1. Java를 설치 해 준다.
- 개발 기준 1.8 버전
- https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html - JDK 1.8 download page(로그인 필요)
<pre>
- [주의 사항] 기존 Java가 있을 경우 jdk1.8.0_151 이하 버전 일 경우에는 "Illegal key size" 오류가 발생 할 수 있습니다. 
- 해당 오류는 Java JDK 1.8.0_151 버전을 기점으로 AES256 암호화를 호환이 되었기에 해당 버전 이하일 경우에는 위와 같은 오류가 발생 할 수 있습니다.
- 그럴 경우에는 해당 링크(https://mirotic91.tistory.com/21)에 맞게 설정 해 주거나 또는 기존 버전 Java를 지우고 최신 버전으로 설치 하는것이 좋을 것 같습니다.
</pre> 



2. STS3^을 받아 준다. 
- https://spring.io/tools			- STS v4
- https://spring.io/tools3/sts/all	- STS v3

3. STS.ini 파일을 열어 javaw.exe 경로를 추가 해 준다. (openFile 아래 & startup 설정 아래)
<pre>
-vm
C:/Program Files/java/jdk1.8.0_231/bin/javaw.exe
</pre>

4. STS를 열어 소스를 받아 준다.

5. queryDsl 작업이 되어 있기 때문에 model에 대한 Q파일을 생성 해 줘야 합니다. 
- project에서 [마우스 오른쪽 클릭 -> Maven -> Update Project...] 클릭 해 줍니다. 
- target/generated-sources/java 밑에 model과 같은 경로로 Q파일이 생성 되어 있는 지 확인 합니다.
- 안 되었을 경우 [Project -> Clean...] 을 실행 시켜 주고 다시  [마우스 오른쪽 클릭 -> Maven -> Update Project...]을 실행 해 줍니다.

5. pom.xml에 "excusion" 설정을 해 주었기 때문에 Build Path를 JDK로 변경 해 줍니다. 
- project 에서[ 마우스 오른쪽 클릭  -> Build Path -> Configure Build Path... -> Libraries] 로 이동합니다.
- JDK가 없을 경우 JDK를 추가 하고 설정 해 줍니다.

6. [ 마우스 오른쪽 클릭 -> Run As -> Spring boot app] 실행 시켜 주고 정상적으로 Token을 받아오는지 확인해 줍니다.

## Swagger
1 [Reuqest Mapping URL] (http://localhost:8300/swagger-ui.html) <br>
2 SwaggerConfig.java <br>
- Swagger에 관련된 환경설정 클래스 <br>

## ORM (Hibernate / Jpa / Dsl) 
1 테이블 생성
- 테이블 기능정의서에 수기되어있는 모델로 테이블 생성하였습니다.
- 개발하면서 수정가능하며 테이블 컬럼 type 및 size 변경이 필요할 수 있습니다. 

2 Jpa 생성
- 작성 하고자 하는 Repository를 생성 해 줍니다. 
- extends로 JPARepository 를 설정 해 주고 함수와 함께 @Query를 이용하여 쿼리를 작성 해 줍니다.

3 QueryDsl 생성
- 먼저 [2 Jpa 생성]을 먼저 작업 완료 해 줍니다. 
- 2가지의 파일을 생성 해 줘야 합니다. [ !! 꼭 Jpa 파일명과 동일 해야 인식 합니다. ]
   1. custom 및 impl 파일 생성을 해 줍니다. 
   2. custom의 경우 생성 하고자 하는 JpaRepository 파일의 명 앞에 붙여 주시면 됩니다. ex) customXXXRepository.java
   3. custom의 Interface를 만들었다면 이제 Impl 파일을 생성 해 줍니다. 
   4. Impl 파일의 경우도 동일하게 JpaRepository 파일 명 뒤에 붙여 주시면 됩니다. ex) XXXRepositoryImpl.java
- 많은 쿼리가공을 하기 위해 queryFactory를 사용하고 있습니다. 
- queryFactory의 경우 설정이 완료 되었고 Impl Class 안에 queryFactory를 추가 하고 사용 하면 될 것 같습니다. 
- 자세한 내용은 아래 URL을 참고 부탁 드립니다. 
   1. https://victorydntmd.tistory.com/206 		- queryDsl 설정 및 간단 쿼리 및 DTO 사용법
   2. https://joont92.github.io/jpa/QueryDSL/ 	- query를 queryDsl에 맞게 select, update, delete 하는법 Join, where 등등 사용법
   3. https://coding-start.tistory.com/99 		- 설정 및 query를 queryDsl에 맞게 select, update, delete 하는법 Join, where 등등 사용법

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




