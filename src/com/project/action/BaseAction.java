package com.project.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.project.entity.FileEntity;
import com.project.service.*;
import com.project.util.FileUploadUtil;
import lombok.Data;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * 公共请求类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description:
 */
@Data
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {
    protected Integer page;
    protected Integer rows;
    /** pageMap存放查询的数据，然后打包成json格式 */
    protected Map<String, Object> pageMap = null;
    /** 删除的ids */
    protected String ids;
    /** 流是用来向前台返回数据的，这个数据是让struts获取的，然后通过流的形式传到前台 */
    protected InputStream inputStream;
    /** 装有将要被打包成json格式返回给前台的数据 */
    protected List<T> jsonList = null;
    protected FileEntity fileImage;

    @Resource// 这里没有在bean.xml配置，用了@Componet，所以要@Resource注入
    protected FileUploadUtil fileUploadUtil;

    //service对象
    protected AdminService adminService;// Lombok会代替Spring的设值注入（不用Resource），前提实现类没有使用@Service注入
    protected CategoryService categoryService;
    protected ProductService productService;
    protected OrderService orderService;
    protected ItemService itemService;
    protected UserService userService;
    protected StatusService statusService;
    protected PayService payService;

    // 三大作用域
    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;
    /** 实体参数 */
    protected T model;

    @Override// 这个方法避免了前台Jsp页面category.id=1的传参方式，直接id=1就行了
    public T getModel() { //这里通过解析传进来的T来new一个对应的instance
        Class<T> clazz = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            model = (T)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return model;
    }
}
