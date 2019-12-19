package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 模拟用户登录
 */
public class ClientTest {
	public static void main(String[] args) throws IOException, IOException {
		
		Socket s = new Socket("127.0.0.1",8888);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in,"utf-8"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		System.out.println("输入用户名");
		String username=in.readLine();
		out.println(username);
		System.out.println("输入密码");
		String password=in.readLine();
		out.println(password);		
		
		String result = br.readLine();
		
		if(result.equals("accept")){
			System.out.println("请输入1或2");
			String comand=in.readLine();
			out.println(comand);
			String finish = br.readLine();
			if(finish.equals("finish")) {
				out.println("byebye");
				s.close();
			}
		} else {
			System.out.println("result");
			s.close();
		}
		//释放资源
		
	}
}
