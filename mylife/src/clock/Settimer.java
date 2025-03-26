package clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.Timer;
 

public class Settimer {

	public static void main(String[] args) {
		Timer t = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				System.out.println("안녕");
			}
		};
		
		
		t.schedule(task, 3000); // schedule(task를 , ~ms마다 수행);
		
		
	}

}
