import javax.swing.JOptionPane;

/*	1) 로또 개수, 확인 버튼 -> Combo box
 * 	2) 수동, 반자동, 자동 버튼 Label / 수정, 삭제 버튼 
 * 	3) 번호 고르기 > 자동(반자동), 초기화, 확인 -> 총 금액, 구매하기 버튼 
 * 	4) 당첨번호, 총 구매 수, 재도전, 종료 버튼 
 *    디자인은 전적으로 그림을 그려서 수작업할 예정 + 귀여운 디자인 훔쳐오기 (내 것처럼)
 *    숫자 90개(1~45) : 당첨됐을 때 숫자 색 / 당첨 안됐을 때 숫자 색 
 *    당첨, 낙첨, 1등, 2등, 3등, 4등, 5등 글씨 
 *    로고
 *    모든 버튼의 글씨는 다 디자인으로 감
 */


public class Lotto {

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog(null, "구매하고 싶은 로또 개수를 선택하세요(최대 5개 가능)");
		new Main_choice(input);
	}

}