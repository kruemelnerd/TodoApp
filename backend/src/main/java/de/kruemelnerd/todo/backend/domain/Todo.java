package de.kruemelnerd.todo.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    long id;
    private String title;
    private String description;
    private Boolean done;

    public Todo() {
    }


    public Todo(String description) {
        this.description = description;
    }


    public Todo(String title, String description, Boolean done) {
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id &&
                Objects.equals(title, todo.title) &&
                Objects.equals(description, todo.description) &&
                done.equals(todo.done);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, done);
    }
}
