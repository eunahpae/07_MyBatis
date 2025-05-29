package com.ohgiraffers.section01.xml;

import static com.ohgiraffers.common.Template.getSqlSession;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

/**
 * MenuService 클래스는 메뉴와 관련된 비즈니스 로직을 처리
 * 동적 SQL을 이용한 다양한 조건 검색 기능 포함
 */
public class MenuService {

  // 마이바티스 매퍼 인터페이스
  private DynamicSqlMapper mapper;

  /**
   * 사용자가 입력한 가격 이하의 메뉴를 검색하여 출력
   *
   * @param price 사용자 입력 가격 (최대 금액)
   */
  public void selectMenuByPrice(int price) {

    // SqlSession 생성
    SqlSession sqlSession = getSqlSession();
    mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    // 검색 조건을 map에 담아 전달
    Map<String, Integer> map = new HashMap<>();
    map.put("price", price);

    // 매퍼 메서드 호출
    List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

    // 검색 결과 출력
    if (menuList != null && !menuList.isEmpty()) {
      for (MenuDTO menu : menuList) {
        System.out.println(menu);
      }
    } else {
      System.out.println("검색 결과가 존재하지 않습니다.");
    }

    sqlSession.close();
  }

  /**
   * 이름 또는 카테고리로 메뉴를 검색하여 출력
   *
   * @param searchCriteria 검색 조건과 검색어가 담긴 객체
   */
  public void searchMenu(SearchCriteria searchCriteria) {

    SqlSession sqlSession = getSqlSession();
    mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    // 검색 수행
    List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

    // 결과 출력
    if (menuList != null && menuList.size() > 0) {
      for (MenuDTO menu : menuList) {
        System.out.println(menu);
      }
    } else {
      System.out.println("검색 결과가 존재하지 않습니다.");
    }

    sqlSession.close();
  }

  /**
   * 상위 카테고리(식사, 음료, 디저트)로 메뉴를 검색하여 출력
   * choose-when-otherwise 구문과 연계
   *
   * @param searchCriteria 검색 기준 (카테고리명)
   */
  public void searchMenuBySubCategory(SearchCriteria searchCriteria) {

    SqlSession sqlSession = getSqlSession();
    mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    // 검색 수행
    List<MenuDTO> menuList = mapper.searchMenuBySubCategory(searchCriteria);

    // 결과 출력
    // menuList.size() > 0 -> !menuList.isEmpty() 로 코드 보완
    if (menuList != null && !menuList.isEmpty()) {
      for (MenuDTO menu : menuList) {
        System.out.println(menu);
      }
    } else {
      System.out.println("검색 결과가 존재하지 않습니다.");
    }

    sqlSession.close();
  }

  /**
   * 전달받은 메뉴 코드 리스트를 기반으로 여러 메뉴를 한 번에 조회하는 메서드
   *
   * @param randomMenuCodeList - 조회할 메뉴 코드가 담긴 리스트
   */
  public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {

    SqlSession sqlSession = getSqlSession();
    mapper = sqlSession.getMapper(DynamicSqlMapper.class);

    // Mapper에 전달할 파라미터 맵 생성
    // 키 "randomMenuByMenuCode"는 XML 매퍼 내에서 사용되는 파라미터 이름과 일치해야 함
    Map<String, List<Integer>> criteria = new HashMap<>();
    criteria.put("randomMenuByMenuCode", randomMenuCodeList);

    // Mapper의 searchMenuByRandomMenuCode 메서드를 호출하여
    // 조건에 맞는 메뉴 목록을 DB 에서 조회
    List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);

    if (menuList != null && !menuList.isEmpty()) {
      for (MenuDTO menu : menuList) {
        System.out.println(menu);
      }
    } else {
      System.out.println("검색 결과가 존재하지 않습니다.");
    }

    sqlSession.close();
  }
}
