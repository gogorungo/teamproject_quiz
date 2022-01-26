package phase1;

import java.io.IOException;

public class gameClientWriteMsg extends gameClient {

	public gameClientWriteMsg() {
		start();
	}
	
	@Override
	public void run() {
		
		System.out.println("메세지를 입력하세요");
		String msg = scan.nextLine();
		try {
			bw.write(msg+"\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
