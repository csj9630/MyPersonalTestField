package blobTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ImgBlobDesign extends JFrame {

	public JButton getJbtnSelect() {
		return jbtnSelect;
	}

	public JTextField getJtfCode() {
		return jtfCode;
	}

	private JButton jbtnImage;
	private JButton jbtnAdd, jbtnSelect;
	private JTextField jtfCode;

	private JLabel jlbImage;

	public ImgBlobDesign() {
		super("친구관리");

		JLabel jlbInform = new JLabel("이미지 추가");

		ImageIcon ii = new ImageIcon("src/images/default.png");
		jlbImage = new JLabel(ii);
		jbtnImage = new JButton("선택");
		jbtnAdd = new JButton("추가");
		jtfCode = new JTextField();
		jbtnSelect = new JButton("불러오기");
		
		setLayout(null);

		jlbInform.setSize(200, 50);
		jlbInform.setLocation(10, 10);
		add(jlbInform);

		jlbImage.setSize(500, 500);
		jlbImage.setLocation(100, 20);
//		jlbImage.setBackground(Color.BLUE);
		jlbImage.setOpaque(true);
		jlbImage.setHorizontalAlignment(SwingConstants.CENTER);
		add(jlbImage);

		jbtnImage.setSize(170, 50);
		jbtnImage.setLocation(600, 200);
		add(jbtnImage);
		
		
		jbtnAdd.setSize(170, 50);
		jbtnAdd.setLocation(600, 300);
		add(jbtnAdd);
		
		jtfCode.setSize(170, 50);
		jtfCode.setLocation(600, 400);
		add(jbtnAdd);
		
		jbtnSelect.setSize(170, 50);
		jbtnSelect.setLocation(600, 500);
		add(jbtnSelect);
		

		// 이벤트 등록
		ImgBlobEvent ibe = new ImgBlobEvent(this);

		jbtnImage.addActionListener(ibe);
		jbtnAdd.addActionListener(ibe);
		jbtnSelect.addActionListener(ibe);

		setBounds(100, 100, 1000, 600);
		setVisible(true);

	}

	public JLabel getJlbImage() {
		return jlbImage;
	}

	public JButton getJbtnImage() {
		return jbtnImage;
	}

	public JButton getJbtnAdd() {
		return jbtnAdd;
	}

	public static void main(String[] args) {
		new ImgBlobDesign();
	}

}
