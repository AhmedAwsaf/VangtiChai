package com.ahmedawsaf.cse489;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.LinearLayout;
import android.content.res.Configuration;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int cscore = 0;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;

    private Button clear;
    private TextView score;

    private TextView fivehtext;
    private TextView hundredtext;
    private TextView fiftytext;
    private TextView twentytext;
    private TextView tentext;
    private TextView fivetext;
    private TextView twotext;
    private TextView onetext;

    int fivehundred = 0;
    int hundred = 0;
    int fifty = 0;
    int twenty = 0;
    int ten = 0;
    int five = 0;
    int two = 0;
    int one = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout mainLayout = findViewById(R.id.outputLL);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            mainLayout.setOrientation(LinearLayout.VERTICAL);
        }

        score = findViewById(R.id.textView4);

        fivehtext = findViewById(R.id.textView17);
        hundredtext = findViewById(R.id.textView12);
        fiftytext = findViewById(R.id.textView13);
        twentytext = findViewById(R.id.textView16);
        tentext = findViewById(R.id.textView18);
        fivetext = findViewById(R.id.textView19);
        twotext = findViewById(R.id.textView20);
        onetext = findViewById(R.id.textView21);


        button1 = findViewById(R.id.button10);
        button2 = findViewById(R.id.button11);
        button3 = findViewById(R.id.button12);
        button4 = findViewById(R.id.button13);
        button5 = findViewById(R.id.button14);
        button6 = findViewById(R.id.button15);
        button7 = findViewById(R.id.button16);
        button8 = findViewById(R.id.button17);
        button9 = findViewById(R.id.button18);
        button0 = findViewById(R.id.button19);
        clear = findViewById(R.id.button20);

        button1.setOnClickListener(v -> addnumber(1));
        button2.setOnClickListener(v -> addnumber(2));
        button3.setOnClickListener(v -> addnumber(3));
        button4.setOnClickListener(v -> addnumber(4));
        button5.setOnClickListener(v -> addnumber(5));
        button6.setOnClickListener(v -> addnumber(6));
        button7.setOnClickListener(v -> addnumber(7));
        button8.setOnClickListener(v -> addnumber(8));
        button9.setOnClickListener(v -> addnumber(9));
        button0.setOnClickListener(v -> addnumber(0));
        clear.setOnClickListener(v -> clearnumber());
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        LinearLayout mainLayout = findViewById(R.id.outputLL);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mainLayout.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            mainLayout.setOrientation(LinearLayout.VERTICAL);
        }
    }


    private void refreshtext(){
        String sc = String.valueOf(cscore);
        score.setText("Amount: "+sc);

        Vangti();

        fivehtext.setText("500: "+String.valueOf(fivehundred));
        hundredtext.setText("100: "+String.valueOf(hundred));
        fiftytext.setText("50: "+String.valueOf(fifty));
        twentytext.setText("20: "+String.valueOf(twenty));
        tentext.setText("10: "+String.valueOf(ten));
        fivetext.setText("5: "+String.valueOf(five));
        twotext.setText("2: "+String.valueOf(two));
        onetext.setText("1: "+String.valueOf(one));
    }

    private void addnumber(int number) {
//        int cs = Integer.parseInt(score.getText().toString().substring(8));
        cscore = cscore*10 + number;
        refreshtext();
    }

    private void clearnumber() {
        cscore = 0;
        refreshtext();
    }

    private void Vangti(){
        int rescore = cscore;

        fivehundred = rescore/500;
        rescore = rescore%500;

        hundred = rescore/100;
        rescore = rescore%100;

        fifty = rescore/50;
        rescore = rescore%50;

        twenty = rescore/20;
        rescore = rescore%20;

        ten = rescore/10;
        rescore = rescore%10;

        five = rescore/5;
        rescore = rescore%5;

        two = rescore/2;
        rescore = rescore%2;

        one = rescore;

    }
}