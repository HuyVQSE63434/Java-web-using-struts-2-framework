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
import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class StartAction {

    private final String SUCCESS = "success";
    private final String SUCCESS2 = "success2";
    private final String FAIL = "fail";

    public StartAction() {
    }

    public String execute() throws Exception {
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        String url = FAIL;
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                registrationDAO dao = new registrationDAO();
                boolean result = dao.login(cooky.getName(), cooky.getValue());
                if (result) {
                    Map session = ActionContext.getContext().getSession();
                    session.put("username", dao.getFullname());
                    session.put("userId", cooky.getName());

                    if (dao.getRole() == 0) {
                        Carts cart = (Carts) session.get("carts");
                        if (cart == null) {
                            cart = dao.uploadCart(cooky.getName());
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
            }
        }

        return url;
    }

}
