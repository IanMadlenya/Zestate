package com.guanzhuli.zestate.buyer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guanzhuli.zestate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyerFragment extends Fragment {


    public BuyerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buyer, container, false);
        return view;
    }

}
