package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
	
public class TrieTree{
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	//构造TireTree
    	int numOfWord=in.nextInt();
    	
    	//System.out.println("单词个数:"+numOfWord);
    	
    	TreeNode root=new TreeNode(' ',0);
    	
    	int j=0;
        while(j<=numOfWord-1&&in.hasNext()) {
        	String word=in.nextLine();
        	
        	if(word!=null&&!word.equals("")){
        		//System.out.println("添加单词:"+word);
        		
        		TreeNode parent=root;
            	for(int i=0;i<=word.length()-1;i++){
            		
            		if(!parent.childrens.containsKey(word.charAt(i))){
            			TreeNode node=new TreeNode(word.charAt(i),1);
            			parent.childrens.put(word.charAt(i), node);
            		}else{
            			parent.childrens.get(word.charAt(i)).frequence++;
            		}
            		parent=parent.childrens.get(word.charAt(i));
            	}
            	j++;
        	}
        }
        //打印树结构
        //root.print();
        
        
        //添加前缀
        int numOfQuestion=in.nextInt();
    	//System.out.println("前缀个数:"+numOfQuestion);
    	int k=0;
    	
    	List<String> prexs=new ArrayList<>(); 
        while(k<=numOfQuestion-1&&in.hasNext()) {
        	
        	String prex=in.nextLine();
        	
        	if(prex!=null&&!prex.equals("")){
        		//System.out.println("添加前缀:"+prex);
        		prexs.add(prex);
        		k++;
        	}
        	
        }
        
        //System.out.println("开始查找...............");
        //前缀查找
        for(String prex:prexs){
        	//System.out.println("查找:"+prex);
        	TreeNode parent=root;
        	for(int i=0;i<=prex.length()-1;i++){
        		if(!parent.childrens.containsKey(prex.charAt(i))){
        			//System.out.println(parent.frequence);
        			System.out.println(0);
        			break;
        		}else{
        			parent=parent.childrens.get(prex.charAt(i));
        			if(i==prex.length()-1){
        				System.out.println(parent.frequence);
            		}
        		}
        	}
        }
    }
    
	public static class TreeNode{
			
			public char value;
			public int frequence=0;
			
			public Map<Character,TreeNode> childrens=new HashMap<>();
			
			public TreeNode(char value,int frequence) {
				super();
				this.value = value;
				this.frequence=frequence;
			}
			
			public String toString(){
				return "Value:"+value+",Frequence:"+frequence;
			}
			
			public void print(){
				System.out.println(this.toString());
				for(TreeNode node:childrens.values()){
					node.print();
				}
			}
		}
}
