package storage.com.finalstorage.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import storage.com.finalstorage.R;
import storage.com.finalstorage.model.Person;
import storage.com.finalstorage.service.FirebaseHelper;

public class CreateOrderActivity extends AppCompatActivity {


    private EditText editTextName;
    private EditText editTextAddress;
    private TextView textViewPersons;
    private Button buttonSave;
    private FirebaseHelper firebaseHelper = FirebaseHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();
                Person person = new Person();
                person.setName(name);
                person.setAddress(address);
                firebaseHelper.getDataReference().child("Person").push().setValue(person);

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Order created!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}
