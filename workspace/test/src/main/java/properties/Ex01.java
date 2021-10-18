package properties;

import java.io.InputStream;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		   //InputStream i = System.in; 
		   //BufferedReader  r = new BufferedReader(new InputStreamReader(i)); 
		   //System.out.println("파일명을 입력하세요"); 
		   //String file = r.readLine(); 


		   Scanner r = new Scanner(System.in); 
		   System.out.println("파일명을 입력하세요"); 
		   String file = r.nextLine(); 

		   System.out.println(file); 
		   
		   while(true) {
			   if((file.indexOf(".") == -1) || file.startsWith(".") || file.endsWith(".")) {
				   System.out.println("잘못 입력됐습니다. 다시 입력해주세요 : ");
				   file = r.nextLine();
				   
				   System.out.println(file);
			   } else {
				   int index = file.indexOf('.');
				   String front = file.substring(0, index);
				   String back = file.substring(index + 1, file.length());
				   
				   System.out.println("파일명 : " + front);
				   System.out.println("확장자 : " + back);
				   break;
				   
			   }
		   }

	}

}
