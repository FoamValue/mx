package cn.chenxinjie.mx.sys.token.dto;

import java.io.Serializable;
import java.util.List;

public class MxTokenDTO implements Serializable {

    private String userNo;
    private String userName;
    private List<String> roleNos;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleNos() {
        return roleNos;
    }

    public void setRoleNos(List<String> roleNos) {
        this.roleNos = roleNos;
    }
}
