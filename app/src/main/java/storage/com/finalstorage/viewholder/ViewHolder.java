package storage.com.finalstorage.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import storage.com.finalstorage.R;

/**
 * Created by uukeshov on 18.02.2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView storage;
    TextView productName;
    TextView createDate;
    TextView status;
    TextView orderId;
    ImageView ivOrderImage;
    CardView cv;



    public TextView getStorage() {
        return storage;
    }

    public void setStorage(TextView storage) {
        this.storage = storage;
    }

    public TextView getProductName() {
        return productName;
    }

    public void setProductName(TextView productName) {
        this.productName = productName;
    }

    public TextView getCreateDate() {
        return createDate;
    }

    public void setCreateDate(TextView createDate) {
        this.createDate = createDate;
    }

    public TextView getStatus() {
        return status;
    }

    public void setStatus(TextView status) {
        this.status = status;
    }

    public TextView getOrderId() {
        return orderId;
    }

    public void setOrderId(TextView orderId) {
        this.orderId = orderId;
    }

    public CardView getCv() {
        return cv;
    }

    public void setCv(CardView cv) {
        this.cv = cv;
    }

    public ImageView getIvOrderImage() {
        return ivOrderImage;
    }

    public void setIvOrderImage(ImageView ivOrderImage) {
        this.ivOrderImage = ivOrderImage;
    }

    public ViewHolder(View v) {
        super(v);
        cv = (CardView)itemView.findViewById(R.id.card_view);
        storage = (TextView) v.findViewById(R.id.storageId);
        productName = (TextView) v.findViewById(R.id.productname);
        createDate = (TextView) v.findViewById(R.id.createDate);
        status = (TextView) v.findViewById(R.id.status);
        orderId = (TextView) v.findViewById(R.id.orderId);
        ivOrderImage = (ImageView) v.findViewById(R.id.iv_order_poster);
    }
}