package carSell.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import carSell.DTO.UserDTO;



public class UserService {
	public UserService() {
	} // UserService


	public boolean addUser(UserDTO uDTO) {
		boolean flag = false;// 기본은 실패 상태


		return flag;
	}// addUser


	public List<UserDTO> searchAllUser() {
		List<UserDTO> list = null;


		return list;

	}// searchAllUser


	public UserDTO searchOneUser(int num) {
		UserDTO uDTO = null;
	

		return uDTO;
	}// searchOneUser


	public int modifyUser(UserDTO uDTO) {
		int flag = 0;


		return flag;
	}// modifyUser

	
	public int removeUser(int UserNum) {
		int flag = 0;

		return flag;
	}// removeUser
}
