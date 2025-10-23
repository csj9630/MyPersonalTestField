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

	public int updateUser(UserDTO uDTO) throws SQLException, IOException{
		int flag = 0;
		
		GetConnection gc = GetConnection.getInstance();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1.드라이버 로딩+2.커넥션 얻기
			con = gc.getConn();
			// 3. 쿼리문 생성 객체 얻기

			// 이걸 StringBuilder로 하기
			StringBuilder updateUser = new StringBuilder();

			//@formatter:off
					
			//회원번호를 사용하여 나이, 전화번호 변경
			updateUser
				.append("		update	user_info ")
				.append("		set 	name=?, email=?, tel=?, address=? ")
				.append("		where	user_code=? ");
			//@formatter:on

			pstmt = con.prepareStatement(updateUser.toString());

			// 4. 바인드변수에 값 설정
			pstmt.setString(1, uDTO.getName());
			pstmt.setString(2, uDTO.getEmail());
			pstmt.setString(3, uDTO.getTel());
			pstmt.setString(4, uDTO.getAddress());
			pstmt.setInt(5, uDTO.getUser_code());

			System.out.println(uDTO);
			// 5. 쿼리문 수행 후 결과 얻기
			flag = pstmt.executeUpdate();// 변경한 행의 수가 리턴

		} finally {
			// 5. 연결 끊기
			gc.dbClose(con, pstmt, null);
		} // end finally
		
		return flag;
	}// updateUser

	public List<UserDTO> selectAllUser() {
		List<UserDTO> list = new ArrayList<UserDTO>();

		return list;
	}// selectAllUser


//	public int deleteUser(int user_code) {
//		int flag = 0;
//
//		return flag;
//	}// deleteUser

}// class
