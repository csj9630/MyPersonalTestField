package blobTest;

import java.io.File;
import java.io.FileInputStream;

public class ImgDTO {

	private int product_code;
	private FileInputStream img;
	private File file;

	public ImgDTO(int product_code, FileInputStream img, File file) {
		super();
		this.product_code = product_code;
		this.img = img;
		this.file = file;
	}

	public ImgDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public FileInputStream getImg() {
		return img;
	}

	public void setImg(FileInputStream img) {
		this.img = img;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
