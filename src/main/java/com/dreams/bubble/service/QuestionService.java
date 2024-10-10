package com.dreams.bubble.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreams.bubble.model.dto.question.QuestionQueryRequest;
import com.dreams.bubble.model.entity.Question;
import com.dreams.bubble.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dreams.bubble.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Bubble
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-10-08 14:20:05
*/
public interface QuestionService extends IService<Question> {
    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);
    

    /**
     * 获取题目封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
