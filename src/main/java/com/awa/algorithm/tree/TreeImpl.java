package com.awa.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeImpl<E> implements Tree<E> {

	Node<E> root;

	public boolean insert(E element) {
		if (root == null) {
			root = new NodeImpl();
			root.setData(element);
			return true;
		} else {
			insertInToTree(root, element);
		}
		return false;
	}

	private void insertInToTree(com.awa.algorithm.tree.Tree.Node<E> root, E element) {
		/*
		 * if we keep inserting new element on left child then it will become
		 * skew tree same is true with right child better i guess we should
		 * traverse the tree at level wise and add when find the null .
		 */

		Queue<Node<E>> q = new LinkedList<Node<E>>();
		q.offer(root);
		com.awa.algorithm.tree.Tree.Node<E> currentNode = root;
		while (!q.isEmpty()) {
			com.awa.algorithm.tree.Tree.Node<E> node = q.poll();

			if (node.getLeftChild() == null) {
				Node<E> newNode = new NodeImpl();
				newNode.setData(element);
				node.setLeftChild(newNode);
				break;
			}

			if (node.getRightChild() == null) {
				Node<E> newNode = new NodeImpl();
				newNode.setData(element);
				node.setRightChild(newNode);
				break;
			}
			q.offer(node.getLeftChild());
			q.offer(node.getRightChild());
		}

	}

	public boolean delete(E element) {

		return false;
	}

	public E find(E element) {

		return null;
	}

	public String preOrderTraversal() {

		List<E> datalist = new ArrayList<E>();
		Stack<Node<E>> q = new Stack<Node<E>>();
		
		Node<E> currentNode = root;
		q.push(currentNode);
		while (!q.isEmpty()|| currentNode!=null) {
			if (currentNode != null) {
				if(currentNode!=root && currentNode!=null){
					q.push(currentNode);
				}
				currentNode = currentNode.getLeftChild();

			}else {
				com.awa.algorithm.tree.Tree.Node<E> processingNod = q.pop();
				System.out.println(processingNod);
				datalist.add(processingNod.getData());
				currentNode= processingNod.getRightChild() ;
				
				

			}

		}
		return datalist.toString();

	}

	public String postOrderTraversal() {

		List<E> datalist = new ArrayList<E>();
		Stack<Node<E>> q = new Stack<Node<E>>();
		
		Node<E> currentNode = root;
		q.push(currentNode);
		Node<E> visitedNode =null ;
		while (!q.isEmpty()) {
			currentNode=q.peek();
			if (visitedNode == null || ( visitedNode.getLeftChild()==currentNode || visitedNode.getRightChild()==currentNode  )) {
				if(currentNode.getLeftChild()!=null){
					q.push(currentNode.getLeftChild());
				}

			}else if(currentNode.getLeftChild()==visitedNode) {
				if(currentNode.getRightChild()!=null){
					q.push(currentNode.getRightChild());
				}
			}else {
				com.awa.algorithm.tree.Tree.Node<E> processingNod = q.pop();
				System.out.println(processingNod);
				datalist.add(processingNod.getData());
			}
			visitedNode =currentNode ;
		}
		return datalist.toString();
	}

	public String inorderTraversal() {
       //In order Left Root Right    
		List<E> datalist = new ArrayList<E>();
		Stack<Node<E>> q = new Stack<Node<E>>();
		
		Node<E> currentNode = root;
		q.push(currentNode);
		while (!q.isEmpty()|| currentNode!=null) {
			if (currentNode != null) {
				if(currentNode!=root && currentNode!=null){
					q.push(currentNode);
				}
				currentNode = currentNode.getLeftChild();

			}else {
				com.awa.algorithm.tree.Tree.Node<E> processingNod = q.pop();
				System.out.println(processingNod);
				datalist.add(processingNod.getData());
				currentNode= processingNod.getRightChild() ;
				
				

			}

		}
		return datalist.toString();
	}

	public int hightOfTree() {

		return 0;
	}

	public int depthOfTree() {

		return 0;
	}

	public int depthOfNode() {

		return 0;
	}

	public int hightOfNode() {

		return 0;
	}

	private class NodeImpl implements Node<E> {

		private Node<E> lChild;
		private Node<E> rChild;
		E data;

		public E getData() {

			return data;
		}

		public void setLeftChild(Node<E> lch) {
			this.lChild = lch;

		}

		public void setRightChild(Node<E> rch) {
			this.rChild = rch;

		}

		public Node<E> getLeftChild() {

			return lChild;
		}

		public Node<E> getRightChild() {

			return rChild;
		}

		public void setData(E element) {
			this.data = element;
		}

	}

	public E getRoot() {
		// TODO Auto-generated method stub
		return this.root.getData();
	}
}
