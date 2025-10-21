package carSell.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import carSell.DTO.UserDTO;
import carSell.design.ModifyUserInfoDesign;
import carSell.function.ModifyUserFunction;

public class ModifyUserInfoEvt extends WindowAdapter implements ActionListener {
	private ModifyUserInfoDesign mud;
	private ModifyUserFunction muf;

	private boolean btnFlag = false;

	public static final int UNEDITABLE = 211;
	public static final int EDITABLE = 238;

	public ModifyUserInfoEvt(ModifyUserInfoDesign mud) {
		this.mud = mud;
		this.muf = new ModifyUserFunction(mud);
		editFlag(false, UNEDITABLE);
//		mud.getJtfCard().setText(cardMasking("1234-4567-8978-7893"));

	}// ModifyUserInfoEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mud.getJbtnModify()) {
			if (btnFlag == false) {
				enterEditMode();
			} else {
				if (!jtfEmptyWarning()) {
					return;
				} // end if
				saveChanges();
			} // end else
			btnFlag = !btnFlag;
		} // end if

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}// windowClosing

	private void enterEditMode() {
		editFlag(true, EDITABLE);

		warningSet(false);

		mud.getJbtnModify().setText("수정사항 저장");
		mud.getJbtnModify().setBackground(new Color(50, 205, 50));// 버튼색 바꿈

	}// enterEditMode

	private void saveChanges() {

		if (!(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(mud, "저장하시겠습니까?"))) {
			return;
		} // end if;

		editFlag(false, UNEDITABLE);
		warningSet(false);

		// DB 저장 로직 자리
		saveUserInfo();

		mud.getJbtnModify().setText("내 정보 수정");
		mud.getJbtnModify().setBackground(new Color(37, 157, 237));// 버튼색 바꿈

	}// saveChanges

	// -----------------Function-----------------------------------

	/**
	 * 액션 시 텍스트필드가 비어 있으면 경고문 JLabel을 보이게 함.<br>
	 * JFormattedTextField을 쓰는 둘은 empty 말고 비어 있을 때의 string으로 대체.<br>
	 */
	public boolean jtfEmptyWarning() {
		boolean flag = true;
		System.out.println(mud.getJtfCard().getText());
		if (mud.getJtfName().getText().isEmpty()) {
			mud.getJlWrnName().setVisible(true);
			flag = false;
		} else {
			mud.getJlWrnName().setVisible(false);
		} // end else

		if (mud.getJtfEmail().getText().isEmpty()) {
			mud.getJlWrnEmail().setVisible(true);
			flag = false;
		} else {
			mud.getJlWrnEmail().setVisible(false);
		} // end else

//		if (mud.getJtfTel().getText().isEmpty()) {
		if (mud.getJtfTel().getText().equals("     -        -      ")) {
			mud.getJlWrngTel().setVisible(true);
			flag = false;
		} else {
			mud.getJlWrngTel().setVisible(false);
		} // end else

//		if (mud.getJtfCard().getText().isEmpty()) {
		if (mud.getJtfCard().getText().equals("      -        -        -      ")) {
			mud.getJlWrnCard().setVisible(true);
			flag = false;
		} else {
			mud.getJlWrnCard().setVisible(false);
		} // end else

		if (mud.getJtfAddr().getText().isEmpty()) {
			mud.getJlWrnAddr().setVisible(true);
			flag = false;
		} else {
			mud.getJlWrnAddr().setVisible(false);
		} // end else

		return flag;
	}// jtfEmptyWarning

	/**
	 * 모든 경고문을 보이게 하거나, 안 보이게.
	 * 
	 * @param flag
	 */
	public void warningSet(boolean flag) {
		mud.getJlWrnName().setVisible(flag);
		mud.getJlWrnEmail().setVisible(flag);
		mud.getJlWrngTel().setVisible(flag);
		mud.getJlWrnCard().setVisible(flag);
		mud.getJlWrnAddr().setVisible(flag);
	}// warningSet

	public void editFlag(boolean flag, int colorCode) {
		// 텍스트필드 배경
		mud.getJtfName().setBackground(new Color(colorCode, colorCode, colorCode));
		mud.getJtfEmail().setBackground(new Color(colorCode, colorCode, colorCode));
		mud.getJtfTel().setBackground(new Color(colorCode, colorCode, colorCode));
		mud.getJtfCard().setBackground(new Color(colorCode, colorCode, colorCode));
		mud.getJtfAddr().setBackground(new Color(colorCode, colorCode, colorCode));

		// 텍스트필드 수정불가
		mud.getJtfName().setEditable(flag);
		mud.getJtfEmail().setEditable(flag);
		mud.getJtfTel().setEditable(flag);
		mud.getJtfCard().setEditable(flag);
		mud.getJtfAddr().setEditable(flag);

		// 텍스트필드 포커스 안 주기
		mud.getJtfName().setFocusable(flag);
		mud.getJtfEmail().setFocusable(flag);
		mud.getJtfTel().setFocusable(flag);
		mud.getJtfCard().setFocusable(flag);
		mud.getJtfAddr().setFocusable(flag);

	}// editFlag

	// 카드번호 가운데 8자리 마스킹
	public String cardMasking(String cardNo) {
		// 카드번호 16자리 또는 15자리 '-'포함/미포함 상관없음
		String regex = "(\\d{4})-?(\\d{4})-?(\\d{4})-?(\\d{3,4})$";

		Matcher matcher = Pattern.compile(regex).matcher(cardNo);
		if (matcher.find()) {
			String target = matcher.group(2) + matcher.group(3);
			int length = target.length();
			char[] c = new char[length];
			Arrays.fill(c, '*');

			return cardNo.replace(target, String.valueOf(c));
		}
		return cardNo;
	}// cardMasking

	// ----------DB 로직--------------------------------------------------------

	/**
	 * 텍스트필드의 정보를 DB에 저장한다.
	 */
	public void saveUserInfo() {
		UserDTO uDTO = new UserDTO();
		uDTO.setName(mud.getJtfName().getText());
		uDTO.setEmail(mud.getJtfEmail().getText());
		uDTO.setTel(mud.getJtfTel().getText());
		uDTO.setCard_num(mud.getJtfCard().getText());
		uDTO.setAddress(mud.getJtfAddr().getText());
		
		System.out.println(uDTO);
		
		JOptionPane.showMessageDialog(mud, "사용자 정보를 저장했습니다");
	}// saveUserInfo

}// class
