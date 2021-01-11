package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class ConstantNode extends ArithmeticExpressionNode {

	private Object value;
		
	public ConstantNode() {
		super();
		value = 0;
		this.typeNameNode = "Constant Node";
	}
	
	@Override
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.typeNameNode + " " + value);
		this.printChildrenNode(prefix + " ");
		
	}


	public ConstantNode(double value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String image) {
		try {
			this.value = Integer.parseInt(image);
		}catch(NumberFormatException e) {
			this.value = Double.parseDouble(image);
		}
	}

	@Override
	public Object execute(Context context) {	
		return value;		
	}
}
