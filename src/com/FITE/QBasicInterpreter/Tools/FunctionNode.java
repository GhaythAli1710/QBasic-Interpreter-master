package com.FITE.QBasicInterpreter.Tools;
/**/
import com.FITE.QBasicInterpreter.ParseTreeNodeTypes.*;
import java.util.ArrayList;
import java.util.HashMap;
/**/
public class FunctionNode extends BlockNode {
	
	private ArrayList<String> parIds = new ArrayList<>();
	private ArrayList<String> parTypes = new ArrayList<>();
	private String functionId;
	private FunctionNode ancestor;
	private HashMap<String, FunctionNode> myFunctions = new HashMap<>();
	

	public FunctionNode getAncestor() {
		return ancestor;
	}

	public void setAncestor(FunctionNode ancestor) {
		this.ancestor = ancestor;
	}

	public void addFunction(FunctionNode func) {
		myFunctions.put(func.functionId, func);
	}
	
	public HashMap<String, FunctionNode> getMyFunctions() {
		return myFunctions;
	}


	public ArrayList<String> getParTypes() {
		return parTypes;
	}

	public void setParTypes(ArrayList<String> parTypes) {
		this.parTypes = parTypes;
	}

	public FunctionNode() {
		this.typeNameNode = "Function Node";
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public ArrayList<String> getParIds() {
		return parIds;
	}
	@Override
	public void printSubTree(String prefix) {
		System.out.println(prefix + this.typeNameNode + " " + functionId + " with parameters: " + parIds);
		printChildrenNode(prefix);
	}

	public void setParIds(ArrayList<String> parIds) {
		this.parIds = parIds;
	}
	@Override
	public Object execute(Context context) throws Exception {
		boolean b = Context.privateFunctionMaps.contains(myFunctions);
		if(!b)
			Context.privateFunctionMaps.push(myFunctions);
		Object ret = null;
		try {
			for (AbstractNode n : this.childrenNode)
				n.execute(context);
		}catch(ReturnException e) {
			ret = e.ret;
		}
		if(!b)
			Context.privateFunctionMaps.pop();
		return ret;
	}
	

}
