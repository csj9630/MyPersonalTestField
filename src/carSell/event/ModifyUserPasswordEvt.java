package carSell.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import carSell.Service.UserService;
import carSell.design.ModifyUserPasswordDesign;
import carSell.function.ModifyUserPasswordFunction;

/**
 * 비밀번호 수정 페이지의 이벤트 클래스.<br>
 * 일단 암호화는 상정하지 않음<br>
 * 비번 체크 로직은 따로 만들어야할 듯.<br>
 */
public class ModifyUserPasswordEvt extends WindowAdapter implements ActionListener {
	private ModifyUserPasswordDesign mpd;
	private ModifyUserPasswordFunction mpf;
	
	public ModifyUserPasswordEvt(ModifyUserPasswordDesign mpd) {
		this.mpd = mpd;
		this.mpf= new ModifyUserPasswordFunction(mpd);
	}//ModifyUserPasswordEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == mpd.getJbtnModify()) {
			if(!jtfEmptyWarning()) {
				return;
			}else {
				warningSet(false);
				mpd.getJbtnModify().setText("통과");
			}//end else
		}//end if
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}//windowClosing
	
	/**
	 * 액션 시 텍스트필드가 비어 있으면 경고문 JLabel을 보이게 함.<br>
	 * getPassword()은 char[]을 Return 하므로 toString<br>
	 */
	public boolean jtfEmptyWarning() {
		boolean flag = true;
		if(mpd.getJtfPw().getPassword().toString().isEmpty()) {
			mpd.getJlWrnPw().setVisible(true);
			flag = false;
		}//end if
		if(mpd.getJtfNewPw().getPassword().toString().isEmpty()) {
			mpd.getJlWrnNewPw().setVisible(true);
			flag = false;
		}//end if
		if(mpd.getJtfNewPwCheck().getPassword().toString().isEmpty()) {
			mpd.getJlWrnNewPwCheck().setVisible(true);
			flag = false;
		}//end if
		
		return flag;
	}//jtfEmptyWarning
	
	
	/**
	 * 모든 경고문을 보이게 하거나, 안 보이게.
	 * @param flag
	 */
	public void warningSet(boolean flag) {
		mpd.getJlWrnPw().setVisible(flag);
		mpd.getJlWrnNewPw().setVisible(flag);
		mpd.getJlWrnNewPwCheck().setVisible(flag);
	}//warningSet


}//class
