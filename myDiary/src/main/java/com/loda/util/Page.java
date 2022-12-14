package com.loda.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/9 20:44
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class Page<T> {
    private Integer pageCurNum;  // 当前页  （前台传递的参数；如果前台未传递，则默认第一页）
    private Integer pageSize; // 每页显示的数量 （前台传递或后台设定）
    private Long totalCount;  // 总记录数 （后台数据库中查询得到；count()函数）

    private Integer totalPages;
    private Integer prePage;
    private Integer nextPage;

    private Integer startNavPage;
    private Integer endNavPage;

    private List<T> dataList;

    public Page(Integer pageCurNum, Integer pageSize, Long totalCount) {
        this.pageCurNum = pageCurNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        this.totalPages = (int)Math.ceil(totalCount / (pageSize* 1.0));
        this.prePage = pageCurNum - 1 < 1 ? 1 : pageCurNum - 1;

        this.nextPage = pageCurNum + 1 > totalPages ? totalPages : pageCurNum + 1;

        this.startNavPage = pageCurNum - 5;
        this.endNavPage = pageCurNum + 4;

        if (this.startNavPage < 1){
            this.startNavPage = 1;
            this.endNavPage = this.startNavPage + 9 > totalPages ? totalPages : this.startNavPage + 9;
        }
        if (this.endNavPage > totalPages) {
            this.endNavPage = totalPages;
            this.startNavPage = this.endNavPage - 9 < 1 ? 1 : this.endNavPage - 9;
        }
    }
}
