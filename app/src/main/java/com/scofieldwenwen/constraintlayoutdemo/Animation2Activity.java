package com.scofieldwenwen.constraintlayoutdemo;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class Animation2Activity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;
    private ConstraintSet mConstraintSet  = new ConstraintSet();
    private ConstraintSet mConstraintSetApply= new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);

        mConstraintLayout = findViewById(R.id.main);
        mConstraintSet.clone(mConstraintLayout);
        mConstraintSetApply.clone(this,R.layout.activity_animation2_second);
    }

    public void onResetClick(View view) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        mConstraintSet.applyTo(mConstraintLayout);
    }

    public void onApplyClick(View view) {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        mConstraintSetApply.applyTo(mConstraintLayout);
    }
}
