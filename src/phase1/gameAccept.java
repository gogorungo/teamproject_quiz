package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class gameAccept extends gameServer {
	private Scanner scan;
	
	public gameAccept() {
		//접속자가 있는지 체크하는 쓰레드
		start();	
	}
	
	
	// 접속한 유저를 관리하기 위한 쓰레드
	@Override
	public void run() {
		try {
			// 접속한 유저가 있을 시 소켓을 잇고 br과 bw 연결
			socket = new Socket();
			socket = listener.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			scan = new Scanner(System.in);
			
			// 유저 아이디 입력
			String userId = br.readLine();
			
			//서버의 해시맵으로 전달
			user.put(userId, new gameUser(socket, br, bw));
			
			//서버에 출력. 전체 출력
			System.out.println("[공지] : " + userId + "님이 입장하셨습니다\n");
			new broadcast("[공지] : " + userId + "님이 입장하셨습니다\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
