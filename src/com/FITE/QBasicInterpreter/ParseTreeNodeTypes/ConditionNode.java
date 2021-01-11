package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Exception.RunTimeException;
import com.FITE.QBasicInterpreter.Tools.Context;

public class ConditionNode extends AbstractNode {
	
	public ConditionNode() {
		this.typeNameNode  = "Condition Node";
	}
	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.typeNameNode + " : operation " + operation);
		printChildrenNode(prefix);
	}
	
	private boolean calc(double d1, double d2) {
		switch(this.operation)
		{
		case ">":
			return d1>d2;
		case "<":
			return d1<d2;
		case ">=":
			return d1>=d2;
		case "<=":
			return d1<=d2;
		case"<>":
			return Math.abs(d1 - d2) > 1e-6;
		case "=":
			return Math.abs(d1 - d2) < 1e-6;
		default:
			return false;
		}
	}
	@Override
	public Object execute(Context context) throws Exception {
		Object b1 = this.childrenNode.get(0).execute(context);
		Object b2 = this.childrenNode.get(1).execute(context);
		try {
			if(b1 instanceof Integer) {
				int d1 = (int) b1;
				if(b2 instanceof Integer) {
					int d2 = (int) b2;
					return calc(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return calc(d1, d2);
				}
			}
			else{
				double d1 = (double) b1;
				if(b2 instanceof Integer) {
					int d2 = (int) b2;
					return calc(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return calc(d1, d2);
				}
			}	
		}
		catch(ClassCastException e) {
				switch (operation) {
				case "=":
					return b1.equals(b2);
				case "<>":
					return !b1.equals(b2);
				default:
					throw new RunTimeException("operation " + operation + " on strings is not supported");
				}
		}
	}
}
