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
