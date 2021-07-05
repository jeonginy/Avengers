import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*	1) 로또 개수, 확인 버튼 -> Combo box
 * 	2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 
 * 	3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 
 * 					- 자동용 랜덤 수 뽑아내는 클래스 생성 
 * 	4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
 * 	  - 당첨번호 랜덤 수 뽑아내는 클래스 생성 
 *    디자인은 전적으로 그림을 그려서 수작업할 예정 + 귀여운 디자인 훔쳐오기 (내 것처럼)
 *    숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
 *    당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
 *    로고
 *    모든 버튼의 글씨는 다 디자인으로 감
 */
class Main_choice extends JFrame {
	List<JLabel> nameList = new ArrayList<>();
	List<JLabel> lottoList = new ArrayList<>();
	List<List<JButton>> btnList = new ArrayList<>();
	String[] btnNameList = { "자동", "수정", "삭제" };

	public Main_choice(String input) {
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		int count = Integer.parseInt(input);
		
		for(int i = 0; i < count; i++) {
			JPanel A = new JPanel();
			A.setLayout(new FlowLayout());
			JLabel numOfName = new JLabel(String.valueOf((char) (i + 65)));
			nameList.add(numOfName);
			JLabel numOfLotto = new JLabel("X X X X X X");
			lottoList.add(numOfLotto);
			
			A.add(numOfName);
			A.add(numOfLotto);
			
			List<JButton> btn = new ArrayList<JButton>();
			for(int j = 0; j < 3; j++) {
				JButton temp = new JButton(btnNameList[j]);
				btn.add(temp);
				A.add(temp);
			}
			btnList.add(btn);
			main.add(A);
			
		}
		
		lottoList.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Select(e);
			}
		});
		
		add(main);
		showGUI();
		
	}
	private void showGUI() {
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
