package com.example.basedemo.entity;
import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * 对Page<E>结果进行包装
 * <p/>
 * 新增分页的多项属性，主要参考:http://bbs.csdn.net/topics/360010907
 * 〈分页〉
 *
 * @author Chkl
 * @create 2019/5/14
 * @since 1.0.0
 *
 * @version 3.3.0
 * @since 3.2.2
 * 项目地址 : http://git.oschina.net/free/Mybatis_PageHelper
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int current;
    //每页的数量
    private int size;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> records;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param records
     */
    public PageInfo(List<T> records) {
        if (records instanceof Page) {
            Page page = (Page) records;
            this.current = page.getPageNum();
            this.size = page.getPageSize();

            this.pages = page.getPages();
            this.records = page;
            this.total = page.getTotal();
        } else if (records instanceof Collection) {
            this.current = 1;
            this.size = records.size();

            this.pages = 1;
            this.records = records;
            this.total = records.size();
        }
        if (records instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = current == 1;
        isLastPage = current == pages;
    }

}
