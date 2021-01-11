package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;
import java.util.Scanner;

import com.FITE.QBasicInterpreter.Exception.RunTimeException;
import com.FITE.QBasicInterpreter.Tools.Context;
public class InputNode extends AbstractNode {

	public InputNode() {
		this.typeNameNode = "Input Node";
	}
	
	private String varName;
	
	@Override
	public void printSubTree(String prefix) {
		// TODO Auto-generated method stub
		System.out.println(prefix + this.typeNameNode + " var Name "+ varName);
		printChildrenNode(prefix);
	}

	@SuppressWarnings("resource")
	@Override
	public Object execute(Context context) throws RunTimeException {
		context.put(varName, new Scanner(System.in).next());
		return null;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
}
