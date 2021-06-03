package com.project.action;

import com.project.entity.CategoryEntity;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 商品类别请求类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public class CategoryAction extends BaseAction<CategoryEntity>{

    // 增加类别
    public void save() {
        categoryService.save(model);
    }

    // 批量删除类别
    public String deleteByIds() {
        categoryService.deleteByIds(ids);
        //如果删除成功就会往下执行，我们将"true"以流的形式传给前台
        inputStream = new ByteArrayInputStream("true".getBytes()); //将"true"的字节存到流inputStream中
        return "stream";
    }

    // 修改类别
    public void update() {
        categoryService.update(model);
    }

    // 查询所有类别
    public String query() {
        jsonList = categoryService.query();
        return "jsonList";
    }

    // 分页查询所有类别数据
    public String queryJoinAdmin() {
        pageMap = new HashMap<>();
        List<CategoryEntity> categoryList = categoryService.queryJoinAdmin(model.getType(), page, rows);
        Long total = categoryService.getCount(model.getType());
        pageMap.put("rows", categoryList);
        pageMap.put("total", total);
        return "jsonMap";
    }

}
