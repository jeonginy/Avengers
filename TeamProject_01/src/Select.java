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

/*	1) 로또 개수, 확인 버튼 -> Combo box
 * 	2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 
 * 	3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 
 * 	4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
 * 
 *    디자인은 전적으로 그림을 그려서 수작업할 예정 + 귀여운 디자인 훔쳐오기 (내 것처럼)
 *    숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
 *    당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
 *    로고
 *    모든 버튼의 글씨는 다 디자인으로 감
 */

public class Select extends JFrame {

	List<List<JRadioButton>> check = new ArrayList<>();
		
	public Select(MouseEvent e) {
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
		JButton confirm = new JButton("확인><");
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
