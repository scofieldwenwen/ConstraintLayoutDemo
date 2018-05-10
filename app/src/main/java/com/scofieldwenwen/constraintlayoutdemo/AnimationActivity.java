package com.scofieldwenwen.constraintlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

/**
 * https://github.com/xitu/gold-miner/blob/master/TODO/constraint-layout-animations-dynamic-constraints-ui-java-hell.md
 */
public class AnimationActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private ConstraintSet resetConstraintSet = new ConstraintSet();
    private ConstraintSet applyConstraintSet1 = new ConstraintSet();
    private ConstraintSet applyConstraintSet2 = new ConstraintSet();
    private ConstraintSet applyConstraintSet3 = new ConstraintSet();
    private ConstraintSet applyConstraintSet4 = new ConstraintSet();
    private ConstraintSet applyConstraintSet5 = new ConstraintSet();
    private ConstraintSet applyConstraintSet6 = new ConstraintSet();
    private ConstraintSet applyConstraintSet7 = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_animation);
        constraintLayout = findViewById(R.id.constraint_layout);
        resetConstraintSet.clone(constraintLayout);
        applyConstraintSet1.clone(constraintLayout);
        applyConstraintSet2.clone(constraintLayout);
        applyConstraintSet3.clone(constraintLayout);
        applyConstraintSet4.clone(constraintLayout);
        applyConstraintSet5.clone(constraintLayout);
        applyConstraintSet6.clone(constraintLayout);
        applyConstraintSet7.clone(constraintLayout);
    }

    public void onResetClick1(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        resetConstraintSet.applyTo(constraintLayout);
    }

    public void onApplyClick1(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet1.setMargin(R.id.button1, ConstraintSet.START, 8);
        applyConstraintSet1.applyTo(constraintLayout);
    }

    public void onApplyClick2(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet2.setMargin(R.id.button1, ConstraintSet.START, 0);
        applyConstraintSet2.setMargin(R.id.button1,ConstraintSet.END,0);
        applyConstraintSet2.setMargin(R.id.button2, ConstraintSet.START, 0);
        applyConstraintSet2.setMargin(R.id.button2,ConstraintSet.END,0);
        applyConstraintSet2.setMargin(R.id.button3, ConstraintSet.START, 0);
        applyConstraintSet2.setMargin(R.id.button3,ConstraintSet.END,0);

        applyConstraintSet2.centerHorizontally(R.id.button1, R.id.constraint_layout);
        applyConstraintSet2.centerHorizontally(R.id.button2,R.id.constraint_layout);
        applyConstraintSet2.centerHorizontally(R.id.button3, R.id.constraint_layout);
        applyConstraintSet2.applyTo(constraintLayout);
    }

    public void onApplyClick3(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet3.setMargin(R.id.button3, ConstraintSet.START, 0);
        applyConstraintSet3.setMargin(R.id.button3, ConstraintSet.END, 0);
        applyConstraintSet3.setMargin(R.id.button3, ConstraintSet.TOP, 0);
        applyConstraintSet3.setMargin(R.id.button3, ConstraintSet.BOTTOM, 0);

        applyConstraintSet3.centerHorizontally(R.id.button3,R.id.constraint_layout);
        applyConstraintSet3.centerVertically(R.id.button3,R.id.constraint_layout);
        applyConstraintSet3.applyTo(constraintLayout);
    }

    public void onResetClick4(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        applyConstraintSet4.constrainWidth(R.id.button1, 600);
        applyConstraintSet4.constrainWidth(R.id.button2, 600);
        applyConstraintSet4.constrainWidth(R.id.button3, 600);

        applyConstraintSet4.applyTo(constraintLayout);
    }

    public void onResetClick5(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);

        applyConstraintSet5.setVisibility(R.id.button2,ConstraintSet.GONE);
        applyConstraintSet5.setVisibility(R.id.button3,ConstraintSet.GONE);
        applyConstraintSet5.clear(R.id.button1);
        applyConstraintSet5.connect(R.id.button1,ConstraintSet.LEFT,R.id.constraint_layout,ConstraintSet.LEFT,0);
        applyConstraintSet5.connect(R.id.button1,ConstraintSet.RIGHT,R.id.constraint_layout,ConstraintSet.RIGHT,0);
        applyConstraintSet5.connect(R.id.button1,ConstraintSet.TOP,R.id.constraint_layout,ConstraintSet.TOP,0);
        applyConstraintSet5.connect(R.id.button1,ConstraintSet.BOTTOM,R.id.constraint_layout,ConstraintSet.BOTTOM,0);
        applyConstraintSet5.applyTo(constraintLayout);
    }

    public void onResetClick6(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);

        applyConstraintSet6.clear(R.id.button1);
        applyConstraintSet6.clear(R.id.button2);
        applyConstraintSet6.clear(R.id.button3);

        // button 1 left and top align to parent
        applyConstraintSet6.connect(R.id.button1, ConstraintSet.LEFT, R.id.constraint_layout, ConstraintSet.LEFT, 0);

        // button 3 right and top align to parent
        applyConstraintSet6.connect(R.id.button3, ConstraintSet.RIGHT, R.id.constraint_layout, ConstraintSet.RIGHT, 0);

        // bi-direction or Chaining between button 1 and button 2
        applyConstraintSet6.connect(R.id.button2, ConstraintSet.LEFT, R.id.button1, ConstraintSet.RIGHT, 0);
        applyConstraintSet6.connect(R.id.button1, ConstraintSet.RIGHT, R.id.button2, ConstraintSet.LEFT, 0);

        // bi-direction or Chaining between button 2 and button 3
        applyConstraintSet6.connect(R.id.button2, ConstraintSet.RIGHT, R.id.button3, ConstraintSet.LEFT, 0);
        applyConstraintSet6.connect(R.id.button3, ConstraintSet.LEFT, R.id.button2, ConstraintSet.RIGHT, 0);

        //(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style)
        applyConstraintSet6.createHorizontalChain(R.id.button1,ConstraintSet.LEFT,
                R.id.button3,ConstraintSet.LEFT,
                new int[]{R.id.button1, R.id.button3}, null, ConstraintWidget.CHAIN_SPREAD_INSIDE);

        applyConstraintSet6.constrainWidth(R.id.button1,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet6.constrainWidth(R.id.button2,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet6.constrainWidth(R.id.button3,ConstraintSet.WRAP_CONTENT);

        applyConstraintSet6.constrainHeight(R.id.button1,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet6.constrainHeight(R.id.button2,ConstraintSet.WRAP_CONTENT);
        applyConstraintSet6.constrainHeight(R.id.button3,ConstraintSet.WRAP_CONTENT);

        applyConstraintSet6.applyTo(constraintLayout);
    }

    public void onResetClick7(View view) {
        startActivity(new Intent(this, Animation2Activity.class));

    }
}
