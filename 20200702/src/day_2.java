public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayData ad = new ArrayData();
		int total = 0;
		
		String[] arr = ad.arry1;
		
		for(int i = 1; i < arr.length-3; i++) {
			total += Integer.parseInt(arr[i]);
		}
		
		arr[arr.length-3] = Integer.toString(total);
		arr[arr.length-2] = Integer.toString(total/(arr.length-4));
			if(Integer.parseInt(arr[arr.length-2]) >= 90) {
				arr[arr.length-1] = "수";
			}else if(Integer.parseInt(arr[arr.length-2]) >= 80) {
				arr[arr.length-1] = "우";
			}else if(Integer.parseInt(arr[arr.length-2]) >= 70) {
				arr[arr.length-1] = "미";
			}else if(Integer.parseInt(arr[arr.length-2]) >= 60) {
				arr[arr.length-1] = "양";
			}else{
				arr[arr.length-1] = "가";
			}
		
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"/");
		}
	}

}
