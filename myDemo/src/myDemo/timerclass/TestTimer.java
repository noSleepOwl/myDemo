package myDemo.timerclass;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时测试类
 * @author uigsw
 *
 */
public class TestTimer {
	
	public static void main(String[] args) {
		new TestTimer(10);
	}
	
	public TestTimer(int seconds){
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(timer),0, seconds*10);
	}
	class MyTimerTask extends TimerTask{
		private Toolkit toolkit;
		private  Timer timer ;
		int numWarningBeeps  = 3000;
		public MyTimerTask(Timer timer) {
			this.timer  = timer;
			toolkit = Toolkit.getDefaultToolkit();
		}

		@Override
		public void run() {
			if(numWarningBeeps  > 0){
				toolkit.beep();
				System.out.println(numWarningBeeps);
				numWarningBeeps--;
			}else{
				System.out.println("timer's up");
				timer.cancel();
				System.out.println("定时结束");
			}
			
		}
	}
}
