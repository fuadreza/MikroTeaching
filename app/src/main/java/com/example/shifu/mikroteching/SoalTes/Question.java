package com.example.shifu.mikroteching.SoalTes;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 04/05/2018.
 *
 */

class Question {
    private int id;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private String optE;
    private String answer;

    Question(){
        id=0;
        question = "";
        optA = "";
        optB = "";
        optC = "";
        optD = "";
        optE = "";
        answer = "";
    }

    Question(String question, String optA, String optB, String optC, String optD, String optE, String answer) {
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.optE = optE;
        this.answer = answer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getAnswer() {
        return answer;
    }

    void setAnswer(String answer) {
        this.answer = answer;
    }

    String getOptC() {
        return optC;
    }

    void setOptC(String optC) {
        this.optC = optC;
    }

    String getOptB() {
        return optB;
    }

    void setOptB(String optB) {
        this.optB = optB;
    }

    String getOptA() {
        return optA;
    }

    void setOptA(String optA) {
        this.optA = optA;
    }

    String getOptD() {
        return optD;
    }

    void setOptD(String optD) {
        this.optD = optD;
    }

    String getOptE() {
        return optE;
    }

    void setOptE(String optE) {
        this.optE = optE;
    }

    String getQuestion() {
        return question;
    }

    void setQuestion(String question) {
        this.question = question;
    }
}
