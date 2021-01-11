package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;

import com.FITE.QBasicInterpreter.Exception.ReturnException;
import com.FITE.QBasicInterpreter.Exception.RunTimeException;
import com.FITE.QBasicInterpreter.Tools.Context;

public class AssignmentNode extends AbstractNode {
	
	private String varId;
	
	public AssignmentNode() {
		this.typeNameNode = "Assignment Node";
	}

	@Override
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.typeNameNode + " variable " + varId);
		printChildrenNode(prefix);
	}
	public String getvarId() {
		return varId;
	}
	public void setvarId(String varId) {
		this.varId = varId;
	}
	
	private double f(Context context) throws Exception {
		if(this.childrenNode.get(0) instanceof StringNode)
			throw new RunTimeException("operation is not supported");
		double x;
		if(this.childrenNode.get(0) instanceof VariableNode) {
			Object ret = this.childrenNode.get(0).execute(context);
			if(ret instanceof String)
				throw new RunTimeException("operation is not supported");
			if(ret instanceof Integer)
				x = (int) ret;
			else
				x = (double) ret;
		}
		else
			x = (double) this.childrenNode.get(0).execute(context);
		return x;
	}
	
	@Override
	public Object execute(Context context) throws Exception {
		if(varId.equals("ret")) {
			throw new ReturnException(this.childrenNode.get(0).execute(context));
		}
		if(context.getVars().containsKey(varId)) {
			Object b = context.getVars().get(varId);
			if(b instanceof Double) {
				double x = f(context);
				double value = (double) b;
				
				context.getVars().put(varId, x);
				
				return null;
			}
			if(b instanceof Integer) {
				double x = f(context);
				int value = (int) b;
				context.getVars().put(varId, (int)x);
			
				return null;
			}
			
			if(this.childrenNode.get(0) instanceof VariableNode)
				context.put(varId, (String) this.childrenNode.get(0).execute(context).toString());
			else
			if(this.childrenNode.get(0) instanceof StringNode) {
				if(b instanceof String)
					context.getVars().put(varId, this.childrenNode.get(0).execute(context));
			}
			else
				throw new RunTimeException("operation is not supported");	
		}
		else {
			context.put(varId, (String) this.childrenNode.get(0).execute(context).toString());	
		}
		return null;
	}
}
