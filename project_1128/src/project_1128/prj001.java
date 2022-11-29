package project_1128;

import java.util.Scanner;

public class prj001 {
	
	public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      
	      Scanner scan = new Scanner(System.in);
	      boolean run = true;
	      int userN = 0;
	      int placN = 0;
	      int [][]price = null;

	      while (run) {
	         System.out.println("-메 뉴-");
	         System.out.println("1.인원수,방문처입력 2.금액입력 3.출력");
	         System.out.println("5.???  6. ??? 7. 이름 출력 8. 종료");
	         System.out.println("-----------------------------------------");
	         
	         int sele;
	         System.out.print("메뉴숫자입력> ");
	         sele = scan.nextInt();
	         
	         if(sele ==1) {
	            System.out.print("동참한 친구 인원 수 입력해주세요> ");
	            userN = scan.nextInt();
	            System.out.print("지출목록 개수를 입력해주세요> ");
	            placN = scan.nextInt();
	            price = new int [userN][placN];
	            System.out.println("인원 "+userN+"명과 지출 "+placN + "개 선택되었습니다. 각 지출처별 사용금액은 2번메뉴에서 남겨주세요");
	         }
	         System.out.println();
	         
	         // 지출액 입력칸 
	         if(sele ==2) {
	            for(int i=0; i < userN; i++) {
	               for(int j=0; j < placN; j++) {
	                  System.out.println((i+1)+"번째 사람 "+(j+1)+"번째 지출액 입력>");
	                  price[i][j] = scan.nextInt();
	               }
	            }
	         }
	         System.out.println();
	         
	         // 지출액 출력칸 
	         if(sele == 3) {
	            
	        	 // 윗 상단 분류 시작 
	            for(int j=0; j<placN; j++)
		            System.out.print("\t"+(j+1)+"번장소");
		            System.out.print("\t 총액");
		            System.out.print("\t 평균지출");
		            System.out.println();    
	            
		         // 옆 상단 분류 이름 i번만큼 출력 후 아래 반복  시작 
	            for(int i=0; i< userN; i++) {
	               System.out.print((i+1)+"번친구\t");

	               //i번 친구 지출 총액 및 값들 출력 
	               int summ = 0; 
	               double avg = 0;
	               for(int j=0; j< placN; j++) {
	                  summ += price[i][j]; // i번 친구들의 총액 .
	                  System.out.print(price[i][j]+"\t"); //지출액 출력 
	               }               
	               System.out.print(summ+"\t"); // i번 친구들 총액 출력 
	               avg = (double)summ/(double)placN; 
	               System.out.print(avg); //i번째 친구들 평균지출
	               System.out.println(); // 줄바꿈 
	            }
	             System.out.print("지출합 \t");
		             int summ = 0;
		             double avg = 0;		
		             for(int i=0; i<placN; i++) {
		               int sum = 0;
		               for(int j=0;j<userN;j++) {
		            	   sum += price[j][i]; // i열과 j열 뒤바꿈. 그의 합 
		               }
		               summ += sum;
		               System.out.print(sum+"\t");
		            }
		            System.out.print(summ+"\t");
		            avg = (double)summ/(double)placN;
		            System.out.print(avg);            
		            System.out.println();            
	         }
	      }
	   }
	}


