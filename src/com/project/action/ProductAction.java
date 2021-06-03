package com.project.action;

import com.project.entity.ProductEntity;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 商品请求类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
public class ProductAction extends BaseAction<ProductEntity>{
    // 添加商品
    public void save() {
        //fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
        String pic = fileUploadUtil.uploadFile(fileImage);
        model.setPic(pic);
        model.setDate(new Timestamp(new Date().getTime())); //设置一下当前时间，因为前台没有把时间字段传进来，这里自己设置一下即可
        productService.save(model);//商品信息入库
    }

    // 批量删除商品
    public String deleteByIds() {
        productService.deleteByIds(ids);
        //如果删除成功就会往下执行，我们将"true"以流的形式传给前台
        inputStream = new ByteArrayInputStream("true".getBytes());
        return "stream";
    }

    // 修改商品
    public void update() throws Exception {
        String pic = fileUploadUtil.uploadFile(fileImage);
        model.setPic(pic);
        model.setDate(new Timestamp(new Date().getTime())); //设置一下当前时间，因为前台没有把时间字段传进来，这里自己设置一下即可
        productService.update(model);//更新商品
    }

    // 查询所有商品数据
    public String queryJoinCategory() {
        //用来存储分页的数据
        pageMap = new HashMap<String, Object>();
        //根据关键字和分页的参数查询相应的数据
        List<ProductEntity> productList = productService.queryJoinCategory(model.getName(), page, rows);
        pageMap.put("rows", productList); //存储为JSON格式
        //根据关键字查询总记录数
        Long total = productService.getCount(model.getName());
        pageMap.put("total", total); //存储为JSON格式
        return "jsonMap";
    }

    // 查询商品详细信息
    public String get() {
        request.put("product", productService.getById(model.getId()));
        return "detail";
    }

}
