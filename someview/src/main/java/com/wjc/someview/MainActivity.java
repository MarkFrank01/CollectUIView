package com.wjc.someview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wjc.someview.BootPageView.BootPageActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button view_bootpage;
    private Button view_dashboard;
    private Button view_drawerpluslayout;
    private Button view_histogram;
    private Button view_linechart;
    private Button view_piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        view_bootpage=(Button)findViewById(R.id.view_bootpage);
        view_dashboard=(Button)findViewById(R.id.view_dashboard);
        view_drawerpluslayout=(Button)findViewById(R.id.view_drawerpluslayout);
        view_histogram=(Button)findViewById(R.id.view_histogram);
        view_linechart=(Button)findViewById(R.id.view_linechart);
        view_piechart=(Button)findViewById(R.id.view_piechart);

        view_bootpage.setOnClickListener(this);
        view_dashboard.setOnClickListener( this );
        view_drawerpluslayout.setOnClickListener( this );
        view_histogram.setOnClickListener( this );
        view_linechart.setOnClickListener( this );
        view_piechart.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.view_bootpage:
                Intent intent=new Intent(this, BootPageActivity.class);
                startActivity(intent);
                break;
            case R.id.view_dashboard:
//                Intent intent1=new Intent(this)
        }
    }
}
