package allcombos;

import util.Util;

public class AllCombos {
	public static void main(String[] args) {
		final String str = "1,2,3";
		int[] array = Util.StringTo1DArray(str);
//		Util.printArray(array);

//		allCombos(array);
	}

//	static void permute(List<Integer> arr, int k){
//		for (int i = k;i<arr.size();i++){
//			Util.swap(i, k, arr);
//			permute(arr, k+1);
//			Util.swap(i, k, arr);
//		}
//		if (k==arr.size()-1){
//			Util.printArray(arr);
//		}
//	}

//	private static void allCombos(int[] array) {
//		List<Integer> arr = new ArrayList<>();
//		for (int i = 0;i<array.length;i++) arr.add(array[i]);
//
//		permute(arr, 0);
//
//
//	}

}
