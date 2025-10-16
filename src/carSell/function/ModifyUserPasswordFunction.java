package carSell.function;

import carSell.Service.UserService;
import carSell.design.ModifyUserPasswordDesign;
import carSell.event.ModifyUserPasswordEvt;

public class ModifyUserPasswordFunction {
	private ModifyUserPasswordDesign mpd;
	private UserService us;


	public ModifyUserPasswordFunction(ModifyUserPasswordDesign mpd) {
		this.mpd = mpd;
		this.us = new UserService();
	}//ModifyUserFunction
	
	public void updatePassword() {
		
	}//updatePassword
	
}// class
