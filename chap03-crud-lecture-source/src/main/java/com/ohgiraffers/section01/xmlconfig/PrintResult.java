package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu);
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "메뉴 목록 조회를 실패하였습니다."; break;
            case "selectOne" : errorMessage = "메뉴 상세 조회를 실패하였습니다."; break;
        }

        System.out.println(errorMessage);
    }


}
