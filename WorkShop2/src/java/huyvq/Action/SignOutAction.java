/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class SignOutAction {
    private final String SUCCESS="success";
    public SignOutAction() {
    }
    
    public String execute() throws Exception {
        Map session= ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
    
}
