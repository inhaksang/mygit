package clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clocknow {
	

	public static void main(String[] args) {
		LocalTime timenow = LocalTime.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("hh:mm:ss"); //시:분:초 형태로 hh는 12시간형태
		String strtime = timenow.format(form);
		
		int nowH = timenow.getHour();
		int nowM = timenow.getMinute();
		int nowS = timenow.getSecond();
		
		LocalTime gettime = LocalTime.of(8, 58, 58);
		int getH = gettime.getHour();
		String now0H = String.format("%02d", nowH); // %03d는 최소 3자리, 빈 공간은 0으로 채운다는 의미
		
		System.out.printf("%02d시 %02d분 %02d초 \n", nowH, nowM, nowS);
		//System.out.printf("%02d시",getH);
		

	}

}
