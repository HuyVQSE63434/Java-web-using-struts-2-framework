/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionContext;
import huyvq.carts.Carts;
import java.util.Map;
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
    @Result(name = "success", type = "redirectAction" ,params = {"actionName","searchInRange",
"txtRangeBegin","${rangeBegin}","txtRangeEnd","${rangeEnd}"} )
})
public class AddToCartAction {

    private String mobileId;
    private String mobileName;
    private String rangeBegin;
    private String rangeEnd;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public AddToCartAction() {
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getRangeBegin() {
        return rangeBegin;
    }

    public void setRangeBegin(String rangeBegin) {
        this.rangeBegin = rangeBegin;
    }

    public String getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(String rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    @Action("/addtocart")
    public String execute() throws Exception {
        String url = SUCCESS;
        Map session = ActionContext.getContext().getSession();
        Carts carts = (Carts) session.get("carts");
        if (carts == null) {
            carts = new Carts();
        }
        carts.addItemsToCart(mobileId, mobileName, (String) session.get("userId"));
        session.put("carts", carts);
        return url;
    }

}
