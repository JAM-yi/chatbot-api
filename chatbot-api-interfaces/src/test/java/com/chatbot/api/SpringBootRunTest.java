package com.chatbot.api;

import com.alibaba.fastjson.JSONObject;
import com.chatbot.api.domain.ai.IOpenAi;
import com.chatbot.api.domain.zsxq.IZsxqApi;
import com.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.chatbot.api.domain.zsxq.model.vo.Topics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author Fan
 * @description
 * @date 2024/07/10 21:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;
    @Value("${chatbot-api.sparkAppKey}")
    private String sparkAppKey;
    @Value("${chatbot-api.sparkAppSecret}")
    private String sparkAppSecret;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAi openAi;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSONObject.toJSONString(unAnsweredQuestionsAggregates));
        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics item : topics) {
            String topicId = item.getTopic_id();
            String text = item.getQuestion().getText();
            logger.info("topicId:{}, text:{}", topicId, text);

            // 回答问题

        }
    }

    @Test
    public void test_sparkLite() throws IOException {
        String response = openAi.doSparkLite("帮我写一个Java归并排序");
        logger.info("测试结果：{}", response);
    }


}
