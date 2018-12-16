/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import huyvq.registrations.registrationDAO;

/**
 *
 * @author Admin
 */
public class deleteMobileAction {
    private String mobileId;
    private String lastSearchValue;
    private final String SUCCESS="success";
    private final String FAIL="fail";

    public deleteMobileAction() {
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
    
    public String execute() throws Exception {
        String url=SUCCESS;
        registrationDAO dao= new registrationDAO();
        boolean result= dao.deleteMobile(mobileId);
        return url;
    }
    
}
