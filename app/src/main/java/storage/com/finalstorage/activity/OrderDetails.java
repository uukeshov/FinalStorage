package storage.com.finalstorage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;

import storage.com.finalstorage.R;
import storage.com.finalstorage.model.Orders;
import storage.com.finalstorage.utils.Utils;

public class OrderDetails extends AppCompatActivity {


    private TextView id;
    private TextView ownerId;
    private TextView productId;
    private TextView quantity;
    private TextView amount;
    private TextView orderDate;
    private TextView orderItems;
    private TextView storage;
    private TextView status;
    private TextView measure;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String OrderList = intent.getStringExtra("OrderList");
        Gson gson = new Gson();
        Orders orders = gson.fromJson(OrderList, Orders.class);

        id = (TextView) findViewById(R.id.id);
        ownerId = (TextView) findViewById(R.id.ownerId);
        productId = (TextView) findViewById(R.id.productId);
        quantity = (TextView) findViewById(R.id.quantity);
        amount = (TextView) findViewById(R.id.amount);
        orderDate = (TextView) findViewById(R.id.orderDate);
        orderItems = (TextView) findViewById(R.id.orderItems);
        storage = (TextView) findViewById(R.id.storage);
        status = (TextView) findViewById(R.id.status);
        measure = (TextView) findViewById(R.id.measure);
        price = (TextView) findViewById(R.id.price);

        id.setText("Номер заказа: " + orders.getId());
        ownerId.setText("Владелец заказа: " + orders.getOwnerId());
        productId.setText("Название продукта: " + orders.getProductId());
        quantity.setText("Количество: " + orders.getQuantity().toString());
        amount.setText("Общая цена: " + orders.getAmount().toString());
        orderDate.setText("Дата создания заказа: " + Utils.getDate(orders.getOrderDate(), "dd/MM/yyyy hh:mm:ss.SSS"));
        orderItems.setText("Полt проpапас: " + orders.getOrderItems());
        storage.setText("Склад: " + orders.getStorage());
        status.setText("Статус: " + orders.getStatus());
        measure.setText("Единица измерения: " + orders.getMeasure());
        price.setText("Цена за единицу: " + orders.getPrice());

    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
