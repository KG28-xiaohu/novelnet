package com.novelnet.demo.controller;

import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.pojo.User;
import com.novelnet.demo.service.IBookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/bookshelf")
@CrossOrigin
public class BookshelfController {
    @Autowired
    private IBookshelfService iBookshelfService;

    /**
     * 收藏图书的方法
     * 需要参数：bid-图书id（params传参）
     * 返回值：201-添加成功、400-添加失败（重复添加）
     */
    @PutMapping("/token/addBook")
    public Result addBook(HttpSession session, int bid){
        User user = (User)session.getAttribute("user");
        return iBookshelfService.addBook(user.getUid(), bid) < 0 ?
                new Result(400, null, "addBook ERROR: 重复收藏") :
                new Result(201, null, "addBook OK!!!");
    }

    /**
     * 移除收藏图书的方法
     * 需要参数：bid-图书id（params传参）
     * 返回值：200-移除成功、400-移除失败（重复添加）
     */
    @DeleteMapping("/token/delBook")
    public Result delBook(HttpSession session, int bid){
        User user = (User)session.getAttribute("user");
        return iBookshelfService.delBook(user.getUid(), bid) < 0 ?
                new Result(400, null, "delBook ERROR: 删除失败") :
                new Result(200, null, "delBook OK!!!");
    }
}
