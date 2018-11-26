package com.example.administrator.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.text.ParsePosition;
import java.util.HashMap;

public class Dashboard extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    private SliderLayout imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        int int_image[] = {R.drawable.flip_a, R.drawable.flipk, R.drawable.flipka};

        imageSlider = (SliderLayout) findViewById(R.id.slider);

        for (int name : int_image) {

            TextSliderView textSliderView = new TextSliderView(this);

            textSliderView
                    .image(name)
                    .setOnSliderClickListener(this)
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            imageSlider.addSlider(textSliderView);
            imageSlider.setPresetTransformer(SliderLayout.Transformer.Default);
            imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            imageSlider.setCustomAnimation(new DescriptionAnimation());
            imageSlider.setDuration(3000);
            imageSlider.addOnPageChangeListener(this);
        }

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        int po = imageSlider.getCurrentPosition() + 1;
        Toast.makeText(this, "Position:" + po, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
