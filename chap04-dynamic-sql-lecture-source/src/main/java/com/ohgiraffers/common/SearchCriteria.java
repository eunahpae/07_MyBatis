package com.ohgiraffers.common;

/**
 * SearchCriteria 클래스는 검색 조건과 검색어를 저장하는 데이터 전달 객체(DTO)
 * 예: condition = "name", value = "붕어빵초밥"
 */
public class SearchCriteria {

  // 검색 조건
  private String condition;

  // 검색 값
  private String value;

  public SearchCriteria() {
  }

  public SearchCriteria(String condition, String value) {
    this.condition = condition;
    this.value = value;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "SearchCriteria{" +
        "condition='" + condition + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
