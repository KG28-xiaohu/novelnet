package com.novelnet.demo.mapper;

import com.novelnet.demo.pojo.Bookshelf;
import org.apache.ibatis.annotations.Param;

public interface BookshelfMapper {
    //收藏图书
    int addBook(@Param("uid") int uid, @Param("bid") int bid, @Param("collectTime") String collectTime);
    //判断图书是否存在
    Bookshelf isHaveBookshelf(@Param("uid") int uid, @Param("bid") int bid);
}
