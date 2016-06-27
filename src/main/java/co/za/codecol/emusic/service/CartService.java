package co.za.codecol.emusic.service;

import co.za.codecol.emusic.domain.LineItem;

import java.util.List;


public interface CartService {

    void setItems(List<LineItem> items);

    List<LineItem> getItems();

    int getCount();

    void addItem(String productCode);

    void removeItem(String productCode);
}
