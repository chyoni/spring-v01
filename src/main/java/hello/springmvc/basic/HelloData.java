package hello.springmvc.basic;

import lombok.Data;

// * @Data가 이제 toString(), getter, setter 다 대신 만들어주는 녀석
@Data
public class HelloData {
    private String username;
    private int age;
}
