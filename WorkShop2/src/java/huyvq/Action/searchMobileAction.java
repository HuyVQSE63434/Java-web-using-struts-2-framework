/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.Action;

import huyvq.registrations.registrationDAO;
import huyvq.registrations.registrationDTOForMobile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class searchMobileAction {

    private String txtSearch;
    private List<registrationDTOForMobile> resultList;
    private final String SUCCESS = "success";

    public String getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(String txtSearch) {
        this.txtSearch = txtSearch;
    }

    public List<registrationDTOForMobile> getResultList() {
        return resultList;
    }

    public void setResultList(List<registrationDTOForMobile> resultList) {
        this.resultList = resultList;
    }

    public searchMobileAction() {
    }

    public String execute() throws Exception {
        String url = SUCCESS;
        if (txtSearch != null) {
            registrationDAO dao = new registrationDAO();
            resultList = new ArrayList<>();
            resultList = dao.searchMobile(txtSearch);
        }
        return url;
    }

}
