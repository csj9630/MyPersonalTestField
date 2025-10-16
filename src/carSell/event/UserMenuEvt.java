package carSell.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import carSell.design.UserMenuDesign;

public class UserMenuEvt extends WindowAdapter implements ActionListener {
	private UserMenuDesign umd;

	public UserMenuEvt(UserMenuDesign umd) {
		this.umd = umd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 각 버튼별 액션
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}

}
