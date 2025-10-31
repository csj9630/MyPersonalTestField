package blobTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import carSell.DAO.GetConnection;
import day1014_BlobTest.LobDTO;

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
		System.out.println("db단");
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
	/**
	 * BLOB 데이터를 읽어 들이기 위해서 스트림을 사용한다.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ImgDTO selectFriends(int num) throws IOException, SQLException {
		ImgDTO idto = null;

		// 1.2. 커넥션 얻기

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		InputStream is = null;
		FileOutputStream fos = null;

		GetConnection gc = GetConnection.getInstance();

		try {
			con = gc.getConn();
			// 3.
			StringBuilder selectFriend = new StringBuilder();

			// sql문에 띄어쓰기 꼭 넣기
			selectFriend.append("SELECT PRODUCT_CODE, IMAGE FROM IMAGE WHERE PRODUCT_CODE=? ");


			pstmt = con.prepareStatement(selectFriend.toString());

			// 4.
			pstmt.setInt(1, num);
			// 5.
			rs = pstmt.executeQuery();

			if (rs.next()) {
				idto = new ImgDTO();
				idto.setProduct_code(num); // 입력된 번호를 할당

				// DB Tables에서 조회된 결과를 설정.
		
				
//				idto.setExt(rs.getString("ext"));

				// 이미지는 별도의 스트림을 연결하여 받아들인다.
				// Properties로 외부 저장소를 가져온다.
				Properties prop = new Properties();
				prop.load(new FileInputStream("src\\properties\\database.properties"));

				File dir = new File(prop.getProperty("savePath"));

				// 디렉터리가 없다면 생성한다.
				if (!dir.exists()) {
					dir.mkdir();
				} // end if

				// 다운로드된 파일명은 "PK값+확장자" 형식.
				File file = new File(dir.getAbsolutePath() + File.separator + idto.getProduct_code() + "." + "png");

				// 출력스트림 설정
				fos = new FileOutputStream(file); // 파일이 존재하면 덮어쓰고, 존재하지 않으면 생성
				// ->회원 당 파일 하나로 관리 가능.

				// 입력스트림 얻기
				is = rs.getBinaryStream("image");
				int dataLength = 0;
				byte[] readData = new byte[512];

				while ((dataLength = is.read(readData)) != -1) { // 읽어들인 내용이 존재한
					// 읽어들인 내용의 길이까지를 출력스트림으로 출력
					fos.write(readData, 0, dataLength);
				} // end while
				fos.flush();

			} // end if
				// 6.
		} finally {
			if (is != null) {
				is.close();
			} // end if
			if (fos != null) {
				fos.close();
			} // end if
			gc.dbClose(con, pstmt, rs);
		} // end finally

		return idto;
	}// selectFriends
}// class
