package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * ģ���û���¼
 */
public class ClientTest {
	public static void main(String[] args) throws IOException, IOException {
		
		Socket s = new Socket("127.0.0.1",8888);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in,"utf-8"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		System.out.println("�����û���");
		String username=in.readLine();
		out.println(username);
		System.out.println("��������");
		String password=in.readLine();
		out.println(password);		
		
		String result = br.readLine();
		
		if(result.equals("accept")){
			System.out.println("������1��2");
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
		//�ͷ���Դ
		
	}
}
