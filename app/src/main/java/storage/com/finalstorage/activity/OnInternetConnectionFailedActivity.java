package storage.com.finalstorage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import storage.com.finalstorage.R;
import storage.com.finalstorage.service.CheckInternetConnection;

public class OnInternetConnectionFailedActivity extends AppCompatActivity {

    CheckInternetConnection checkInternetConnection;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_internet_connection_failed);
        button = (Button) findViewById((R.id.button));
        textView = (TextView) findViewById(R.id.textView);
    }

    public void reConnectToInternet(View v) {
        checkInternetConnection = new CheckInternetConnection();
        if (checkInternetConnection.hasConnection(this)) {
            Intent myIntent = new Intent(this, MainActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(myIntent);
            finish();
        } else {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Соединения нет, попробуйте снова!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
