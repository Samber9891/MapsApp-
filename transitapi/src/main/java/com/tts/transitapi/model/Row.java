package com.tts.transitapi.model;

import java.util.List;

public class Row {

    // used in Distanceresponse model, formats the responses to be in a list
    public List<Element> elements;

    public Row() {
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Row [elements=" + elements + "]";
    }

   

}
