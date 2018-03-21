package com.example.lhd.launchertest;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private  String[] datas={"我是1","我是2","我是3","我是4","我是5","我是6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.POPUP);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popUpView=MainActivity.this.getLayoutInflater().inflate(R.layout.popupwindow,null);
                ListView listView=popUpView.findViewById(R.id.popupList);
                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,datas));
                PopupWindow popupWindow=new PopupWindow(popUpView,300,500);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0f0f0f")));
                popupWindow.setOutsideTouchable(true);
                popupWindow.update();
                popupWindow.showAsDropDown(button,0,0);
            }
        });

    }
}
