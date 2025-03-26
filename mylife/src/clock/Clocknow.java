package clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clocknow {
	

	public static void main(String[] args) {
		LocalTime timenow = LocalTime.now();
		//DateTimeFormatter form = DateTimeFormatter.ofPattern("hh:mm:ss"); 시:분:초 형태로 hh는 12시간형태
		//String strtime = timenow.format(form);
		
		String apm;
		
		int nowH = timenow.getHour(); //timenow의 결과에서 시간만 입력
		int nowM = timenow.getMinute(); //분 만 입력
		int nowS = timenow.getSecond(); //초 만 입력
		
		if (nowH >=13) {
			nowH -=12;
			apm = "오후";
		} else {
			apm = "오전";
		}
		
		System.out.printf("%s %02d시 %02d분 %02d초 \n", apm, nowH, nowM, nowS);
	}

}
