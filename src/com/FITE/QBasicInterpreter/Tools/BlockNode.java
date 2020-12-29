package com.FITE.QBasicInterpreter.Tools;
/**/
import com.FITE.QBasicInterpreter.ParseTreeNodeTypes.*;
/**/
public class BlockNode extends AbstractNode {
	
	public BlockNode() {
		this.typeNameNode= "Block Node";
	}

	@Override
	public Object execute(Context context) throws Exception {
		context.startScope();
		for (AbstractNode n : this.childrenNode)
			n.execute(context);
		context.endScope();
		return null;
	}
}
