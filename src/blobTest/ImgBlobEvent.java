package blobTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import kr.co.sist.util.img.ImageResize;

public class ImgBlobEvent implements ActionListener {
	private String selectedImg;
	private ImgBlobDesign ibd;
	public ImgBlobEvent(ImgBlobDesign ibd) {
		this.ibd = ibd;
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
				JOptionPane.showMessageDialog(null, "이미지 확장자가 아닙니다.");
				return;
			} // end if

			// 이미지 크기 변경
			ImageResize.resizeImage(file.getAbsolutePath(), 200, 170);

			selectedImg = file.getParent() + "/" + "rs_" + file.getName();
			System.out.println(selectedImg);

//			wd.getJlbImage().setIcon(new ImageIcon(selectedImg));

		} // end if

	}// prviewImg

	public void insertImgToBlob(int product_code) throws IOException {
		
		//임시로 product_code에 1 추가.
		product_code = 1;
		String msg = "";
		ImgDTO idto = new ImgDTO();

		// -----이미지 선택됐는지 체크---------
		if ("".equals(selectedImg)) {
			JOptionPane.showMessageDialog(null, "이미지를 선택해주세요");
			return;
		} // end if

		File file = new File(selectedImg);
		FileInputStream fisImg = new FileInputStream(file);
		
		//----파일 확장자 확인.------
		String ext = file.getName().substring(file.getName().lastIndexOf(".")+1);
		String[] allowExtArr = "png,jpg,gif,bmp".split(",");
		boolean flag = false;

		for (String aExt : allowExtArr) {
			if (flag = ext.equals(aExt)) {
				break;
			} // end if
		} // end for

		if (!flag) {
			JOptionPane.showMessageDialog(null, "이미지 확장자가 아닙니다.");
			return;
		} // end if
		
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
		
		JOptionPane.showMessageDialog(null, msg);
	}// insertImgToBlob


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == ibd.getJbtnImage()) {
			prviewImg();
		} // end if
		
	}
}// class
