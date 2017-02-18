/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.com.finalstorage.model;

/**
 *
 * @author urmat.ukeshov
 */
public class Orders {

    private Integer id;
    private String ownerId;
    private Integer productId;
    private Long quantity;
    private Long amount;
    private Long orderDate;
    private Integer orderItems;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Long orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Integer orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
