package hello.springmvc.basic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("/post")
    public String post(@RequestBody JsonNode requestBody) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> stringObjectMap = objectMapper.readValue(requestBody.toString(), new TypeReference<Map<String, Object>>() {});
            for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                log.info("key: {}", entry.getKey());
                log.info("value: {}", entry.getValue());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }

    @PostMapping("/post/v2")
    public String post2(@RequestBody hello.springmvc.basic.RequestBody requestBody) {
        Map<String, Object> fields = requestBody.getFields();
        log.info("requestBody instance: {}", requestBody);

        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            log.info("key: {}", entry.getKey());
            log.info("value: {}", entry.getValue());
        }
        return "ok";
    }
}
