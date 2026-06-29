package com.library.ormlearn.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "attempt")
public class Attempt {

    @Id
    @Column(name = "attempt_id")
    private int id;

    @Column(name = "attempted_date")
    private LocalDate attemptedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "attempt")
    private List<AttemptQuestion> attemptQuestions;

    public Attempt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(LocalDate attemptedDate) {
        this.attemptedDate = attemptedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(List<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}