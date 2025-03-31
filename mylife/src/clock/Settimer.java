package clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.Timer;
 

public class Settimer {

	public static void Settimer(int h, int m, int s) {
		Timer t = new Timer();
	
		
		
		LocalTime scntime = LocalTime.of(h,m,s);//타이머 설정 시간
		int scnH = scntime.getHour();
		int scnM = scntime.getMinute();
		int scnS = scntime.getSecond();
		
		Clocknow.timenow();
		
		int targetH = Clocknow.nowH + scnH;
		int targetM = Clocknow.nowM + scnM;
		int targetS = Clocknow.nowS + scnS;
		
		int targeth;
		String apm;
		if (targetH >=13) {
			targeth = targetH-12;
			apm = "오후";
		} else {
			targeth = targetH;
			apm = "오전";
		}
		
		int targetTime = 1000*(scnS + 60*(scnM + 60*(scnH))); //ms 단위
		
		
				
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("응애");
			}
		};
		
		System.out.printf("%s %02d시 %02d분 %02d초.\n", apm, Clocknow.nowH, Clocknow.nowM, Clocknow.nowS);
		System.out.printf("%s %02d시 %02d분 %02d초에 알림이 울립니다.\n", apm, targeth, targetM, targetS);
		t.schedule(task, targetTime); // schedule(task를 , ~ms후 수행);
		
		
	}

}
