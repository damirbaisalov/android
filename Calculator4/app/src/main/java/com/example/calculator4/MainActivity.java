package com.example.calculator4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import android.content.res.Configuration;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.w3c.dom.Text;

enum State
{
    START,
    PLUS,
    MINUS,
    DIVIDE,
    MULT,
    EQUAL,
    POW,
    SQRT,
    SIN,
    COS,
    TAN,
    PERCENT,
    LN,
    LOG,
    FACTORIAL,
    XYSQUARE
}

enum Sign
{
    PLUS,
    MINUS,
    DIVIDE,
    MULT,
    UNDEFINED,
    POW,
    SQRT,
    SIN,
    COS,
    TAN,
    PERCENT,
    LN,
    LOG,
    FACTORIAL,
    XYSQUARE
}

public class MainActivity extends AppCompatActivity {

    TextView calcScreen;
    TextView txtV;
    //    private TextView resScreen;
    public Button n0;
    public Button n1;
    public Button n2;
    public Button n3;
    public Button n4;
    public Button n5;
    public Button n6;
    public Button n7;
    public Button n8;
    public Button n9;
    public Button btnDot;
    public Button equal;
    public Button addit;
    public Button subs;
    public Button mult;
    public Button div;
    public Button btnDelete;
    public Button btnSqrt;
    public Button btnPow;
    public Button deleteAll;

    public Button rad;
    public Button deg;

    public Button bnfactorial;
    public Button bnpower;
    public Button bncos;
    public Button bnsin;
    public Button bntan;
    public Button bnln;
    public Button bnlog;
    public Button bnpercent;



    public boolean dot = false;
    public double num1 = 0;
    public double num2 = 0;

    public int temp = 0;

    State state = State.START;
    Sign sign = Sign.UNDEFINED;

    String text;
    String text1;
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num1 = savedInstanceState.getDouble("num1");
        num2 = savedInstanceState.getDouble("num2");
        dot = savedInstanceState.getBoolean("dot");
        state = (State)savedInstanceState.getSerializable("state");
        sign = (Sign)savedInstanceState.getSerializable("sign");

        text = savedInstanceState.getString("calcScreen");
        calcScreen.setText(text);

        text1 = savedInstanceState.getString("txtView");
        txtV.setText(text1);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("num1", num1);
        outState.putDouble("num2", num2);



        outState.putBoolean("dot", dot);

        outState.putSerializable("state", state);
        outState.putSerializable("sign", sign);
        outState.putString("calcScreen", calcScreen.getText().toString());

        outState.putSerializable("txtView", txtV.getText().toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcScreen = findViewById(R.id.calcScreen);
//        resScreen = findViewById(R.id.resScreen);
        n0 = findViewById(R.id.num0);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        n3 = findViewById(R.id.num3);
        n4 = findViewById(R.id.num4);
        n5 = findViewById(R.id.num5);
        n6 = findViewById(R.id.num6);
        n7 = findViewById(R.id.num7);
        n8 = findViewById(R.id.num8);
        n9 = findViewById(R.id.num9);
        btnDot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        addit = findViewById(R.id.plus);
        subs = findViewById(R.id.subs);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);

        rad = findViewById(R.id.RAD);
        deg = findViewById(R.id.DEG);

        deleteAll = findViewById(R.id.clear);
        btnDelete = findViewById(R.id.del);

        btnPow = findViewById(R.id.square);
        btnSqrt = findViewById(R.id.sqrt);

         txtV = findViewById(R.id.textView);

         bnfactorial = findViewById(R.id.factorial);
         bnpower = findViewById(R.id.xysquare);
        bnpercent = findViewById(R.id.percent);
         bnsin = findViewById(R.id.sin);
         bncos = findViewById(R.id.cos);
        bntan = findViewById(R.id.tan);
        bnln = findViewById(R.id.ln);
        bnlog = findViewById(R.id.log);

//        deleteAll.setOnClickListener(this);
//        deleteAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v) {
//                calcScreen.setText("");
//                sign = Sign.UNDEFINED;
//                state = State.START;
//                dot = false;
//                num1 = 0;
//                num2 = 0;
//            }
//        });
//

        View.OnClickListener calcOnclick = new View.OnClickListener() {

            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.clear:
                        calcScreen.setText("");
                       sign = Sign.UNDEFINED;
                       state = State.START;
                       dot = false;
                       num1 = 0;
                       num2 = 0;
                       break;
                    case R.id.del:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (calcScreen.getText().toString().length() == 0) {
                            num1 = 0;
                            num2 = 0;
                        } else if (calcScreen.getText().toString().length() != 1) {
                            try {
                                calcScreen.setText(calcScreen.getText().toString().substring(0, calcScreen.getText().toString().length() - 1));
                                num1 = Double.parseDouble(calcScreen.getText().toString());
                            } catch (NumberFormatException e) {
                                calcScreen.setText("");
                            }
                        } else
                            calcScreen.setText("");
                        if (calcScreen.getText().toString().contains(".")) {
                            dot = true;
                        } else
                            dot = false;

                        break;

                    case R.id.dot:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (calcScreen.getText().toString().contains("."))
                            dot = true;
                        if (dot != true)
                            calcScreen.append(".");

                        dot = true;
                        break;

                    case R.id.num1:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("1");
                        break;

                    case R.id.num2:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("2");
                        break;

                    case R.id.num3:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("3");
                        break;

                    case R.id.num4:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("4");
                        break;

                    case R.id.num5:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("5");
                        break;

                    case R.id.num6:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("6");
                        break;

                    case R.id.num7:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("7");
                        break;

                    case R.id.num8:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("8");
                        break;

                    case R.id.num9:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        calcScreen.append("9");
                        break;

                    case R.id.num0:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        if (state != State.START && state != State.EQUAL) {
                            state = State.START;
                            calcScreen.setText("");
                        }
                        if ((calcScreen.getText().toString().length() == 0 && dot == false) || (calcScreen.getText().toString().charAt(0) == '0' && dot == false))
                            calcScreen.setText("0");
                        else
                            calcScreen.append("0");

                        break;


                    case R.id.plus:
                        state = State.PLUS;
                        sign = Sign.PLUS;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        dot = false;
                        break;


                    case R.id.subs:
                        state = State.MINUS;
                        sign = Sign.MINUS;

                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }

                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }

                        dot = false;
                        break;
                    case R.id.mult:
                        state = State.MULT;
                        sign = Sign.MULT;

                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {


                            calcScreen.setText("");
                        }
                        dot = false;
                        break;

                    case R.id.div:
                        state = State.DIVIDE;
                        sign = Sign.DIVIDE;

                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());

                        } catch (NumberFormatException e) {
                            calcScreen.setText("Infinity");
                        }
                        dot = false;
                        break;


                    case R.id.sqrt:
                        state = State.SQRT;
                        sign = Sign.SQRT;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (calcScreen.getText().toString().length() > 0) {

                            calcScreen.setText(Double.toString(Math.sqrt(num1)));
                        }
                        dot = false;
                        break;

                    case R.id.square:
                        state = State.POW;
                        sign = Sign.POW;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (calcScreen.getText().toString().length() > 0) {
                            calcScreen.setText(Double.toString(Math.pow(num1, 2)));
                        }
                        dot = false;
                        break;
//1
                    case R.id.sin:
                        state = State.SIN;
                        sign = Sign.SIN;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try{
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                        calcScreen.setText(Double.toString(Math.sin(num1)));}
                        dot = false;
                        break;
//2
                    case R.id.cos:
                        state = State.COS;
                        sign = Sign.COS;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try{
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                        calcScreen.setText(Double.toString(Math.cos(num1)));}
                        dot = false;
                        break;
//3
                    case R.id.tan:
                        state = State.TAN;
                        sign = Sign.TAN;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText(Double.toString(Math.tan(num1)));}
                        dot = false;
                        break;
//4
                    case R.id.percent :
                        state = State.PERCENT;
                        sign = Sign.PERCENT;
                        if(calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText(Double.toString(num1*0.01));}
                        dot=false;
                        break;
//5
                    case R.id.ln:
                        state = State.LN;
                        sign = Sign.LN;
                        if(calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText(Double.toString(Math.log(num1)));}
                        dot=false;
                        break;
//6
                    case R.id.log:
                        state = State.LOG;
                        sign = Sign.LOG;
                        if(calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            calcScreen.setText("");
                        }
                        if (!calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText(Double.toString(Math.log10(num1)));}
                        dot=false;
                        break;
//7
                    case R.id.factorial:
                        state = State.FACTORIAL;
                        sign = Sign.FACTORIAL;
                        if(calcScreen.getText().toString().equals("Infinity")){
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                            temp = (int) num1;
                        }
                        catch(NumberFormatException e)
                        {
                            calcScreen.setText("");
                            break;
                        }
//                        if (calcScreen.getText().toString().equals("Infinity") != true){
                            if (temp < 0 || temp > 100 ){
                                calcScreen.setText("Infinity");
                            break;}
                            else{
                                if (temp == 0 ){
//                                    calcScreen.setText("1");
                                    temp = 1;
                                } else{
                                    int result =1;
                                    for (int i=1; i <= temp; i++){
                                       result= result*i;
                                    }
                                    temp = result;
                                }
                            }
                            num1 = temp;
                            calcScreen.setText(Double.toString(num1));
                        dot=false;
                    break;
//8
                    case R.id.xysquare:
                        state = State.XYSQUARE;
                        sign = Sign.XYSQUARE;
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num1 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        dot = false;
                        break;

//9
                    case R.id.RAD:
                        txtV.setText("RAD");
                        break;
                    case R.id.DEG:
                        txtV.setText("DEG");
                        break;

                    case R.id.equal:
                        if (calcScreen.getText().toString().equals("Infinity")) {
                            calcScreen.setText("");
                        }
                        try {
                            num2 = Double.parseDouble(calcScreen.getText().toString());
                        } catch (NumberFormatException e) {
                            calcScreen.setText("");
                        }
                        if (sign == sign.PLUS)
                            calcScreen.setText(Double.toString(num1 + num2));
                        else if (sign == sign.MINUS)
                            calcScreen.setText(Double.toString(num1 - num2));
                        else if (sign == sign.MULT)
                            calcScreen.setText(Double.toString(num1 * num2));
                        else if (sign == sign.DIVIDE)
                            calcScreen.setText((Double.toString(num1 / num2)));
                        else if (sign == sign.XYSQUARE)
                            calcScreen.setText(Double.toString(Math.pow(num1,num2)));
                        else if (sign == sign.UNDEFINED)
                            calcScreen.setText(calcScreen.getText().toString());
                        else
                            calcScreen.setText("Infinity");
                        state = State.EQUAL;
                        break;

                }

            }

        };

        n0.setOnClickListener(calcOnclick);
        n1.setOnClickListener(calcOnclick);
        n2.setOnClickListener(calcOnclick);
        n3.setOnClickListener(calcOnclick);
        n4.setOnClickListener(calcOnclick);
        n5.setOnClickListener(calcOnclick);
        n6.setOnClickListener(calcOnclick);
        n7.setOnClickListener(calcOnclick);
        n8.setOnClickListener(calcOnclick);
        n9.setOnClickListener(calcOnclick);
        btnDot.setOnClickListener(calcOnclick);
        equal.setOnClickListener(calcOnclick);
        addit.setOnClickListener(calcOnclick);
        subs.setOnClickListener(calcOnclick);
        mult.setOnClickListener(calcOnclick);
        div.setOnClickListener(calcOnclick);
        btnSqrt.setOnClickListener(calcOnclick);
        btnPow.setOnClickListener(calcOnclick);
        btnDelete.setOnClickListener(calcOnclick);
        deleteAll.setOnClickListener(calcOnclick);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bnfactorial.setOnClickListener(calcOnclick);
            bnpercent.setOnClickListener(calcOnclick);
            bncos.setOnClickListener(calcOnclick);
            bnsin.setOnClickListener(calcOnclick);
            bntan.setOnClickListener(calcOnclick);
            bnln.setOnClickListener(calcOnclick);
            bnlog.setOnClickListener(calcOnclick);
            bnpower.setOnClickListener(calcOnclick);
            rad.setOnClickListener(calcOnclick);
            deg.setOnClickListener(calcOnclick);
        }
    }
}




