package com.ohgiraffers.section02.javaconfig;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MenuMapper {

  @Results(id = "menuResultMap", value = {
      @Result(id = true, property = "code", column = "MENU_CODE"),
      @Result(property = "name", column = "MENU_NAME"),
      @Result(property = "price", column = "MENU_PRICE"),
      @Result(property = "categoryCode", column = "CATEGORY_CODE"),
      @Result(property = "orderableStatus", column = "ORDERABLE_STATUS")
  })

  /*
    1. 개행 없이 한 줄로
    @Select("SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS FROM TBL_MENU WHERE ORDERABLE_STATUS = 'Y' ORDER BY MENU_CODE")
  */
  /*
    2. 문자열 연결 방식
    @Select("SELECT * " +
        "FROM TBL_MENU " +
        "WHERE ORDERABLE_STATUS = 'Y'")
  */
  /*
    3. 문자열 연결 방식 + 개행 처리
    - SQL이 길어질 경우, 가독성을 유지하기 위해 줄을 나눠 작성
    - 특히 실무에서는 쿼리가 복잡해질수록 WHERE, JOIN, GROUP BY, ORDER BY 등이 많아지므로 줄바꿈을 적극 활용
    - 문자열을 +로 연결할 때 개행 문자 \n은 선택사항 : SQL 실행 결과에는 영향 없고, 오직 가독성과 로그 포맷에만 영향이 있음
  */
  @Select("SELECT MENU_CODE\n" +
      "     , MENU_NAME\n" +
      "     , MENU_PRICE\n" +
      "     , CATEGORY_CODE\n" +
      "     , ORDERABLE_STATUS\n" +
      "  FROM TBL_MENU\n" +
      " WHERE ORDERABLE_STATUS = 'Y'\n" +
      " ORDER BY MENU_CODE")
  List<MenuDTO> selectAllMenu();

  @Select("SELECT MENU_CODE\n" +
      "     , MENU_NAME\n" +
      "     , MENU_PRICE\n" +
      "     , CATEGORY_CODE\n" +
      "     , ORDERABLE_STATUS\n" +
      "  FROM TBL_MENU\n" +
      " WHERE ORDERABLE_STATUS = 'Y'\n" +
      "   AND MENU_CODE = #{ code }")
  @ResultMap("menuResultMap")
  MenuDTO selectMenuByCode(int code);

  @Insert("INSERT INTO TBL_MENU (\n" +
      "                       MENU_NAME\n" +
      "                       , MENU_PRICE\n" +
      "                       , CATEGORY_CODE\n" +
      "                       , ORDERABLE_STATUS\n" +
      "                     )\n" +
      "VALUES (\n" +
      "         #{ name }\n" +
      "           , #{ price }\n" +
      "       , #{ categoryCode }\n" +
      "       , 'Y'\n" +
      "       )")
  int insertMenu(MenuDTO menu);

  @Update("UPDATE TBL_MENU\n" +
      "   SET MENU_NAME = #{ name }\n" +
      "     , MENU_PRICE = #{ price }\n" +
      "     , CATEGORY_CODE = #{ categoryCode }\n" +
      " WHERE MENU_CODE = #{ code }")
  int updateMenu(MenuDTO menu);

  @Delete("DELETE\n" +
      "  FROM TBL_MENU\n" +
      " WHERE MENU_CODE = #{ code }")
  int deleteMenu(int deleteCode);
}
