package com.boot.example.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BookMapperTests {
    @Autowired //Autowired로 자동 주입하여 메서드 얻어옴
    private BookMapper bookMapper;

    @Test
    public void bookListTest(){
        bookMapper.bookList().stream().forEach((book -> log.info(book.toString())));
    }
}
