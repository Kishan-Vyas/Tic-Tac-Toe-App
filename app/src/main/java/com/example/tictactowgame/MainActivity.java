package com.example.tictactowgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
String b1, b2, b3, b4, b5, b6, b7, b8, b9;
TextView textDisplayWin;
GridLayout mainGridLayout;
int flag=0;
int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

    }

    // for finding id....
    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        mainGridLayout = findViewById(R.id.mainGridLayout);
        textDisplayWin = findViewById(R.id.textDisplayWin);
    }

    public void check(View view) {
        Button btnCurrent = (Button)view;


        Animation popUp = AnimationUtils.loadAnimation(this, R.anim.pop_up);

        if(btnCurrent.getText().toString().equals("")) {

            count++;

            if (flag == 0) {
                btnCurrent.setText("O");
                btnCurrent.setTextColor(getResources().getColor(R.color.green));
                flag = 1;
            } else {
                btnCurrent.setText("X");
                btnCurrent.setTextColor(getResources().getColor(R.color.red));
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // conditions....

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //1

                    btn1.setText("-");
                    btn2.setText("-");
                    btn3.setText("-");
//                    changeWinColor(b4,b5,b6,b7,b8,b9);
                    makeEmptyBtn(b1);
                }
                else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2

                    btn4.setText("-");
                    btn5.setText("-");
                    btn6.setText("-");
                    makeEmptyBtn(b4);
                }
                else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3

                    btn7.setText("-");
                    btn8.setText("-");
                    btn9.setText("-");
                    makeEmptyBtn(b7);
                }
                else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4

                    btn1.setText("|");
                    btn4.setText("|");
                    btn7.setText("|");
                    makeEmptyBtn(b1);
                }
                else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //5

                    btn2.setText("|");
                    btn5.setText("|");
                    btn8.setText("|");
                    makeEmptyBtn(b2);
                }
                else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6

                    btn3.setText("|");
                    btn6.setText("|");
                    btn9.setText("|");
                    makeEmptyBtn(b3);
                }
                else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //7

                    btn1.setText("\\");
                    btn5.setText("\\");
                    btn9.setText("\\");
                    makeEmptyBtn(b1);
                }
                else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //8
                    btn3.setText("/");
                    btn5.setText("/");
                    btn7.setText("/");
                    makeEmptyBtn(b3);
                }
                else if(count==9) {
                    //Draw
                    changBackground("draw");
                    makeEmptyBtn("draw");
                }
            }
        }
    }


    private void changeWinColor(String bt1,String bt2 ,String bt3, String bt4,String bt5,String bt6) {

    }

    private void makeEmptyBtn(String btnValue) {

        changBackground(btnValue);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                count=0;
                flag=0;
                mainGridLayout.setBackgroundColor(getResources().getColor(R.color.mainBackgroundcolor));
                textDisplayWin.setText("");
                textDisplayWin.setTextColor(getResources().getColor(R.color.black));
            }
        }, 1300);
    }


    public void reset(View view) {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count=0;
        flag=0;
    }

    private void changBackground(String btnValue) {
        if(btnValue == "O") {
            mainGridLayout.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if (btnValue == "X") {
            mainGridLayout.setBackgroundColor((getResources().getColor(R.color.red)));
        }
        else if (btnValue == "draw") {
            mainGridLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        }

        // change Text to Win
        if(btnValue == "O") {
            textDisplayWin.setTextColor(getResources().getColor(R.color.green));
            textDisplayWin.setText("Winner is  O");
        } else if (btnValue == "X") {
            textDisplayWin.setTextColor(getResources().getColor(R.color.red));
            textDisplayWin.setText("Winner is  X");
        } else if (btnValue == "draw"){
            textDisplayWin.setTextColor(getResources().getColor(R.color.blue));
//            GameCode g1 = new GameCode();
//            g1.test();
            textDisplayWin.setText("Draw!");
        }

    }






}