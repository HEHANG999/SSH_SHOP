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
 * �µ���Ʒ�߳��������ڶ�ʱ��������
 * @Created: �κ�
 * @Date: 2021/5/13
 * @Description:
 */
@Component
public class ProductTimerTask extends TimerTask {
    @Resource
    private ProductService productService;
    @Resource
    private CategoryService categoryService;

    /** ServletContext���󣬸����˺�̨���ݺ���Ҫ����application������ */
    private ServletContext application;
    /** //ͨ�������������ServletContext����set��������Ϊ�������޷���application����ģ�ֻ��web��������ʱ�Ŵ��� */
    public void setApplication(ServletContext application) {
        this.application = application;
    }

    @Override
    public void run() {
        System.out.println("-------web��������ʼ����-------");
        List<List<ProductEntity>> bigList = new ArrayList<>(); //bigList�д��һ��װ����Ʒ���list
        for(CategoryEntity category : categoryService.queryByHot(1)) {// ��ѯ���ȵ����
            List<ProductEntity> lst = productService.queryByCategoryId(category.getId());// �����ȵ����id��ȡ�Ƽ���Ʒ��Ϣ
            bigList.add(lst);// ��װ��category��list�ŵ�bigList��
        }
        application.setAttribute("bigList", bigList); //�Ѳ�ѯ��bigList����ServletContext���ö��󣬼��������Ѿ��õ���ServletContext����
    }
}
