package com.novelnet.demo.service.impl;

import com.novelnet.demo.mapper.BookMapper;
import com.novelnet.demo.pojo.Book;
import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<String> getType() {
        List<Book> bookList = bookMapper.getType();
        return bookList.stream().map(Book::getType).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooks(String type, String name) {
        return bookMapper.getBooks(type, name);
    }

    @Override
    public Book getBook(int bid) {
        return bookMapper.getBook(bid);
    }
}
