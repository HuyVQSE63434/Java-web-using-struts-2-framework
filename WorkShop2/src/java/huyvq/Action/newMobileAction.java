/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import com.opensymphony.xwork2.ActionSupport;
import huyvq.registrations.registrationDAO;
/**
 *
 * @author Admin
 */
public class newMobileAction extends ActionSupport{

    private String txtNewMobileId;
    private String txtNewDescription;
    private String txtNewPrice;
    private String txtNewMobileName;
    private String txtNewYearOfProduction;
    private String txtNewQuantity;
    private boolean chkNewNoteSale;
    private String status;
    private final String SUCCESS="success";
    public newMobileAction() {
    }

    public String getTxtNewMobileId() {
        return txtNewMobileId;
    }

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

    public void setTxtNewPrice(String txtNewPrice) {
        this.txtNewPrice = txtNewPrice;
    }

    public String getTxtNewMobileName() {
        return txtNewMobileName;
    }

    public void setTxtNewMobileName(String txtNewMobileName) {
        this.txtNewMobileName = txtNewMobileName;
    }

    public String getTxtNewYearOfProduction() {
        return txtNewYearOfProduction;
    }

    public String getStatus() {
        return status;
    }
    
    public void setTxtNewYearOfProduction(String txtNewYearOfProduction) {
        this.txtNewYearOfProduction = txtNewYearOfProduction;
    }

    public String getTxtNewQuantity() {
        return txtNewQuantity;
    }

    public void setTxtNewQuantity(String txtNewQuantity) {
        this.txtNewQuantity = txtNewQuantity;
    }

    public boolean isChkNewNoteSale() {
        return chkNewNoteSale;
    }

    public void setChkNewNoteSale(boolean chkNewNoteSale) {
        this.chkNewNoteSale = chkNewNoteSale;
    }
    
    public String execute() throws Exception {
        String url= SUCCESS;
        registrationDAO dao= new registrationDAO();
        boolean result= dao.createNewMobile(txtNewMobileId, txtNewDescription, Float.parseFloat(txtNewPrice), txtNewMobileName,
                Integer.parseInt(txtNewYearOfProduction), Integer.parseInt(txtNewQuantity), chkNewNoteSale);
        if(result){
            status="create successful!!!!!";
        }else{
            status="create fail!!!!!!";
        }
        return url;
    }

}
