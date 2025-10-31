package carSell.DAO;

import carSell.DTO.AdminDTO;

public class AdminDAO {
	private static AdminDAO pstmt_uDAO;

	private AdminDAO() {
		super();
	}// AdminDAO

	public static AdminDAO getInstance() {
		if (pstmt_uDAO == null) {// 객체가 생성되어 있지 않을 때만
			pstmt_uDAO = new AdminDAO();// 새로 객체를 생성하라.
		} // end if
		return pstmt_uDAO;
	}// getInstance

	public AdminDTO selectOneAdmin(int admin_id) {
		AdminDTO uDTO = null;

		return uDTO;
	}// selectOneAdmin

//	public int insertAdmin(AdminDTO uDTO) {
//		int rowCnt =0;
//		
//		return rowCnt;
//	}//insertAdmin
//	
//	public  int updateAdmin(AdminDTO uDTO) {
//		int flag = 0;
//		
//		return flag;
//	}//updateAdmin

//	public List<AdminDTO> selectAllAdmin() {
//		List<AdminDTO> list = new ArrayList<AdminDTO>();
//		
//		return list;
//	}//selectAllAdmin

//	public int deleteAdmin(int admin_id) {
//		int flag=0;
//		
//		return flag;
//	}//deleteAdmin
	
}// class
