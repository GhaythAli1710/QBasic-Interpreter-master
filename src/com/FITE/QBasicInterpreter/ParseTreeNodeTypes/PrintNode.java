package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class PrintNode extends AbstractNode {

	public PrintNode() {
		this.typeNameNode = "Print Node";
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		//System.out.println("test");
		System.out.println(childrenNode.get(0).execute(context));
		return null;
	}
}
