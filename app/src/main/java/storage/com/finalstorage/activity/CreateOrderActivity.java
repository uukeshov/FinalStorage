package storage.com.finalstorage.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import storage.com.finalstorage.R;
import storage.com.finalstorage.service.FirebaseHelper;

public class CreateOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private EditText editTextName;
    private EditText editTextAddress;
    private TextView priceTextView;
    private TextView measureTextView;
    private Button buttonSave;
    private FirebaseHelper firebaseHelper = FirebaseHelper.getInstance();

    private String[] data = {"one", "two", "three", "four", "five"};
    private String[] data2 = {"ewq", "ewqewqe", "ewqewqe", "ewqewqew", "ewqewqewqe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        priceTextView = (TextView) findViewById(R.id.priceTextView);
        Spinner spin = (Spinner) findViewById(R.id.spinner_product_category);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        measureTextView = (TextView) findViewById(R.id.measureTextView);
        Spinner spin2 = (Spinner) findViewById(R.id.spinner_product);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data2);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(bb);
        spin2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Spinner spin = (Spinner) parent;
        Spinner spin2 = (Spinner) parent;
        if (spin.getId() == R.id.spinner_product_category) {
            Toast.makeText(this, "Your choose :" + data[position], Toast.LENGTH_SHORT).show();
        }
        if (spin2.getId() == R.id.spinner_product) {
            Toast.makeText(this, "Your choose :" + data2[position], Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Choose Countries :", Toast.LENGTH_SHORT).show();
    }
/*
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
                finish();
            }
        });*/

}
