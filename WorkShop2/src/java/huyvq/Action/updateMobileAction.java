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
public class updateMobileAction {

    private String mobileId;
    private String txtdescription;
    private String txtprice;
    private String txtquantity;
    private boolean checkNotSale;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public updateMobileAction() {
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getTxtdescription() {
        return txtdescription;
    }

    public void setTxtdescription(String txtdescription) {
        this.txtdescription = txtdescription;
    }

    public String getTxtprice() {
        return txtprice;
    }

    public void setTxtprice(String txtprice) {
        this.txtprice = txtprice;
    }

    public String getTxtquantity() {
        return txtquantity;
    }

    public void setTxtquantity(String txtquantity) {
        this.txtquantity = txtquantity;
    }

    public boolean isCheckNotSale() {
        return checkNotSale;
    }

    public void setCheckNotSale(boolean checkNotSale) {
        this.checkNotSale = checkNotSale;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        registrationDAO dao= new registrationDAO();
        boolean result=dao.updateMobile(mobileId, txtdescription, txtprice, txtquantity, checkNotSale);
        return url;
    }

}
