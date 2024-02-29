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
    private int cid;
    private int chapterNum;
    private String title;
    private String collectTime;
    private Book book;
}
