package com.supermyle.bmicalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calcBMI(View v)
    {
        DecimalFormat df = new DecimalFormat("0.##");
        EditText getPounds = (EditText) findViewById(R.id.poundsInput);
        EditText getFeet = (EditText) findViewById(R.id.feetInput);
        EditText getInches = (EditText) findViewById(R.id.inchesInput);
        TextView getBMI = (TextView) findViewById(R.id.bmiFinal);
        TextView getHealth = (TextView) findViewById(R.id.health);
        try {
            double pounds = Double.parseDouble(getPounds.getText().toString()); //Gets pounds value
            double feet = Double.parseDouble(getFeet.getText().toString()); //Gets feet value
            double inches = Double.parseDouble(getInches.getText().toString()); //Gets inches value
            //Weight in pounds converted to kilograms for conversions
            double kilograms = pounds * .45;
            //Convert feet to inches and add inches to get total height in inches
            double inchesFinal = ((feet * 12) + inches);
            //Multiply the height in inches by 0.025 (the metric conversion factor)
            double converted = inchesFinal * .025;
            //Square the answer from above
            double squared = converted * converted;
            //Divide kilograms by squared number to get BMI
            double bmi = kilograms / squared;
            getBMI.setText("The BMI for a person who is \n" + df.format(feet) + "\' " + df.format(inches) + "\" and weighs " + df.format(pounds) +
                    " lbs \nhas a BMI of " + df.format(bmi));
            if(bmi < 18.5 || bmi > 24.9)
            {
                getHealth.setTextColor(Color.parseColor("#FF0000"));
            }else {getHealth.setTextColor(Color.parseColor("#00FF00"));}
            getHealth.setText("The healthy BMI range for adults is 18.5 to 24.9");

        }catch (Exception e){ //Catch all errors
            getBMI.setText("Enter a valid height/weight");
            getHealth.setText("");
        }
    }

}
