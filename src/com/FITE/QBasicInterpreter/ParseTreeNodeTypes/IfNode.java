package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class IfNode extends AbstractNode {

	public IfNode() {
		this.typeNameNode = "If Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		if ((Boolean)this.childrenNode.get(0).execute(context))
			this.childrenNode.get(1).execute(context);
		else if (this.childrenNode.size() > 2)
			this.childrenNode.get(2).execute(context);
		
		return null;
	}
}
