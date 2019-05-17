package sg.edu.rp.c346.l05quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button plus;
    Button minus;
    CheckBox one;
    CheckBox round;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=findViewById(R.id.editTextNumber);
        plus=findViewById(R.id.buttonPlus);
        minus=findViewById(R.id.buttonMinus);
        one=findViewById(R.id.oneWay);
        round=findViewById(R.id.round);
        submit=findViewById(R.id.buttonSubmit);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(num.getText().toString());
                amount=amount+1;
                String value=String.format("%d",amount);
                num.setText(value);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount2 = Integer.parseInt(num.getText().toString());
                if(amount2>0) {
                    amount2 = amount2 - 1;
                    String value = String.format("%d", amount2);
                    num.setText(value);
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(one.isChecked()&&round.isChecked()){
                    String text="Please only select one check box";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                }else if(one.isChecked()){
                    double amount2 = Double.parseDouble(num.getText().toString());
                    Intent intent= new Intent(getBaseContext(), SecondActivity.class);
                    intent.putExtra("double", amount2*100);
                    intent.putExtra("String", "One Way");
                    startActivity(intent);
                }else if(round.isChecked()){
                    double amount2 = Double.parseDouble(num.getText().toString());
                    Intent intent= new Intent(getBaseContext(), SecondActivity.class);
                    intent.putExtra("double", amount2*100*2);
                    intent.putExtra("String", "Two Way");
                    startActivity(intent);
                }else{
                    String text="Please select at least one checkbox";
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
