package Lottery;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// XXXXX 라벨용 마우스 아답타
class NumLblMouseAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		// 현재 이벤트를 발생시킨 라벨 객체 저장
		JLabel tempClick = (JLabel) e.getSource();
		// idx를 계속 사용하기위해 for문 밖에서 선언
		int idx = 0;
		for (; idx < SelectingNumber.numOfLottery.length; idx++) {
			// 만약 이벤트를 발생시킨 애가 있다면 j가 6이 되기전에 멈추기때문에
			// 탈출 조건을 써야되서 for문 밖에 j 선언
			int j = 0;
			for (; j < 6; j++) {
				// 만약 이벤트를 발생시킨 애와 j번째 객체가 같다면 브레이크
				if (tempClick == SelectingNumber.numOfLottery[idx][j])
					break;
				// 중간에 브레이크 됐다면 j는 6보다 작기때문에 밖의 for문을
				// 탈출하기위해 브레이크 한번더
			}
			if (j != 6)
				break;
		}
		boolean editchk = false;
		if (idx == SelectingNumber.numOfLottery.length) {
			// idx를 계속 사용하기위해 for문 밖에서 선언
			idx = 0;
			for (; idx < SelectingNumber.editOfLottery.size(); idx++) {
				// 만약 이벤트를 발생시킨 애가 있다면 j가 6이 되기전에 멈추기때문에
				// 탈출 조건을 써야되서 for문 밖에 j 선언
				if (SelectingNumber.editOfLottery.get(idx).contains(tempClick)) {
					break;
				}
			}
			editchk = true;
		}
		// 여기까지 나온 idx는 각 열의 1~6번까지 어느 버튼을 선택하든
		// A열의 1~6번을 선택하면 idx는 0
		// B열이라면 idx는 1이 나오도록 해놓음 - for문에서 브레이크를 두번 쓰고 idx를 밖으로 뺀 이유
		// 순서대로 입력을 안할경우를 대비한 boolean값 선언 및 탐색작업
		boolean checkOrder = true;
		// 위에서 알아낸 호출한 객체의 순서(A, B, C, D, E중 한명의 인덱스)의 직전까지
		// 탐색해서 만약 선택한놈보다 전의 객체도 비어있다면 순서대로 누른게 아니므로
		// boolean 값을 false로 바꾸고 에러창 출력
		for (int i = 0; i < idx; i++) {
			if (SelectingNumber.choiceOfwayList[i] == null) {
				JOptionPane.showMessageDialog(null, "순서대로 입력하세요");
				checkOrder = false;
				// null인 객체가 하나라도 있다면 순서가 안맞으므로
				// 다음은 볼 필요도 없이 바로 브레이크
				break;
			}
		}
		// 위에서 비어있는 객체가 없어서 false로 바뀌지 않았다면
		// 순서가 맞으므로 if문 안의 다음 창 띄우기 실행
		if (checkOrder) {
			// 만약 이번에 선택할 숫자들의 기존 입력값이 없다면
			// 새로운 객체를 생성해서 실행후 리스트에 추가
			if (SelectingNumber.choiceOfwayList[idx] == null)
				if (editchk) {
					JOptionPane.showMessageDialog(null, "X를 눌려서 번호를 선택해주세요.");
				} else {
					// 첫번째 전달인자로 라벨의 숫자를 바꾸기 위해 라벨 배열을 넘겨주고
					// 두번째 전달인자로 선택한 숫자를 저장하기 위해 선택한 숫자 배열을 넘겨줌
					SelectingNumber.choiceOfwayList[idx] = new ChoiceOfway(SelectingNumber.numOfLottery[idx],
							SelectingNumber.selectedNum[idx]);
					// 기존에 입력했던 값을 수정하는거라면
					// 기존 객체 불러오기
				}
			else {
				SelectingNumber.choiceOfwayList[idx].callSelectionPop();
			}
		}
	}
}

class DeleteAdapter extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel deClick = (JLabel) e.getSource(); // 삭제 레이블을 눌렸을 때, 삭제된 열의 값은 = null 밑의 열이 그 위로 올라와야함

		int idx = 0; // 한번 돌아가는 횟수
//	      if (deClick != null) {
		for (; idx < SelectingNumber.editOfLottery.size(); idx++) { // editOfLottery List의 길이만큼 돌아감
			// 선택된 숫자들의 공간 횟수
			if (SelectingNumber.editOfLottery.get(idx).contains(deClick)) // 클릭된 delete 레이블이 deClick을 가지고 있다면 끝
				break; // 찾은 index 값을 계속해서 써야되기 때문에, 그 값에서 정지

		} // if delete -> i = i + 1 && i != 6
		if (SelectingNumber.choiceOfwayList[idx] == null) // 배열 안에 객체가 저장돼 있기 때문에 null으로 초기화, int라면, 0으로 초기화
			JOptionPane.showMessageDialog(null, "선택하지 않아 삭제가 불가능합니다", "삭제 에러", JOptionPane.ERROR_MESSAGE);
		else {
			if (idx != SelectingNumber.choiceOfwayList.length - 1) { // choicefOfwayList의 index가 마지막 값이 아니고 (마지막이고,)
				if (SelectingNumber.choiceOfwayList[idx + 1] != null) { // choicefOfwayList의 index + 1이 null이 아니라면
					for (int i = idx; i < SelectingNumber.choiceOfwayList.length; i++) {
						// (null값이면)
						if (i == SelectingNumber.choiceOfwayList.length - 1) {
							SelectingNumber.choiceOfwayList[i] = null; // XXXXXX
							SelectingNumber.selectedNum[i] = new int[6]; // 0000000
						} else {
							SelectingNumber.choiceOfwayList[i] = SelectingNumber.choiceOfwayList[i + 1]; // D->C /
							// E->D				
							System.out.println(3);
							SelectingNumber.selectedNum[i] = SelectingNumber.selectedNum[i + 1];
						}
					}
				} else {
					SelectingNumber.choiceOfwayList[idx] = null;
					SelectingNumber.selectedNum[idx] = new int[6];
				}
			} else {
				SelectingNumber.choiceOfwayList[idx] = null;
				SelectingNumber.selectedNum[idx] = new int[6];
			}
			Main.selNum.setNumLabel();
		}
	}
}

class SelectingNumber extends JFrame {
	/*
	 * 2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액,
	 * 구매하기 버튼 A XXXXXXX 수정 삭제 장당 1,000 B XXXXXXX 수정 삭제 >> 번 호 >> 총 금액 : C XXXXXXX
	 * 수정 삭제 D XXXXXXX 수정 삭제 반자동 초기화 확인 구매하기
	 */
	// 배열로 선언한 이유는 우리가 원하는대로 인덱스에 접근할 수 있고
	// 리스트에서 add를 했을때 조건을 제대로 안잡는다면
	// 자칫 로또 번호가 담긴 라벨의 인덱스와 숫자 선택창의 인덱스, 선택한 숫자들의 인덱스가
	// 다를 수 있으므로 배열로 수정함
	static List<JLabel> nameOfLottery = new ArrayList<>(); // 선택한 개수만큼 담을 이름 그릇
	static JLabel[][] numOfLottery; // 선택한 번호나 xxx를 표시할 라벨의 배열
	static List<List<JLabel>> editOfLottery = new ArrayList<>(); // 수정 삭제 버튼 담을 그릇
	static ChoiceOfway[] choiceOfwayList; // 숫자 선택창을 저장할 배열
	static String[] editOfButton = { "Buttons/EDIT.gif", "Buttons/DELETE.gif" }; // 수정 삭제 버튼
	static int[][] selectedNum; // 선택한 숫자들이 담길 배열
	JPanel warningPnl; // 제일 위에 설명할 라벨을 위한 패널
	JLabel warningMsg;

//   Main에서 next버튼 눌렸을 때, ActionListener로 인해 호출 
//   ActionListener cast this constructor to choose the numbers of lottery
	public SelectingNumber(int select) { // Main 콤보박스에서 선택한 숫자값 들고오기
		// 3개를 생성자에서 초기화 한 이유는
		// 콤보박스에서 선택한 횟수를 알아야지
		// 정확하게 초기화가 가능하기 때문임
		numOfLottery = new JLabel[select][6]; // 선택한 숫자나 xxx가 담길 라벨 배열 초기화
		choiceOfwayList = new ChoiceOfway[select]; // 숫자 선택창들이 담길 배열 초기화
		selectedNum = new int[select][6]; // 선택한 숫자들이 담길 배열 초기화 49 -> 45

		JPanel main = new JPanel(); // 전체를 관리할 패널
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS)); // 세로정렬

		warningPnl = new JPanel(); // 설명용 패널
		ImageIcon warningIcon = new ImageIcon("Labels/sentence.gif");
		warningMsg = new JLabel(warningIcon);
		warningPnl.setOpaque(true);
		warningPnl.setBackground(Color.white);
		warningPnl.add(warningMsg);
		main.add(warningPnl);

		// The names
		// 1) integer A 배열을 그대로 가지고 와서 1,2,3,4,5를 A,B,C,D,E로 만들어서 뽑기
		for (int i = 0; i < select; i++) {
			// A와 XXXXX 및 버튼이 담길 패널 생성
			JPanel choice = new JPanel();
			choice.setOpaque(true);
			choice.setBackground(Color.white);
			choice.setLayout(new FlowLayout()); // FlowLayout이 기본이라 생략가능

			// A ~ E까지 선택한 횟수만큼 라벨을 만들어서 패널에 추가
			// A는 65이기 때문에 i가 0일때 65를 더해 A라는 문자를 추출
			ImageIcon abcIcon = new ImageIcon("Labels/" + String.valueOf((char) (i + 65)) + ".gif");
			JLabel numOfName = new JLabel(abcIcon);
			nameOfLottery.add(numOfName);
			choice.add(numOfName);

			// 2) 아무것도 선택하지 않은 상태에서 보이는 레이블
			JLabel[] tmpNumList = new JLabel[6]; // 2차원 배열이므로 하나하나 만들때마다 초기화
			for (int j = 0; j < 6; j++) { // x로 바뀐다면 j는 0부터 시작가능
				ImageIcon tmpNumIcon = new ImageIcon("number/x.gif");
				JLabel num1 = new JLabel(tmpNumIcon);
				// 나중에 사용하기위해 임시로 만든 배열에 저장
				tmpNumList[j] = num1;
				choice.add(num1);
			}
			// 임시로 만든 배열을 실제로 쓸 2차원 배열에 저장
			numOfLottery[i] = tmpNumList;

			// Reset, Confirm buttons
			List<JLabel> lblList = new ArrayList<JLabel>(); // 버튼들을 담을 임시 그릇
			for (int j = 0; j < 2; j++) { // 버튼이 2개 이므로 for 조건도 2보다 작을때까지
				ImageIcon tmpIcon = new ImageIcon(editOfButton[j]); // edit / delete 버튼 누르기
				JLabel tmpLbl = new JLabel(tmpIcon); // 담은 버튼을 담을 임시 저장소
				if (j == 0) {
					tmpLbl.addMouseListener(new NumLblMouseAdapter());
				} else if (j == 1) {
					tmpLbl.addMouseListener(new DeleteAdapter());
				}
				lblList.add(tmpLbl); // 버튼에 임시 저장소에 있는 원소 넣기
				choice.add(tmpLbl); // 임시 버튼을 choice판에 붙이기
			}
			editOfLottery.add(lblList);
			main.add(choice);
		}
		for (int i = 0; i < select; i++) {
			// 숫자 라벨이 총 6개 이므로 6개중 어떤걸 선택해도
			// 해당 라인이 눌려진걸로 인식되도록 for문을 한번 더 씀
			// 해당 라인이 눌려진걸로 인식하는건 LblMouseAdapter 안에 구현해 놓음
			for (int j = 0; j < 6; j++) {
				numOfLottery[i][j].addMouseListener(new NumLblMouseAdapter());
			}
		}
		// next button
		JPanel nextPnl = new JPanel();
		nextPnl.setOpaque(true);
		nextPnl.setBackground(Color.white);

		ImageIcon nextLblIcon = new ImageIcon("Buttons/NEXT.gif");
		JLabel nextLbl = new JLabel(nextLblIcon);

		nextLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (choiceOfwayList[select - 1] == null) {
					JOptionPane.showMessageDialog(null, "모든 숫자를 선택해주세요");
				} else {
					Confirm one = new Confirm(select, selectedNum);
					System.out.println(one.onOff);
					if (one.onOff == 1) {
						System.out.println(111);
						new outcome(selectedNum, select);
					}
					dispose();
				}
			}
		});
		nextPnl.add(nextLbl);
		main.add(nextPnl);
		add(main);
		showGUI();
	}
	private void showGUI() {
		setLocation(500, 200);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
//	레이블에 img 붙일 method생성 
	public void setNumLabel() {	
		for (int i = 0; i < selectedNum.length; i++) {
			int[] tempInt = selectedNum[i];
			System.out.println(Arrays.toString(tempInt));
			JLabel[] tempLbl = numOfLottery[i];					
			for (int j = 0; j < 6; j++) {
				if (tempInt[j] == 0) {
					tempLbl[j].setIcon(new ImageIcon("number/x.gif"));
//					URL tempLblIconURL = SelectingNumber.class.getClassLoader().getResource("x.gif");
//					tempLbl[j].setIcon(new ImageIcon(tempLblIconURL));
				} else {
					tempLbl[j].setIcon(new ImageIcon("number/" + tempInt[j] + ".gif"));
//					URL tempLblIconURL = SelectingNumber.class.getClassLoader().getResource(tempInt[j] + ".gif");
//					tempLbl[j].setIcon(new ImageIcon(tempLblIconURL));
				}
			}
		}
	}

}

