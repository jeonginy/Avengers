//package Lottery;
//
//class DeleteAdapter extends MouseAdapter {
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		JLabel deClick = (JLabel) e.getSource(); // 삭제 레이블을 눌렸을 때, 삭제된 열의 값은 = null 밑의 열이 그 위로 올라와야함
//
//		int idx = 0; // 한번 돌아가는 횟수
////		if (deClick != null) {
//			for (; idx < SelectingNumber.editOfLottery.size(); idx++) { // editOfLottery List의 길이만큼 돌아감
//				// 선택된 숫자들의 공간 횟수
//				if (SelectingNumber.editOfLottery.get(idx).contains(deClick)) { // 클릭된 delete 레이블이 deClick을 가지고 있다면 끝
//					break; // 찾은 index 값을 계속해서 써야되기 때문에, 그 값에서 정지
//				}
//			} // if delete -> i = i + 1 && i != 6
//			if (SelectingNumber.choiceOfwayList[idx] == null) // 배열 안에 객체가 저장돼 있기 때문에 null으로 초기화, int라면, 0으로 초기화
//				JOptionPane.showMessageDialog(null, "선택하지 않아 삭제가 불가능합니다", "삭제 에러", JOptionPane.ERROR_MESSAGE);
//			else {
//				if (idx != SelectingNumber.choiceOfwayList.length - 1) { // choicefOfwayList의 index가 마지막 값이 아니고 (마지막이고,)
//					if (SelectingNumber.choiceOfwayList[idx + 1] != null) { // choicefOfwayList의 index + 1이 null이 아니라면
//																			// (null값이면)
//						for (int i = idx; i < SelectingNumber.choiceOfwayList.length; i++) {
//							if (i == SelectingNumber.choiceOfwayList.length - 1) {
//								SelectingNumber.choiceOfwayList[i] = null; // XXXXXX
//								SelectingNumber.selectedNum[i] = new int[6]; // 0000000
//							} else {
//								SelectingNumber.choiceOfwayList[i] = SelectingNumber.choiceOfwayList[i + 1]; // D->C /
//																												// E->D
//								SelectingNumber.selectedNum[i] = SelectingNumber.selectedNum[i + 1];
//							}
//						}
//					} else {
//						SelectingNumber.choiceOfwayList[idx] = null;
//						SelectingNumber.selectedNum[idx] = new int[6];
//					}
//				} else {
//					SelectingNumber.choiceOfwayList[idx] = null;
//					SelectingNumber.selectedNum[idx] = new int[6];
//				}
//				Main.selNum.setNumLabel();
//			}
//	}
//
//public class test {
//
//}
