package com.example.agrima.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner list;
    String data[]={"Agrima","Kajal","Priyanshi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(Spinner) findViewById(R.id.listview);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {




            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // TextView txt=(TextView)view;
//                //Toast.makeText(MainActivity.this,txt.getText().toString(),Toast.LENGTH_SHORT).show();

                switch (position)

                {  case 0:
                        Toast.makeText(MainActivity.this, "First",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Second",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Third",
                                Toast.LENGTH_SHORT).show();
                        break;
//
//
//                }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

           }
        });

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent , View view, int position, long id) {
//               // TextView txt=(TextView)view;
//                //Toast.makeText(MainActivity.this,txt.getText().toString(),Toast.LENGTH_SHORT).show();
//                switch (position){
//                    case 0:
//                        Toast.makeText(MainActivity.this, "First",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//                        Toast.makeText(MainActivity.this, "Second",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(MainActivity.this, "Third",
//                                Toast.LENGTH_SHORT).show();
//                        break;
//
//
//                }
//
//
//            }
//        });
    }
}
