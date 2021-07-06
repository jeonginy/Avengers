package Lottery;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class SelectingNumber extends JFrame {
	/*
	 * 2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액,
	 * 구매하기 버튼 A XXXXXXX 수정 삭제 장당 1,000 B XXXXXXX 수정 삭제 >> 번 호 >> 총 금액 : C XXXXXXX
	 * 수정 삭제 D XXXXXXX 수정 삭제 반자동 초기화 확인 구매하기
	 */
	List<JLabel> nameOfLottery = new ArrayList<>(); // 선택한 개수만큼 담을 이름 그릇
	List<JLabel> numOfLottery = new ArrayList<>(); // 로또 번호 담을 그릇
	List<List<JButton>> editOfLottery = new ArrayList<>(); // 자동 수정 삭제 버튼 담을 그릇
	List<ChoiceOfway> choiceOfwayList = new ArrayList<>();
	String[] editOfButton = { "수정", "삭제" }; // 수정 삭제 버튼
	static int[] selectedNum = new int[6];
	int select;
//	Main에서 next버튼 눌렸을 때, ActionListener로 인해 호출 
//	ActionListener cast this constructor to choose the numbers of lottery

	public SelectingNumber(int select) { // Main Integer[] A - 1,2,3,4,5 가져오기
		this.select = select;

		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		
		// The names
		// 1) integer A 배열을 그대로 가지고 와서 1,2,3,4,5를 A,B,C,D,E로 만들어서 뽑기
		for (int i = 1; i <= select; i++) {
			JPanel choice = new JPanel();
			choice.setLayout(new FlowLayout());
			JLabel numOfName = new JLabel(String.valueOf((char) (i + 64)));
			nameOfLottery.add(numOfName);

			// 2) 아무것도 선택하지 않은 상태에서 보이는 레이블
			JLabel num = new JLabel("X X X X X X");
			numOfLottery.add(num);

			choice.add(numOfName);
			choice.add(num);

			// Reset, Confirm buttons
			List<JButton> btn = new ArrayList<JButton>(); // 버튼들을 담을 그릇
			for (int j = 0; j < 2; j++) {
				JButton tmpBtn = new JButton(editOfButton[j]); // 담은 버튼을 담을 임시 저장소
				btn.add(tmpBtn); // 버튼에 임시 저장소에 있는 원소 넣기
				choice.add(tmpBtn); // 임시 버튼을 choice판에 붙이기
			}
			editOfLottery.add(btn);
			main.add(choice);
		}
		for (int i = 0; i < select; i++) {
			numOfLottery.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int idx = numOfLottery.indexOf((JLabel) e.getSource());
					if (choiceOfwayList.size() >= idx + 1)
						choiceOfwayList.get(idx).callSelectionPop();
					else
						choiceOfwayList.add(new ChoiceOfway(e));
				}
			});
		}
		add(main);

		showGUI();
	}

	private void showGUI() {
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
