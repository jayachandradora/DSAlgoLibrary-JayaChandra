package intv.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NArrayTree {

	public static void main(String[] args) {
		NTreeNode<Integer> root = new NTreeNode<>(1);
		NTreeNode<Integer> root11 = new NTreeNode<>(11);
		NTreeNode<Integer> root12 = new NTreeNode<>(12);
		NTreeNode<Integer> root13 = new NTreeNode<>(13);
		NTreeNode<Integer> root21 = new NTreeNode<>(21);
		NTreeNode<Integer> root22 = new NTreeNode<>(22);
		NTreeNode<Integer> root31 = new NTreeNode<>(31);
		NTreeNode<Integer> root32 = new NTreeNode<>(32);

		root.children.addAll(Arrays.asList(root11, root12, root13));
		root12.children.addAll(Arrays.asList(root21, root22));
		root21.children.addAll(Arrays.asList(root31, root32));
		NArrayTree tree = new NArrayTree();
		tree.printTree(root);
	}

	public void printTree(NTreeNode<Integer> root) {
		String s = root.data + " = " ;
		for (int i = 0; i < root.children.size(); i++)
			s = s + root.children.get(i).data + ", ";
		
		System.out.println(s);
		for (int i = 0; i < root.children.size(); i++)
			printTree(root.children.get(i));
	}
}

class NTreeNode<T> {
	public T data;
	public List<NTreeNode<Integer>> children;

	public NTreeNode(T data) {
		this.data = data;
		children = new ArrayList<NTreeNode<Integer>>();
	}
}

//https://www.youtube.com/watch?v=FlrON7xVbu4&ab_channel=Codebix