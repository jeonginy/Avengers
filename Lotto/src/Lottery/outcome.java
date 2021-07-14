package Lottery;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
*  숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
*  당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
*/
class outcome extends JFrame {
	public outcome(int[][] selectedNum, int select) {
		// 결과 창 판때기 
		JPanel result = new JPanel();
		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

//		String a = "";
		List<Integer> outcomeNum = MakeNumber.randomNum();

		int bonusNum = outcomeNum.get(6); // 보너스넘버
		outcomeNum.remove(6);	//	보너스 넘버 제거하고 차례대로 숫자 오름차순 정리 
		// 1 2 3 4 5 6 + 8
		Collections.sort(outcomeNum);

		//	당첨숫자 붙일 판때기 
		JPanel winNumPnl = new JPanel();
		ImageIcon winNumIcon = new ImageIcon("Score/winningNum.gif");
		JLabel winNum = new JLabel(winNumIcon);	//	당첨숫자 아이콘 레이블에 넣고 판때기에 붙이기 
		winNumPnl.add(winNum);


		for (int i = 0; i < 6; i++) {		//	1-5까지 번호 이미지 레이블에 넣기 
			int nowNum = outcomeNum.get(i);
			ImageIcon winNumsIcon = new ImageIcon("number/" + nowNum + ".gif");
			JLabel winNums = new JLabel(winNumsIcon);
			winNumPnl.add(winNums);
		}
		// 앞서 없앤 보너스 번호 레이블에 붙이기 (" + " + " bonus ")
		ImageIcon bonus = new ImageIcon("number/add.gif");		
		ImageIcon bonus2 = new ImageIcon("number/" + bonusNum + ".gif");
		JLabel lbl;
		JLabel lbl2;

		lbl = new JLabel(bonus);
		lbl2 = new JLabel(bonus2);

		winNumPnl.add(lbl);
		winNumPnl.add(lbl2);

		result.add(winNumPnl);
		//	선택된 숫자 배열의 길이까지 반목문돌려서 보너스 번호 가졌는지 아닌지 체크하고 
//			당첨된 숫자, 미당첨된 숫자 구별하고 이미지 넣고 레이블 붙이기 
		for (int i = 0; i < selectedNum.length; i++) {
			JPanel imDone = new JPanel();	//	1등, 2등, 3등, 4등, 5등 번호붙일 판때기 
			int count = 0;	//	당첨된 숫자 개수 카운팅 
			boolean bonusChk = false; // 보너스 번호를 가졌는지 아닌지 체크

			for (int j = 0; j < 6; j++) {		//	선택된 숫자들이 당첨숫자에 포함돼있으면 보너스 번호 체크 "on"
				int tmpNum = selectedNum[i][j];
				boolean checkNum = outcomeNum.contains(tmpNum);
				if (checkNum) {
					// 라벨 추가 당첨이니까 컬러 라벨 imageicon("number\\" + 숫자 + ".gif")
					ImageIcon img = new ImageIcon("number/" + tmpNum + ".gif");
					JLabel ociamge = new JLabel(img);
//					System.out.println(tmpNum);
					imDone.add(ociamge);
					count++;	//	당첨된 숫자 있으면 카운팅 +1
				} else {
					// 라벨 추가 미당첨이니까 흑백 라벨 imageicon("number\\" + 숫자 + "b.gif")
					ImageIcon img = new ImageIcon("number/" + tmpNum + "b.gif");
					JLabel ociamge2 = new JLabel(img);
//					System.out.println(tmpNum);
					imDone.add(ociamge2);
				}
				if (tmpNum == bonusNum)
					bonusChk = true; // 보너스 넘버를 가지고 있는걸 체크함
			}
			// 한묶음의 선택한 숫자 당첨 확인이 끝나고 나서
			// count가 5라면 이 배열이 뽀나쓰 넘버를 들고있는지 확인해야함
			// 왜냐하면 2등은 숫자 5개와 뽀나쓰 넘버가 맞을때 이기 때문
			if (count == 5 && bonusChk) { // 이건 2등

			} else {
				JLabel realResult = null;
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
			result.add(imDone);
		}
		
		JPanel swing = new JPanel(new FlowLayout());
		JLabel swinglbl = new JLabel("총 구매 수 : " + select );
		JButton swingbtn = new JButton("재도전");
		JButton swingbtn2 = new JButton("종료");
		swingbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		swingbtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		swing.add(swinglbl);
		swing.add(swingbtn);
		swing.add(swingbtn2);
		
		result.add(swing);
		
		add(result);

		showGUI();
	}

	private void showGUI() {
//		setSize(500, 500);
		setLocation(500, 200);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
