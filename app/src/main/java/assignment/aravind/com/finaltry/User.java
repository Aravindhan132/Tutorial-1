package assignment.aravind.com.finaltry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class User extends AppCompatActivity {

    ListView lv;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        lv=(ListView)findViewById(R.id.list_view);
        list=new ArrayList<>();
        adding();
        Intent intent = getIntent();
        if(intent!=null) {
            list .add ((String) getIntent().getSerializableExtra("array"));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list );

        lv.setAdapter(arrayAdapter);
    }

    private void adding() {
       for(int i=0;i<25;i++){
           list.add(String.valueOf("sample "+i));
       }
    }
    public void send(String gett){
        list.add(String.valueOf(gett));
    }
}
