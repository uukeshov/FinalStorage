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

    TextView orderProductName;
    ImageView ivOrderImage;
    CardView cv;


    public TextView getOrderProductName() {
        return orderProductName;
    }

    public void setOrderProductName(TextView orderProductName) {
        this.orderProductName = orderProductName;
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
        orderProductName = (TextView) v.findViewById(R.id.orderProductName);
        ivOrderImage = (ImageView) v.findViewById(R.id.iv_order_poster);
    }
}