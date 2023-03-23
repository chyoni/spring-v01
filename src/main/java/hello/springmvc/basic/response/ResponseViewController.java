package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // ! ModelAndView를 리턴하는 방식과 String을 리턴하는 방식 모두 곧 View를 띄워주는데 우리 둘 다 해봤음.
    // ! ModelAndView를 리턴하면, 원하는 viewPath와 데이터를 모두 한번에 정의해서 Dispatcher Servlet한테 던져주는 것
    // ! String을 리턴하면, 리턴한 값이 곧 viewPath가 되고 데이터는 Model을 parameter로 Dispatcher Servlet이 던져주면 그 던져진 model을 가지고 데이터를 작업하기만 하면 됨
    // ! 그렇게 작업하고 viewPath 자체를 리턴하면 Dispatcher Servlet이 자기가 던진 model에 데이터는 들어와있고 리턴 받은 viewPath로 View를 띄움

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    // * 이 방법은 권장하지는 않음. 여튼 @Controller 만 되어있고 리턴 타입이 void면 request URL이 곧 viewName이 된다는 방식인데 쓰지 말자.
//    @RequestMapping("/response/hello")
//    public void responseViewV3(Model model) {
//        model.addAttribute("data", "hello!");
//    }
}
