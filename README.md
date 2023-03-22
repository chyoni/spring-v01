# Spring MVC

### #01 Init

    - https://start.spring.io (해당 링크에서 spring boot로 프로젝트 생성)
    - spring boot에 Jar를 사용하면, src/main/resources/static/index.html 위치에 index.html 파일을 두면 Welcome 
    페이지로 처리해준다. (스프링 부트가 지원하는 정적 컨텐츠 위치에 /index.html이 있으면 된다.

### #02 slf4j / @RestController

    - 우선, slf4j를 이용해서 로그를 찍고, 로그 레벨을 패키지 별로 설정하는 방법에 대한 커밋
    - @RestController는 @Controller랑 어떤 차이가 있냐면 @Controller는 반환 값이 String이면 뷰 이름으로 인식하고
    그래서 뷰를 찾고 뷰가 렌더링 되는 방식이다. 근데 @RestController는 반환 값으로 뷰를 찾는것이 아니라 HTTP 메시지 바디에
    바로 입력을 해준다.

### #03 Request Mapping 방법 

    - RequestMapping 에는 URL로 매핑, Method로 매핑, Header에 특정 키밸류 쌍으로 매핑, Content-Type으로 매핑
    Accept로 매핑, PathVariable로 매핑 등 여러 방법이 있고 하나하나 다 알아보자. 그리고 GetMapping, PostMapping 
    얘네는 RequestMapping(value= "/asdasd" method = GET) 이거랑 똑같은데 귀찮으니까 그냥 바로 Method를 지정해버린거다.