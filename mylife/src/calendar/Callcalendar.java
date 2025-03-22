package calendar;

import java.util.Scanner; //Scanner: 입력 받을수 있음
import java.time.LocalDate; // LocalDate date = LocalDate.of(YYYY,MM,DD);
import java.time.LocalTime; // LocalTime time = LocalTime.of(hh,mm,ss);
import java.time.LocalDateTime; // LocalDateTime datetime = LocalDateTime.of(YYYY,MM,DD,hh,mm,ss);

public class Callcalendar {
	
	static void notint() { //아무것도 안 적으면 default, 같은 패키지 내에서만 사용 가능, private는 해당 클래스에서만 사용 가능
		System.out.print("올바르지 않은 값 ('YYYY MM DD' 형태로 입력하세요)");
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); //Sy stem: 표준 입출력 기능, in: 입력
		
		LocalDate today = LocalDate.now(); //현재 날짜 가져오기
		
		boolean t=true;
		
		int y = today.getYear(), m = today.getMonthValue(), d = today.getDayOfMonth();
		String[] yyyymmdd = new String[3];
		
		while (t) {
			System.out.print("\n\n\n\n\n");
			MainCalendar.dayprint(y, m, d); //기본 달력 출력
			
			while (true) {
				System.out.print("\n");
				String inputdate = scn.nextLine();
				try {
					yyyymmdd = inputdate.split(" "); // inputdate를 공백을 기준으로 split(분리) 하여 배열에 저장
					y = Integer.parseInt(yyyymmdd[0]); //Integer.parseInt : 정수변환 
					m = Integer.parseInt(yyyymmdd[1]);
					d = Integer.parseInt(yyyymmdd[2]);
					if (m>=13) {
						notint();
						continue;
					}
					if (d>=32 || (d==31 && MainCalendar.m31or30(y, m)<=30) || (d==30 && m==2 && MainCalendar.yoonyear(y)) || (d==29 && m==2 && !MainCalendar.yoonyear(y))) {
						notint();
						continue;
					}
					break;
				} catch (Exception e){
					notint();
				}
			}
			
			
		}

	}

}
