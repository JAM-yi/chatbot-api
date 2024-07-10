package com.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Fan
 * @description 单元测试
 * @date 2024/07/10 18:09
 **/
public class ApiTest {

    @Test
    public void queryUnanswerdQuestions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28888225542111/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "zsxq_access_token=0671E971-DD50-6489-8A56-BBA756A9CF7A_CAB9A97C7045E4E3; abtest_env=product; zsxqsessionid=d9071943be8e61badb43eadfa2a5eacf");
        get.addHeader("Content-Type", "application/json, text/plain, */*");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String resStr = EntityUtils.toString(response.getEntity());
            System.out.println(resStr);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855448111442542/answer");
        post.addHeader("cookie", "zsxq_access_token=BC371116-1896-CEBC-3A91-D90C0556D918_CAB9A97C7045E4E3; abtest_env=product; zsxqsessionid=ea732f1c85a2c5c497ff43e6292e5c5c");
        post.addHeader("Content-Type", "application/json, text/plain, */*");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不知道\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String resStr = EntityUtils.toString(response.getEntity());
            System.out.println(resStr);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
