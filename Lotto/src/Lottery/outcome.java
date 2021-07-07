package Lottery;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/*
4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
*  숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
*  당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
*/
class outcome extends JFrame {
	public outcome(int[][] selectedNum) {

		// 메인 패널
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		/*
		List<Integer> outcomeNum = MakeNumber.randomNum();

		int bonusNum = outcomeNum.get(6); // 보너스넘버
		outcomeNum.remove(6);
		// 1 2 3 4 5 6 + 8
		Collections.sort(outcomeNum);
*/
		List<Integer> outcomeNum = new ArrayList<>();
		outcomeNum.add(1);
		outcomeNum.add(2);
		outcomeNum.add(3);
		outcomeNum.add(4);
		outcomeNum.add(5);
		outcomeNum.add(6);
		int bonusNum = 7;
		// 당첨 숫자용 패널
		JPanel winNumPnl = new JPanel();

		ImageIcon winNumIcon = new ImageIcon("Score/winningNum.gif");
		JLabel winNum = new JLabel(winNumIcon);
		winNumPnl.add(winNum);

		for (int i = 0; i < 6; i++) {
			int nowNum = outcomeNum.get(i);
			ImageIcon nowWinNumIcon = new ImageIcon("number/" + nowNum + ".gif");
			JLabel nowWinNum = new JLabel(nowWinNumIcon);
			winNumPnl.add(nowWinNum);
		}

		JPanel imDone = new JPanel();

		for (int i = 0; i < selectedNum.length; i++) {
			int count = 0;
			boolean bonusChk = false; // 보너스 번호를 가졌는지 아닌지 체크

			for (int j = 0; j < 6; j++) {
				int tmpNum = selectedNum[i][j];
				boolean checkNum = outcomeNum.contains(tmpNum);
				if (checkNum) {
					// 라벨 추가 당첨이니까 컬러 라벨 imageicon("number/" + 숫자 + ".gif")
					JLabel ociamge = new JLabel();
					ImageIcon img = new ImageIcon("number/" + tmpNum + ".gif");
					winNum.add(ociamge);
					count++;
				} else {
					// 라벨 추가 미당첨이니까 흑백 라벨 imageicon("number/" + 숫자 + "b.gif")
					JLabel ociamge2 = new JLabel();
					ImageIcon img = new ImageIcon("number/" + tmpNum + "b.gif");
					winNum.add(ociamge2);
				}
				if (tmpNum == bonusNum)
					bonusChk = true; // 보너스 넘버를 가지고 있는걸 체크함
			}
			// 한묶음의 선택한 숫자 당첨 확인이 끝나고 나서
			// count가 5라면 이 배열이 뽀나쓰 넘버를 들고있는지 확인해야함
			// 왜냐하면 2등은 숫자 5개와 뽀나쓰 넘버가 맞을때 이기 때문
			if (count == 5 && bonusChk) { // 이건 2등

			} else {
				JLabel realResult = new JLabel();
				switch (count) {
				case 6:
					ImageIcon tmp = new ImageIcon("Score/1st.gif");
					realResult = new JLabel(tmp);
					break;
				case 5:
					ImageIcon tmp2 = new ImageIcon("Score/1st.gif");
					realResult = new JLabel(tmp2);
					break;
				case 4:
					ImageIcon tmp3 = new ImageIcon("Score/4th.gif");
					realResult = new JLabel(tmp3);
					break;
				case 3:
					ImageIcon tmp4 = new ImageIcon("Score/5th.gif");
					realResult = new JLabel(tmp4);
					break;
				default:
					ImageIcon tmp5 = new ImageIcon("Score/unlucky.gif");
					realResult = new JLabel(tmp5);
					break;
				}
				imDone.add(realResult);
			}

		}
		result.add(winNumPnl);
		result.add(imDone);
		add(result);

		showGUI();
	}

	private void showGUI() {
//		setSize(500, 500);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}