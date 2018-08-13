package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.sun.crypto.provider.RSACipher;

import sun.security.util.Length;

public class FileDemo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";
		File file = new File(PATH);
		try {
			FileWriter fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw); // true 이어쓰기, false 지우고 다시쓰기
			BufferedReader reader = new BufferedReader(fr);
			while (true) {
				System.out.println("메뉴 1. 전송 2. 읽기 0. 종료");

				switch (s.next()) {
				case "1":
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine(); //라인개행
					writer.flush(); // 전송역할
					break;
				case "2":
					System.out.println("메시지 보기");
					String msg =reader.readLine();
					while((msg =reader.readLine()) !=null) {
						System.out.println(msg);
						
					}
				reader.close();
					break;
				case "0":
					System.out.println("메시지 입력");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileName fn = new FileName(PATH);
		System.out.println("파일명 :" + fn.getFileName());
		System.out.println("확장자 :" + fn.getExt());

	}
}

class FileName {
	// inner Class는 public을 갖지 않는다
	// 이유는 이 클래스 내부에서만 사용하고자 함이다
	// 만약 다른 곳에서 계속 사용한다면 독립시켜야한다
	// 1회용 사용 클래스 라고 생각하자
	private String path, sep, ext, fileName;

	public FileName(String path) {
		this.path = path;
		this.sep = File.separator;
		this.ext = path.substring(path.lastIndexOf(".") + 1);
		this.fileName = path.substring(path.lastIndexOf(sep) + 1, path.lastIndexOf("."));

	}

	public String getPath() {
		return path;
	}

	public String getSep() {
		return sep;
	}

	public String getExt() {
		return ext;
	}

	public String getFileName() {
		return fileName;
	}

}
