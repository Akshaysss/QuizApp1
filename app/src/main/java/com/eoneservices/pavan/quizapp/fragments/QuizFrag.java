package com.eoneservices.pavan.quizapp.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eoneservices.pavan.quizapp.QuizApp.QuestionPaper_Model;
import com.eoneservices.pavan.quizapp.R;
import com.eoneservices.pavan.quizapp.adapter.Quiz_Adapter;

import java.util.ArrayList;
import java.util.List;


public class QuizFrag extends Fragment {

    public static ViewPager pager;
    Quiz_Adapter adapter;
    TabLayout tabLayout;

    public QuizFrag() {
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

        pager = (ViewPager) v.findViewById(R.id.quiz_pager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout1);

        List<QuestionPaper_Model> data = new ArrayList<>();
        data.add(new QuestionPaper_Model("Question 1", "Opt A", "Opt B", "Opt C", "Opt D", "Opt B"));
        data.add(new QuestionPaper_Model("Question 2", "Opt A", "Opt B", "Opt C", "Opt D", "Opt C"));
        data.add(new QuestionPaper_Model("Question 3", "Opt A", "Opt B", "Opt C", "Opt D", "Opt B"));
        data.add(new QuestionPaper_Model("Question 4", "Opt A", "Opt B", "Opt C", "Opt D", "Opt A"));
        data.add(new QuestionPaper_Model("Question 5", "Opt A", "Opt B", "Opt C", "Opt D", "Opt B"));


        adapter = new Quiz_Adapter(getActivity(), data);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

        return v;
    }

    public static void changePage(int position) {
        try{
            pager.setCurrentItem(position + 1, true);
        }catch (Exception e){
            Log.e("pager:",e.getMessage());
        }

    }

}
