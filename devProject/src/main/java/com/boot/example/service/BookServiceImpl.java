package com.boot.example.service;

import com.boot.example.domain.Book;
import com.boot.example.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //구현클래스에 서비스 어노테이션 안 하면 인터페이스 생성 못 함
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Override
    public List<Book> bookList() {
        return bookMapper.bookList();
    }
    // Required매개변수생성자 얻으려면 타입 파이널로 지정해야 함
}
