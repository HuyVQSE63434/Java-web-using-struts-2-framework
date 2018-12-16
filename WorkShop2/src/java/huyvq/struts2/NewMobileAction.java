/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import huyvq.registrations.registrationDAO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Admin
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "newMobile.jsp")
    ,
    @Result(name = "input", location = "newMobile.jsp")
    ,
    @Result(name = "fail", location = "newMobile.jsp")

})
public class NewMobileAction extends ActionSupport {

    private String txtNewMobileId;
    private String txtNewDescription;
    private String txtNewPrice;
    private String txtNewMobileName;
    private String txtNewYearOfProduction;
    private String txtNewQuantity;
    private boolean chkNewNoteSale;
    private String status;
    private final String SUCCESS = "success";

    public NewMobileAction() {
    }

    public String getTxtNewMobileId() {
        return txtNewMobileId;
    }
    @RequiredStringValidator(trim = true, message = "Mobile ID is required!!!")
    public void setTxtNewMobileId(String txtNewMobileId) {
        this.txtNewMobileId = txtNewMobileId;
    }

    public String getTxtNewDescription() {
        return txtNewDescription;
    }

    public void setTxtNewDescription(String txtNewDescription) {
        this.txtNewDescription = txtNewDescription;
    }

    public String getTxtNewPrice() {
        return txtNewPrice;
    }

    @RequiredStringValidator(message = "Price is required!!!")
    @IntRangeFieldValidator( message = "Price Must be number!!!")
    public void setTxtNewPrice(String txtNewPrice) {
        this.txtNewPrice = txtNewPrice;
    }

    public String getTxtNewMobileName() {
        return txtNewMobileName;
    }

    @RequiredStringValidator(message = "Mobile name is required!!!")
    public void setTxtNewMobileName(String txtNewMobileName) {
        this.txtNewMobileName = txtNewMobileName;
    }

    public String getTxtNewYearOfProduction() {
        return txtNewYearOfProduction;
    }

    public String getStatus() {
        return status;
    }

    @RequiredStringValidator(message = "Year of production is required!!!")
    public void setTxtNewYearOfProduction(String txtNewYearOfProduction) {
        this.txtNewYearOfProduction = txtNewYearOfProduction;
    }

    public String getTxtNewQuantity() {
        return txtNewQuantity;
    }

    @RequiredStringValidator(message = "Quantity is required!!!")
    public void setTxtNewQuantity(String txtNewQuantity) {
        this.txtNewQuantity = txtNewQuantity;
    }

    public boolean isChkNewNoteSale() {
        return chkNewNoteSale;
    }

    public void setChkNewNoteSale(boolean chkNewNoteSale) {
        this.chkNewNoteSale = chkNewNoteSale;
    }

    @Action(value = "/newMobile", exceptionMappings = {
        @ExceptionMapping(exception = "java.lang.NumberFormatException", result = "input")
        ,
@ExceptionMapping(exception = "java.sql.SQLException", result = "input")})
    public String execute() throws Exception {
        String url = SUCCESS;
        registrationDAO dao = new registrationDAO();
        boolean result = dao.createNewMobile(txtNewMobileId, txtNewDescription, Float.parseFloat(txtNewPrice), txtNewMobileName,
                Integer.parseInt(txtNewYearOfProduction), Integer.parseInt(txtNewQuantity), chkNewNoteSale);
        if (result) {
            status = "create successful!!!!!";
        } else {
            status = "create fail!!!!!!";
        }
        return url;
    }

}
