package com.samples.ui.ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarActivity extends Activity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    private static final int NUM_STAR = 5;
    private float step = 0.5f;
    private float rat = 0.5f;

    private RatingBar ratingBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar = (RatingBar)findViewById(R.id.rating_bar);
        ratingBar.setNumStars(NUM_STAR);
        ratingBar.setRating(rat);
        ratingBar.setStepSize(step);
        ratingBar.setOnRatingBarChangeListener(this);

        textView = (TextView)findViewById(R.id.text_value);
        textView.setText(String.valueOf(rat));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_up:
                rat += step;
                if (rat > NUM_STAR){
                    rat = NUM_STAR;
                }
                ratingBar.setRating(rat);
                break;
            case R.id.button_down:
                rat -= step;
                if (rat < 0){
                    rat = 0;
                }
                ratingBar.setRating(rat);
                break;
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        textView.setText(String.valueOf(ratingBar.getRating()));
        rat = ratingBar.getRating();
    }
}
