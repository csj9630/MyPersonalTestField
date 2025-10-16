package carSell.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import carSell.Service.UserService;
import carSell.design.ModifyUserPasswordDesign;
import carSell.function.ModifyUserPasswordFunction;

public class ModifyUserPasswordEvt extends WindowAdapter implements ActionListener {
	private ModifyUserPasswordDesign mpd;
	private ModifyUserPasswordFunction mpf;
	
	public ModifyUserPasswordEvt(ModifyUserPasswordDesign mpd) {
		this.mpd = mpd;
		this.mpf= new ModifyUserPasswordFunction(mpd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}

}
