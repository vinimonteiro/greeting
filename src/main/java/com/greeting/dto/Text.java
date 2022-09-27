package com.greeting.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {
    private String content;

    public Text(){

    }

    public Text(String content){
        this.content = content;
    }

    @JsonProperty
    public String getContent(){
        return content;
    }
}
