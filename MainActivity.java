package com.example.agrima.phonebook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button maa,pa,bh,di;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.maa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialContact("7355632925");

            }

            private void dialContact(String s) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", s, null)));
            }

            {
                findViewById(R.id.pa).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialContact("9839227068");
                    }

                    private void dialContact(String s) {
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", s, null)));
                    }

                    {
                        findViewById(R.id.bh).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialContact("7007495458");
                            }

                            private void dialContact(String s) {
                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", s, null)));
                            }

                            {
                                findViewById(R.id.di).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        dialContact("9628052305");
                                    }

                                    private void dialContact(String s) {
                                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", s, null)));
                                    }
                                });
                            }
                        });

                    }

                });
            }
        });
    }}
