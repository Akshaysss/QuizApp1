package com.eoneservices.pavan.quizapp.QuizApp;

/**
 * Created by Pavan on 21-06-2017.
 */

public class QuestionPaper_Model {

    private String Que, Opt_A, Opt_B, Opt_C, Opt_D, Ans;

    public QuestionPaper_Model() {
    }

    public QuestionPaper_Model(String que, String opt_A, String opt_B, String opt_C, String opt_D, String ans) {
        Que = que;
        Opt_A = opt_A;
        Opt_B = opt_B;
        Opt_C = opt_C;
        Opt_D = opt_D;
        Ans = ans;
    }

    public String getQue() {
        return Que;
    }

    public void setQue(String que) {
        Que = que;
    }

    public String getOpt_A() {
        return Opt_A;
    }

    public void setOpt_A(String opt_A) {
        Opt_A = opt_A;
    }

    public String getOpt_B() {
        return Opt_B;
    }

    public void setOpt_B(String opt_B) {
        Opt_B = opt_B;
    }

    public String getOpt_C() {
        return Opt_C;
    }

    public void setOpt_C(String opt_C) {
        Opt_C = opt_C;
    }

    public String getOpt_D() {
        return Opt_D;
    }

    public void setOpt_D(String opt_D) {
        Opt_D = opt_D;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
