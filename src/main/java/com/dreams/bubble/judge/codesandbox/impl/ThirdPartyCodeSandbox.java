package com.dreams.bubble.judge.codesandbox.impl;

import com.dreams.bubble.judge.codesandbox.model.ExecuteCodeRequest;
import com.dreams.bubble.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements com.dreams.bubble.judge.codesandbox.CodeSandbox {
    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
