package com.library.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @Column(name = "attempt_option_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Options option;

    public AttemptOption() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AttemptQuestion getAttemptQuestion() {
        return attemptQuestion;
    }

    public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
        this.attemptQuestion = attemptQuestion;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }
}
