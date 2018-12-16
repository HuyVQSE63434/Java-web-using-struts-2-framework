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
    @Result(name = "success", location = "searchForUser.jsp")
})
public class SearchInRangeAction {

    private String txtRangeBegin;
    private String txtRangeEnd;
    private List<registrationDTOForMobile> resultList;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getTxtRangeBegin() {
        return txtRangeBegin;
    }

    public void setTxtRangeBegin(String txtRangeBegin) {
        this.txtRangeBegin = txtRangeBegin;
    }

    public String getTxtRangeEnd() {
        return txtRangeEnd;
    }

    public void setTxtRangeEnd(String txtRangeEnd) {
        this.txtRangeEnd = txtRangeEnd;
    }

    public List<registrationDTOForMobile> getResultList() {
        return resultList;
    }

    public SearchInRangeAction() {
    }
    @Action("/searchInRange")
    public String execute() throws Exception {
        String url = SUCCESS;
        if (txtRangeBegin != null && txtRangeEnd != null) {
            resultList = new ArrayList<>();
            registrationDAO dao = new registrationDAO();
            resultList = dao.searchInRange(txtRangeBegin, txtRangeEnd);
        }
        return url;
    }
}
