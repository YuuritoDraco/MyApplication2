package com.example.user.myapplication;

import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity implements BlankFragment.OnFragmentListener
{

    IDStudentFragment idStudentFragment = new IDStudentFragment();
    BlankFragment blankFragment = BlankFragment.newInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, blankFragment, "tag");
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        /*Button button = (Button) findViewById(R.id.buttonStudent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, blankFragment, "tag");
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/

        blankFragment.setOnTextListener(new TestListener() {
            @Override
            public void onCallBack() {
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onClick(String string)
            {
                Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onGoBack()
    {
        Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
    }


}
