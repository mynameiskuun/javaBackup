package project_1129;

public class MaxEx {

	public static void main(String[] args) {

//		int max = 0;
//		int[] array = {1,333,22,6,8888};
//		
//		for(int i=0; i<array.length; i++) {
//			max = array[0];
//			if(max<array[i]) {
//				max = array[i];
//			}
//		}
//		
//		System.out.println("max : " + max);
		
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		double cnt = 0;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				sum += array[i][j];
			}
			cnt += array[i].length;
		}
		
		avg = sum/cnt ;
		
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
	}

}
