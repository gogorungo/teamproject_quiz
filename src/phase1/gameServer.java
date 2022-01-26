package phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class gameServer extends Thread {
	// 유저 정보를 담을 해쉬맵
	protected HashMap<String, gameUser> user = new HashMap<String, gameUser>();
	protected ServerSocket listener;
	protected Socket socket;
	protected BufferedReader br;
	protected BufferedWriter bw;
	
	public gameServer() {
		// 포트 준비하고 대기
		try {
			listener = new ServerSocket(9); // 포트 8500
			System.out.println("서버 접속 대기중!");
			// 접속자 승인 및 유저 등록
			new gameAccept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	}
	
	public static void main(String[] args) {
		new gameServer();
	}
}
