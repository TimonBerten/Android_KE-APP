package com.example.berten;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    public static final double PI = 3.141592653589793;
    private Button start;
    private Button popup;
    private double vorsatz = 0;
    private int zug = 0;
    private int schub = 0;
    private int biegung = 0;
    public double flaeche = 0;
    private double spannung = 0;
    private double faktor = 0;
    private double laenge = 0;
    private double a = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        start = findViewById(R.id.btnStart);
        start.setOnClickListener(this);

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkB4);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkB1);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkB2);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkB3);

        cb1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                        vorsatz = 1;
                    }
                }
        );
        cb2.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                        zug=1;
                    }
                }
        );
        cb3.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                        schub=1;
                    }
                }
        );
        cb4.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                        biegung=1;
                    }
                }
        );
        //popup = findViewById(R.id.btnPopup);
        //popup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            startCalc();
        }
        /*if (v.getId() == R.id.btnPopup) {
            onButtonShowPopupWindowClick(v);
        }*/
    }

    public void startCalc(){
        EditText edita = (EditText) findViewById(R.id.a);
        EditText editlaenge = (EditText) findViewById(R.id.laenge);
        a = Double.parseDouble(edita.getText().toString());;
        laenge = Double.parseDouble(editlaenge.getText().toString());;

        if(vorsatz==0) {
            laenge = laenge - 2 * a;
        }
        flaeche = a * laenge;

        Toast.makeText(getApplicationContext(), Double.toString(flaeche)+" mm^2", Toast.LENGTH_LONG).show();




        //onButtonShowPopupWindowClick(findViewById(R.id.btnStart));
    }

    public double wArea(double a, double b, double t, int v){
        if(v==1){
            return (a * b);  //Einzelne Naht
        }
        if(v==2){
            return (2 * a * (b + t));  //Rechteck mit symmetrischem Wurzelpunkt
        }
        if(v==3){
            return (PI * b * a); //Kreis mit symmetrischem Wurzelpunkt
        }
        else return 0;
    }

    public double vSpannung(double zug, double biegung, double schub, double torsion){
        double gb = zug + biegung;
        double gt = schub + torsion;
        return (0.5 * (gb + Math.sqrt(Math.pow(gb,2) + 4 * Math.pow(gt,2))));
    }

    public double compare(double real, double zul){
        return (zul/real);
    }
    public double zugspannung(){
        return 0;
    }
    public double schubspannung(){
        return 0;
    }
    public double biegespannung(){
        return 0;
    }



    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_ergebnis, null);

        //TextView popupText = (TextView) findViewById(R.id.popupText);
        //popupText.setText("");
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);



        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}