package com.chatbot.api.domain.ai.model.aggregates;

import com.chatbot.api.domain.ai.model.vo.Choices;
import com.chatbot.api.domain.ai.model.vo.Usage;

import java.util.List;

/**
 * @author Fan
 * @description
 * @date 2024/07/11 14:45
 **/
public class AIAnswer {
    private int code;
    private String message;
    private String sid;
    private List<Choices> choices;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    private Usage usage;
}
