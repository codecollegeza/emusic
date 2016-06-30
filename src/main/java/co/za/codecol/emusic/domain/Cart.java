package co.za.codecol.emusic.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<LineItem> lineItems) {
        items = lineItems;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        //If the item already exists in the cart, only the quantity is changed.
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }

    public double getCartTotal() {
        double cartTotal = 0.00;
        for (LineItem item : items) {
            cartTotal += item.getTotal();
        }
        return cartTotal;
    }
    public double getCartGrandTotal() {

        double flatDeliveryFee = 35.00;
        if(getCartTotal() > 50) {
            return getCartTotal();
        }else{
            return getCartTotal() + flatDeliveryFee;
        }
    }
    public double getShipping(){
        double flatDeliveryFee = 35.00;
        if(getCartTotal() > 50) {
            return 0.00;
        }else{
            return flatDeliveryFee;
        }
    }
}

