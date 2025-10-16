package carSell.DAO;

import java.util.ArrayList;
import java.util.List;

import carSell.DTO.UserDTO;


/**
 * DBMS의 USER_INFO 테이블에서 값을 JAVA로 가져오기 위한 파트. 
 */
public class UserDAO {
	private static UserDAO pstmt_uDAO;
	
	private UserDAO() {
		super();
	}//UserDAO
	
	public static UserDAO getInstance() {
		if (pstmt_uDAO == null) {// 객체가 생성되어 있지 않을 때만
			pstmt_uDAO = new UserDAO();// 새로 객체를 생성하라.
		} // end if
		return pstmt_uDAO;
	}// getInstance
	
	public int insertUser(UserDTO uDTO) {
		int rowCnt =0;
		
		return rowCnt;
	}//insertUser
	
	public  int updateUser(UserDTO uDTO) {
		int flag = 0;
		
		return flag;
	}//updateUser
	
	
	public List<UserDTO> selectAllUser() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		return list;
	}//selectAllUser
	
	public UserDTO selectOneUser(int user_code){
		UserDTO uDTO = null;
		
		return uDTO;
	}//selectOneUser
	
	public int deleteUser(int user_code) {
		int flag=0;
		
		return flag;
	}//deleteUser
	
}//class
