/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huyvq.struts2;

import huyvq.registrations.registrationDAO;
import huyvq.registrations.registrationDTOForMobile;
import java.util.ArrayList;
import java.util.List;
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
    @Result(name = "success", location = "searchForStaff.jsp")
})
public class SearchMobileAction {

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

    public SearchMobileAction() {
    }
    @Action("/searchMobile")
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
