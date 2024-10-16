package com.dreams.bubble.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dreams.bubble.annotation.AuthCheck;
import com.dreams.bubble.common.BaseResponse;
import com.dreams.bubble.common.ErrorCode;
import com.dreams.bubble.common.ResultUtils;
import com.dreams.bubble.constant.UserConstant;
import com.dreams.bubble.exception.BusinessException;
import com.dreams.bubble.model.dto.question.QuestionQueryRequest;
import com.dreams.bubble.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.dreams.bubble.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.dreams.bubble.model.entity.Question;
import com.dreams.bubble.model.entity.QuestionSubmit;
import com.dreams.bubble.model.entity.User;
import com.dreams.bubble.model.vo.QuestionSubmitVO;
import com.dreams.bubble.service.QuestionSubmitService;
import com.dreams.bubble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *

 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录的id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }
    /**
     * 分页获取题目提交列表(除了管理员外，普通用户只能看到非答案，提交代码等公开信息)
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                   HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 从数据库中获取原始的题目提交分页信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        //返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
    }

}
