package blobTest;

import java.io.IOException;
import java.sql.SQLException;

import day1014_BlobTest.LobDAO;
import day1014_BlobTest.LobDTO;

public class ImgService {
	public boolean addImgtoBlob(ImgDTO idto) {
		boolean flag = false;

		ImgDAO idao = ImgDAO.getInstance();
		try {
			System.out.println("전");
			idao.insertImg(idto);
			System.out.println("후");
			flag = true;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		return flag;
	}//addImgtoBlob
	
	public ImgDTO searchFriends(int num) {
		ImgDTO idto = null;

		try {
			ImgDAO idao = ImgDAO.getInstance();
			idto = idao.selectFriends(num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idto;
	}//searchFriends
}//class
