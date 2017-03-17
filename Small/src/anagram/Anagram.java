//https://github.com/dwyl/english-words
//http://app.aspell.net/create
//https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm#Even.27s_speedup
//http://stackoverflow.com/questions/2000048/stepping-through-all-permutations-one-swap-at-a-time/11916946#11916946

package anagram;

class Anagram {
	public static List<String> getAnagrams(String string) {
		List<String> anagrams = getStringCombos(string);
		
		stripInvalid(anagrams);
		return anagrams;
	}

	
	public static List<String> getStringCombos(String wordStr) {
		List<String> combos = new ArrayList<>();
		char[] string = wordStr.toCharArray();
		
		
		
		
		
		return combos;
	}
	
	public static void stripInvalid(List<String> str) {
		//TODO	
	}
}
