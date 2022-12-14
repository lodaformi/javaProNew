package com.loda.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author loda
 * @Date 2022/11/8 20:40
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class Note {
    private Integer typeId;
    private String typeName;
    private Integer userId;
    private Integer noteId;
    private String title;
    private String content;
    private Date pubTime;
    private Float lon;
    private Float lat;
}
