package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-json-v1")
    public void responseBodyV1() {

    }
}
