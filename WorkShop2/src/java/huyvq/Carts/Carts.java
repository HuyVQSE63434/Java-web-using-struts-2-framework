/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.carts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author huyvqse63434
 */
public class Carts implements Serializable{

    private String customerID;
    private HashMap<String[], Integer> items;

    public Carts() {
    }

    public Carts(String customerID, HashMap<String[], Integer> items) {
        this.customerID = customerID;
        this.items = items;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public HashMap<String[], Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String[], Integer> items) {
        this.items = items;
    }

    public void addItemsToCart(String id, String title, String customerId) {
        if (items == null) {
            this.items = new HashMap<>();
        }
        this.setCustomerID(customerId);
        int quantity = 1;
        String[] item = new String[2];
        item[0] = id;
        item[1] = title;
        Set<String[]> keys = items.keySet();
        boolean change = false;
        for (String[] key : keys) {
            if (key[0].equals(id)) {
                if (key[1].equals(title)) {
                    quantity = this.items.get(key) + 1;
                    items.replace(key, quantity);
                    change = true;
                }
            }
        }
        if (change == false) {
            items.put(item, quantity);
        }
    }

    public void removeItemFromCart(String id) {
        if (this.items == null) {
            return;
        }
        Set<String[]> keys = items.keySet();
        boolean test = true;
        for (String[] key : keys) {
            if (key[0].equals(id)) {
                test = false;
            }
            if (test == false) {
                items.remove(key);
                if (items.isEmpty()) {
                    items = null;
                }
                return;
            }
        }
        if (items.isEmpty()) {
            items = null;
        }
    }
}
