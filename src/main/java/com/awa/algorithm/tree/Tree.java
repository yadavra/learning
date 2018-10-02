package com.awa.algorithm.tree;

public interface Tree<E> {
    E getRoot();
	interface Node<E> {
		E getData();

		void setLeftChild(Node<E> lch);

		void setRightChild(Node<E> rch);

		Node<E> getLeftChild();

		Node<E> getRightChild();
       
		void setData(E element); 

	}

	// Opertation on Tree model

	boolean insert(E element);

	boolean delete(E element);

	E find(E element);

	String preOrderTraversal();

	String postOrderTraversal();

	String inorderTraversal();

	int hightOfTree();

	int depthOfTree();

	int depthOfNode();

	int hightOfNode();

}
