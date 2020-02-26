package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanshijun on 2020/2/3.
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;//颜色为蓝色的当前页.
    private List<Integer> pages = new ArrayList<Integer>();//显示的页码有哪几个.
    private Integer totalPage;


    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage=totalPage;
        this.page = page;
        pages.add(page);
        //将page-1,page-3,page+1,...,page+3添加进去
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        }
        {
            showEndPage = true;
        }

    }
}
