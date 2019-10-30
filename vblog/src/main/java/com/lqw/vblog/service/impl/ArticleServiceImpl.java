package com.lqw.vblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqw.vblog.entity.Article;
import com.lqw.vblog.mapper.article.ArticleMapper;
import com.lqw.vblog.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {



}
