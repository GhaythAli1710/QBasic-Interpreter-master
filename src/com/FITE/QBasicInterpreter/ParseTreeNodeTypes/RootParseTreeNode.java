package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;
/**/
import com.FITE.QBasicInterpreter.Tools.Context;
/**/
public class RootParseTreeNode extends AbstractNode {
	/**/ 
	public RootParseTreeNode() {
		this.typeNameNode = "Root Parse Tree Node";
	}
	/**/
	@Override
	public Object execute(Context context) throws Exception {
		context.startScope();
		for (AbstractNode node : this.childrenNode)
			node.execute(context);
		context.endScope();
		return null;
	}
}
