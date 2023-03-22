package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 이 예제같은 경우 userId에 대한 PathVariable을 다른 변수 이름으로 쓰고 싶을 땐 저렇게 userId에 대한 PathVariable임을 명시해줘야 한다.
     * 근데 이 바로 아래 예제 같은 경우 PathVariable에 대한 변수 이름을 동일하게 사용할 경우 ("userId") 같은 걸 생략해도 된다.
     * @param id
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String id) {
        log.info("mapping Path userId= {}", id);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/order/{orderCount}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderCount) {
        log.info("mapping Path userId= {}, orderCount= {}", userId, orderCount);
        return "ok";
    }

    /**
     * path 뒤에 ?mode=debug 가 있어야만 호출
     * params = "mode" 파라미터로 mode 라는 키가 있어야 한다는 뜻
     * params = "!mode" 파라미터로 mode 라는 키가 없어야 한다는 뜻
     * params = "mode=debug" 파라미터로 mode 라는 키에 debug 라는 밸류가 있어야 한다는 뜻 (현재 우리 예제)
     * params = "mode != debug" 파라미터로 mode 라는 키에 debug 라는 밸류는 없어야 한다는 뜻
     * params = {"mode=debug", "data=good"} 파라미터로 mode=debug, data=good 모두 있어야 한다는 뜻
     * @return
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더 추가로 매핑
     * headers = "mode"  mode 라는 키가 헤더에 있어야 한다는 뜻
     * headers = "!mode" mode 라는 키가 헤더에 없어야 한다는 뜻
     * headers = "mode=debug" mode 라는 키에 debug 라는 밸류가 헤더에 있어야 한다는 뜻 (현재 아래 예제)
     * headers = "mode!=debug" mode 라는 키에 debug 라는 밸류는 없어야 한다는 뜻
     * @return
     */
    @GetMapping(value = "/mapping-param", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * 헤더에서 Content-Type을 명시하는 방법
     * consumes = "application/json"  application/json 이어야 한다.
     * consumes = "!application/json" application/json 이 아니어야 한다.
     * consumes = "application/*" application/아무거나
     * consumes = "*\/*" 진짜 아무거나
     * @return
     */
    @GetMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * 헤더에서 Accept를 명시하는 방법
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     * @return
     */
    @GetMapping(value = "/mapping-produces", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
