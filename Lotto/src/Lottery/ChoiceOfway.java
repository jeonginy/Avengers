package Lottery;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
class ChoiceOfway extends JFrame {
/*	 3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 
			장당 1,000				총 금액 : 
			  번 호 		>>	 	
		 반자동,   초기화   		확인,  구매하기
			  
*/
	List<List<JRadioButton>> check = new ArrayList<>();
	
	public ChoiceOfway(MouseEvent e) {
		// 전체 로또 판때기
		JPanel selectionPop = new JPanel();
		selectionPop.setLayout(new BoxLayout(selectionPop, BoxLayout.Y_AXIS));
		
		// 로또 금액, 숫자
		JPanel lottoPnl = new JPanel();
		lottoPnl.setLayout(new BoxLayout(lottoPnl, BoxLayout.Y_AXIS));
		JLabel price = new JLabel("금액 : 1,000원(장당)");
		lottoPnl.add(price);
		
		for(int i = 1; i < 8; i++) {
			JPanel lottoTemp = new JPanel();
			lottoTemp.setLayout(new FlowLayout());
			List<JRadioButton> tempRadList = new ArrayList<JRadioButton>();
			for (int j = 1; j < 8; j++) {
				JRadioButton radioTemp = new JRadioButton(String.valueOf((7 * (i - 1)) + j));
				lottoTemp.add(radioTemp);
				tempRadList.add(radioTemp);
			}
			lottoPnl.add(lottoTemp);
			check.add(tempRadList);
		}
		// 확인 및 수정 버튼 
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		JButton auto = new JButton("자동");
		JButton reset = new JButton("초기화");
		JButton confirm = new JButton("확인");
		btnPanel.add(auto);
		btnPanel.add(reset);
		btnPanel.add(confirm);
		
		// 전체 창에 로또 금애그 숫자, 확인 및 수정 버튼 추가
		selectionPop.add(lottoPnl);
		selectionPop.add(btnPanel);
		
		// 전체 로또 판때기에 부착
		add(selectionPop);
		showGUI();
		
	}
	private void showGUI() {
		setSize(300,300);
		setVisible(true);
	}


}
