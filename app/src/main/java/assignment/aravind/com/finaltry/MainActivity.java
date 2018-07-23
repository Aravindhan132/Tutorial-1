package assignment.aravind.com.finaltry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String first;
    String second;
    RadioButton Admin,User;
    private static EditText UserName,Password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserName=(EditText)findViewById(R.id.USERNAME);
        Password=(EditText)findViewById(R.id.PASSWORD);
        final Button Login=(Button)findViewById(R.id.Login);
        Admin=(RadioButton)findViewById(R.id.RAdmin);
        User=(RadioButton)findViewById(R.id.RUser);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               moveactivity();
            }
        });


    }

    private void moveactivity() {
        first=Admin.getText().toString();
        second=User.getText().toString();
        Log.e("firstradiobutton",first);
        Log.e("secondradiobutton",second);

        int val=radiobutton();
        if(val==1){
            if(validateadmin()) {
                startActivity(new Intent(MainActivity.this, Admin.class));
            }
        }
        else if(val==2){
            if(validate()){
                startActivity(new Intent(MainActivity.this,User.class));
            }
        }
        else if(val==3){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateadmin() {
        String uname=String.valueOf(UserName.getText());
        String pass=String.valueOf(Password.getText());
        if(uname.equals("Admin")&&pass.equals("123")){
            return true; }
        return false;

    }

    private int  radiobutton() {
        if(User.isChecked()&&!Admin.isChecked()){
            Log.e("Admin","Clicked");
            Toast.makeText(getApplicationContext(),"User clicked",Toast.LENGTH_LONG).show();
            return 2;
        }
        else if(Admin.isChecked()&&!User.isChecked()){
            Log.e("User","Clicked");

            Toast.makeText(getApplicationContext(),"Admin clicked",Toast.LENGTH_LONG).show();
            return 1;
        }
        else if(Admin.isChecked()&&Admin.isChecked()){
            Toast.makeText(getApplicationContext(),"Don't click Both",Toast.LENGTH_LONG).show();
            return 0;
        }
        return 0;
    }

    private static boolean validate() {
        String uname=String.valueOf(UserName.getText());
        String pass=String.valueOf(Password.getText());
        if(uname.equals("User")&&pass.equals("123")){
           return true; }
           return false;
        }
    }

