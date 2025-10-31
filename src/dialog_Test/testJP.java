package dialog_Test;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class testJP extends JPanel {
	private JButton jbtnDialogOpen, jbtnDialogOpen2;
	private ParentFlame2 pf2;
	
	public testJP(ParentFlame2  pf2) {
		this.pf2 = pf2;
		jbtnDialogOpen = new JButton("모달");
		jbtnDialogOpen2 = new JButton("비모달");
		
		
		

		JPanel jpCenter = new JPanel();
		JPanel jpBottom = new JPanel();
		
		
		jpCenter.setBorder(new TitledBorder("다이얼로그"));
		
		jpCenter.add(jbtnDialogOpen);
		jpCenter.add(jbtnDialogOpen2);
		
		
		add("Center",jpCenter);
		add("South",jpBottom);//체크용 추가 파트
		
		
	}
	public JButton getJbtnDialogOpen() {
		return jbtnDialogOpen;
	}
	public void setJbtnDialogOpen(JButton jbtnDialogOpen) {
		this.jbtnDialogOpen = jbtnDialogOpen;
	}
	public JButton getJbtnDialogOpen2() {
		return jbtnDialogOpen2;
	}
	public void setJbtnDialogOpen2(JButton jbtnDialogOpen2) {
		this.jbtnDialogOpen2 = jbtnDialogOpen2;
	}
	
}
