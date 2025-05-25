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
      printResult.printSuccessMessage("selectList");
      printResult.printMenuList(menuList);
    } else {
      printResult.printErrorMessage("selectList");
    }
  }

  public void selectMenuByCode(Map<String, String> parameter) {

    int code = Integer.parseInt(parameter.get("code"));

    MenuDTO menu = menuService.selectMenuByCode(code);

    if (menu != null) {
      printResult.printSuccessMessage("selectOne");
      printResult.printMenu(menu);
    } else {
      printResult.printErrorMessage("selectOne");
    }

  }

  public void registMenu(Map<String, String> parameter) {

    String name = parameter.get("name");
    int price = Integer.parseInt(parameter.get("price"));
    int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

    MenuDTO menu = new MenuDTO();
    menu.setName(name);
    menu.setPrice(price);
    menu.setCategoryCode(categoryCode);

    if (menuService.registMenu(menu)) {
      printResult.printSuccessMessage("insert");
    } else {
      printResult.printErrorMessage("insert");
    }

  }

  public void modifyMenu(Map<String, String> parameter) {

    int code = Integer.parseInt(parameter.get("code"));
    String name = parameter.get("name");
    int price = Integer.parseInt(parameter.get("price"));
    int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

    MenuDTO menu = new MenuDTO();
    menu.setCode(code);
    menu.setName(name);
    menu.setPrice(price);
    menu.setCategoryCode(categoryCode);

    if (menuService.modifyMenu(menu)) {
      printResult.printSuccessMessage("update");
    } else {
      printResult.printErrorMessage("update");
    }

  }

  public void deleteMenu(Map<String, String> parameter) {

    int deleteCode = Integer.parseInt(parameter.get("deleteCode"));
    System.out.println(deleteCode);

    int result = menuService.deleteMenuByCode(deleteCode);
    System.out.println(result);

    if (result > 0) {
      printResult.printSuccessMessage("delete");
    } else {
      printResult.printErrorMessage("delete");
    }

  }
}
