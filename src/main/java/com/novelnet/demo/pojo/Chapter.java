package com.novelnet.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chapter {
    private int bid;
    private int chapter_num;
    private String title;
    private String collect_time;
    private Book book;
}
