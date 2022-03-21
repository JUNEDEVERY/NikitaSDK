package com.example.kalkylator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondPage extends AppCompatActivity implements View.OnClickListener {

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
    Button pow;
    Button sqrt;
    Button sin;
    Button cos;
    Button clear;
    Button equals;
    Button firstWindows;

    float resulting;
    String press;
    boolean fnum;
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
        pow = findViewById(R.id.pow);
        sqrt = findViewById(R.id.sqrt);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        firstWindows = findViewById(R.id.firstWindows);

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


        clear.setOnClickListener(this);
        equals.setOnClickListener(this);

        firstWindows.setOnClickListener(this);
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
            case R.id.pow:
            case R.id.sqrt:
            case R.id.sin:
            case R.id.cos:
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
                double number1 = Float.valueOf(firstNumber.getText().toString());
                double number2 = Float.valueOf(secondNumber.getText().toString());
                if(firstNumber.getText().toString() == "") number1 = 0;
                else number1 = Float.valueOf(firstNumber.getText().toString());
                if(secondNumber.getText().toString() == "") number2 = 0;
                else number2 = Float.valueOf(secondNumber.getText().toString());
                switch (press) {
                    case ("pow"):
                        double resultingstepenb = Math.pow(number1, number2);
                        result.setText(String.valueOf(resultingstepenb));
                        str_array1[0] = String.valueOf(number1 + " ^ " + number2 + " = " + resultingstepenb);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("sqrt"):
                        double resultingsqrt = Math.pow(number1, (1/number2));
                        result.setText(String.valueOf(resultingsqrt));
                        str_array1[0] = String.valueOf("pow("+ number1 +","  + number2 + ") = " + resultingsqrt);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("sin"):
                        double resultingsinus = Math.sin(number1);
                        result.setText(String.valueOf(resultingsinus));
                        str_array1[0] = String.valueOf("sin" +number1 +" = " + resultingsinus);
                        for(int i=0; i<9;i++)
                        {
                            str_array1[i+1] = str_array[i];
                        }
                        for(int i=0; i<str_array.length;i++)
                        {
                            str_array[i] = str_array1[i];
                        }
                        break;
                    case ("cos"):
                        double resultingcos = Math.cos(number1);
                        result.setText(String.valueOf(resultingcos));
                        str_array1[0] = String.valueOf("cos " +number1  + " = " + resultingcos);
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
                result.setText("");
                fnum = true;
                break;
            case R.id.firstWindows:
                //Intent intent = new Intent(SecondPage.this, com.example.kalkylator.MainActivity.class);
               Intent intent = new Intent(SecondPage.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}