package com.dreams.bubble.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreams.bubble.model.dto.question.QuestionAddRequest;
import com.dreams.bubble.model.dto.question.QuestionQueryRequest;
import com.dreams.bubble.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.dreams.bubble.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.dreams.bubble.model.entity.Question;
import com.dreams.bubble.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dreams.bubble.model.entity.User;
import com.dreams.bubble.model.vo.QuestionSubmitVO;
import com.dreams.bubble.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Bubble
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-10-08 14:21:26
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * QuestionSubmitAddRequest 题目提交信息
     *
     * @param
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
