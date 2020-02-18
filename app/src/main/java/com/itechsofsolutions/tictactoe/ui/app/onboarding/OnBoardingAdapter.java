package com.itechsofsolutions.tictactoe.ui.app.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.itechsofsolutions.tictactoe.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
public class OnBoardingAdapter extends PagerAdapter {

    Context context;
    DotsIndicator indicator;
    LayoutInflater layoutInflater;

    // create a constructor
    public OnBoardingAdapter(Context context) {
        this.context = context;
    }

    // crate a array for main image
    public int[] slide_images = {
            R.drawable.ic_account,
            R.drawable.ic_category,
            R.drawable.ic_explore,
    };

    // create a array for headings
    public String[] text_hadings = {

            "Create your account",
            "Choose your category",
            "Explore your knowledge",
    };

    // create a array for desc
    public String[] text_titles = {
            "Mauris et justo odio varius temps. Mauris\n" +
                    "interdum, purus vitae interdum sodales sapin eros blandit neque, pharetra tempus",

            "Mauris et justo odio varius temps. Mauris\n" +
                    "interdum, purus vitae interdum sodales sapin eros blandit neque, pharetra tempus",

            "Mauris et justo odio varius temps. Mauris\n" +
                    "interdum, purus vitae interdum sodales sapin eros blandit neque, pharetra tempus",

            "Mauris et justo odio varius temps. Mauris\n" +
                    "interdum, purus vitae interdum sodales sapin eros blandit neque, pharetra tempus",

    };



    @Override
    public int getCount() {
        return text_hadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;

        if (position == 0){
            layoutInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_onboarding,
                    container, false);

            ImageView imageSlide =  view.findViewById(R.id.image_view_onboarding);

            TextView textHeadings =  view.findViewById(R.id.text_view_create);
            TextView textDesc =  view.findViewById(R.id.text_view_sub_title);

            imageSlide.setImageResource(slide_images[position]);
            textHeadings.setText(text_hadings[position]);
            textDesc.setText(text_titles[position]);
        }

        else  if (position == 1){

            layoutInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_onboarding,
                    container, false);

            ImageView imageSlide = view.findViewById(R.id.image_view_onboarding);
            TextView textHeadings =  view.findViewById(R.id.text_view_create);
            TextView textDesc =  view.findViewById(R.id.text_view_sub_title);

            imageSlide.setImageResource(slide_images[position]);
            textHeadings.setText(text_hadings[position]);
            textDesc.setText(text_titles[position]);


        }

        else if (position == 2) {
            layoutInflater = (LayoutInflater) context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_onboarding, container, false);

            ImageView imageSlide = view.findViewById(R.id.image_view_onboarding);
            TextView textHeadings =  view.findViewById(R.id.text_view_create);
            TextView textDesc =  view.findViewById(R.id.text_view_sub_title);

            imageSlide.setImageResource(slide_images[position]);
            textHeadings.setText(text_hadings[position]);
            textDesc.setText(text_titles[position]);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
