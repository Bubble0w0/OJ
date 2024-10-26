package com.dreams.bubble.judge.strategy;

import com.dreams.bubble.model.dto.question.JudgeCase;
import com.dreams.bubble.judge.codesandbox.model.JudgeInfo;
import com.dreams.bubble.model.entity.Question;
import com.dreams.bubble.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文(用于定义在策略中传递的参数)
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
