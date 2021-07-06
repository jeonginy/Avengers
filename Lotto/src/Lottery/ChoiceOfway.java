package Lottery;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

class RadioActionListener implements ActionListener {
	List<List<JRadioButton>> check;
	List<Integer> selectedNumber;

	public RadioActionListener(List<List<JRadioButton>> check, List<Integer> selectedNumber) {
		this.check = check;
		this.selectedNumber = selectedNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int tmp2 = 0;
		for (int i = 0; i < this.check.size(); i++) {
			List<JRadioButton> tmp = this.check.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				tmp2 = (i * 7) + j + 1;
				if (tmp.get(j).isSelected()) {
					if (!this.selectedNumber.contains(tmp2))
						this.selectedNumber.add(tmp2);
				}
				if (this.selectedNumber.size() > 6) {
					tmp.get(j).setSelected(false);
					JOptionPane.showMessageDialog(null, "6개 이하만 선택해주세요");
				}
				if (this.selectedNumber.contains(tmp2) && !tmp.get(j).isSelected())
					this.selectedNumber.remove(this.selectedNumber.indexOf(tmp2));
			}
		}
	}
}

class ChoiceOfway extends JFrame {
	/*
	 * 3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 장당 1,000 총 금액 : 번 호 >> 반자동, 초기화
	 * 확인, 구매하기
	 */
	List<List<JRadioButton>> check = new ArrayList<>();

	List<Integer> selectedNumberList; // 선택한 숫자 저장
	JPanel selectionPop;
	JPanel lottoPnl;
	JLabel price;
	JPanel btnPanel;
	JButton auto;
	JButton reset;
	JButton confirm;
	List<JLabel> numOfLottery;

	public ChoiceOfway(JLabel[] numOfLottery, int[] selectedNumber) {
		// SelectingNumber class의 선택한 숫자 list를 가져와서 여기에서 숫자 저장
		selectedNumberList = new ArrayList<>();
		
		// 전체 로또 판때기
		selectionPop = new JPanel();
		selectionPop.setLayout(new BoxLayout(selectionPop, BoxLayout.Y_AXIS));

		// 로또 금액, 숫자
		lottoPnl = new JPanel();

		lottoPnl.setLayout(new BoxLayout(lottoPnl, BoxLayout.Y_AXIS));
		price = new JLabel("금액 : 1,000원(장당)");
		lottoPnl.add(price);

		addLottoRadio(lottoPnl);

		// 확인 및 수정 버튼
		btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());

		auto = new JButton("자동");
		auto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MakeNumber.randomNum(selectedNumberList);
				for (int i = 0; i < check.size(); i++) {
					List<JRadioButton> tmp = check.get(i);
					for (int j = 0; j < tmp.size(); j++) {
						int tmp2 = (i * 7) + j + 1;
						if (selectedNumberList.contains(tmp2))
							tmp.get(j).setSelected(true);
						else
							tmp.get(j).setSelected(false);
					}
				}
			}
		});

		reset = new JButton("초기화");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < check.size(); i++) {
					List<JRadioButton> tmp = check.get(i);
					for (int j = 0; j < tmp.size(); j++) {
						tmp.get(j).setSelected(false);
					}
				}
				selectedNumberList.clear();
			}
		});

		confirm = new JButton("확인");
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedNumberList.size() != 6)
					JOptionPane.showMessageDialog(null, "6개를 선택하세요");
				else {
					Collections.sort(selectedNumberList);
					for (int i = 0; i < 6; i++) {
						int tmp = selectedNumberList.get(i);
						selectedNumber[i] = tmp;
						ImageIcon tmpIcon = new ImageIcon("number\\" + tmp + ".gif");
						numOfLottery[i].setIcon(tmpIcon);
					}
					dispose();
				}
			}
		});

		btnPanel.add(auto);
		btnPanel.add(reset);
		btnPanel.add(confirm);

		// 전체 창에 로또 금액 숫자, 확인 및 수정 버튼 추가
		selectionPop.add(lottoPnl);
		selectionPop.add(btnPanel);

		// 전체 로또 판때기에 부착
		add(selectionPop);
		showGUI();
	}

	public void callSelectionPop() {
		remove(selectionPop);
		add(selectionPop);
		showGUI();
	}

	private void modLottoRadio(JPanel lottoPnl) {
		for (int i = 0; i < check.size(); i++) {
			JPanel lottoTemp = new JPanel();
			if (i == 6)
				lottoTemp.setLayout(new FlowLayout(FlowLayout.LEFT));
			else
				lottoTemp.setLayout(new FlowLayout());
			List<JRadioButton> tempRadList = check.get(i);
			for (int j = 0; j < tempRadList.size(); j++) {
				int tmpNum = (i * 7) + j + 1;
				lottoTemp.add(tempRadList.get(j));
				if (selectedNumberList.contains(tmpNum))
					tempRadList.get(j).setSelected(true);
				else
					tempRadList.get(j).setSelected(false);
			}
			lottoPnl.add(lottoTemp);
			check.add(tempRadList);
		}
	}

	private void addLottoRadio(JPanel lottoPnl) {
		for (int i = 0; i < 7; i++) {
			JPanel lottoTemp = new JPanel();
			if (i == 6)
				lottoTemp.setLayout(new FlowLayout(FlowLayout.LEFT));
			else
				lottoTemp.setLayout(new FlowLayout());
			List<JRadioButton> tempRadList = new ArrayList<JRadioButton>();
			for (int j = 0; j < 7; j++) {
				if (i == 6 && j > 2)
					break;
				int tmp = (i * 7) + j + 1;
				ImageIcon tmpIcon = new ImageIcon("number\\" + tmp + ".gif");
				JRadioButton radioTemp = new JRadioButton();
				JLabel tmpLbl = new JLabel(tmpIcon);
				radioTemp.addActionListener(new RadioActionListener(check, selectedNumberList));
				lottoTemp.add(radioTemp);
				lottoTemp.add(tmpLbl);
				tempRadList.add(radioTemp);
			}
			lottoPnl.add(lottoTemp);
			check.add(tempRadList);
		}
	}

	private void showGUI() {
//		setSize(500, 500);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
