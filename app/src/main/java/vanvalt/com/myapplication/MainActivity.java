package vanvalt.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  public static final String EXTRA_MESSAGE = "com.vanvalt.mainActivity";
    private Button  button_dial;
    private Button  button_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = (Button)findViewById(R.id.button_1);
        Button button1 = (Button)findViewById(R.id.button_2);
        button_dial = (Button)findViewById(R.id.button_dial);
        button_send = (Button)findViewById(R.id.send);
        button_send.setOnClickListener(this);
        button_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "HelloWorld";
                Intent intent = new Intent(MainActivity.this,SecondActitu.class);
             /*   intent.putExtra("extra_data",data);
                startActivity(intent);*/
                startActivityForResult(intent, 1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent  intent = new Intent(MainActivity.this,SecondActitu.class);
         /*       Intent intent = new Intent("com.vanvalt.yinshi");
                intent.addCategory("com.vanvalt.mycategory");*/
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                // intent.setData(Uri.parse("tel:15514397873"));*/
                startActivity(intent);
            }
        });
         getSupportActionBar().setDisplayShowTitleEnabled(false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"dianjialetianji",Toast.LENGTH_SHORT).show();
                break;

            case R.id.remove_item:
                Toast.makeText(this,"yichu",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.e("MainActivity",returnData);
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()) {
            case R.id.send:
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.edit_message);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
     public void setOverIconVisable(Menu menu) {
        try {
            Class clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Field field = clazz.getDeclaredField("mOptionalIconsVisible");
            if (field != null) {
                field.setAccessible(true);
                field.set(menu,true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu !=null) {
            setOverIconVisable(menu);
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
    }
}
