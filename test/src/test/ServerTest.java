package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String username = br.readLine();
		String password = br.readLine();
		
		if(username.equals("admin") && password.equals("123456")){
			out.println("accept");
			String judge = br.readLine();
			if(judge.equals("1")){
				System.out.println("文件传输完成");
			}else if(judge.equals("2")){
				System.out.println("数据库查询完成");
			}
			out.println("finish");
			out.flush();
			s.close();
			ss.close();
		}else{
			out.println("refuse");
			out.flush();
			s.close();
			ss.close();
		}
	}
}
