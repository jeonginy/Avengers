package Lottery;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
*  숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
*  당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
*/ 
class outcome {
	public outcome(int[][] selectedNum) {
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		
//		String a = "";
		List<Integer> outcomeNum = MakeNumber.randomNum();
		
		int bonusNum = outcomeNum.get(6);
		outcomeNum.remove(6);
		// 1 2 3 4 5 6 + 8
		Collections.sort(outcomeNum);
		
		JPanel winNumPnl = new JPanel();
		ImageIcon winNumIcon = new ImageIcon("Score\\winningNum.gif");
		JLabel winNum = new JLabel(winNumIcon);
		winNumPnl.add(winNum);
		
		for (int i = 0; i < 7; i++) {
			int nowNum = outcomeNum.get(i);
			ImageIcon winNumsIcon = new ImageIcon("number\\" + nowNum + ".gif");
			JLabel winNums = new JLabel(winNumsIcon);
			winNumPnl.add(winNums);
		}
		
		for (int i = 0; i < selectedNum.length; i++) {
			int count = 0;
			boolean bonusChk = false;
			
			for (int j = 0; j < 6; j++) {
				int tmpNum = selectedNum[i][j];
				boolean checkNum = outcomeNum.contains(tmpNum);
				if (checkNum) {
					// 라벨 추가 당첨이니까 컬러 라벨 imageicon("number\\" + 숫자 + ".gif")
					
					count++;
				}
				else {
					// 라벨 추가 미당첨이니까 흑백 라벨 imageicon("number\\" + 숫자 + "b.gif")
					
				}
				if (tmpNum == bonusNum)
					bonusChk = true;
			}
			
			// 한묶음의 선택한 숫자 당첨 확인이 끝나고 나서
			// count가 5라면 이 배열이 뽀나쓰 넘버를 들고있는지 확인해야함
			// 왜냐하면 2등은 숫자 5개와 뽀나쓰 넘버가 맞을때 이기 때문
			if (count == 5 && bonusChk) { // 이건 2등
				
			}
			
			// 밑으로는 switch를 쓰던지 if를 쓰던지 알아서 하시오
			// count = 6 -> 1등
			// count = 5 -> 3등
			// count = 4 -> 4등
			// count = 3 -> 5등
			
		}
	}
	
}




