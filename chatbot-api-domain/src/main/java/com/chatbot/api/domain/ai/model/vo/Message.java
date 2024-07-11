package com.chatbot.api.domain.ai.model.vo;

/**
 * @author Fan
 * @description
 * @date 2024/07/11 14:39
 **/
public class Message {

    private String role;
    private String content;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
