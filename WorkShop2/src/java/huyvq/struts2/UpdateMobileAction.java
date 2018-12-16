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
    @Result(name = "success" , type = "redirectAction", params = {
    "actionName","searchMobile","txtSearch","${lastSearchValue}"
    })
})
public class UpdateMobileAction {

    private String mobileId;
    private String txtdescription;
    private String txtprice;
    private String txtquantity;
    private boolean checkNotSale;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public UpdateMobileAction() {
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
    @Action("/Updatemobile")
    public String execute() throws Exception {
        String url = SUCCESS;
        registrationDAO dao= new registrationDAO();
        boolean result=dao.updateMobile(mobileId, txtdescription, txtprice, txtquantity, checkNotSale);
        return url;
    }

}
