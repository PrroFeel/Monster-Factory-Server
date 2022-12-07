<br/>
<div align=center><img width=50% src='https://user-images.githubusercontent.com/101858177/204172728-a76ab656-2d02-43a7-9c2f-1a0769f3a30d.png'/><div>
<hr/>
<div align=center> MONSTER FACTORY는 게임을 제작하고, 플레이할 수 있는 게임 메타버스 플랫폼입니다 </div>
<div align=center> 해당 REPO에서는 MONSTER FACTORY 어플리케이션의 백엔드 REST API 서버를 구현 하였습니다</div>

<br/>
<br/>
<br/>
<br/>
<h3> ✏️프로젝트 설계 주안점✏️ </h3>
<hr/>
<br/>
<div align="left">
<strong>   1️⃣ 도메인 주도 설계(DDD) </strong>
> 도메인 중심으로 서비스 기능을 제공합니다
<br/>
<strong>   2️⃣ CQRS 패턴 적용 </strong>
> Query와 Command를 분리해 조회 성능을 높이고 Query를 별도의 솔루션으로 관리합니다
<br/>
<strong>  3️⃣ CloudFront 배포 </strong>
> 정적 리소스 저장소인 s3의 CloudFront 배포를 통해 파일 접근에 대한 응답성을 높입니다
<br/>
<strong>   4️⃣ BCrypt 암호화 </strong>
> BCrypt 암호화를 이용해 DB 저장에서 이뤄지는 보안을 강화 했습니다
<br/>
<strong>   5️⃣ EC2 배포 </strong>
> 안정적이고 지속적인 서버 운영을 위해 클라우드 환경에 서버 어플리케이션을 배포합니다
</div>

<br/>
<br/>
<br/>
<h3> 🔧기술 스택🔧</h3>
<hr/> 
<br/>
<img src="https://img.shields.io/badge/Java-EF2D5E?style=flat-square&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white"/>
<img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=flat-square&logo=springsecurity&logoColor=white"/>
<img src="https://img.shields.io/badge/JPA-F3702A?style=flat-square&logo=jpa&logoColor=white"/>
<img src="https://img.shields.io/badge/RestAPI-004088?style=flat-square&logo=restapi&logoColor=white"/>
<img src="https://img.shields.io/badge/ApacheTomcat-F8DC75?style=flat-square&logo=apachetomcat&logoColor=white"/>
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=white"/>
<br/>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonRDS-527FFF?style=flat-square&logo=amazonrds&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonS3-569A31?style=flat-square&logo=amazons3&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonCloudFront-FF4F8B?style=flat-square&logo=amazoncloudfront&logoColor=white"/>
<img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=flat-square&logo=amazonec2&logoColor=white"/>
<img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white"/>
<br/>
<img src="https://img.shields.io/badge/IntelliJIDEA-000000?style=flat-square&logo=intellijidea&logoColor=white"/>
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white"/>


<br/><br/><br/><br/><br/>
<h3> 프로젝트 구조도 </h3>
<hr/>
<br/>
<img width=80% src='https://user-images.githubusercontent.com/101858177/204679614-1c99056b-1211-4715-9b65-bf7aaa946d00.png'/>


<br/><br/><br/><br/>
<h3> Wiki </h3>
<hr/>
<div> 도메인 주도 설계, CQRS 패턴을 적용한 패키지 구조, 트러블 슈팅 등 </div> 
<div> 프로젝트에 대한 추가 자료를 정리 해놓았습니다</div>
<a href="https://github.com/PrroFeel/Monster-Factory-Server/wiki">👉위키 바로가기👈</a>


<br/><br/><br/><hr/>
<div>개발자 : <a href="https://github.com/YSChoi123">최윤서</a>, <a href="https://github.com/carrtt1">최은진</a></div>
<br/>
<div> GitHub 마일스톤 기능을 이용해 프로젝트의 전반적인 이슈를 관리 하였습니다</div> 
<a href="https://github.com/PrroFeel/Monster-Factory-Server/milestones?state=closed">👉종료된 마일스톤 바로가기👈</a>
<br/>
<h3>MONSTER FACTORY의 다른 Repository </h3>
<div><a href="https://github.com/PrroFeel/Monster-Factory-Client"/>MONSTER FACTORY client 페이지 REPO</div>
<div><a href="https://github.com/PrroFeel/Monster-Factory-admin"/>MONSTER FACTORY admin 페이지 REPO</div>

<br/>
<h1></h1>
<img align=right width= 10% src='https://user-images.githubusercontent.com/101858177/204683543-275c3810-b13a-48f8-9e5f-9ba93f721872.png'/>
