package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestBodyJsonV2Controller {

    // ! ObjectMapper를 사용안하고도 이렇게 Json을 바로 객체로 읽어들여서 쓸 수 있다.

    @ResponseBody
    @PostMapping("/request-body-json-v2/v0")
    public String requestBodyJsonV0(HttpEntity<HelloData> helloData) {
        HelloData data = helloData.getBody();
        log.info("username={} age={}", data.getUsername(), data.getAge());
        return "ok";
    }

    // ******************************************************************** //

    @ResponseBody
    @PostMapping("/request-body-json-v2/v1")
    public String requestBodyJson(@RequestBody HelloData helloData) {
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2/v2")
    public HelloData requestBodyJsonV2(@RequestBody HelloData helloData) {
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }
}
