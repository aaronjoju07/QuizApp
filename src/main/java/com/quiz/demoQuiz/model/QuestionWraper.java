package com.quiz.demoQuiz.model;

public class QuestionWraper {
    private Integer id;
    private String questionText;
    private String option_a;
    private String option_b;
    private String option_c;

    public QuestionWraper(Integer id, String questionText, String option_a, String option_b, String option_c) {
        this.id = id;
        this.questionText = questionText;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }
}
