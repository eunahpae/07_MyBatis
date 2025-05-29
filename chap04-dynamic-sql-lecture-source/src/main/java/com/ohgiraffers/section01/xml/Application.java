package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.SearchCriteria;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 동적 SQL 조건문 예제 실행을 위한 애플리케이션.
 * 클래스 사용자로부터 메뉴 입력을 받아 적절한 서비스 메서드를 호출
 */
public class Application {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // 메인 메뉴 루프
    do {
      System.out.println("========= 마이바티스 동적 SQL (조건문) ============");
      System.out.println("1. if 확인하기");
      System.out.println("2. choose(when, otherwise) 확인하기");
      System.out.println("3. foreach 확인하기");
      System.out.println("4. trim(where, set) 확인하기");
      System.out.println("9. 종료하기");
      System.out.println("메뉴를 선택하세요 : ");
      int no = sc.nextInt();

      switch (no) {
        case 1:
          ifSubMenu();
          break;
        case 2:
          chooseSubMenu();
          break;
        case 3:
          foreachSubMenu();
          break;
        case 4:
        case 9:
          System.out.println("프로그램을 종료합니다.");
          return;
      }

    } while (true);
  }

  /**
   * if 구문 관련 기능을 선택할 수 있는 서브 메뉴
   */
  private static void ifSubMenu() {
    Scanner sc = new Scanner(System.in);
    MenuService menuService = new MenuService();

    do {
      System.out.println("======== if 서브메뉴 =========");
      System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
      System.out.println("2. 메뉴이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
      System.out.println("9. 이젠 메뉴로");
      System.out.println("메뉴 번호를 입력하세요 : ");
      int no = sc.nextInt();

      switch (no) {
        case 1:
          menuService.selectMenuByPrice(inputPrice());
          break;
        case 2:
          menuService.searchMenu(inputSearchCriteria());
          break;
        case 9:
          return;
      }
    } while (true);
  }

  /**
   * 사용자로부터 최대 가격을 입력받아 반환
   *
   * @return 최대 금액 (int)
   */
  private static int inputPrice() {
    Scanner sc = new Scanner(System.in);
    System.out.println("검색하실 가격의 최대 금액을 입력해주세요 : ");
    int price = sc.nextInt();
    return price;
  }

  /**
   * 사용자로부터 검색 조건과 값을 입력받아 SearchCriteria 객체 생성
   *
   * @return SearchCriteria (검색 기준 객체)
   */
  private static SearchCriteria inputSearchCriteria() {
    Scanner sc = new Scanner(System.in);
    System.out.println("검색 기준을 입력해주세요(name or category) : ");
    String condition = sc.nextLine();
    System.out.println("검색어를 입력해주세요 : ");
    String value = sc.nextLine();
    return new SearchCriteria(condition, value);
  }

  /**
   * choose 구문 관련 기능을 선택할 수 있는 서브 메뉴
   */
  private static void chooseSubMenu() {
    Scanner sc = new Scanner(System.in);
    MenuService menuService = new MenuService();

    do {
      System.out.println("=========== choose 서브 메뉴 ==========");
      System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
      System.out.println("9. 이전 메뉴로");
      System.out.println("메뉴 번호를 입력하세요 : ");
      int no = sc.nextInt();

      switch (no) {
        case 1:
          menuService.searchMenuBySubCategory(inputSubCategory());
          break;
        case 9:
          return;
      }
    } while (true);
  }

  /**
   * foreach 반복문 관련 기능을 실행할 수 있는 서브 메뉴
   * - 랜덤한 메뉴 코드 5개를 생성하여 해당 메뉴 목록을 조회
   */
  private static void foreachSubMenu() {
    Scanner sc = new Scanner(System.in);
    MenuService menuService = new MenuService();

    do {
      System.out.println("=========== foreach 서브 메뉴 ==========");
      System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
      System.out.println("9. 이전 메뉴로 돌아가기");
      System.out.print("메뉴 번호를 입력하세요 : ");
      int no = sc.nextInt();

      switch (no) {
        case 1:
          menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList());
          break;
        case 9:
          return;
      }
    } while (true);
  }

  /**
   * 데이터베이스에 존재하는 메뉴 코드 범위(1~21)를 기준으로
   * 중복되지 않는 5개의 랜덤 메뉴 코드를 생성하고, 이를 정렬된 리스트로 반환
   *
   * @return 정렬된 5개의 랜덤 메뉴 코드 리스트
   */
  private static List<Integer> createRandomMenuCodeList() {
    Set<Integer> set = new HashSet<>();

    // 1부터 21까지의 범위에서 중복 없이 5개의 랜덤한 숫자 생성
    // HashSet 은 중복을 자동으로 제거하므로, 중복 걱정 없이 숫자 추가 가능
    while (set.size() < 5) {
      int temp = (int) (Math.random() * 21) + 1;  // 1~21 사이의 난수 생성
      set.add(temp);
    }

    // HashSet 은 요소의 순서를 유지하지 않기 때문에,
    // 출력 또는 정렬이 필요한 경우 리스트로 변환
    List<Integer> list = new ArrayList<>(set);

    // 결과를 정렬하여 일관된 순서로 메뉴 코드 출력 (사용자 경험 향상)
    Collections.sort(list);

    return list;
  }

  /**
   * 사용자로부터 상위 카테고리 값을 입력받아 SearchCriteria 객체 생성
   *
   * @return SearchCriteria ("category", 입력값)
   */
  private static SearchCriteria inputSubCategory() {
    Scanner sc = new Scanner(System.in);
    System.out.println("상위 분류를 입력해주세요(식사, 음료, 디저트) : ");
    String value = sc.nextLine();
    return new SearchCriteria("category", value);
  }
}
