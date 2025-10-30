package blobTest;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImgBlobDesign extends JFrame{
	
	

	private JButton jbtnImage;



	private JLabel jlbImage;
	
	public ImgBlobDesign() {
		super("친구관리");
		
		
		
		JLabel jlbInform = new JLabel("이미지 추가");
		
		ImageIcon ii= new ImageIcon("src/images/default.png");


		jbtnImage = new JButton("선택");

		setLayout(null);
		
		jlbInform.setSize(200,50);
		jlbInform.setLocation(10,10);
		add(jlbInform);
		
		jlbImage.setSize(170, 170);
		jlbImage.setLocation(100, 20);
		jlbImage.setBackground(Color.BLUE);
		jlbImage.setOpaque(true);
		jlbImage.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlbImage);
		
		jbtnImage.setSize(170,50);
		jbtnImage.setLocation(380, 200);
		add(jbtnImage);

		
		
		//이벤트 등록
		ImgBlobEvent ibe = new ImgBlobEvent(this);
		
		jbtnImage.addActionListener(ibe);		
		
		
		setBounds(300,300,1000,800);
		setVisible(true);
		
	}


	public JLabel getJlbImage() {
		return jlbImage;
	}

	
	public JButton getJbtnImage() {
		return jbtnImage;
	}

	public static void main(String[] args) {
		new ImgBlobDesign();
	}
	

}
