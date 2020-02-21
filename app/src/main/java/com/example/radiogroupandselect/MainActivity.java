package com.example.radiogroupandselect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
CheckBox male,female;
RadioGroup radioGroup;

RadioButton radioBtn;
Button resultChechkBox,resultRadioButton;
TextView viewCheckBox,viewRadioBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        male = (CheckBox)findViewById(R.id.male);
        female = (CheckBox)findViewById(R.id.female);
        radioGroup  = (RadioGroup)findViewById(R.id.radioGroup);
        resultChechkBox = (Button) findViewById(R.id.resultCheckbtn);
        resultRadioButton = (Button)findViewById(R.id.resultRadioBtn);
        viewCheckBox = (TextView)findViewById(R.id.resultCheckView);
        viewRadioBtn = (TextView)findViewById(R.id.resultViewRadioBtn);
        resultChechkBox.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                StringBuilder stringBuffer = new StringBuilder();

                if (male.isChecked()){
                    String value = male.getText().toString();
                    stringBuffer.append(" "+value);
                }
                if (female.isChecked()){
                    String value = female.getText().toString();
                    stringBuffer.append(" "+value);
                }
                viewCheckBox.setText(stringBuffer);
                viewCheckBox.setTextColor(getColor(R.color.colorAccent));
            }
        });



        //RadioButton part




        resultRadioButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("if you want to ordered it click yoes otherwise cancel");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        int select  = radioGroup.getCheckedRadioButtonId();
                        radioBtn = (RadioButton)findViewById(select);
                        String value = radioBtn.getText().toString();
                        viewRadioBtn.setText("oh this is  = "+value);




                        viewRadioBtn.setTextColor(getColor(R.color.colorPrimaryDark));
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog alertDialog = builder.create();
                        alertDialog.dismiss();
                    }
                });
              AlertDialog alertDialog = builder.create();
              alertDialog.setCanceledOnTouchOutside(false);
              alertDialog.show();

            }
        });
    }
}
