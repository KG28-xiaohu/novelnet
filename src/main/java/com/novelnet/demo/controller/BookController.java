package com.novelnet.demo.controller;

import com.novelnet.demo.pojo.Book;
import com.novelnet.demo.pojo.Result;
import com.novelnet.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    private IBookService iBookService;

    /**
     * 获取图书所有类型的方法，返回字符串集合
     * 无需要参数
     * 返回值：200-成功
     */
    @GetMapping("/getType")
    public Result getType(){
        return new Result(200, iBookService.getType(), "getType OK!!!");
    }

    /**
     * 获取图书的方法
     * 需要参数：type-类型（选填）、name-书名（选填）（用params传参）
     * 返回值：200-成功
     */
    @GetMapping("/getBooks")
    public Result getBooks(@RequestParam("type") String type, @RequestParam("name") String name){
        List<Book> books = iBookService.getBooks(type, name);
        return new Result(200, books, "getBooks OK!!!");
    }

    /**
     * 获取图书详情的方法（包括图书章节信息）
     * 需要参数：bid-图书id
     * 返回值：200-成功
     */
    @GetMapping("/getBook")
    public Result getBook(@RequestParam("bid") int bid){
        Book book = iBookService.getBook(bid);
        return new Result(200, book, "getBook OK!!!");
    }
}
