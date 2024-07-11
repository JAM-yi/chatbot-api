package com.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @author Fan
 * @description
 * @date 2024/07/11 14:33
 **/
public interface IOpenAi {

    String doSparkLite(String question) throws IOException;
}
