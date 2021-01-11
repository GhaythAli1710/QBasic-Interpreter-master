package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Exception.RunTimeException;
import com.FITE.QBasicInterpreter.Tools.Context;

public class VariableNode extends ArithmeticExpressionNode {

	private String varId;
	
	public VariableNode() {
		super();
		this.typeNameNode = "Variable Node";
	}
	
	public VariableNode(String s) {
		this.varId = s;
		this.typeNameNode= "Variable Node";
	}

	public String getVarId() {
		return varId;
	}

	public void setVarId(String varId) {
		this.varId = varId;
	}
	
	@Override
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.typeNameNode + " " + varId);
		printChildrenNode(prefix + " ");
		
	}

	@Override
	public Object execute(Context context) throws Exception {
		if(context.getVars().containsKey(varId)) 
			return context.getVars().get(varId);
		else
			throw new RunTimeException("variable " + varId + " is not defined");
		
	}

}
