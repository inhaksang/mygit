package clock;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clocknow {
	public static int nowH;
	public static int nowM;
	public static int nowS;
	
	public static void timenow() {
		
		LocalTime timenow = LocalTime.now();
		nowH = timenow.getHour(); //timenow의 결과에서 시간만 입력
		nowM = timenow.getMinute(); //분 만 입력
		nowS = timenow.getSecond(); //초 만 입력
	}
	

	public static void main(String[] args) {
		
		timenow();
		
		
		String apm;
		int nowh;
		
		if (nowH >=13) {
			nowh = nowH-12;
			apm = "오후";
		} else {
			nowh = nowH;
			apm = "오전";
		}
		
		System.out.printf("%s %02d시 %02d분 %02d초 \n", apm, nowh, nowM, nowS);
		
		
		Scanner scntimer = new Scanner(System.in);
		
		try {
			int timerH = scntimer.nextInt();
			int timerM = scntimer.nextInt();
			int timerS = scntimer.nextInt();
			
			Settimer.Settimer(timerH, timerM, timerS);
			
			scntimer.close();
		} catch(Exception e) {
			System.out.println("시간 형태가 잘못되었습니다. 00 00 00 형태로 입력하세요");
			
		}
	}

}
