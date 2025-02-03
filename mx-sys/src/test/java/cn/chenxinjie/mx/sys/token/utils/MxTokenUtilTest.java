package cn.chenxinjie.mx.sys.token.utils;


import cn.chenxinjie.mx.sys.token.dto.MxTokenDTO;

import java.util.ArrayList;
import java.util.List;
public class MxTokenUtilTest {

    public static void getToken() {
        MxTokenDTO mxTokenDTO = new MxTokenDTO();
        mxTokenDTO.setUserNo("001");
        mxTokenDTO.setUserName("admin");
        List<String> roleNos = new ArrayList<>();
        roleNos.add("admin");
        roleNos.add("user");
        mxTokenDTO.setRoleNos(roleNos);
        String token = MxTokenUtil.getToken(mxTokenDTO);
        System.out.println(token);
    }
    public static void main(String[] args) {
        getToken();
    }
}