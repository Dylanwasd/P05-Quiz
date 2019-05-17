package sg.edu.rp.c346.l05quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView trip;
TextView cost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        trip=findViewById(R.id.textView);
        cost=findViewById(R.id.textView3);
        Intent intentReceived = getIntent();
        double value = intentReceived.getDoubleExtra("double",0.0);
        cost.setText("Your air ticket costs  $" + value);
        String value2=intentReceived.getStringExtra("String");
        trip.setText("You have selected "+value2+" trip");

    }
}
