package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class OrNode extends ConditionNode {

	public OrNode() {
		super();
		this.typeNameNode = "Or Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		boolean b1 = (boolean) this.childrenNode.get(0).execute(context);
		boolean b2 = (boolean) this.childrenNode.get(1).execute(context);

		return b1 || b2;
	}
}
