package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class AndNode extends ConditionNode {

	public AndNode() {
		super();
		this.typeNameNode = "And Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		boolean b1 = (boolean) this.childrenNode.get(0).execute(context);
		boolean b2 = (boolean) this.childrenNode.get(1).execute(context);

		return b1 && b2;
	}
}
