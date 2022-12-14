package com.loda.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/9 21:10
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Setter
@Getter
public class NoteInfo {
    private String groupName;  // 分组名称
    private long noteCount;  // 云记数量

    private Integer typeId; // 类型ID
}
