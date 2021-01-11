package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class NotNode extends ConditionNode {

	@Override
	public Object execute(Context context) throws Exception {
		return !(boolean) this.childrenNode.get(0).execute(context);
	}
}
