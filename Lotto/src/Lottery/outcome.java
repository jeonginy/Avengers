package Lottery;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
/*
4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
*  숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
*  당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
*/ 
class outcome {
	public outcome(List<Integer> selectedNum) {
		JPanel result = new JPanel();
		result.setLayout(new FlowLayout());
		
		JLabel winNum = new JLabel("당첨번호 : ");
		
		
//		String a = "";
		List<Integer> outcomeNum = MakeNumber.randomNum();
		StringBuilder sb = new StringBuilder();
		for( int i : outcomeNum ) {
//			a += i + " ";
			sb.append(i + " ");
		}
		winNum.setText(sb.toString());
		//		ImageIcon imgOfNum = new ImageIcon("number/");
		
		
	}
	
}




