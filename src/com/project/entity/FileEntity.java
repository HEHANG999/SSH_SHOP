package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * 文件实体类
 * @Created: 何航
 * @Date: 2021/5/12
 * @Description: 注意这里的命名，比如文件接收类型默认是uploadContentType而不能是contentType（可以set设置）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FileEntity {
    /** 上传文件 */
    private File upload;
    /** 文件类型 */
    private String uploadContentType;
    /** 文件名称 */
    private String uploadFileName;
}
