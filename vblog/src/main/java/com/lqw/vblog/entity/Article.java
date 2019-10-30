package com.lqw.vblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("article")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;//序列化版本ID
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;

    @TableField("title")
    private String title;

    @TableField("mdContent")
    private String mdContent;

    @TableField("htmlContent")
    private String htmlContent;

    @TableField("summary")
    private String summary;

    @TableField("cid")
    private Long cid;

    @TableField("uid")
    private Long uid;

    @TableField("publishDate")
    private Date publishDate;

    @TableField("editTime")
    private Date editTime;

    @TableField("state")
    private Long state;

    @TableField("pageView")
    private Long pageView;


}
