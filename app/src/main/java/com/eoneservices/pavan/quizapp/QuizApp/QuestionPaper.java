package com.eoneservices.pavan.quizapp.QuizApp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eoneservices.pavan.quizapp.R;

import java.util.ArrayList;
import java.util.List;


public class QuestionPaper extends Fragment implements View.OnClickListener {



    List<QuestionPaper_Model> Questionlist;

    private TextView mQue;
    private TextView mscore;
    private Button mopta, moptb, moptc, moptd;
    private TextView mans;
    int Count = 0;
    int Score = 0;

    public QuestionPaper() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question_paper, container, false);


        mQue = (TextView) v.findViewById(R.id.Question);

        mans = (TextView) v.findViewById(R.id.Ans);

        Questionlist = new ArrayList<>();

        QuestionPaper_Model ques1 = new QuestionPaper_Model();
        ques1.setAns("4");
        ques1.setQue("2+2");
        ques1.setOpt_A("3");
        ques1.setOpt_B("4");
        ques1.setOpt_C("5");
        ques1.setOpt_D("6");
        Questionlist.add(ques1);

        QuestionPaper_Model ques2 = new QuestionPaper_Model();
        ques1.setAns("10");
        ques1.setQue("3+7");
        ques1.setOpt_A("8");
        ques1.setOpt_B("9");
        ques1.setOpt_C("10");
        ques1.setOpt_D("11");
        Questionlist.add(ques2);

        System.out.println(Questionlist.size());

        updateQuestion();

        return v;
    }

    private void updateQuestion() {
        System.out.println(Count);

        QuestionPaper_Model model = Questionlist.get(Count);
        mQue.setText(model.getQue());
        mopta.setText(model.getOpt_A());
        moptb.setText(model.getOpt_B());
        moptc.setText(model.getOpt_C());
        moptd.setText(model.getOpt_D());
        mans.setText(model.getAns());

        /*mscore.setText(""+Score);*/

        if (Count < Questionlist.size()-1){
            Count++ ;
        }else {
            Toast.makeText(getContext(),"You are reached to a last question",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        if(b.getText().equals(mans)){
            Score++;
            updateQuestion();
        }else {
            updateQuestion();
        }
    }
}
