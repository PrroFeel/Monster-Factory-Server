<br/>
<div align=center><img width=50% src='https://user-images.githubusercontent.com/101858177/204172728-a76ab656-2d02-43a7-9c2f-1a0769f3a30d.png'/><div>
<hr/>
<div align=center> MONSTER FACTORY는 게임을 제작하고, 플레이할 수 있는 게임용 메타버스 플랫폼입니다 </div>
<div align=center> 이 repository는 MONSTER FACTORY 개발용 백엔드 제작 REPO입니다 </div>


<br/>
<br/>
<br/>
<h3 align=center> 사용 언어 및 개발 환경 </h3>
<hr/>
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=flat-square&logo=springsecurity&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonRDS-527FFF?style=flat-square&logo=amazonrds&logoColor=white"/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonS3-569A31?style=flat-square&logo=amazons3&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=flat-square&logo=amazonec2&logoColor=white"/>
<img src="https://img.shields.io/badge/FrontCloud-FF4F8B?style=flat-square&logo=frontcloud&logoColor=white"/>
<br/>
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-EF2D5E?style=flat-square&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/JPA-F3702A?style=flat-square&logo=jpa&logoColor=white"/>
<img src="https://img.shields.io/badge/ApacheTomcat-F8DC75?style=flat-square&logo=apachetomcat&logoColor=white"/>
<img src="https://img.shields.io/badge/RestAPI-004088?style=flat-square&logo=restapi&logoColor=white"/>


<br/>
<br/>
<br/>
<br/>
<h3 align=center> 프로젝트 주요 기능 </h3>
<hr/>
<br/>
<strong> 1️⃣ 도메인 주도 설계 </strong>
<div> 도메인 주도 설계를 기반으로 도메인 처리 중심의 비지니스 처리 및 변경성을 확보 했습니다 </div>
<br/>
<strong> 2️⃣ DIP </strong>
<div> 의존 역전 원칙 (DIP)을 적용해 유지 보수와 수정이 용이합니다 </div>
<br/>
<strong> 3️⃣ CQRS 패턴 </strong>
<div> Query와 Command를 분리해 자주 사용되는 조회 성능을 높이고 </div>
<div> 사용 횟수가 현저히 많은 조회를 별도의 솔루션으로 관리할 수 있도록 확장성을 고려합니다 </div>
<br/>
<strong> 4️⃣ JPA </strong>
<div> JPA를 사용해, 불필요한 코드의 반복되는 작성을 줄이면서 개발 시간을 단축 했습니다 </div>
<br/>
<strong> 5️⃣ 파일 관련 </strong>
<div> 파일 업로드 및 조회에서 발생하는 파일 관련 트래픽 부하를 줄여서 성능을 높이기 위해 S3 Storage를 사용 합니다 </div>
<div> s3의 CloudFront 배포를 통해 엣지 로케이션에서 보다 빠른 응답을 할 수 있도록 합니다 </div>
<br/>
<strong> 6️⃣ Spring Security </strong>
<div> Spring Security를 사용해 인증된 유저만 접근을 허용하는 보안 처리를 했습니다 </div>
<br/>
<strong> 7️⃣ BCrypt </strong>
<div> BCrypt 암호화를 이용해 회원 정보에 대한 보안을 강화했습니다 </div>
<br/>
<strong> 8️⃣ DB 관리 </strong>
<div> MySQL DB를 Amazon RDS 서비스로 구축해 DB를 편리하게 관리할 수 있도록 합니다 </div>
<br/>
<strong> 9️⃣ swagger </strong>
<div> 협업에서의 원활한 api 서버 이용을 위해 Swagger 명세서를 작성했습니다 </div>
<br/>
<strong> 1️⃣0️⃣ Docker </strong>
<div> Docker를 이용해 배포할 어블리케이션을 안전하게 빌드하고 실행할 수 있게 합니다 </div>
<br/>
<strong> 1️⃣1️⃣ EC2 </strong>
<div> 공통된 서비스를 제공하기 위해서 EC2 인스턴스로 서버 어플리케이션을  </div>
