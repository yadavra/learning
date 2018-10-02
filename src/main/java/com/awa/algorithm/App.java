package com.awa.algorithm;

import com.awa.algorithm.tree.Tree;
import com.awa.algorithm.tree.TreeImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     
        
        Tree<String> t = new TreeImpl<String>() ;
        t.insert("1");
        t.insert("2");
        t.insert("3");
        t.insert("4");
        t.insert("5");
        t.insert("6");
        t.insert("7");
        System.out.println( "Hello Root" + t.preOrderTraversal() );
    }
}
