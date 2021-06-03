package com.project.config;

import com.project.entity.CategoryEntity;
import com.project.entity.ProductEntity;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * 新的商品线程任务，用于定时更新数据
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description:
 */
@Component
public class ProductTimerTask extends TimerTask {
    @Resource
    private ProductService productService;
    @Resource
    private CategoryService categoryService;

    /** ServletContext对象，更新了后台数据后，需要存入application域里面 */
    private ServletContext application;
    /** //通过监听器将这个ServletContext对象set进来，因为这里是无法拿application对象的，只有web容器部署时才创建 */
    public void setApplication(ServletContext application) {
        this.application = application;
    }

    @Override
    public void run() {
        System.out.println("-------web服务器初始加载-------");
        List<List<ProductEntity>> bigList = new ArrayList<>(); //bigList中存放一个装有商品类的list
        for(CategoryEntity category : categoryService.queryByHot(1)) {// 查询出热点类别
            List<ProductEntity> lst = productService.queryByCategoryId(category.getId());// 根据热点类别id获取推荐商品信息
            bigList.add(lst);// 将装有category的list放到bigList中
        }
        application.setAttribute("bigList", bigList); //把查询的bigList交给ServletContext内置对象，假设我们已经拿到了ServletContext对象
    }
}
