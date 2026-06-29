package com.library.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "score")
    private double score;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Options> options;

    @OneToMany(mappedBy = "question")
    private List<AttemptQuestion> attemptQuestions;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(List<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}