package carSell.design;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UserMenuDesign extends JFrame {

	private JButton modifyInfo, modifyPw, orderState;

	public UserMenuDesign() {
		super("사용자 정보");
	}// UserMenuDesign

	public JButton getModifyInfo() {
		return modifyInfo;
	}

	public JButton getModifyPw() {
		return modifyPw;
	}

	public JButton getOrderState() {
		return orderState;
	}
}
