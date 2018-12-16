/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import huyvq.registrations.registrationDAO;
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
    @Result(name = "success", type = "redirectAction", params = {
        "actionName","searchMobile",
        "txtSearch","${lastSearchValue}"
    })
})
public class DeleteMobileAction {
    private String mobileId;
    private String lastSearchValue;
    private final String SUCCESS="success";
    private final String FAIL="fail";

    public DeleteMobileAction() {
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    @Action("/deleteMobile")
    public String execute() throws Exception {
        String url=SUCCESS;
        registrationDAO dao= new registrationDAO();
        boolean result= dao.deleteMobile(mobileId);
        return url;
    }
    
}
