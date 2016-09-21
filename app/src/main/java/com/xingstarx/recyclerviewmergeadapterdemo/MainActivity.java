package com.xingstarx.recyclerviewmergeadapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.mvdw.recyclerviewmergeadapter.adapter.RecyclerViewMergeAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

// Create new merge adapter
        RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();

// Add any number of subadapters to merge adapter
        final MyRecyclerViewSubAdapter subAdapter1 = new MyRecyclerViewSubAdapter();
        MyRecyclerViewSubAdapter subAdapter2 = new MyRecyclerViewSubAdapter();

        subAdapter1.setDataList(generateDatas());
        subAdapter2.setDataList(generateDatas());

        mergeAdapter.addAdapter(subAdapter1);
        mergeAdapter.addAdapter(subAdapter2);

// Set merge adapter to RecyclerView

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mergeAdapter);


        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(subAdapter1.getDataList().size() > 5) {
                    subAdapter1.removeData(5);
                    subAdapter1.notifyItemRemoved(5);
                    mRecyclerView.removeCallbacks(this);
                    mRecyclerView.postDelayed(this, 1500);
                }
            }
        }, 1500);

    }

    private List<String> generateDatas() {
        List<String> dataList= new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            dataList.add("android developer " + i);
        }
        return dataList;
    }

}
