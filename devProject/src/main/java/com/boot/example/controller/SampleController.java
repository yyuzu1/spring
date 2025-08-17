package com.boot.example.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.boot.example.domain.ExampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//순수하게 데이터만 전송할 ㄸㅐ 사용
@RestController
@RequestMapping("/sample")
public class SampleController {

    //@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
    @GetMapping(value="/getText",produces = MediaType.TEXT_PLAIN_VALUE)
    public String getText() {
        return "안녕하세요";
    }

    //@GetMapping(value="/getExample",produces = MediaType.APPLICATTION_JSON_VALUE)
    @GetMapping("/getExample")
    public ExampleVO getSample() {
        return new ExampleVO(1,"홍길동","010-1234-9087");
    }

    @GetMapping("/getList")
    public List<ExampleVO> getList() {
        List<ExampleVO> list = new ArrayList<>();
        list.add(new ExampleVO(1, "한유주","010-4984-8947"));
        list.add(new ExampleVO(2, "한우봄","010-4554-8977"));
        list.add(new ExampleVO(3, "한애기","010-8797-4891"));
        list.add(new ExampleVO(4, "박호박","010-8971-4413"));

        return list;
    }

    @GetMapping(value="/getMap", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ExampleVO> getMap() {
        Map<String, ExampleVO> map = new HashMap<>();
        map.put("First", new ExampleVO(5, "박오뎅","010-1212-5245"));

        return map;
    }
}
