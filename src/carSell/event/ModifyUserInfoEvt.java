package carSell.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import carSell.Service.AdminService;
import carSell.Service.UserService;
import carSell.design.ModifyUserInfoDesign;
import carSell.function.ModifyUserFunction;

public class ModifyUserInfoEvt extends WindowAdapter implements ActionListener {
	private ModifyUserInfoDesign mud;
	private ModifyUserFunction muf;
	
	public ModifyUserInfoEvt(ModifyUserInfoDesign mud) {
		this.mud = mud;
		this.muf = new ModifyUserFunction(mud);
//		warningSet(false);
	}//ModifyUserInfoEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mud.getJbtnModify()) {
			if(!jtfEmptyWarning()) {
				return;
			}else {
				warningSet(false);
				mud.getJtfAddr().setText("통과");
			}//end else
		}//end if

	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}//windowClosing
	
	/**
	 * 액션 시 텍스트필드가 비어 있으면 경고문 JLabel을 보이게 함.
	 */
	public boolean jtfEmptyWarning() {
		boolean flag = true;
		if(mud.getJtfName().getText().isEmpty()) {
			mud.getJlWrnName().setVisible(true);
			flag = false;
		}//end if
		if(mud.getJtfEmail().getText().isEmpty()) {
			mud.getJlWrnEmail().setVisible(true);
			flag = false;
		}//end if
		if(mud.getJtfTel().getText().isEmpty()) {
			mud.getJlWrngTel().setVisible(true);
			flag = false;
		}//end if
		if(mud.getJtfCard().getText().isEmpty()) {
			mud.getJlWrnCard().setVisible(true);
			flag = false;
		}//end if
		if(mud.getJtfAddr().getText().isEmpty()) {
			mud.getJlWrnAddr().setVisible(true);
			flag = false;
		}//end if
		
		return flag;
	}//jtfEmptyWarning
	
	
	/**
	 * 모든 경고문을 보이게 하거나, 안 보이게.
	 * @param flag
	 */
	public void warningSet(boolean flag) {
		mud.getJlWrnName().setVisible(flag);
		mud.getJlWrnEmail().setVisible(flag);
		mud.getJlWrngTel().setVisible(flag);
		mud.getJlWrnCard().setVisible(flag);
		mud.getJlWrnAddr().setVisible(flag);
	}//warningSet

}//class
