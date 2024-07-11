package com.chatbot.api.domain.ai.service;

import com.alibaba.fastjson.JSON;
import com.chatbot.api.domain.ai.IOpenAi;
import com.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import com.chatbot.api.domain.ai.model.vo.Choices;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Fan
 * @description
 * @date 2024/07/11 14:38
 **/
@Service
public class OpenAi implements IOpenAi {

    private Logger logger = LoggerFactory.getLogger(OpenAi.class);

    @Value("${chatbot-api.sparkAppKey}")
    private String sparkAppKey;
    @Value("${chatbot-api.sparkAppSecret}")
    private String sparkAppSecret;

    @Override
    public String doSparkLite(String question) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpPost post = new HttpPost("https://spark-api-open.xf-yun.com/v1/chat/completions");
            post.addHeader("Content-Type", "application/json");
            post.addHeader("Authorization", "Bearer " + sparkAppKey + ":" + sparkAppSecret);

            String paramJson = "{\n" +
                    "    \"model\":\"general\",\n" +
                    "    \"messages\": [\n" +
                    "        {\n" +
                    "            \"role\": \"user\",\n" +
                    "            \"content\": \"" + question + "\"\n" +
                    "        }\n" +
                    "    ]" +
                    "}";

            StringEntity stringEntity = new StringEntity(paramJson, "UTF-8");
            post.setEntity(stringEntity);

            CloseableHttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String jsonStr = EntityUtils.toString(response.getEntity());
                AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
                StringBuilder answer = new StringBuilder();
                for (Choices choices : aiAnswer.getChoices()) {
                    answer.append(choices.getMessage().getContent());
                }
                return answer.toString();
            } else {
                throw new RuntimeException("sparkLite Err Code is " + response.getStatusLine().getStatusCode());
            }
        }
    }


}
