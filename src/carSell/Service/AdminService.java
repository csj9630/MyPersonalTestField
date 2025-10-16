package carSell.Service;

import java.util.List;

import carSell.DTO.AdminDTO;

public class AdminService {
	public AdminService() {
	} // AdminService

	public boolean addAdmin(AdminDTO uDTO) {
		boolean flag = false;// 기본은 실패 상태

		return flag;
	}// addAdmin

	public List<AdminDTO> searchAllAdmin() {
		List<AdminDTO> list = null;

		return list;

	}// searchAllAdmin

	public AdminDTO searchOneAdmin(int num) {
		AdminDTO uDTO = null;

		return uDTO;
	}// searchOneAdmin

	public int modifyAdmin(AdminDTO uDTO) {
		int flag = 0;

		return flag;
	}// modifyAdmin

	public int removeAdmin(int AdminNum) {
		int flag = 0;

		return flag;
	}// removeAdmin
}
