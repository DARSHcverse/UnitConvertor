/* ----------------Student Details----------------
Name: Darshan Subramaniam; Id: 222550339
CourseName: SIT305
 */

package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity {

    EditText mEditText;     //Initializing a variable for EditText

    Spinner Select_from;    //Initializing a variable for a list that should be selected from

    Spinner Select_to;      //Initializing a variable for a list that should be selected to
    Button Convert;         //Initializing a variable for a button to convert units


    TextView Result1;//Initializing a variable for viewing the results

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText=findViewById(R.id.editTextTextPersonName);        //Using the variable to find the id of an activity
        Select_from=findViewById(R.id.Select_unit_from);            //Using the variable to find the id of an activity
        Select_to=findViewById(R.id.Select_unit_to);                //Using the variable to find the id of an activity
        Convert=findViewById(R.id.button);                          //Using the variable to find the id of an activity
        Result1=findViewById(R.id.Result1);                         //Using the variable to find the id of an activity

        Convert.setOnClickListener(new View.OnClickListener() {     //Using the setOnClickListener to execute the button
            @Override
            public void onClick(View v) {

                Log.v("Checking Spinner value", Select_from.getSelectedItem().toString());          //using the log.v to monitor the result
                Log.v("Checking other Spinner value", Select_to.getSelectedItem().toString());      //using the log.v to monitor the result

                String SelectFrom=Select_from.getSelectedItem().toString();                             //Assigning a variable to get the value in spinner
                String SelectTo=Select_to.getSelectedItem().toString();                                 //Assigning a variable to get the value in spinner

                if (SelectFrom.equals("Metre") && SelectTo.equals("Centimetre"))                        //Using if function here to to see if the value equals to String and to giving an "and" logic to show the both variable are must
                {
                    Double Result_C=Double.parseDouble(mEditText.getText().toString())*100;             //Calculations
                    Result1.setText(String.valueOf(Result_C)+" Centimetre");                            //Printing the result into Result1 space
                }
                else if (SelectFrom.equals("Metre") && SelectTo.equals("Foot")) {

                    Double Result_F=Double.parseDouble(mEditText.getText().toString())*3.28084;
                    Result1.setText(Double.toString(Result_F)+" Foot");
                }
                else if (SelectFrom.equals("Metre") && SelectTo.equals("Inch")) {
                    Double Result_I=Double.parseDouble(mEditText.getText().toString())*39.37;
                    Result1.setText(Double.toString(Result_I)+" Inch");
                }
                else if (SelectFrom.equals("Celsius") && SelectTo.equals("Fahrenheit")) {
                    Double Result_F=(Double.parseDouble(mEditText.getText().toString())*1.8)+32;
                    Result1.setText(Double.toString(Result_F)+" Fahrenheit");
                }
                else if (SelectFrom.equals("Celsius") && SelectTo.equals("Kelvin")) {
                    Double Result_K=Double.parseDouble(mEditText.getText().toString())+273.15;
                    Result1.setText(Double.toString(Result_K)+" Kelvin");
                }
                else if (SelectFrom.equals("Kilograms") && SelectTo.equals("Gram")) {
                    Double Result_G=Double.parseDouble(mEditText.getText().toString())*1000;
                    Result1.setText(Double.toString(Result_G)+" Gram");
                }
                else if (SelectFrom.equals("Kilograms") && SelectTo.equals("Ounce(Oz)")) {
                    Double Result_O=Double.parseDouble(mEditText.getText().toString())*35.274;
                    Result1.setText(Double.toString(Result_O)+" Ounce");
                }
                else if (SelectFrom.equals("Kilograms") && SelectTo.equals("Pound(lb)")) {
                    Double Result_P=Double.parseDouble(mEditText.getText().toString())*2.2;
                    Result1.setText(Double.toString(Result_P)+" Pound");
                }
                else{               //Else statement to say something went wrong
                    Toast.makeText(MainActivity.this,"Invaid!",Toast.LENGTH_LONG).show();           //Using a Toast to bring up an watermark text to say its an invalid Choice
                    Result1.setText("Wrong Unit Selected!\nTry Again");
                }
                Toast.makeText(MainActivity.this,"Converted",Toast.LENGTH_LONG).show();             //Using a Toast to bring up an watermark text to say its an invalid Choice
            }
        });

    }
}