package storage.com.finalstorage.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import storage.com.finalstorage.R;
import storage.com.finalstorage.model.Orders;
import storage.com.finalstorage.model.ProductCategories;
import storage.com.finalstorage.service.FirebaseHelper;

public class CreateOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView priceTextView;
    private TextView measureTextView;
    private TextView totalPrice;
    private EditText quantityEditText;
    private Button buttonSave;
    private ProductCategories productCategories;
    private final List<ProductCategories> categoriesList = new ArrayList<ProductCategories>();
    private FirebaseHelper firebaseHelper = FirebaseHelper.getInstance();
    private Orders orders;

    private String[] product_category = {"Vegetables", "Beverages", "Meat"};
    private String[] product = {"potatos", "tomato", "cucumber"};
    private String[] vegetables = {"potatos", "tomato", "cucumber"};
    private String[] beverages = {"Vodka", "Beer", "Rom"};
    private String[] meat = {"beef", "horse", "ares"};
    private Spinner spin;
    private Spinner spin2;
    private Integer priceForOneItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonSave = (Button) findViewById(R.id.CreateOrderButton);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        totalPrice = (TextView) findViewById(R.id.TotalPrice);
        measureTextView = (TextView) findViewById(R.id.measureTextView);
        quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        spin = (Spinner) findViewById(R.id.spinner_product_category);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, product_category);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        priceForOneItem = getPrice();
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                if (spin.getSelectedItemPosition() == 0) {
                    product = vegetables;
                    measureTextView.setText("kg");

                }

                if (spin.getSelectedItemPosition() == 1) {
                    product = beverages;
                    measureTextView.setText("bottle");
                }

                if (spin.getSelectedItemPosition() == 2) {
                    product = meat;
                    measureTextView.setText("kg");
                }

                spin2 = (Spinner) findViewById(R.id.spinner_product);
                ArrayAdapter<String> bb = new ArrayAdapter<String>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, product);
                bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin2.setAdapter(bb);
                spin2.setOnItemSelectedListener(this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
        priceTextView.setText(priceForOneItem.toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Choose Countries :", Toast.LENGTH_SHORT).show();
    }

    private Integer getPrice() {
        Random r = new Random();
        int i1 = r.nextInt(80 - 65) + 65;
        return i1;
    }

    public void onMyButtonClick(View view) {
        if (TextUtils.isEmpty(quantityEditText.getText().toString())) {
            quantityEditText.setError("Введите количество продукта");
            return;
        } else {
            Integer price = Integer.parseInt(quantityEditText.getText().toString()) * priceForOneItem;
            totalPrice.setText(price.toString());
            orders = new Orders();
            orders.setId(1);
            orders.setAmount(Long.parseLong(quantityEditText.getText().toString()));
            orders.setOwnerId(firebaseHelper.getAuthUserDisplayName());
            orders.setProductId(spin2.getSelectedItemPosition());
            orders.setType(1);
            orders.setOrderItems(1);
            orders.setOrderDate(System.currentTimeMillis());
            firebaseHelper.getDataReference().child("Orders").push().setValue(orders);
            Toast.makeText(this, "Заказ успешно создан!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
    /*private void populateSpinner1() {
        firebaseHelper.getDataReference().child("ProductCategories").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productCategories = new ProductCategories();
                for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                    productCategories.setId(Long.valueOf(areaSnapshot.child("id").getValue(Integer.class)));
                    productCategories.setName(areaSnapshot.child("name").getValue(String.class));
//                    productCategories.setParentId(Long.valueOf(areaSnapshot.child("parentId").getValue(Integer.class)));
                    categoriesList.add(productCategories);
                }

                spin = (Spinner) findViewById(R.id.spinner_product_category);
                ArrayAdapter<ProductCategories> areasAdapter = new ArrayAdapter<ProductCategories>(CreateOrderActivity.this, android.R.layout.simple_spinner_item, categoriesList);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(areasAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/
}
