package sharda.ac.in.loginactivity;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName, textPassword;
    Button btnSubmit;
    AsyncHttpClient client;
    RequestParams params;
    ListView list;
    ArrayList listdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        textPassword = (EditText) findViewById(R.id.editTextPassword);
        list = (ListView) findViewById(R.id.list);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        listdata = new ArrayList();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextUserName.getText().toString())) {
                    editTextUserName.setError("Enter Name");
                } else if (TextUtils.isEmpty(textPassword.getText().toString())) {
                    textPassword.setError("Enter Password");
                } else {
                    client = new AsyncHttpClient();
                    params = new RequestParams();
                    client.get("https://jsonplaceholder.typicode.com/posts", new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                            String data = new String(responseBody);
                            Log.d("Agrima", data);
                            try {
                                JSONArray array = new JSONArray(data);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject jsnobj = array.getJSONObject(i);
                                    int userId = jsnobj.getInt("userId");
                                    int id = jsnobj.getInt("id");
                                    String title = jsnobj.getString("title");
                                    String body = jsnobj.getString("body");
                                    listdata.add(userId+"\n"+id+"\n"+title+"\n"+body);

                                    ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,
                                            android.R.layout.simple_list_item_1,listdata);
                                    list.setAdapter(adapter);
                                }


                            } catch (JSONException je) {
                                je.printStackTrace();
                            }


                        }

                        @Override
                        public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers,
                                              byte[] responseBody, Throwable error) {

                        }

                        ;


                    });
                }
            }
        });
    }
}
