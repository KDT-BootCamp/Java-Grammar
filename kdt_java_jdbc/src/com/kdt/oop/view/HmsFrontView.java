package com.kdt.oop.view;

import java.util.List;
import java.util.Scanner;

import com.kdt.exp.RecordNotFoundException;
import com.kdt.oop.EmployeeVO;
import com.kdt.oop.PersonVO;
import com.kdt.oop.StudentVO;
import com.kdt.oop.TeacherVO;
import com.kdt.oop.crtl.InsertController;
import com.kdt.oop.crtl.ListController;
import com.kdt.oop.crtl.RemoveController;
import com.kdt.oop.crtl.SearchController;
import com.kdt.oop.crtl.UpdateController;
import com.kdt.oop.util.HmsType;

public class HmsFrontView {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private ListController listCrtl;
	private SearchController searchCrtl;
	private RemoveController removeCrtl;
	private UpdateController updateCrtl;
	private InsertController insertCrtl;
	
	public HmsFrontView() {
		listCrtl = new ListController();
		searchCrtl = new SearchController();
		updateCrtl = new UpdateController();
		insertCrtl = new InsertController();
		removeCrtl = new RemoveController();
	}

	public void mainMenu() {
		System.out.println("파일로부터 데이터를 가져옵니다.");
		System.out.println("-----------------------------------");		
		 /*if(backend.loadToFile()) {
			System.out.println("-----------------------------------");
		} else {
			System.out.println("불러오기 완료");
		}
		*/
		
		while(true) {
		try {
		System.out.println(">>> Hms Ver 1.0 <<<");
		System.out.println("1. 전체출력");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이름으로 찾아서 삭제");
		System.out.println("4. 이름으로 찾아서 수정");
		System.out.println("5. 사용자 추가");
		System.out.println("99 시스템 종료");
		System.out.print("Input Number : ");
		
		int number = scanner.nextInt();
		switch(number) {
			case 1 :
				listView();
				System.out.println();
				break;
			case 2 :
				search();
				System.out.println();
				break;
			case 3 :
				remove();
				System.out.println();
				break;
			case 4 :
				update();
				System.out.println();
				break;
			case 5 :
				subMenu();
				break;
			case 99 :
				System.out.println(">>>프로그램을 종료합니다<<<");
				System.exit(0);
			default :
				System.out.println("입력이 잘못되었습니다.");

					}
				} 
					catch(RecordNotFoundException e) {
						e.printStackTrace();
					}
					catch(Exception e) {
					e.printStackTrace();
					System.out.println("알림))");	
					System.out.println("메뉴 구성의 숫자만 입력해주세요");
					System.out.println("\n");
				}
		} // while 
	} // mainMenu
	
	public void search() throws RecordNotFoundException{
		System.out.println(">>검색기능<<");
		System.out.print("이름을 입력하세요 : ");
		PersonVO pers = null;
		scanner.nextLine();
		String str = scanner.next();
		pers = searchCrtl.execute(str);
		if(pers != null) {
		System.out.println(pers.perInfo());
		}
		else {
			throw new RecordNotFoundException("데이터가 존재하지 않습니다.");
		}
	}
	
	public void listView() {
		System.out.println();
		System.out.println(">>> 전체 데이터를 보여줍니다. <<<");		
		
		List<PersonVO> ary = listCrtl.execute();
		ary.stream().forEach(obj -> System.out.println(obj.perInfo()));
		
	} // listView
	

	public void subMenu() {
		
		while(true) {
		try {
		System.out.println(">>> 사용자 추가를 위해 메뉴를 선택해주세요 <<<");
		System.out.println("1. student");
		System.out.println("2. teacher");
		System.out.println("3. employee");
		System.out.println("99. up-to");
		System.out.print("Input Number : ");
		
		int number = scanner.nextInt();
		switch(number) {
			case 1 :
			case 2 :
			case 3 :
				makeView(number);
				break;
			case 99 :
				System.out.println("사용자 추가를 종료합니다.");
				return;
			default :
				System.out.println("입력이 잘못되었습니다.");
					}
			} catch(Exception e) {
				System.out.println("알림))");	
				System.out.println("메뉴 구성의 숫자만 입력해주세요");
				scanner.nextLine();
			}
		} // try - catch 문
	} //subMenu
		public void makeView(int number) {
			System.out.println();
			System.out.println(">>> 객체 생성 <<<");
		
			scanner.nextLine(); // 개행 문자 제거용
			System.out.print("이름	: ");
			String name = scanner.nextLine();
			System.out.print("나이	: ");
			int age = scanner.nextInt();
			scanner.nextLine(); // 개행 문자 제거용
			System.out.print("주소	: ");
			String address = scanner.nextLine();
			/*
			String commonMsg = (number == 1) ?
						"학번	: " : (number == 2) ?
								"과목	: " : "부서	: " ;
			// 삼항연산자가 속도 제일 빠름
			System.out.print(commonMsg);
			*/
			String common = null;
			String msg = null;
			switch(number) {
			case 1 :
				System.out.print("학번	: ");
				common = scanner.nextLine();
				msg  = insertCrtl.execute(HmsType.STU,name,age,address,common) ;
				break;
			case 2 :
				System.out.print("과목	: ");
				common = scanner.nextLine();
				msg  = insertCrtl.execute(HmsType.TEA,name,age,address,common) ;	
				break;
			case 3 :
				System.out.print("부서	: ");
				common = scanner.nextLine();
				msg  = insertCrtl.execute(HmsType.EMP,name,age,address,common) ;
				break;
		}
		System.out.println(msg);
	} //makeView

	public void remove() {
		scanner.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String name = scanner.nextLine();
		
		 String str = removeCrtl.execute(name) ? "삭제완료" : "데이터가 존재하지 않습니다." ;
		
		  System.out.println(str);
	
	}

	public void update() {
		scanner.nextLine();
		String name = null;
		System.out.print("수정하고자 하는 이름을 입력하시오 : ");
		name = scanner.nextLine();
		PersonVO per = updateCrtl.execute(name);
		if(per != null) {
		if(per instanceof StudentVO) {
				System.out.print("새 학번 : ");
				String newmsg = scanner.nextLine();
				StudentVO stu = new StudentVO();
				stu.setType(HmsType.STU);
				stu.setName(name);
				stu.setStuId(newmsg);
				updateCrtl.execute(stu);
			} else if(per instanceof TeacherVO) {
				System.out.print("새 과목 : ");
				String newmsg = scanner.nextLine();
				TeacherVO tea = new TeacherVO();
				tea.setType(HmsType.STU);
				tea.setName(name);
				tea.setSubject(newmsg);
				updateCrtl.execute(tea);
			} else if(per instanceof EmployeeVO) {
				System.out.print("새 부서 : ");
				String newmsg = scanner.nextLine();
				EmployeeVO emp = new EmployeeVO();
				emp.setType(HmsType.STU);
				emp.setName(name);
				emp.setDept(newmsg);
				updateCrtl.execute(emp);

			}			
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정하고자 하는 데이터가 존재하지 않습니다.");
		}
	}
}

