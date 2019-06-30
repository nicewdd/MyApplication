package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private TextView tv;
    private EditText phoneNum;
    private int style = 0;
    private boolean agree = false;
    private RadioButton radioBtn1,radioBtn2;
    private Switch switch1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch1 = findViewById(R.id.switch1);
        btn1 = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        phoneNum = findViewById(R.id.phoneNum);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked){
                if(isChecked){
                    agree = true;
                    switch1.setText("agree");
                }
                else{
                    agree = false;
                    switch1.setText("disagree");
                    tv.setText("Information gathering");
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                RadioGroup radioGrp=(RadioGroup)findViewById(R.id.radioGroup);
                int id = radioGrp.getCheckedRadioButtonId();
                RadioButton rdBtn=(RadioButton)findViewById(id);
                Switch switchTest = (Switch) findViewById(R.id.switch1);
                if(agree){
                    if(rdBtn.getText().equals("male")){
                        tv.setText("Hello,sir." + "Your phone number is:" + phoneNum.getText());
                    }
                    else{
                        tv.setText("Hello,madam." + "Your phone number is:" + phoneNum.getText());
                    }
                }
               else{
                    tv.setText("Information gathering");
                }
            }
        });
    }
}
