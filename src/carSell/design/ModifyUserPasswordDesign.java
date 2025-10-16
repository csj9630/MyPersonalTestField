package carSell.design;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import carSell.event.ModifyUserInfoEvt;

public class ModifyUserPasswordDesign extends JDialog {

	private JTextField jtfPw, jtfNewPw, jtfNewPwCheck;
	private JLabel jlTitle;
	private JLabel jlPw, jlNewPw, jlNewPwCheck;
	private JLabel jlWrnPw, jlWrnNewPw, jlWrnNewPwCheck, jlWrnCard, jlWrnAddr;
	private JButton jbtnModify;

	public ModifyUserPasswordDesign() {
		//super("비밀번호 수정");

	}// ModifyUserInfoDesign

	public JTextField getJtfPw() {
		return jtfPw;
	}

	public JTextField getJtfNewPw() {
		return jtfNewPw;
	}

	public JTextField getJtfNewPwCheck() {
		return jtfNewPwCheck;
	}

	public JLabel getJlTitle() {
		return jlTitle;
	}

	public JLabel getJlPw() {
		return jlPw;
	}

	public JLabel getJlNewPw() {
		return jlNewPw;
	}

	public JLabel getJlNewPwCheck() {
		return jlNewPwCheck;
	}

	public JLabel getJlWrnPw() {
		return jlWrnPw;
	}

	public JLabel getJlWrnNewPw() {
		return jlWrnNewPw;
	}

	public JLabel getJlWrnNewPwCheck() {
		return jlWrnNewPwCheck;
	}

	public JLabel getJlWrnCard() {
		return jlWrnCard;
	}

	public JLabel getJlWrnAddr() {
		return jlWrnAddr;
	}

	public JButton getJbtnModify() {
		return jbtnModify;
	}

}// class
