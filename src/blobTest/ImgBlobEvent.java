package blobTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import kr.co.sist.util.img.ImageResize;

public class ImgBlobEvent implements ActionListener {
	private String selectedImg;
	private ImgBlobDesign wd;
	public ImgBlobEvent(ImgBlobDesign wd) {
		this.wd = wd;
	}//

	public void prviewImg() {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);

		File file = jfc.getSelectedFile();
		if (file != null) {
			// 선택한 파일 사이즈를 200x170으로 변경 후 이미지 아이콘에 설정함
			String fileName = file.getName();

			String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

//			이미지는 png,jpg,gif,bmp만 사용
			String allowedExt = "png,jpg,gif,bmp";

			String[] allowExtArr = allowedExt.split(",");

			boolean flag = false;

			for (String aExt : allowExtArr) {
				if (flag = ext.equals(aExt)) {
					break;
				} // end if
			} // end for

			if (!flag) {
				JOptionPane.showMessageDialog(wd, "이미지 확장자가 아닙니다.");
				return;
			} // end if

			// 이미지 크기 변경
			ImageResize.resizeImage(file.getAbsolutePath(), 640, 480);

			selectedImg = file.getParent() + "/" + "rs_" + file.getName();
//			System.out.println(selectedImg);

			wd.getJlbImage().setIcon(new ImageIcon(selectedImg));
			
		

		} // end if

	}// prviewImg

	public void insertImgToBlob(int product_code) throws IOException {
		
		//임시로 product_code에 1 추가.
		product_code = 1;
		String msg = "";
		ImgDTO idto = new ImgDTO();

		// -----이미지 선택됐는지 체크---------
		if ("".equals(selectedImg) || selectedImg ==null) {
			JOptionPane.showMessageDialog(wd, "이미지를 선택해주세요");
			return;
		} // end if

		File file = new File(selectedImg);
		FileInputStream fisImg = new FileInputStream(file);
		
		//----파일 확장자 확인.------
		/*
		 * String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
		 * String[] allowExtArr = "png,jpg,gif,bmp".split(","); boolean flag = false;
		 * 
		 * for (String aExt : allowExtArr) { if (flag = ext.equals(aExt)) { break; } //
		 * end if } // end for
		 * 
		 * if (!flag) { JOptionPane.showMessageDialog(wd, "이미지 확장자가 아닙니다."); return; }
		 * // end if
		 */		
		//ImgDTO에 값 세팅.
		idto.setProduct_code(product_code);
		idto.setFile(file);
		idto.setImg(fisImg);
		
		//이미지를 DB에 업로드
		ImgService is = new ImgService();
		
		if(is.addImgtoBlob(idto)) {
			msg = "이미지가 정상적으로 업로드됐습니다.";
			
			if (fisImg != null) {
				fisImg.close();
			} // end if
			idto.getFile().delete();
		}else {
			msg = "이미지가 업로드되지 못했습니다.";
		}//end else
		
		JOptionPane.showMessageDialog(wd, msg);
		// 입력칸 초기화
		ImageIcon ii = new ImageIcon("src/images/default.png");
		wd.getJlbImage().setIcon(ii);
	}// insertImgToBlob

	
	public void searchFriends(int product_code) {
		ImgService ls = new ImgService();

		try {
			int num = product_code;
			ImgDTO lDTO = ls.searchFriends(num);// 친구조회

			if (lDTO == null) {
				JOptionPane.showMessageDialog(wd, num + "으로 검색된 친구는 존재하지 않습니다.");
				return;
			} // end if
			
//			wd.getJtfName().setText(lDTO.getName());
//			wd.getJtfEmail().setText(lDTO.getEmail());
//			wd.getJtfPhone().setText(lDTO.getTel());
//			wd.getJtaInform().setText(lDTO.getIntro());
			
			//이미지 넣기
			//Properties로 외부 저장소를 가져온다.
			Properties prop = new Properties();
			try {
				prop.load(new FileInputStream("src/properties/database.properties"));
				
				ImageIcon ii = new ImageIcon(prop.getProperty("savePath")+lDTO.getProduct_code()+".png");
				wd.getJlbImage().setIcon(ii);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
			
			File dir = new File(prop.getProperty("savePath"));
			System.out.println("이미지를 가져왔습니다.");
			
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(wd, "친구 번호는 숫자만 입력해주세요");
		} // end catch
	}// searchFriends

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource() == wd.getJbtnImage()) {
			prviewImg();
		} // end if
		if (ae.getSource() == wd.getJbtnAdd()) {
			try {
				System.out.println(selectedImg);
				insertImgToBlob(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if
		
		if (ae.getSource() == wd.getJbtnSelect()) {
			searchFriends(1);
		}
	}
}// class
