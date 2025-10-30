package blobTest;

import java.io.IOException;
import java.sql.SQLException;

public class ImgService {
	public boolean addImgtoBlob(ImgDTO idto) {
		boolean flag = false;

		ImgDAO lDAO = ImgDAO.getInstance();
		try {
			lDAO.insertImg(idto);
			flag = true;
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		return flag;
	}//addImgtoBlob
}//class
