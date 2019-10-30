package com.lqw.vblog.controller.admin;

import com.lqw.vblog.constants.Response.ResponseCode;
import com.lqw.vblog.entity.Article;
import com.lqw.vblog.exception.BaseResponse;
import com.lqw.vblog.exception.ResponseResult;
import com.lqw.vblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@BaseResponse

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/article/all", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult getArticleByAdmin(@RequestParam("id") int id) throws Exception {
        Article article = articleService.getById(id);
        Map<String, String> map = new HashMap<>();
        map.put(article.getId().toString(), article.getTitle());
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseCode.RESPONSE_SUCCESS.getCode());
        responseResult.setData(map);
        return responseResult;
    }


}
