package com.example.joseph;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_start;
    Button btn_set;
    Button btn_reset;
    EditText edit_sum;
    EditText edit_start;
    EditText edit_count;

    PeopleView[] peopleView;

    int sum = 0;
    int start = 0;
    int count = 0;
    int num = 0;

    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init() {
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_set = (Button)findViewById(R.id.btn_set);
        btn_reset = (Button)findViewById(R.id.btn_reset);

        btn_start.setOnClickListener(this);
        btn_set.setOnClickListener(this);
        btn_reset.setOnClickListener(this);

        edit_sum = (EditText)findViewById(R.id.sum);
        edit_start = (EditText)findViewById(R.id.start);
        edit_count = (EditText)findViewById(R.id.count);

        peopleView = new PeopleView[16];

        peopleView[0] = findViewById(R.id.n1);
        peopleView[1] = findViewById(R.id.n2);
        peopleView[2] = findViewById(R.id.n3);
        peopleView[3] = findViewById(R.id.n4);
        peopleView[4] = findViewById(R.id.n5);
        peopleView[5] = findViewById(R.id.n6);
        peopleView[6] = findViewById(R.id.n7);
        peopleView[7] = findViewById(R.id.n8);
        peopleView[8] = findViewById(R.id.n9);
        peopleView[9] = findViewById(R.id.n10);
        peopleView[10] = findViewById(R.id.n11);
        peopleView[11] = findViewById(R.id.n12);
        peopleView[12] = findViewById(R.id.n13);
        peopleView[13] = findViewById(R.id.n14);
        peopleView[14] = findViewById(R.id.n15);
        peopleView[15] = findViewById(R.id.n16);

        btn_start.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set:
                if (edit_sum.getText().toString().isEmpty() || edit_start.getText().toString().isEmpty() || edit_count.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "输入有误，请重新输入", Toast.LENGTH_LONG).show();
                    break;
                }
                sum = Integer.parseInt(edit_sum.getText().toString());
                start = Integer.parseInt(edit_start.getText().toString());
                count = Integer.parseInt(edit_count.getText().toString());
                if (sum > 16) {
                    Toast.makeText(MainActivity.this, "总人数不能超过16", Toast.LENGTH_SHORT).show();
                    break;
                }
                for (int i=0; i<sum; i++) {
                    peopleView[i].setPaintshow();
                }
                game.CreateGame(sum);
                game.SetStart(start);
                Toast.makeText(MainActivity.this, "准备就绪", Toast.LENGTH_SHORT).show();
                btn_start.setEnabled(true);
                btn_set.setEnabled(false);
                break;
            case R.id.btn_start:
                if (num < sum) {
                    int out = game.runonce(count);
                    peopleView[out-1].setPaintshut();
                    num++;
                    String output = "第" + out + "名玩家出局";
                    Toast.makeText(MainActivity.this, output, Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"游戏结束", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_reset:
                sum = 0;
                start = 0;
                count = 0;
                num = 0;
                for (int i=0; i<16; i++) {
                    peopleView[i].setPaintinit();
                }
                game = new Game();
                btn_set.setEnabled(true);
                btn_start.setEnabled(false);
                edit_sum.setText("");
                edit_start.setText("");
                edit_count.setText("");
                Toast.makeText(MainActivity.this, "游戏已重置", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }
    }
}
