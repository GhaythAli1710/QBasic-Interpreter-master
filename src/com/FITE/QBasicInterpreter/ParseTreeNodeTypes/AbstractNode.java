package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;
/**/
import com.FITE.QBasicInterpreter.Tools.Context;
import java.util.ArrayList;
/**/
public abstract class AbstractNode {
	/*
	 *  ATTRIBUTES */
	protected String typeNameNode;
	protected ArrayList<AbstractNode> childrenNode = new ArrayList<AbstractNode>();
	/* 
	 * GETTER AND SETTER */
	public String getTypeNameNode() {
		return this.typeNameNode;
	}	
	public void setTypeNode(String type) {
		this.typeNameNode = type;
	}	
	public ArrayList<AbstractNode> getChildrenNode() {
		return this.childrenNode;
	}
	public void addChildToNode(AbstractNode child) {
		this.childrenNode.add(child);
	}	
	/* 
	 * FUNCS */
	public abstract Object execute(Context context) throws Exception;	
	/*
	 *  PRINT */ 
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.getTypeNameNode());
		printChildrenNode(prefix);
	}	
	protected void printChildrenNode(String prefix) {
		for(AbstractNode node : this.childrenNode)
			node.printSubTree(prefix + "  ");
	}
}
