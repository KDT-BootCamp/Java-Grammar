package kdt_java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kdt.jdbc.board.domain.PostRequestDTO;
import com.kdt.jdbc.board.domain.PostResponseDTO;

public class DatabaseApp {

    public static final String URL = "jdbc:mysql://localhost:3306/test_db";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "scott";
    public static final String PASSWORD = "scott";
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        init();
       
        
    	// System.out.println(selectRow(2));
        /*
        System.out.println(">>> 사용자로부터 특정 게시물을 삭제하겠다는 요청이 들어왔다면 ? ");
        System.out.println(">>> 특정 게시물 삭제 ");
        int flag = removeRow(1);
        System.out.println((flag == 1) ? "게시글 삭제 완료" : "게시글 삭제 실패");
		*/
        
        System.out.println(">>> 사용자로부터 특정 게시물을 수정하겠다는 요청이 들어왔다면 ? ");
        System.out.println(">>> 특정 게시물 수정 ");
        PostRequestDTO udateDTO = new PostRequestDTO();
        udateDTO.setId(2); udateDTO.setTitle("목요비데스");
        udateDTO.setContent("태풍온다");
        int flag = updateRow(udateDTO);
        System.out.println((flag == 1) ? "게시글 수정 완료" : "게시글 수정 실패");    
    }

    
    
    public static Connection conn;
    
    public static int updateRow(PostRequestDTO udateDTO) {
    	int flag = 0;
    	PreparedStatement pstm = null;
    	PostRequestDTO post = udateDTO;
    	String sql = "update tb_post set title = ? ,content = ? , modified_date = current_date() where id = ?";
    	
    	try {
    		pstm = conn.prepareStatement(sql);
        	pstm.setString(1, post.getTitle());
        	pstm.setString(2, post.getContent());
        	pstm.setInt(3, post.getId());
    		flag = pstm.executeUpdate();
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(conn != null) {
    				conn.close();
    				} 
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}	
    	return flag;
    }
    
    public static int removeRow(int idx) {
    	int flag = 0;
    	PreparedStatement pstmt = null;
    	String deleteSQL = "delete from tb_post where id = ? ";
    	try {
    	pstmt = conn.prepareStatement(deleteSQL);
    	pstmt.setInt(1, idx);
    	flag = pstmt.executeUpdate();
    	} catch(Exception e){
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
    
    
    public static void insertRow() {
		PreparedStatement pstmt = null ; 
		String insertSQL = "insert into tb_post(title, content, writer, notice_yn, delete_yn) values(?,?,?,?,?)"; 
		int flag = 0 ;
		
		PostRequestDTO request = new PostRequestDTO("즐거운 수요미데스", "스크린치러가자", "섭섭해"); 
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, request.getTitle()); 
			pstmt.setString(2, request.getContent());
			pstmt.setString(3, request.getWriter()); 
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0); 
			flag = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace() ; 
		} finally {
			try {
				if( conn != null ) { conn.close(); } 
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("DML Result >>> " + flag);
		}
	}
    
    public static PostResponseDTO selectRow(int index) {
		PreparedStatement 		pstmt = null ;
		ResultSet 				rset  = null ;
		String selectSQL = "select id, title, content, writer from tb_post where id= ? " ; 
		PostResponseDTO response = null ; 
		try {
			pstmt = conn.prepareStatement(selectSQL); 
			pstmt.setInt(1, index);
			rset  = pstmt.executeQuery() ;
			if( rset.next() ) {
				response = new PostResponseDTO();
				response.setId(rset.getInt(1)); 
				response.setTitle(rset.getString(2));
				response.setContent(rset.getString(3));
				response.setWriter(rset.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( conn != null ) { conn.close(); } 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return response ; 
	}
    
    
    public static void init() {
        try {
            Class.forName(DRIVER);
            System.out.println("Driver loaded!");
            
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("DB SERVER CONNECTION ! " + conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
