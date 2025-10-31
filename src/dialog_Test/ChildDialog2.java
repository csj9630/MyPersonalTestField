package dialog_Test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 다이얼로그 : 부모 창에서 생성되는 자식 창
 * 부모창에서 제공할 수 없는 부가적인 정보를 제공하는 창.
 * 
 * 자식 다이얼로그를 닫을 때 부모 창으로 정보 전달이 되는지 확인 중.
 * windowListener 추가
 * 윈도우 버튼으로 닫을 때만 필드 String 변수값 변경.
 */
public class ChildDialog2 extends JDialog implements ActionListener, WindowListener {
	


	private String childText="Hello World";//변경해서 보낼 field 변수
	private ParentFlame2 pf;
	private JButton jbtnClose;
	
	public ChildDialog2(ParentFlame2 pf, boolean modal) {
		super(pf,"부가적인 정보를 제공",modal);
		
		this.pf = pf;
		
		JLabel jlblOutput = new JLabel(modal ? "부모창 x" : "부모창 O");
		Font font = new Font("맑은 고딕",Font.BOLD,20);
		Color color = Color.red;
		
		if(!modal) {
			font  =new Font("궁서체",Font.BOLD|Font.ITALIC,24);
			color=Color.BLUE;
		}//end if
		
//---자식->부모창으로 정보 보내기------------------
		JLabel jlTxt = new JLabel(childText);//테스트용 텍스트.
		addWindowListener(this); //윈도우 버튼 리스너 추가.
//------------------------------------------//		
		
		jlblOutput.setFont(font);
		jlblOutput.setForeground(color);
		
		add("Center",jlblOutput);
		add("Center",jlTxt);//테스트용 텍스트.
		
		
		jbtnClose = new JButton("닫기");
		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtnClose);
		
		add("South",jpSouth);
		jbtnClose.addActionListener(this);
		
//		setBounds(100,100,200,200);
		//자식창을 부모 창 내부에서 뜨게 한다.
		setBounds(pf.getX()+100,pf.getY()+100,200,200); //부모좌표를 가져올 수 있음.
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}//ChildDialog
	
	
	
	public String getChildText() {
		return childText;
	}

	public void setChildText(String childText) {
		this.childText = childText;
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnClose) {
			
		}//end if
		pf.setParentString("너에게 닿기를");
//		pf.revalidate();
//		pf.repaint();
		this.dispose();
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
//		setChildText("Data From Child");
		pf.setParentString("윈도우 닫기 버튼 누름");
		pf.revalidate();
		pf.repaint();
		this.dispose();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}//class
