package dialog_Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ParentFlame2 extends JFrame implements ActionListener {


	private String parentString;
	private JLabel jlText;//체크용 추가 파트
	private testJP tsp;
	//private ChildDialog2 cd;//체크용 추가 파트
	
	public ParentFlame2() {
		super("부모창");
		testJP tsp = new testJP(this);
		parentString ="테스트";
		jlText = new JLabel(parentString);//체크용 추가 파트
		this.tsp = tsp;
		tsp.getJbtnDialogOpen().addActionListener(this);
		tsp.getJbtnDialogOpen2().addActionListener(this);
		
		
		add("Center",tsp);
		add("South",jlText);
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}// ParentFlame

	
	
	public String getParentString() {
		return parentString;
	}


	public void setParentString(String parentString) {
		this.parentString = parentString;
	}


	/**
	 * 버튼 액션을 구분해주기.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == tsp.getJbtnDialogOpen()) {
			useModel();
			this.revalidate();
			this.repaint();
		}//end if
		if(ae.getSource() == tsp.getJbtnDialogOpen2()) {
			useNonModel();
		}//end if
	}// actionPerformed

	/**
	 * ChildDialog2를 열고, String값을 받아낸다.
	 */
	public void useModel() {
		ChildDialog2 cd = new ChildDialog2(this, true);
		System.out.println(parentString);;
		
	
//		String result = cd.getChildText();
		
//		getJlText().setText(result);
//		System.out.println("부모 : "+ result);
	}//useModel
	public void useNonModel() {
//		new ChildDialog2(this, false);
		ChildDialog2 cd = new ChildDialog2(this, false);
		System.out.println(parentString);

//		String result = cd.getChildText();
		
//		getJlText().setText(result);
//		System.out.println("부모 : "+ result);
	}//useNonModel
	
	
	public static void main(String[] args) {
		new ParentFlame2();
	}// main

}// class