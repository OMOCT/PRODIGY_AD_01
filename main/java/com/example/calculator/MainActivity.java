package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    private static final char Addition = '+';
    private static final char Subtraction = '-';
    private static final char Multiplication = '*';
    private static final char Division = '/';
    private static final char Percent = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,
    btnDot,btnAdd,btnSub,btnMul,btnDiv,btnPer,btnCE,btnNeg,btnEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);

        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        btnDiv = findViewById(R.id.div);
        btnMul = findViewById(R.id.mul);
        btnPer = findViewById(R.id.per);
        btnCE = findViewById(R.id.CE);
        btnEqual = findViewById(R.id.equal);
        btnDot = findViewById(R.id.point);
        btnNeg = findViewById(R.id.neg);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText()+"9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = Addition;
                outputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = Subtraction;
                outputDisplay.setText(decimalFormat.format(firstValue) + "-");
                inputDisplay.setText(null);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = Multiplication;
                outputDisplay.setText(decimalFormat.format(firstValue) + "X");
                inputDisplay.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = Division;
                outputDisplay.setText(decimalFormat.format(firstValue) + "/");
                inputDisplay.setText(null);
            }
        });

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = Percent;
                outputDisplay.setText(decimalFormat.format(firstValue) + "%");
                inputDisplay.setText(null);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + ".");
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputDisplay.getText().length() > 0) {
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });

//        btnNeg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (inputDisplay.getText().charAt(0) == '-'){
//                    inputDisplay.setText(inputDisplay.getText().substring(1));
//                }
//            }
//        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText("=" +             decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
    }

    private void allCalculations(){
        if (!Double.isNaN(firstValue)){
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);
            if (currentSymbol == Addition)
                firstValue = this.firstValue+secondValue;
            else if (currentSymbol == Subtraction)
                firstValue = this.firstValue-secondValue;
            else if (currentSymbol == Multiplication)
                firstValue = this.firstValue*secondValue;
            else if (currentSymbol == Division)
                firstValue = this.firstValue/secondValue;
            else if (currentSymbol == Percent)
                firstValue = this.firstValue%secondValue;
        }else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e){

            }
        }
    }

}