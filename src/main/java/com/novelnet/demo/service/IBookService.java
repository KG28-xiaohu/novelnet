package com.novelnet.demo.service;

import com.novelnet.demo.pojo.Book;

import java.util.List;

public interface IBookService {
    //获取图书类型
    List<String> getType();
    //获取图书
    List<Book> getBooks(String type, String name, int num);
    //获取图书详情
    Book getBook(int bid);
}
