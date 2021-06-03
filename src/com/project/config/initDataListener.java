package com.project.config;

import com.project.util.FileUploadUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

/**
 *  自定义监听器
 * @Created: 何航
 * @Date: 2021/5/13
 * @Description: 用于服务器初始化时加载数据
 */
//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的，不能放到Spring中
public class initDataListener implements ServletContextListener {

    @Override// ServletContextEvent服务器上部署应用程序时调用
    public void contextInitialized(ServletContextEvent event) {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        ProductTimerTask productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");// 注意这里是ServletContext的方式获取bean，@Resource不可用
        productTimerTask.setApplication(event.getServletContext());

        // 通过设置定时器，让首页的数据每个一小时同步一次（配置为守护线程）
        // 第一个参数是指定任务，即TimerTask对象；第二个参数为第一次开启任务时间；第三个参数为时间间隔，即每隔多长时间执行一次
        new Timer(true).schedule(productTimerTask,0,1000*60*60);


        //将存储银行图片的数组放到application中，项目启动的时候加载
        FileUploadUtil fileUpload = (FileUploadUtil) context.getBean("fileUploadUtil");
        event.getServletContext().setAttribute("bankImageList", fileUpload.getBankImage());
    }
}
