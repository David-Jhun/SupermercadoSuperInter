package thread;

import controller.UniversalController;

public class ThreadClock2 extends Thread{
	
	private UniversalController controller;
	
	private String time;
	
	public ThreadClock2( UniversalController controller,  String time) {
		this.controller = controller;
		this.time = time;
	}
	
	@Override
	public void run() {
		controller.updateTime(time);
	}

}
