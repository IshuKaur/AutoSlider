package com.example.ishpreetkaur.autoslider;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class FragmentPager extends Fragment {

    int[] img = {R.drawable.star_wars, R.drawable.deadpool, R.drawable.batman, R.drawable.avengers,R.drawable.deadpool_new};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_simple, null);
//        bannerImages();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.bgimage);
        Bundle bundle = getArguments();
        int i = (int) bundle.getInt("img");
        linearLayout.setBackgroundResource(img[i]);
        return view;
    }



}

