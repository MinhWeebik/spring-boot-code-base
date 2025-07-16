package com.base.base.controller;

import com.base.base.service.ExampleService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ex")
@Log4j2
@Validated
public class ExampleController {

    private static ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public ResponseEntity<?> get(
            @RequestParam("type")
            @NotNull String type
    ) {
        Map<String,Object> map = exampleService.getExamples(type);
        log.info("Get " + type + " example success");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
