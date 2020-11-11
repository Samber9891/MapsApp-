package com.tts.transitapi.model;

public class Distance {

    // used in Element model 
    public String text; 
    public int value;

    public Distance() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distance [text=" + text + ", value=" + value + "]";
    }

    


    
}
