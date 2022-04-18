package com.volvadvit.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Contact {

    private ContactType type;
    private String info;

    public Contact(){}
    public Contact(ContactType type, String info) {
        this.type = type;
        this.info = info;
    }

    @XmlAttribute(name = "type", required = true)
    public void setType(ContactType type) {
        this.type = type;
    }

    @XmlElement(name = "info", required = true)
    public void setInfo(String info) {
        this.info = info;
    }

    public ContactType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }
}