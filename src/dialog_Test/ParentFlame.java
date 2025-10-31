package dialog_Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ParentFlame extends JFrame implements ActionListener {


	private String parentString;
	private JButton jbtnDialogOpen, jbtnDialogOpen2;
	private JPanel jpBottom;
	private JLabel jlText;//체크용 추가 파트
	//private ChildDialog cd;//체크용 추가 파트
	
	public ParentFlame() {
		super("부모창");

		jbtnDialogOpen = new JButton("모달");
		jbtnDialogOpen2 = new JButton("비모달");
		
		
		
		jlText = new JLabel(parentString);//체크용 추가 파트

		JPanel jpCenter = new JPanel();
		jpBottom = new JPanel();
		
		
		jpCenter.setBorder(new TitledBorder("다이얼로그"));
		
		jpCenter.add(jbtnDialogOpen);
		jpCenter.add(jbtnDialogOpen2);
		
		jpBottom.add(jlText);//체크용 추가 파트
		
		add("Center",jpCenter);
		add("South",jpBottom);//체크용 추가 파트
		jbtnDialogOpen.addActionListener(this);
		jbtnDialogOpen2.addActionListener(this);
		
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}// ParentFlame

	
	public JPanel getJpBottom() {
		return jpBottom;
	}


	public void setJpBottom(JPanel jpBottom) {
		this.jpBottom = jpBottom;
	}


	public JLabel getJlText() {
		return jlText;
	}
	
	public String getParentString() {
		return parentString;
	}


	public void setParentString(String parentString) {
		this.parentString = parentString;
	}

	public void reset() {
		
		this.setVisible(false);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	/**
	 * 버튼 액션을 구분해주기.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnDialogOpen) {
			useModel();
		}//end if
		if(ae.getSource() == jbtnDialogOpen2) {
			useNonModel();
		}//end if
	}// actionPerformed

	/**
	 * ChildDialog를 열고, String값을 받아낸다.
	 */
	public void useModel() {
		ChildDialog cd = new ChildDialog(this, true);
		System.out.println(parentString);
		System.out.println(this);
//		String result = cd.getChildText();
		
//		getJlText().setText(result);
//		System.out.println("부모 : "+ result);
	}//useModel
	public void useNonModel() {
//		new ChildDialog(this, false);
		ChildDialog cd = new ChildDialog(this, false);
		System.out.println(parentString);

//		String result = cd.getChildText();
		
//		getJlText().setText(result);
//		System.out.println("부모 : "+ result);
	}//useNonModel
	
	
	public static void main(String[] args) {
		new ParentFlame();
	}// main

}// class