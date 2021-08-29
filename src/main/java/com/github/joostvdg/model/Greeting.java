package com.github.joostvdg.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Greeting {

    public Greeting() {}

    public Greeting(@NotNull String message, @NotNull String sender) {
        this.message = message;
        this.sender = sender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "message", nullable = false, unique = true)
    private String message;

    @NotNull
    @Column(name = "sender", nullable = false, unique = true)
    private String sender;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
