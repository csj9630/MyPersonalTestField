package carSell.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	}// UserDAO

	public static UserDAO getInstance() {
		if (pstmt_uDAO == null) {// 객체가 생성되어 있지 않을 때만
			pstmt_uDAO = new UserDAO();// 새로 객체를 생성하라.
		} // end if
		return pstmt_uDAO;
	}// getInstance

	public int insertUser(UserDTO uDTO) throws SQLException, IOException {
		int rowCnt = 0;
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		GetConnection gc = GetConnection.getInstance();
//
//		try {
//			con = gc.getConn();
//
//			// ㅁ 쿼리문 객체 생성
//			String insertUser = "";
//
//		} finally {
//			gc.dbClose(con, pstmt, null);
//		} // end finally

		return rowCnt;
	}// insertUser

	public int updateUser(UserDTO uDTO) {
		int flag = 0;

		return flag;
	}// updateUser

	public List<UserDTO> selectAllUser() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		return list;
	}// selectAllUser

	public UserDTO selectOneUser(int user_code) throws SQLException, IOException {
		UserDTO uDTO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
			
			
			//ㅁ 쿼리문 세팅 및 생성 객체 얻기
			String selectOneUser = 
					" select user_code, id,pass,name,email,tel,address,generate_date,status_activate"
					+ " from user_info "
					+ " where user_code = ? ";
			pstmt = con.prepareStatement(selectOneUser);
			
			//ㅁ 바인드 변수 세팅
			pstmt.setInt(1, user_code);
			
			//ㅁ 쿼리문 수행 후 결과 받기
			rs = pstmt.executeQuery();
			
			
			//조회 결과가 존재한다면, DTO에 넣기
			if(rs.next()) {
				uDTO = new UserDTO();
				uDTO.setUser_code(user_code);
				
				uDTO.setId(rs.getString("id"));

				uDTO.setPass(rs.getString("pass"));
				uDTO.setName(rs.getString("name"));
				uDTO.setEmail(rs.getString("email"));
				uDTO.setTel(rs.getString("TEL"));
				uDTO.setAddress (rs.getString("address"));
				uDTO.setGenerate_date(rs.getDate("generate_date"));
			}//end if
			
			
			
		} finally {
			gc.dbClose(con, pstmt, rs);
		} // end finally

		return uDTO;
	}// selectOneUser

//	public int deleteUser(int user_code) {
//		int flag = 0;
//
//		return flag;
//	}// deleteUser

}// class
