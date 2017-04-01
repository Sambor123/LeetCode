package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMP {
	
	public static int[] makeNext(String pattern){
		int petternSize=pattern.length();
		//构建next数组
		int[] next=new int[petternSize];
		next[0]=-1;
		
		int k=0;
		for(int i=1;i<=pattern.length()-1;i++){
			while(k>0&&!(pattern.charAt(k)==pattern.charAt(petternSize-1))){
				k=next[k-1];
			}
			//System.out.println(k+","+i);
			if(k!=-1&&pattern.charAt(k)==pattern.charAt(i)){
				k++;
			}
			next[i]=k;
		}
		
		return next;
	}
	
	public static int KMPCount(String source,String pattern){
		
		int[] next=makeNext(pattern);
		
//		for(int i:next){
//			System.out.println(i);
//		}
		int count=0;
		int i=0,j=0;
		while (i < source.length() && j < pattern.length()) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || source.charAt(i)== pattern.charAt(j)) {
            	i++;
            	j++;
            } else {
	            //如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
            	//System.out.println("j:"+j);
	            j = next[j];
            }
        }
		if (j == pattern.length())
            return i-j;
		return count;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int count=in.nextInt();
		
		List<Integer> result=new ArrayList<>();
		
		int i=0;
		in.nextLine();
        while(i<=count-1&&in.hasNext()) {
        	String pattern =in.nextLine();
        	String source =in.nextLine();
        	
        	result.add(KMPCount(source, pattern));
        	i++;
        }
        for(int j=0;j<=count-1;j++){
        	System.out.println(result.get(j));
        }
        
	}

}
