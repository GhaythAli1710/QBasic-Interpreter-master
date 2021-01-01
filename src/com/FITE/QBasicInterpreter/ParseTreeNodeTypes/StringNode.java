package com.FITE.QBasicInterpreter.ParseTreeNodeTypes;
/**/
import com.FITE.QBasicInterpreter.Tools.Context;
/**/
public class StringNode extends AbstractNode{
	
	String string;
	
	public StringNode(String image) {
		this.string = image.substring(image.indexOf("\"") + 1, image.lastIndexOf("\""));
	}

	@Override
	public Object execute(Context context) throws Exception {
		return this.string;
	}	
}
