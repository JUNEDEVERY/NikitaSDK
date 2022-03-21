package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView firstNumber;
    TextView secondNumber;
    TextView result;


    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;
    Button secondWindows;

    float resulting;
    String press;
    boolean fnum;
    //Spinner spinner;
    Spinner spinner;
    String[] str_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        str_array = new String[10];
        for(int i=0; i< str_array.length;i++)
        {
            str_array[i]=" ";
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,str_array);
        spinner.setAdapter(adapter1);

        press = "";
        fnum = true;


        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        clear = findViewById(R.id.clear);
        secondWindows = findViewById(R.id.secondWindows);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        multiply.setOnClickListener(this);

        secondWindows.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button buttonthefirst = (Button) view;
                press = buttonthefirst.getText().toString();
                if (press == buttonthefirst.getText().toString()) {
                    fnum = !fnum;
                } else {
                    fnum = !fnum;
                    press = buttonthefirst.getText().toString();
                }

                break;
            case R.id.equals:
                String[] str_array1;
                str_array1 = new String[10];
                float number1 = Float.valueOf(firstNumber.getText().toString());
                float number2 = Float.valueOf(secondNumber.getText().toString());
                switch (press) {
                    case ("+"):
                        resulting = number1 + number2;
                        result.setText(String.valueOf(resulting));
                        str_array1[0] = String.valueOf(number1 + " + " + number2 + " = " + resulting);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("-"):
                        resulting = number1 - number2;
                        result.setText(String.valueOf(resulting));
                        str_array1[0] = String.valueOf(number1 + " - " + number2 + " = " + resulting);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("x"):
                        resulting = number1 * number2;
                        result.setText(String.valueOf(resulting));
                        str_array1[0] = String.valueOf(number1 + "*" + number2 + " = " + resulting);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("/"):
                        resulting = number1 / number2;
                        result.setText(String.valueOf(resulting));
                        str_array1[0] = String.valueOf(number1 + "/" + number2 + " = " + resulting);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                }
                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                fnum = true;
                result.setText("");
                break;
            case R.id.secondWindows:
                Intent intent = new Intent(MainActivity.this, SecondPage.class);
                startActivity(intent);
                break;
        }
    }
}