package com.xingstarx.recyclerviewmergeadapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

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
        final RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();

// Add any number of subadapters to merge adapter
        final MyRecyclerViewSubAdapter subAdapter1 = new MyRecyclerViewSubAdapter();
        MyRecyclerViewSubAdapter subAdapter2 = new MyRecyclerViewSubAdapter();

        subAdapter1.setDataList(generateDatas());
        subAdapter2.setDataList(generateDatas());

        mergeAdapter.addAdapter(subAdapter1);
        View view = getLayoutInflater().inflate(R.layout.view_item_header, null);

        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "onCheckedChanged isChecked == " + isChecked, Toast.LENGTH_LONG).show();

                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        subAdapter1.addData("android developer inserted");
                        mergeAdapter.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });

        mergeAdapter.addView(view);
        mergeAdapter.addAdapter(subAdapter2);

// Set merge adapter to RecyclerView

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mergeAdapter);

    }

    private List<String> generateDatas() {
        List<String> dataList= new ArrayList<>();
        for(int i = 0; i< 15; i++) {
            dataList.add("android developer " + i);
        }
        return dataList;
    }

}
