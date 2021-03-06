/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionContext;
import huyvq.carts.Carts;
import huyvq.registrations.registrationDAO;
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
    @Result(name = "success" , location = "viewCart.jsp")
})
public class SaveCartAction {
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private String saved;

    public String getSaved() {
        return saved;
    }
    
    public SaveCartAction() {
    }
    @Action("/savetoDatabase")
    public String execute() throws Exception {
        String url= SUCCESS;
        Map session= ActionContext.getContext().getSession();
        Carts carts= (Carts) session.get("carts");
        if(carts!=null){
            registrationDAO dao =new registrationDAO();
            boolean result=dao.saveCart(carts);
            if(result){
                saved="saved";
            }else{
                saved="not saved";
            }
        }
        return url;
    }
    
}
