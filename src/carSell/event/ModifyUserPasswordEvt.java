package carSell.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private String testpw = "12345";// 테스트용 임시 비번.
	private String pwCurrent, pwNew, pwNewCheck;
	private JLabel wrnPW, wrnPwNew, wrnPwCheck;

	public ModifyUserPasswordEvt(ModifyUserPasswordDesign mpd) {
		this.mpd = mpd;
		this.mpf = new ModifyUserPasswordFunction(mpd);
	}// ModifyUserPasswordEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mpd.getJbtnModify()) {
			getPasswordField();
			warningSet(false);

			if (!jtfEmptyWarning()) {
				return;
			} // end if;
			
			if(!pwCheck()) {
				return;
			}//end if
			if(!newPwCheck()) {
				return;
			}//end if
			
			
			warningSet(false);
//			mpd.getJbtnModify().setText("통과");
			if(!(JOptionPane.OK_OPTION== JOptionPane.showConfirmDialog(mpd, "비밀번호를 변경하시겠습니까?"))) {
				return;
			}//end if
			JOptionPane.showMessageDialog(mpd, "비밀번호가 변경되었습니다.");
		} // end if
	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}// windowClosing

	/**
	 * 디자인 클래스의 패스워드 필드를 가져와서 String 인스턴스 변수로 저장한다.<br>
	 * 경고 문구용 J라벨이 자주 쓰이는 관계로 같이 가져왔다.<br>
	 */
	public void getPasswordField() {
		pwCurrent = new String(mpd.getJpfPw().getPassword());
		pwNew = new String(mpd.getJpfNewPw().getPassword());
		pwNewCheck = new String(mpd.getJpfNewPwCheck().getPassword());

		wrnPW = mpd.getJlWrnPw();
		wrnPwNew = mpd.getJlWrnNewPw();
		wrnPwCheck = mpd.getJlWrnNewPwCheck();

	}// getPasswordField

	/**
	 * 액션 시 텍스트필드가 비어 있으면 경고문 JLabel을 보이게 함.<br>
	 * getPassword()은 char[]을 Return 하므로 toString<br>
	 */
	public boolean jtfEmptyWarning() {
		boolean flag = true;

		if (pwCurrent.isEmpty()) {
			wrnPW.setVisible(true);
			wrnPW.setText("내용이 비어있습니다.");
			flag = false;
		} else {
			wrnPW.setVisible(false);
		} // end else

		if (pwNew.isEmpty()) {
			wrnPwNew.setVisible(true);
			wrnPwNew.setText("내용이 비어있습니다.");
			flag = false;
		} else {
			wrnPwNew.setVisible(false);
		} // end else

		if (pwNewCheck.isEmpty()) {
			wrnPwCheck.setVisible(true);
			wrnPwCheck.setText("내용이 비어있습니다.");
			flag = false;
		} else {
			wrnPwCheck.setVisible(false);
		} // end else

		return flag;
	}// jtfEmptyWarning

	public void jpfClean() {
		mpd.getJpfPw().setText("");
		mpd.getJpfNewPw().setText("");
		mpd.getJpfNewPwCheck().setText("");
	}// jpfClean

	/**
	 * 모든 경고문을 보이게 하거나, 안 보이게.
	 * 
	 * @param flag
	 */
	public void warningSet(boolean flag) {
		wrnPW.setVisible(flag);
		wrnPwNew.setVisible(flag);
		wrnPwCheck.setVisible(flag);
	}// warningSet

	public boolean pwCheck() {
		boolean flag = false;

		if (testpw.equals(pwCurrent)) {
//			JOptionPane.showMessageDialog(mpd, "일치합니다.");
			wrnPW.setVisible(false);
			flag = true;
		} else {
			wrnPW.setText("이전 비밀번호를 잘못 입력하셨습니다.");
			wrnPW.setVisible(true);
		} // end else

		return flag;
	}// pwCheck

	public boolean newPwCheck() {
		boolean flag = false;

		if (pwNew.equals(pwNewCheck)) {
			wrnPW.setVisible(false);
			flag = true;
		} else {
			wrnPwCheck.setVisible(true);
			wrnPwCheck.setText("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			mpd.getJpfNewPwCheck().setText("");
		} // end else
		return flag;
	}// pwCheck
}// class
