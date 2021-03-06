package buaa.lawyer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;
import android.widget.TextView;

public class MyActivity extends Activity {
    Button mButton;
    EditText mEdit;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mButton = (Button)findViewById(R.id.button);
        mEdit   = (EditText)findViewById(R.id.editText);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String actName = mEdit.getText().toString();
                try {
                    Class<Activity> act = (Class<Activity>) Class.forName(actName);
                    Intent intent = new Intent(MyActivity.this, act);
                    MyActivity.this.startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Log.v("EditText", actName);
            }
        });

        tv = (TextView)findViewById(R.id.textView);
        String info = "";
        info += "model:" + Build.MODEL + " \n";
        info += "serial:" + Build.SERIAL + "\n";
        info += "device:" + Build.DEVICE + "\n";
        info += "HARDWARE:" + Build.HARDWARE + "\n";
        info += "MANUFACTURER:" + Build.MANUFACTURER + "\n";
        info += "FINGERPRINT:" + Build.FINGERPRINT + "\n";
        info += "OS Version:" + System.getProperty("os.version") + "\n";
        tv.setText(info);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
