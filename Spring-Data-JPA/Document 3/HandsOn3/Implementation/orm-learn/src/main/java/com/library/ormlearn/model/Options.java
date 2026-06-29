package com.library.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Options {

    @Id
    @Column(name = "option_id")
    private int id;

    @Column(name = "option_text")
    private String optionText;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Options() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}