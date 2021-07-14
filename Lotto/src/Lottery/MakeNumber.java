package Lottery;

import java.util.*;

// 랜덤 숫자 만들어내는 클래스 
class MakeNumber {
	private MakeNumber() {
	}
	public static List<Integer> randomNum() {
		List<Integer> randomresult = new ArrayList<>();	//	랜덤 당첨 번호를 뽑을 리스트 
		for( int i = 1; i < 46; i++ ) {
		randomresult.add(i);
		}
		Collections.shuffle(randomresult);
		
		List<Integer> lottoNumber = new ArrayList<>();
		
		for (int i = 0; i < 7; i++) {
			lottoNumber.add(randomresult.get(i));
		}
		
		return lottoNumber;
	}
	public static void randomNum(List<Integer> selectedNumber) {
		List<Integer> lottoNumber = new ArrayList<Integer>();
		Set<Integer> dropNum = new HashSet<>();

		for (int i = 1; i <= 45; i++) {
			lottoNumber.add(i);
		}
//		System.out.println("로또번호 :" + lottoNumber.toString() );

		Collections.shuffle(lottoNumber);
//        System.out.println("섞은 후 : " + lottoNumber.toString());

		// 번호뽑기
		
		for (int i : selectedNumber) {
			dropNum.add(i);
		}
		
		int idx = 0;
		while (dropNum.size() != 6) {
//            System.out.println((i+1)+"번째 번호는 '" + lottoNumber.get(i) + "' 입니다. ");
			dropNum.add(lottoNumber.get(idx++));
		}
		
		for (int tmp : dropNum) {
			if (!selectedNumber.contains(tmp))
				selectedNumber.add(tmp);
		}

	}

}
