package com.tts.transitapi.model;

public class Duration {

    // used in Element model
    public String text; 
    public String value;

   

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Duration [text=" + text + ", value=" + value + "]";
    }

    public Duration() {
    }

    
}
