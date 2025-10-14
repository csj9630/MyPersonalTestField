package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ParentFlame extends JFrame implements ActionListener {



	private JButton jbtnDialogOpen, jbtnDialogOpen2;
	
	private JLabel jlText;//체크용 추가 파트
	//private ChildDialog cd;//체크용 추가 파트
	
	public ParentFlame() {
		super("부모창");

		jbtnDialogOpen = new JButton("모달");
		jbtnDialogOpen2 = new JButton("비모달");
		
		jlText = new JLabel("자식창에서 용돈 받기");//체크용 추가 파트

		JPanel jpCenter = new JPanel();
		JPanel jpBottom = new JPanel();
		
		
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

	
	public JLabel getJlText() {
		return jlText;
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
		String result = cd.getChildText();
		
		getJlText().setText(result);
		System.out.println("부모 : "+ result);
	}//useModel
	public void useNonModel() {
//		new ChildDialog(this, false);
		ChildDialog cd = new ChildDialog(this, true);
		String result = cd.getChildText();
		
		getJlText().setText(result);
		System.out.println("부모 : "+ result);
	}//useNonModel
	
	
	public static void main(String[] args) {
		new ParentFlame();
	}// main

}// class