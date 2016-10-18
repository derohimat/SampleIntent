package net.derohimat.sampleintent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSub1 = (Button) findViewById(R.id.btn_sub_1);
        Button btnSub2 = (Button) findViewById(R.id.btn_sub_2);
        Button btnDial = (Button) findViewById(R.id.btn_dial);

        final EditText inpIntent = (EditText) findViewById(R.id.inp_intent);

        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Sub1Activity.class);
                startActivity(intent);
            }
        });

        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strIntent = inpIntent.getText().toString();

                if (TextUtils.isEmpty(strIntent)) {
                    inpIntent.setError("Data untuk dikirim masih kosong");
                    inpIntent.setFocusable(true);
                    return;
                }

                Intent intent = new Intent(mContext, Sub2Activity.class);
                intent.putExtra(Sub2Activity.KEY_DATA, strIntent);
                startActivityForResult(intent, 0);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:089696778913"));
                startActivity(intent);
            }
        });
    }
}
