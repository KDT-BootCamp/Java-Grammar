package com.kdt.oop.logic;

import java.util.List;

import com.kdt.oop.EmployeeVO;
import com.kdt.oop.PersonVO;
import com.kdt.oop.StudentVO;
import com.kdt.oop.TeacherVO;
import com.kdt.oop.dao.HmsDao;
import com.kdt.oop.util.HmsType;

public class HmsBackService {

	private HmsDao dao;
	
	public HmsBackService() {
		dao = new HmsDao();
	}
	// 
	public String createRequest(HmsType type,String name,int age,String address,String common) {
		String msg = null;
		PersonVO per = null;
		switch(type) {
		case STU :
			per = new StudentVO(type,name,age,address,common);
			msg = "학생객체 생성완료";
			break;
		case TEA :
			per = new TeacherVO(type,name,age,address,common);
			msg = "강사객체 생성완료";
			break;
		case EMP :
			per = new EmployeeVO(type,name,age,address,common);
			msg = "직원객체 생성완료";
			break;
			}
		int flag = dao.insertRow(per);
		return (flag != 0) ? msg : "객체 생성 실패";
		}

//	private void setAry(PersonVO per) {
	//	lst.add(per);
	//}
	
	public List<PersonVO> list() {
		return dao.selectRow();
	}

	public PersonVO searchProcess(String searchName) {
		
		return dao.searchRow(searchName);
	}
	
	public boolean removeProcess(String removeName) {
		return (dao.removeRow(removeName) == 1) ? true : false;
	}
	
	public void updateProcess(PersonVO per) {
		dao.updateRow(per);
	}
	
	/*
	public boolean reviseProcess(String name) {
		
		return false;
	}

	public boolean saveToFile() {
		boolean flag = false;
		try {
		
			bw = new BufferedWriter(new FileWriter(new File("./person.txt")));
			
			for(PersonVO p : lst) {
				if(p != null) {
					bw.write(p.info() + "\n");
					bw.flush();
					}
				}
				System.out.println("파일에 저장 완료");
				flag = true;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(bw != null) {
						bw.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		return flag;
	}

	public boolean loadToFile() {
		boolean flag = false;
		try {
			br = new BufferedReader(new FileReader(new File("./person.txt")));
			for(int i = 0; i < lst.size();i++) {
				String str = br.readLine();
				if(str != null) {
					String token [] = str.split("-");
					if (token.length == 5) {
                        switch (token[0]) {
                            case "stu":
                                StudentVO stu = new StudentVO(token[1], Integer.parseInt(token[2]), token[3],token[4]);
                                System.out.println("Student: " + stu.info());
                                setAry(stu);
                                break;
                            case "emp":
                                EmployeeVO emp = new EmployeeVO(token[1], Integer.parseInt(token[2]), token[3],token[4]);
                                System.out.println("Employee: " + emp.info());
                                setAry(emp);
                                break;
                            case "tea":
                                TeacherVO tea = new TeacherVO(token[1], Integer.parseInt(token[2]), token[3],token[4]);
                                System.out.println("Teacher: " + tea.info());
                                setAry(tea);
                                break;
                        }
                    } else {
                        System.out.println("텍스트 형식에 오류가 있습니다.");
                    }
				}
				else {
					flag = true;
					break;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
				}
			}
		return flag;
	}

	public boolean saveToSerial() {
		boolean flag = false;
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./person.txt"));
			oos.writeObject(lst);
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) { oos.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean loadToSerial() {
		boolean flag = false;
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("./serial.txt"));
			 ary = (PersonVO [])ois.readObject();
			 for(int i = 0; i < ary.length; i++) {
				 if(ary[i] != null) {
					 continue;
				 }
				 idx = i;
				 break;
			 }
			 flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) { ois.close(); }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	*/
}


