package leetCode;

import java.util.HashMap;

public class LongestSubstring {
	
	/**
	 * 方法1: Hash法
	 * 时间复杂度 O(n^2)
	 * @param s: a string
     * @return: an integer 
	 */
	public  int getByHash(String str){
		if (str == null)
	        return 0;
		//记录当前最大长度
	    int maxLen = 0;
	    
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	    //外层遍历整个字符串
	    for (int i=0; i<str.length(); i++) {
	        map.clear();
	        map.put(str.charAt(i), 1);

	        //内层遍历起始点后的节点
	        for (int j=i+1; j<str.length(); j++) {
	            if (map.get(str.charAt(j)) != null) {
	            	if (j-i > maxLen) {
	    	            maxLen = j-i;
	    	        }
	                break;
	            }
	            map.put(str.charAt(j), 1);
	        }
	    }

	    return maxLen;
	}
	public int getByDP(String str){
		if (str == null)
	        return 0;
	    int maxLen = 0;
	    int index = 0;
	    int lastIndex = 0;

	    int[] dp = new int[str.length()];
	    
	    dp[0] = 1;
	    for (int i=1; i<str.length(); i++) {
	        for (int j=i-1; j>=lastIndex; j--) {
	            if (str.charAt(i) == str.charAt(j)) {
	                dp[i] = i-j;
	                lastIndex = j+1;
	                break;
	            } else if (j == lastIndex){
	                dp[i] = dp[i-1] + 1;
	            }
	        }

	        if (dp[i] > maxLen) {
	            maxLen = dp[i];
	            index = i+1-maxLen;
	        }
	    }

	    return maxLen;
	}
	public static void main(String[] args){
		LongestSubstring ls=new LongestSubstring();
		
		System.out.println(ls.getByHash("abcabdcdfbb"));
	}
}
