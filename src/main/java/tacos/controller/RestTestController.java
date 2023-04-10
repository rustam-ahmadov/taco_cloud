package tacos.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.entity.RestTestData;

@RestController
@RequestMapping("rest-test")
@Slf4j
public class RestTestController {
    @PostMapping
    public void testData(@Valid @RequestBody RestTestData data) {
      log.info(String.format("Data: %s", data.toString()) );
    }
}
