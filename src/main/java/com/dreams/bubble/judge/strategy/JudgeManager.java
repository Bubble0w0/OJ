package com.dreams.bubble.judge.strategy;

import com.dreams.bubble.judge.codesandbox.model.JudgeInfo;
import com.dreams.bubble.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理(简化调用)
 */
@Service
public class JudgeManager {
    /**
     * 判题
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext){
         QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
         String language = questionSubmit.getLanguage();
         JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
         if ("java".equals(language)){
             judgeStrategy = new JavaLanguageJudgeStrategy();
         }
         return judgeStrategy.doJudge(judgeContext);
     }
}
