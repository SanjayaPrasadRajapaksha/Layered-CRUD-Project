/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layered.entity;

/**
 *
 * @author Sanjaya
 */
public class OrderDetailEntity {

    private String orderID;
    private String itemCode;
    private Integer orderQTY;
    private Integer discount;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderID, String itemCode, Integer orderQTY, Integer discount) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.orderQTY = orderQTY;
        this.discount = discount;
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the orderQTY
     */
    public Integer getOrderQTY() {
        return orderQTY;
    }

    /**
     * @param orderQTY the orderQTY to set
     */
    public void setOrderQTY(Integer orderQTY) {
        this.orderQTY = orderQTY;
    }

    /**
     * @return the discount
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" + "orderID=" + orderID + ", itemCode=" + itemCode + ", orderQTY=" + orderQTY + ", discount=" + discount + '}';
    }

}
