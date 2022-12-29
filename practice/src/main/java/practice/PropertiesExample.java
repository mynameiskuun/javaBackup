package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		String path = PropertiesExample.class.getResource("db.properties").getPath();
		// 클래스 파일이 위치한 경로에서 db.properties라는 파일을 읽는다.
		
		// path = URLDecoder.decode(path, "utf-8");
		// 혹시 utf-8로 디코딩이 제대로 되지 않을 경우를 대비해 적어준다.
		
		properties.load(new FileReader(path));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		System.out.println(driver);
		System.out.println(url);
	}

}
