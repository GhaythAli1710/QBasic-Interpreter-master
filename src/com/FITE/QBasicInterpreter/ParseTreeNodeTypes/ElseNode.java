package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class ElseNode extends AbstractNode {

	public ElseNode() {
		this.typeNameNode = "Else Node";
	}
	@Override
	public Object execute(Context context) throws Exception {
		this.childrenNode.get(0).execute(context);
		return null;
	}
}
