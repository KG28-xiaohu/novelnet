package com.novelnet.demo.controller;

import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/bookshelf")
@CrossOrigin
public class BookshelfController {
    @Autowired
    private IBookshelfService iBookshelfService;

    /**
     * 收藏图书的方法
     * 需要参数：bid-图书id
     * 返回值：201-添加成功、400-添加失败（重复添加）
     */
    @PutMapping("/token/addBook")
    public Result addBook(HttpSession session, int bid){
        User user = (User)session.getAttribute("user");
        int i = iBookshelfService.addBook(user.getUid(), bid);
        return i < 0 ? new Result(400, null, "addBook ERROR: 重复收藏") :
                new Result(201, null, "addBook OK!!!");
    }
}
