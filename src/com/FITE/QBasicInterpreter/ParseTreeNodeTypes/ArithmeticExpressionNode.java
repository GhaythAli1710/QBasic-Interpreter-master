package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Exception.RunTimeException;
import com.FITE.QBasicInterpreter.Tools.Context;

/**/
public class ArithmeticExpressionNode extends AbstractNode {

	protected String operation;

	public ArithmeticExpressionNode() {
		this.typeNameNode = "Expression Node";
	}
	
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
			this.operation = operation;
	}
	
	double calculate(double d1, double d2) {
		switch(this.operation)
		{
		case "+" :
			return d1 + d2;
		case "-" :
			return d1 - d2;
		case "*" :
			return d1 * d2;
		case "/" :
			return d1 / d2;
		case "^" :
			return Math.pow(d1, d2);
		default:
			return 0;
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
					return (int)this.calculate(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return this.calculate(d1, d2);
				}
			}
			else{
				double d1 = (double) b1;
				if(b2 instanceof Integer) {
					int d2 = (int) b2;
					return this.calculate(d1, d2);
				}
				else {
					double d2 = (double) b2;
					return this.calculate(d1, d2);
				}
			}
		}catch(ClassCastException e) {
			throw new RunTimeException("operations on strings is not supported");
		}
	}

	@Override
	public void printSubTree(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + this.typeNameNode + " operation " + this.operation);
		printChildrenNode(prefix);
		
	}
}
