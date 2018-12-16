/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import com.opensymphony.xwork2.ActionContext;
import huyvq.carts.Carts;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ReomoveItemAction {

    private String[] chkItem;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String[] getChkItem() {
        return chkItem;
    }

    public void setChkItem(String[] chkItem) {
        this.chkItem = chkItem;
    }

    public ReomoveItemAction() {

    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if (session != null) {
            Carts carts = (Carts) session.get("carts");
            if (carts != null) {
                if (chkItem != null) {
                    for (String item : chkItem) {
                        carts.removeItemFromCart(item);
                    }
                }
                session.put("carts", carts);
            }
        }
        return SUCCESS;
    }

}
