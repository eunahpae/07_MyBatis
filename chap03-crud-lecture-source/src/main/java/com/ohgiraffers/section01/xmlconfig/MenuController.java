package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

public class MenuController {

  private final PrintResult printResult;

  private final MenuService menuService;

  public MenuController() {
    printResult = new PrintResult();
    menuService = new MenuService();
  }

  public void selectAllMenu() {

    List<MenuDTO> menuList = menuService.selectAllMenu();

    if (menuList != null) {
      printResult.printMenuList(menuList);
    } else {
      printResult.printErrorMessage("selectList");
    }
  }

  public void selectMenuByCode(Map<String, String> parameter) {

    int code = Integer.parseInt(parameter.get("code"));

    MenuDTO menu = menuService.selectMenuByCode(code);

    if (menu != null) {
      printResult.printMenu(menu);
    } else {
      printResult.printErrorMessage("selectOne");
    }

  }
}
