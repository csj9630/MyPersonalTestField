package carSell.design;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifyUserInfoDesign extends JDialog {

	private JTextField jtfName, jtfEmail, jtfTel, jtfCard, jtfAddr;
	private JLabel jlTitle;
	private JLabel jlName, jlEmail, jlTel, jlCard, jlAddr;
	private JLabel jlWrnName, jlWrnEmail, jlWrnTel, jlWrnCard, jlWrnAddr;
	private JButton jtbnModify;

	public ModifyUserInfoDesign() {
		//super("내 정보 수정");

	}// ModifyUserInfoDesign

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public JTextField getJtfTel() {
		return jtfTel;
	}

	public JTextField getJtfCard() {
		return jtfCard;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public JLabel getJlName() {
		return jlName;
	}

	public JLabel getJlEmail() {
		return jlEmail;
	}

	public JLabel getJlTel() {
		return jlTel;
	}

	public JLabel getJlCard() {
		return jlCard;
	}

	public JLabel getJlAddr() {
		return jlAddr;
	}

	public JLabel getJlWrnName() {
		return jlWrnName;
	}

	public JLabel getJlWrnEmail() {
		return jlWrnEmail;
	}

	public JLabel getJlWrngTel() {
		return jlWrnTel;
	}

	public JLabel getJlWrnCard() {
		return jlWrnCard;
	}

	public JLabel getJlWrnAddr() {
		return jlWrnAddr;
	}

	public JButton getJtbnModify() {
		return jtbnModify;
	}

}// class
