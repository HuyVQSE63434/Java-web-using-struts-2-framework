/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import com.opensymphony.xwork2.ActionContext;
import huyvq.carts.Carts;
import huyvq.registrations.registrationDAO;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */

public class LoginAction {

    private String txtid;
    private String txtPassword;
    private final String SUCCESS = "success";
    private final String SUCCESS2 = "success2";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        registrationDAO dao = new registrationDAO();
        boolean result = dao.login(txtid, txtPassword);
        String url = FAIL;
        if (result) {
            Map session = ActionContext.getContext().getSession();
            session.put("username", dao.getFullname());
            session.put("userId", txtid);

            Cookie cookie = new Cookie(txtid, txtPassword);
            cookie.setMaxAge(60 * 1);
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
