package leetCode;

import java.util.Scanner;
	
public class Legendary{
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	String[] str=in.nextLine().split(" ");
    	int P=Integer.parseInt(str[0]);
    	int Q=Integer.parseInt(str[1]);
    	int N=Integer.parseInt(str[2]);
    	
    	int PP=P;
    	
    	TreeNode root=new TreeNode(100,0,0);
    	buildTree(root,P,Q,N,PP);
    	
    	double result=calTree(root);
    	
    	System.out.println(result);
    }
    
    private static double calTree(TreeNode root) {
		
		if(root.left==null&&root.right==null){
			return root.depth*((double)root.probability)/100;
		}else{
			if(root.left!=null&&root.right==null){
				return (((double)root.probability)/100)*(calTree(root.left));
			}else{
				return (((double)root.probability)/100)*(calTree(root.left)+calTree(root.right));
			}
		}
	}

	private static int cal(int p,int i){
    	return (int) Math.floor(p/Math.pow(2, i));
    }
	private static void buildTree(TreeNode root, int p, int q, int n,int PP) {
		
		TreeNode left=new TreeNode(p,root.item+1,root.depth+1);
		root.setLeft(left);
		
		if(left.item<n){
			
			int newP=cal(PP,left.item);
			
			buildTree(left, newP, q, n,PP);
		}
		
		if(p<100){
			TreeNode right=new TreeNode(100-p,root.item,root.depth+1);
			root.setRight(right);
			
			int newP=0;
			if(p+q<100){
				newP=p+q;
			}else{
				newP=100;
			}
			
			buildTree(right, newP, q, n,PP);
		}
	}

	public static class TreeNode{
			int probability;//0-100
			int item;
			int depth;
			TreeNode left;
			TreeNode right;
			
			public int getProbability() {
				return probability;
			}

			public void setProbability(int probability) {
				this.probability = probability;
			}

			public TreeNode getLeft() {
				return left;
			}

			public void setLeft(TreeNode left) {
				this.left = left;
			}

			public TreeNode getRight() {
				return right;
			}

			public void setRight(TreeNode right) {
				this.right = right;
			}

			public TreeNode(int probability,int item,int depth) {
				super();
				this.probability = probability;
				this.item=item;
				this.depth=depth;
			}
	}
}
