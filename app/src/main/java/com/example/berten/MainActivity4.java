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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    public static final double PI = 3.141592653589793;
    private Button start;
    private Button popup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        start = findViewById(R.id.btnStart);
        start.setOnClickListener(this);

        popup = findViewById(R.id.btnPopup);
        popup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            startR();
        }
        if (v.getId() == R.id.btnPopup) {
            onButtonShowPopupWindowClick(v);
        }
    }

    public void startR(){
        EditText b = ;
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




    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_ergebnis, null);

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