package project_1212;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:/_JAVA/file1.txt");
			int data;
			try {
				while((data = fis.read()) != -1) {
					System.out.println(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
