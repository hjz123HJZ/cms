package com.briup.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 轮播图
 * </p>
 *
 * @author briup
 * @since 2023-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_slideshow")
public class Slideshow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 轮播图编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 描述
     */
    private String description;

    /**
     * 轮播图片url
     */
    @NotBlank(message = "url不能为空")
    private String url;

    /**
     * 图片状态
     */
    private String status;

    /**
     * 删除状态
     */
    @TableLogic
    private Integer deleted;

    /**
     * 上传时间
     */
    /**
     * 上传时间，GMT指格林尼治所在地标准时间，＋8：00就是东八区的时间，即北
     京时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime uploadTime;


}
