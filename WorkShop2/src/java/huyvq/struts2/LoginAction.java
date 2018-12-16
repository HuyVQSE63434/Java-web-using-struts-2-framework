/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import huyvq.carts.Carts;
import huyvq.registrations.registrationDAO;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Admin
 */
@ResultPath(value = "/")
@Results({
    @Result(name = "success",location = "searchForUser.jsp"),
    @Result(name = "success2", location = "searchForStaff.jsp" ),
    @Result(name = "fail", location = "invalidLogin.html", type = "redirect")
})
public class LoginAction extends ActionSupport{

    private String txtid;
    private String txtPassword;
        private final String SUCCESS = "success";
        private final String SUCCESS2 = "success2";
        private final String FAIL = "fail";

    public LoginAction() {
    }
    @Action("/login")
    public String execute() throws Exception {
        registrationDAO dao = new registrationDAO();
        boolean result = dao.login(txtid, txtPassword);
        String url = FAIL;
        if (result) {
            Map session = ActionContext.getContext().getSession();
            session.put("username", dao.getFullname());
            session.put("userId", txtid);

            Cookie cookie = new Cookie(txtid, txtPassword);
            cookie.setMaxAge(60 * 5);
            HttpServletResponse response = ServletActionContext.getResponse();
            response.addCookie(cookie);
            if (dao.getRole() == 0) {
                Carts cart = (Carts) session.get("carts");
                if (cart == null) {
                    cart = dao.uploadCart(txtid);
                    if (cart.getItems().size() > 0) {
                        session.put("carts", cart);
                    }
                }
                url = SUCCESS;
            }
            if (dao.getRole() == 2) {
                url = SUCCESS2;
            }
        }
        return url;
    }

    public String getTxtid() {
        return txtid;
    }

    public void setTxtid(String txtid) {
        this.txtid = txtid;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

}
