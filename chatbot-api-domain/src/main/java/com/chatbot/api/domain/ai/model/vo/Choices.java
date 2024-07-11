package com.chatbot.api.domain.ai.model.vo;

/**
 * @author Fan
 * @description
 * @date 2024/07/11 14:40
 **/
public class Choices {

    private Message message;
    private int index;

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
