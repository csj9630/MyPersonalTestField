package blobTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carSell.DAO.GetConnection;

public class ImgDAO {

	private static ImgDAO idao;

	private ImgDAO() {
		super();
	}// LobDAO
		// 싱글톤 패턴으로 DAO 클래스 구성

	public static ImgDAO getInstance() {
		if (idao == null) {
			idao = new ImgDAO();
		} // end if
		return idao;
	}// getInstance

	public void insertImg(ImgDTO idto) throws SQLException, IOException {

		Connection con = null;

		PreparedStatement pstmt = null;

		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
			con.setAutoCommit(false);

			String insertSQL = " insert into image(product_code, image) values (?,?) ";
			pstmt = con.prepareStatement(insertSQL);

			pstmt.setInt(1, idto.getProduct_code());
			pstmt.setBinaryStream(2, idto.getImg(), idto.getFile().length());

			int cnt = pstmt.executeUpdate();

			if (cnt == 1) {
				con.commit();
			} else {
				con.rollback();
			}

			con.commit();
		} finally {
			gc.dbClose(con, pstmt, null);
		} // end finally
	}// insertImg

}// class
