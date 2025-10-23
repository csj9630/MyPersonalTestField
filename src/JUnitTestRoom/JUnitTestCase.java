package JUnitTestRoom;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import carSell.DAO.GetConnection;
import carSell.DAO.UserDAO;
import carSell.DTO.UserDTO;
import carSell.Service.UserService;

class JUnitTestCase {

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Disabled
	@DisplayName("test_SelectOneMember")
	void test_SelectOneMember() {
		
		UserDAO dao = UserDAO.getInstance(); 
		UserDTO uDTO;
		try {
			uDTO = dao.selectOneUser(1);
			//1번 회원 조회 시 null이 아닌가?
			System.out.println(uDTO);
			assertNotNull(uDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//test
	
	@DisplayName("connection Test")
	@Test
	void connectionTest() {
		GetConnection gcon = GetConnection.getInstance();
		assertNotNull(gcon);
	}

}//class
