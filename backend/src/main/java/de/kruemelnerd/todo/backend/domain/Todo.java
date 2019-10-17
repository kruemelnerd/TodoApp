package de.kruemelnerd.todo.backend.domain;


public class Todo {

    String title;
    String desciption;

    public Todo(String description) {
        this.desciption = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
