package calendar;



public class MainCalendar {
	
	//윤년 계산
	public static boolean yoonyear(int year) {
		boolean yoon = false;
		if ((year%4==0 && year%100!=0) || year%400==0) {
			yoon = true;
		}
		return yoon;
	}
	
	//해당 달이 몇일인지 계산
	public static int m31or30(int y, int m) {
		int tmp=0;
		
		if (m==2) {
			tmp = 28+(yoonyear(y) ? 1 : 0); //+연산이 삼항연산보다 우선이라 괄호필요 
		}	
		else if(m<8)
			tmp = (m%2==1) ? 31 : 30;
		else
			tmp = (m%2==0) ? 31 : 30;
		
		return tmp;
	}
	
	//해당 달 첫날 요일 계산
	public static int dayoftheweek(int y, int m) {
		var yoil = 0; //1일때 월 요 일
		int sum = 0; //1년 1월 1일부터 총 일 수
		
		for (int i = 1 ; i < y ; i++) {
			sum = sum+(yoonyear(i) ? 366 : 365);
		}
		for (int j = 1 ; j < m ; j++) {
			sum = sum+(m31or30(y,j));
		}
		
		yoil = sum % 7+1; //7로 나눈 나머지+1이 다음달 첫날 요일
		return yoil;
	}
	
	
	public static void dayprint(int y, int m, int d) {
		System.out.printf("\t\t%d년 \t%d월\n",y,m);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n"); //\t는 tap
		
		int firstday = dayoftheweek(y,m), lastday = m31or30(y,m);
		
		//1일 요일 기준으로 빈공간 만들기
		if (firstday != 7) {
			for(int i = 0 ; i < firstday ; i++)
				System.out.print("\t");
		}
		
		for(int j = 0 ; j < lastday ; j++) {
			if (j+1==d) {
				System.out.printf("[%d]\t",j+1);
			} else {
				System.out.printf("%d\t",j+1);
			}
			if (firstday%7 == 6) // 토요일일때
				System.out.print("\n");
			
			firstday++;
		}
	}

}
