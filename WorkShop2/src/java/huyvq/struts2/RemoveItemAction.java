/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionContext;
import huyvq.carts.Carts;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Admin
 */
@ResultPath("/")
@Results({
    @Result(name = "success",location = "viewCart.jsp")
})
public class RemoveItemAction {

    private String[] chkItem;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public RemoveItemAction() {

    }
    @Action("/removeItem")
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        chkItem= ServletActionContext.getRequest().getParameterValues("chkItem");
        if (session != null) {
            Carts carts = (Carts) session.get("carts");
            if (carts != null) {
                if (chkItem != null) {
                    for (String item : chkItem) {
                        System.out.println(item);
                        carts.removeItemFromCart(item);
                    }
                }
                session.put("carts", carts);
            }
        }
        return SUCCESS;
    }

}
