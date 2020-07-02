import java.util.*;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("불러오기 Y/N :");
		String a = sc.next();
		try{
	        //파일 객체 생성
	        File file = new File("./good.txt");
	         //입력 스트림 생성
	         FileReader file_reader = new FileReader(file);
	         int cur = 0;
	         if(a.equals("Y") || a.equals("y")) {
	         while((cur = file_reader.read()) != -1){
	            System.out.print((char)cur);
	            try{Thread.sleep(30);}				//시간 지연
				catch (InterruptedException e) { }	// " 2
	         }}else {
	        	 System.out.print("...");
	         }
	         file_reader.close();
	        }catch (FileNotFoundException e) {
	            e.getStackTrace();
	        }catch(IOException e){
	            e.getStackTrace();
	        }
	}
}
