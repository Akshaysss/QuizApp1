package com.eoneservices.pavan.quizapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.eoneservices.pavan.quizapp.QuizApp.QuestionPaper_Model;
import com.eoneservices.pavan.quizapp.R;
import com.eoneservices.pavan.quizapp.fragments.QuizFrag;

import java.util.List;

/**
 * Created by Akshay Jindam on 11-03-2017.
 */

public class Quiz_Adapter extends PagerAdapter {

    Context context;
    TextView question, optA, optB, optC, optD, ans;
    List<QuestionPaper_Model> data;


    public Quiz_Adapter(Context context, List<QuestionPaper_Model> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {
        ViewGroup layout = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.quiz_row, collection, false);
        collection.addView(layout);

        question = (TextView) layout.findViewById(R.id.Question);
        optA = (TextView) layout.findViewById(R.id.Opt_A);
        optB = (TextView) layout.findViewById(R.id.Opt_B);
        optC = (TextView) layout.findViewById(R.id.Opt_C);
        optD = (TextView) layout.findViewById(R.id.Opt_D);
        ans = (TextView) layout.findViewById(R.id.Ans);

        question.setText(data.get(position).getQue());
        optA.setText(data.get(position).getOpt_A());
        optB.setText(data.get(position).getOpt_B());
        optC.setText(data.get(position).getOpt_C());
        optD.setText(data.get(position).getOpt_D());
        ans.setText(data.get(position).getAns());


        optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optA, position);
            }
        });

        optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optB, position);
            }
        });

        optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optC, position);
            }
        });

        optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optD, position);
            }
        });


        return layout;
    }


   /* public void checkAnswer(String selected,int position){
        if(selected.equals(data.get(position).getAns())){
            QuizFrag.changePage(position);
        }else{
            Toast.makeText(context, "Please try again?...", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void checkAnswer(TextView selected, int position) {

        String selectedString = selected.getText().toString();
        String answer = data.get(position).getAns();

        if (selectedString.equals(answer)) {
            resetcolor();
            selected.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            QuizFrag.changePage(position);
        } else {
            Toast.makeText(context, "Please try again?...", Toast.LENGTH_SHORT).show();
            resetcolor();
            selected.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
    }


    public void resetcolor() {
        optA.setBackgroundColor(Color.parseColor("#ffffff"));
        optB.setBackgroundColor(Color.parseColor("#ffffff"));
        optC.setBackgroundColor(Color.parseColor("#ffffff"));
        optD.setBackgroundColor(Color.parseColor("#ffffff"));

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "" + position;
    }

}
