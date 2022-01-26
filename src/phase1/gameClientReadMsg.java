package phase1;

import java.io.IOException;

public class gameClientReadMsg extends gameClient {
	
	
	public gameClientReadMsg() {
		start();
	}
	@Override
	public void run() {
		try {
			String serverMsg = br.readLine();
			System.out.println(serverMsg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
