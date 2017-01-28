package com.guanzhuli.zestate.realtor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import com.daimajia.swipe.util.Attributes;
import com.guanzhuli.zestate.R;
import com.guanzhuli.zestate.model.PostPropertyList;
import com.guanzhuli.zestate.realtor.adapter.SwipeSellerAdapter;
import com.guanzhuli.zestate.realtor.util.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAllFragment extends Fragment {
    private String userId;
    private RecyclerView mRecyclerView;
    private SwipeSellerAdapter mAdapter;
    private PostPropertyList mProperties = PostPropertyList.getInstance();
    private SwipeRefreshLayout mRefreshLayout;


    public TabAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_all, container, false);
/*        TextView textView = (TextView)view.findViewById(R.id.tab_all_textview);
        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(),  "fonts/CaviarDreams.ttf");

        textView.setTypeface(custom_font);*/
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.tab_all_refresh);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userId = "17";
                mProperties.updateData(userId);
                if (mProperties.workStatus) {
                    mRefreshLayout.setRefreshing(false);
                    mProperties.workStatus = false;
                }
            }
        });
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_tab_all);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("allTab", String.valueOf(position));
            }
        }));
        mAdapter = new SwipeSellerAdapter(getContext(), mProperties);
        ((SwipeSellerAdapter) mAdapter).setMode(Attributes.Mode.Single);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
