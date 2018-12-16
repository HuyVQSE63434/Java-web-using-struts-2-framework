/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Admin
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "searchForStaff.jsp")
})
public class SignOutAction implements SessionAware{
    private final String SUCCESS="success";
    Map<String, Object> sessionmap;
    public SignOutAction() {
    }
    @Action(value = "/signout")
    public String execute() throws Exception {
        Cookie[] cookies=ServletActionContext.getRequest().getCookies();
        if(cookies!=null){
            for (Cookie cooky : cookies) {
                if(cooky.getName().equalsIgnoreCase((String)sessionmap.get("userId"))){
                    cooky.setMaxAge(0);
                    ServletActionContext.getResponse().addCookie(cooky);
                }
            }
        }
        sessionmap.clear();
        ActionContext.getContext().setSession(sessionmap);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionmap=(SessionMap) map;
    }
    
}
