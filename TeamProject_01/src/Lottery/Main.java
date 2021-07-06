package Lottery;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*	1) 로또 개수, 확인 버튼 -> 원하는 개수 입력 받기 
 * 	2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 
 * 	3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 
 * 	4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
 *    디자인은 전적으로 그림을 그려서 수작업할 예정 + 귀여운 디자인 훔쳐오기 (내 것처럼)
 *    숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
 *    당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
 *    로고
 *    모든 버튼의 글씨는 다 디자인으로 감
 */
public class Main extends JFrame {
//	1) 로또 개수, 확인 버튼 -> 원하는 개수 입력 받기 (최대 5개까지 가능)
	Integer[] A = { 1, 2, 3, 4, 5 };
	JComboBox<Integer> numOfBet = new JComboBox<>(A);
	static int select = 0;

	public Main() {
		JPanel pnl = new JPanel();

		JLabel lbl = new JLabel("Select the numbers of you're betting for");
		JButton btn = new JButton("Next");

		numOfBet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object c = e.getSource();
				JComboBox<Integer> tmp = (JComboBox<Integer>) c;
				select = tmp.getSelectedIndex() + 1;
			}
		});
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectingNumber(select);
				Main.this.dispose();
			}
		});
		

		pnl.add(numOfBet);
		pnl.add(lbl);
		pnl.add(btn);

		add(pnl);

		showGUI();
	}

	private void showGUI() {
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
//		String input = JOptionPane.showInputDialog(null, 
//				"Select the numbers of you're betting for\n(The maximun is up to five)");
//		JButton btn = new JButton(input);
		new Main();
	}

}