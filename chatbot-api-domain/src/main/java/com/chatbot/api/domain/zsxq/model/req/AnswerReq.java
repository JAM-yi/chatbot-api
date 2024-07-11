package com.chatbot.api.domain.zsxq.model.req;

/**
 * @author Fan
 * @description 请求问答接口信息
 * @date 2024/07/10 20:54
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }

}