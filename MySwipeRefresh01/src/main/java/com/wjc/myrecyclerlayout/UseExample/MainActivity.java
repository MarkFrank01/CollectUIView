package com.wjc.myrecyclerlayout.UseExample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.wjc.myrecyclerlayout.R;
import com.wjc.myrecyclerlayout.interfaces.OnTouchUpListener;
import com.wjc.myrecyclerlayout.layout.JCPullRecyclerLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnTouchUpListener{

    private JCPullRecyclerLayout recycler;
    private View header;
    private View footer;

    private NumAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inital();
    }

    private void inital() {
        recycler = (JCPullRecyclerLayout) findViewById(R.id.recycler);
        list = new ArrayList<>();

        initdata();
        header= LayoutInflater.from(this).inflate(R.layout.header,null);
        footer= LayoutInflater.from(this).inflate(R.layout.footer,null);
        recycler.addHeaderView(header,100);
        recycler.addFooterView(footer,100);
        adapter = new NumAdapter(this, list);
        recycler.setMyRecyclerView(new LinearLayoutManager(this), adapter);
        recycler.addOnTouchUpListener(this);
    }

    private void initdata() {
        list.clear();
        for (int i = 0; i < 30; i++) {
            Random random=new Random();
            list.add(random.nextInt(30)+ 1 + "");
        }
    }

    private void add_data(){
        for(int i=0;i<10;i++){
            list.add(100+"");
        }
    }

    @Override
    public void OnRefreshing() {
        Log.e("angel", "OnRefreshing: 正在刷新");
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initdata();
                        adapter.notifyDataSetChanged();
                        Log.e("SB","SB");
                    }
                });
            }
        }).start();
    }

    @Override
    public void OnLoading() {
        Log.e("angel", "OnLoading: 正在加载");
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        add_data();
                        adapter.notifyDataSetChanged();
                        Log.e("SB2","SB2");
                    }
                });
            }
        }).start();
    }
}
