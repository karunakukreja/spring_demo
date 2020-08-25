package com.example.spring_demo.course;

import com.example.spring_demo.topic.Topic;

import javax.persistence.*;

@Entity
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String description;
    private int price;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Topic topic;

    public Course() {
    }
    public Course(int id, String name, String description, Topic topic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = topic;
    }

    public Course( String name, String description, Topic topic, int price) {
        this.name = name;
        this.description = description;
        this.topic = topic;
        this.price = price;
    }
    public Course(int id, String name, String description, Topic topic, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = topic;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", topic=" + topic +
                '}';
    }
}
