package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ! RestController는 return type의 String이 response의 html body안에 그대로 찍히게 하는 Controller
@RestController
@Slf4j
public class LogTestController {

    // ! 저 위에 @Slf4j 이게 아래 코드를 대신 해주는 annotation
    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // ! 개발 서버 또는 로컬에서는 여기서부터 찍기도 한다.
        log.trace("trace log = {}", name); // log level 1
        log.debug("debug log = {}", name); // log level 2

        // ! 운영 단계에서는 info부터 보통 찍는다.
        log.info("info log= {}", name); // log level 3
        log.warn("warn log = {}", name); // log level 4
        log.error("error log = {}", name); // log level 5

        return "ok";
    }
}
