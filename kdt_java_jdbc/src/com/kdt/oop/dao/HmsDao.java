package com.kdt.oop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kdt.oop.EmployeeVO;
import com.kdt.oop.PersonVO;
import com.kdt.oop.StudentVO;
import com.kdt.oop.TeacherVO;
import com.kdt.oop.util.HmsType;

public class HmsDao {
	
	  public static final String URL = "jdbc:mysql://localhost:3306/test_db";
	  public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	  public static final String USER = "scott";
	  public static final String PASSWORD = "scott";
	  
	  
	  public HmsDao() {
	        try {
	            Class.forName(DRIVER);
	            System.out.println("Driver loaded!");
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	  }
	  
	  public int insertRow(PersonVO person) {
		  int flag = 0;
		  PreparedStatement pstm = null;
		  Connection conn = null;
		  String str = "insert into tb_hms(type,name,age,address,comm) value(?, ?, ?, ?, ?)";
		  
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
			  pstm = conn.prepareStatement(str);
			  pstm.setString(2,person.getName());
			  pstm.setInt(3,person.getAge());
			  pstm.setString(4,person.getAddress());
			  switch(person.getType()) {
			  	case STU :
			  		pstm.setString(1,"STU");
					pstm.setString(5,((StudentVO)person).getStuId());
					break;
			  	case TEA :
			  		pstm.setString(1,"TEA");
					pstm.setString(5,((TeacherVO)person).getSubject());			  		
					break;
			  	case EMP :
			  		pstm.setString(1,"EMP");
					pstm.setString(5,((EmployeeVO)person).getDept());
					break;
			  	}
			  flag = pstm.executeUpdate();
			  
		  } catch(Exception e) {
			  e.printStackTrace();
		  } finally {
			  try {
				  if(conn != null) {
					  conn.close();
				  } 
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  return flag;
	  }
	  
	  public List<PersonVO> selectRow(){
		  ResultSet result = null;
		  PreparedStatement pstm = null;
		  Connection conn = null;
		  List<PersonVO> list = new ArrayList<>();
		  PersonVO per = null;
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
			  pstm = conn.prepareStatement("select * from tb_hms");
			  result = pstm.executeQuery();
			  while(result.next()) {
				  String type = result.getString(2);
				  String name = result.getString(3);
				  int age = result.getInt(4);
				  String address = result.getString(5);
				  String comm = result.getString(6);
				  
				  switch(type) {
					case "STU" :
						per = new StudentVO(HmsType.STU,name,age,address,comm);								 
				  		break;
					case "TEA" :
						per = new TeacherVO(HmsType.TEA,name,age,address,comm);							 
			  			break;
					case "EMP" :
						per = new EmployeeVO(HmsType.EMP,name,age,address,comm);						 
		  				break;
				  		}	
			  		list.add(per);
			  		}
		 		}catch(Exception e) {
		 			e.printStackTrace();
		 		} finally {
		 				try {
		 				  if(conn != null) {conn.close();}	
		 				} catch(Exception e) {	  
		 				}
		 			}
		  return list;
	  }

	  public PersonVO searchRow(String searchname) {
		  PreparedStatement pstm = null;
		  ResultSet result = null;
		  Connection conn = null;
		  String sql = "select * from tb_hms where name = ?";
		  PersonVO per = null;
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
			  pstm = conn.prepareStatement(sql);
			  pstm.setString(1,searchname);
			  result = pstm.executeQuery();
				if(result.next()) {  
			  	String type = result.getString(2);
				  String name = result.getString(3);
				  int age = result.getInt(4);
				  String address = result.getString(5);
				  String comm = result.getString(6);
				
				  switch(type) {
					case "STU" :
						per = new StudentVO(HmsType.STU,name,age,address,comm);								 
				  		break;
					case "TEA" :
						per = new TeacherVO(HmsType.TEA,name,age,address,comm);							 
			  			break;
					case "EMP" :
						per = new EmployeeVO(HmsType.EMP,name,age,address,comm);						 
		  				break;
				  		}	
					} 
		  } catch(Exception e) {
			  	e.printStackTrace();
		  } finally {
			  try {
				  if(conn != null) {conn.close();}
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  return per;
	  }
	  
	  public int removeRow(String removeName) {
		  int flag = 0;
		  PreparedStatement pstm = null;
		  Connection conn = null;
		  String sql = "delete from tb_hms where name = ?";
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
			  pstm = conn.prepareStatement(sql);
			  pstm.setString(1,removeName);
			  flag = pstm.executeUpdate();				
		  } catch(Exception e) {
			  	e.printStackTrace();
		  } finally {
			  try {
				  if(conn != null) {conn.close();}
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  return flag;
	  }
	  
	  public void updateRow(PersonVO per) {
		  PreparedStatement pstm = null;
		  Connection conn = null;
		  String sql = "update tb_hms set comm = ? where name = ?";
		  try {
			  conn = DriverManager.getConnection(URL,USER,PASSWORD);
			  pstm = conn.prepareStatement(sql);
			  switch(per.getType()) {
				case STU :
					pstm.setString(1,((StudentVO)per).getStuId());
					pstm.setString(2, per.getName());
			  		break;
				case TEA :
					pstm.setString(1,((TeacherVO)per).getSubject());
					pstm.setString(2, per.getName());
		  			break;
				case EMP :
					pstm.setString(1,((EmployeeVO)per).getDept());
					pstm.setString(2, per.getName());
					break;
			  		}	
			  pstm.executeUpdate();				
			  
		  } catch(Exception e) {
			  	e.printStackTrace();
		  } finally {
			  try {
				  if(conn != null) {conn.close();}
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
	  }
}
