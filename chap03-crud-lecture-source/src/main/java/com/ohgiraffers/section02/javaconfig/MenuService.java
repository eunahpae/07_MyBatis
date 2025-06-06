package com.ohgiraffers.section02.javaconfig;

import static com.ohgiraffers.section02.javaconfig.Template.getSqlSession;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class MenuService {

  private MenuMapper menuMapper;

  public List<MenuDTO> selectAllMenu() {
    SqlSession sqlSession = getSqlSession();
    menuMapper = sqlSession.getMapper(MenuMapper.class);
    List<MenuDTO> menuList = menuMapper.selectAllMenu();
    sqlSession.close();
    return menuList;
  }

  public MenuDTO selectMenuByCode(int code) {
    SqlSession sqlSession = getSqlSession();
    menuMapper = sqlSession.getMapper(MenuMapper.class);
    MenuDTO menu = menuMapper.selectMenuByCode(code);
    sqlSession.close();
    return menu;
  }

  public boolean registMenu(MenuDTO menu) {
    SqlSession sqlSession = getSqlSession();
    menuMapper = sqlSession.getMapper(MenuMapper.class);
    int result = menuMapper.insertMenu(menu);
    if (result > 0) {
      sqlSession.commit();
    } else {
      sqlSession.rollback();
    }
    sqlSession.close();
    return result > 0 ? true : false;
  }

  public boolean modifyMenu(MenuDTO menu) {
    SqlSession sqlSession = getSqlSession();
    menuMapper = sqlSession.getMapper(MenuMapper.class);
    int result = menuMapper.updateMenu(menu);
    if (result > 0) {
      sqlSession.commit();
    } else {
      sqlSession.rollback();
    }
    sqlSession.close();
    return result > 0 ? true : false;
  }

  public boolean deleteMenuByCode(int deleteCode) {
    SqlSession sqlSession = getSqlSession();
    menuMapper = sqlSession.getMapper(MenuMapper.class);
    int result = menuMapper.deleteMenu(deleteCode);
    if (result > 0) {
      sqlSession.commit();
    } else {
      sqlSession.rollback();
    }
    sqlSession.close();
    return result > 0 ? true : false;
  }
}
