package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display =(EditText) findViewById(R.id.input);
        display.setText("");
        display.setShowSoftInputOnFocus(false);


    }
    private void updateString(String stringToAdd){

        String oldStr = display.getText().toString();
        int coursorPosi = display.getSelectionStart();
        String leftString  = oldStr.substring(0,coursorPosi);
        String rightStr = oldStr.substring(coursorPosi);
        display.setText(String.format("%S%S%S",leftString,stringToAdd,rightStr));
        display.setSelection(coursorPosi +1);

    }
    public void Zero (View view)
    {
        updateString("0");
    }
    public void One (View view)
    {
        updateString("1");
    }
    public void Two (View view)
    {
        updateString("2");
    }
    public void Three (View view)
    {
        updateString("3");
    }
    public void Foure (View view)
    {
        updateString("4");
    }
    public void Five (View view)
    {
        updateString("5");
    }
    public void Six (View view)
    {
        updateString("6");
    }
    public void Seven (View view)
    {
        updateString("7");
    }
    public void Eight (View view)
    {
        updateString("8");
    }
    public void Nine (View view)
    {
        updateString("9");
    }
    public void Clear (View view)
    {
        updateString("");
    }
    public void Add (View view)
    {
        updateString("+");
    }
    public void Parentheses (View view)
    {
        int courPos = display.getSelectionStart();
        int openPer = 0;
        int closedPer = 0;
        int textLenth = display.getText().length();


        for(int i=0 ; i <courPos; i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPer +=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPer +=1;
            }
        }
        if(openPer == closedPer || display.getText().toString().substring(textLenth-1,textLenth).equals("(")){
            updateString("(");
        }
        else if(closedPer < openPer && !display.getText().toString().substring(textLenth-1,textLenth).equals("(")) {
            updateString(")");
        }

        display.setSelection(courPos+1);


    }
    public void Exponent (View view)
    {
        updateString("^");
    }
    public void Devide (View view)
    {
        updateString("÷");

    }
    public void Multiply (View view)
    {
        updateString("×");

    }
    public void Subtract (View view)
    {
        updateString("-");
    }
    public void Equals (View view)
    {

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void Dot (View view)
    {
        updateString(".");
    }
    public void PlusMinus (View view)
    {
        updateString("-");
    }
    public void backSpace(View view)
    {
        int coursorPo = display.getSelectionStart();
        int trxtLen = display.getText().length();
         if (coursorPo !=0 && trxtLen !=0 )
         {
             SpannableStringBuilder selection  = (SpannableStringBuilder) display.getText();
             selection.replace(coursorPo -1,coursorPo, "");
             display.setText(selection);
             display.setSelection(coursorPo -1);
         }

    }

}