package net.derohimat.sampleintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Sub2Activity extends AppCompatActivity {
    public static String KEY_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        TextView txtData = (TextView) findViewById(R.id.txt_data);
        String receivedData = getIntent().getStringExtra(KEY_DATA);
        txtData.setText(receivedData);
    }
}
