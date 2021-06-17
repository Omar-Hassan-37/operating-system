package osAss2;

import java.util.*;

public class Router extends Thread {
	
	Semaphore sem = null;
	int nCon = 0;
	int nDev = 0;

	Router(){
		sem = new Semaphore();
	}
	
	@Override
	public void run() {
		sem = new Semaphore(nCon);
	}
	
	public void callDevice(String devName) {
		if(devName == "mobile") {
			Mobile dev = new Mobile();
			dev.connect();
			yield();
			dev.preformOnlineActivity();
			yield();
			dev.disConnect();
		}
		if(devName == "tablet") {
			Tablet dev1 = new Tablet();
			dev1.connect();
			yield();
			dev1.preformOnlineActivity();
			yield();
			dev1.disConnect();
		}
		if(devName == "pc") {
			PC dev2 = new PC();
			dev2.connect();
			yield();
			dev2.preformOnlineActivity();
			yield();
			dev2.disConnect();
		}
	}
}
