package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementTestService {

    private ElementTestMapper mapper;

    public void selectResultMapTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();
        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapConstructorTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructor();
        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();
        for(MenuAndCategoryDTO menu : menuList) {
            System.out.println(menu);
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> categoryList = mapper.selectResultMapCollectionTest();
        for(CategoryAndMenuDTO category : categoryList) {
            System.out.println(category);
        }

        sqlSession.close();
    }

    public void selectSqlTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();
        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }

        sqlSession.close();
    }
}
