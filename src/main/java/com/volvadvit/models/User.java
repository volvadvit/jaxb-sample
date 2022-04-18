package com.volvadvit.models;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
@XmlType(propOrder = {"id", "name", "contacts"})
public class User {

    private long id;
    private String name;
    private int age;
    private List<Contact> contacts = new ArrayList<>();

    public User(){}
    public User(long id, String name, int age, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contacts = contacts;
    }

    @XmlAttribute(required = true)
    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "full_name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public void setAge(int age) {
        this.age = age;
    }

    @XmlElementWrapper(name = "person_contacts", nillable = true)
    @XmlElement(name = "contact")
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User: " + this.id + "; " + this.name + "; " + this.contacts;
    }

    public long getId() {
        return id;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}