package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

  private final MenuDAO menuDAO;

  public MenuService() {
    menuDAO = new MenuDAO();
  }

  public List<MenuDTO> selectAllMenu() {

    SqlSession sqlSession = getSqlSession();

    List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

    sqlSession.close();

    return menuList;
  }

  public MenuDTO selectMenuByCode(int code) {

    SqlSession sqlSession = getSqlSession();

    MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);

    sqlSession.close();

    return menu;
  }
}
