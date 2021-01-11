package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Tools.Context;

public class ForNode extends AbstractNode {

	String variable;
	
	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public Object execute(Context context) throws Exception {
		int v = (Integer) this.childrenNode.get(0).execute(context);
		context.getVars().put(variable, v);
		while(true) {
			
			
		if (v > ((Integer)this.childrenNode.get(1).execute(context)))
					break;
		
			
		else {this.childrenNode.get(2).execute(context);
			v += 1;
			context.getVars().put(variable, v);
		}
		}
		return null;
	}
}
