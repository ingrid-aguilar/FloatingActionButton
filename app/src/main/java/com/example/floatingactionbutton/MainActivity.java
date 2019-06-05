package com.example.floatingactionbutton;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//animación de escala en el floating action button

       final FloatingActionButton fab = findViewById(R.id.fab);
       fab.setScaleX(0);
       fab.setScaleY(0);
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
           final Interpolator interpolator = AnimationUtils.loadInterpolator(getBaseContext(), android.R.interpolator.fast_out_slow_in);

           fab.animate()
                   .scaleX(1)
                   .scaleY(1)
                   .setInterpolator(interpolator)
                   .setDuration(600)
                   .setStartDelay(1000)
                   .setListener(new Animator.AnimatorListener() {
                       @Override
                       public void onAnimationStart(Animator animation) {

                       }

                       @Override
                       public void onAnimationEnd(Animator animation) {
                           fab.animate()
                                   .scaleY(0)
                                   .scaleX(0)
                                   .setInterpolator(interpolator)
                                   .setDuration(600)
                                   .start();

                       }

                       @Override
                       public void onAnimationCancel(Animator animation) {

                       }

                       @Override
                       public void onAnimationRepeat(Animator animation) {

                       }
                   });
       }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
