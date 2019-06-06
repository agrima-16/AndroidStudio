package com.example.agrima.dialing;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    Button dialing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(EditText)findViewById(R.id.no);
        dialing=(Button)findViewById(R.id.dialing);

        dialing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt1=txt.getText().toString();
                if(TextUtils.isEmpty(txt1))
                {
                    txt.setError("Enter no");

                }
                else
                {
                    Intent i=new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:"+txt1));
                    startActivity(i);
                }
            }
        });
    }
}
