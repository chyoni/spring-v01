package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {} age ={}", username, age);
        response.getWriter().write("ok");
    }

    // * 여기서 ResponseBody annotation은 @Controller이면서 String이면 리턴한 값으로 된 이름의 뷰를 찾는다고 했잖아,
    // * 그리고 @RestController 일 때 String이면 그 스트링 값이 그대로 response body에 던져진다고 했고, 근데 지금 Controller 면서 String 이니까
    // * 뷰 이름을 찾는데 그러지말고 얘를 Response body에 넣어라 라는게 @ResponseBody annotation
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username = {} age ={}", memberName, memberAge);
        return "ok";
    }

    // * 이제 parameter랑 URL에서 받는 key가 동일한 값이면 이렇게 생략이 가능하다.
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username = {} age ={}", username, age);
        return "ok";
    }

    // * 근데 V3 보다 더 나아가서 저 @RequestParam 마저도 생략할 수 있다. 근데 String, int, Integer같은 단순 타입이어야 한다. (당연히 URL에서 받는 key랑 parameter랑 같아야하고)
    // * 근데 난 V3가 더 좋긴하다. 너무 생략되어있네 이건
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ) {
        log.info("username = {} age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age
    ) {
        // ! 그 int a = null 불가능하니까 Integer 라는 객체타입으로 선언해줘야함, 또는 defaultValue를 선언하거나
        log.info("username = {} age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true) String username,
            @RequestParam(required = false, defaultValue = "0") int age
    ) {
        log.info("username = {} age ={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam() Map<String, Object> paramMap
    ) {
        log.info("map = {}", paramMap);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username ={} age ={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    // * 위에꺼랑 똑같은데 @ModelAttribute를 생략할 수 있다.
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username ={} age ={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
