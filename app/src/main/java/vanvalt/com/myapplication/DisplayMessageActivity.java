package vanvalt.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by vanvalt123 on 2015/12/5.
 */
public class DisplayMessageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra("param");
        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setText(message);
        setContentView(textView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public static void actionStart(Context context,String data){
        Intent intent = new Intent(context,DisplayMessageActivity.class);
        intent.putExtra("param",data);
        context.startActivity(intent);
    }

}
