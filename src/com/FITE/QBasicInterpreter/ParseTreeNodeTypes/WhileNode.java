package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class WhileNode extends AbstractNode {
	
	public WhileNode() {
		this.typeNameNode = "While Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		while((Boolean)this.childrenNode.get(0).execute(context))
		{
			this.childrenNode.get(1).execute(context);
		}
		return null;
	}
}
