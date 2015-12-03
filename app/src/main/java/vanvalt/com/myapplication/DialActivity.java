package vanvalt.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vanvalt123 on 2015/12/3.
 */
public class DialActivity extends Activity implements View.OnClickListener{
    private EditText et_number;
    private Button dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dial_layout);
        dial = (Button) findViewById(R.id.dial_button);
        dial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        call();

    }
    public void call(){
        et_number =(EditText)DialActivity.this.findViewById(R.id.dial_edit);
        String number = et_number.getText().toString().trim();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ number));
        startActivity(intent);
    }
}
