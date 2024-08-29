package com.bibo.ex2;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Spinner sp;
    RadioGroup rg;
    RadioButton r1, r2;
    ListView lv;
    RatingBar rb;
    Button b;

    String name;
    int degree;
    String area;
    String rating;
    String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing views
        et = findViewById(R.id.editText1);
        sp = findViewById(R.id.spinner1);
        rg = findViewById(R.id.radioGroup1);
        r1 = findViewById(R.id.radio0);
        r2 = findViewById(R.id.radio1);
        lv = findViewById(R.id.listView1);
        rb = findViewById(R.id.ratingBar);
        b = findViewById(R.id.button1);

        // Spinner Item Selected Listener
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action needed
            }
        });

        // RadioGroup Item Checked Change Listener
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio0) {
                    degree = 0;
                } else if (checkedId == R.id.radio1) {
                    degree = 1;
                }
            }
        });

        // ListView Item Click Listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                area = ((TextView) view).getText().toString();
            }
        });

        // RatingBar Change Listener
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float ratingValue, boolean fromUser) {
                rating = String.valueOf(ratingValue);
            }
        });

        // Button Click Listener
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText Item
                name = et.getText().toString();

                // Displaying collected information
                String line = System.getProperty("line.separator");
                String str = "Name = " + name + line +
                        "Sex = " + sex + line +
                        "Degree = " + (degree == 0 ? "B.E CSE" : "B.TECH IT") + line +
                        "Area = " + area + line +
                        "Rating = " + rating;

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Your Data Saved!!!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
