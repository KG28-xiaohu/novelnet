package com.novelnet.demo.service.impl;

import com.novelnet.demo.mapper.BookshelfMapper;
import com.novelnet.demo.pojo.Bookshelf;
import com.novelnet.demo.service.IBookshelfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Service
public class BookshelfServiceImpl implements IBookshelfService {
    @Resource
    private BookshelfMapper bookshelfMapper;

    @Override
    public int addBook(int uid, int bid) {
        if(bookshelfMapper.isHaveBookshelf(uid, bid) != null){
            return -1;
        }
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        return bookshelfMapper.addBook(uid, bid, time.toString());
    }
}
