package com.FITE.QBasicInterpreter.Tools;
/**/
import java.util.*;

import com.FITE.QBasicInterpreter.Exception.RunTimeException;
/**/
public class Context implements Cloneable{
	/**/
	private HashMap<String,Object> vars = new HashMap<>();
	private Stack<HashMap<String, Object>> stack = new Stack<>();
	/**/
	public HashMap<String, Object> getVars() {
		return vars;
	}
	/**/
	@SuppressWarnings("unchecked")
	public void startScope() {
		stack.push((HashMap<String, Object>) vars.clone());
	}
	
	public void endScope() {
		HashMap<String, Object> top = stack.pop();
		for(String s : vars.keySet())
			if(top.containsKey(s))
				top.put(s, vars.get(s));
		vars = top;
	}
	
	public void findAndput(String varName, Object value, String type) throws RunTimeException {
		if(!vars.containsKey(varName))
			vars.put(varName, value);
		else {
			switch (type) {
			case "char":{
				if(vars.get(varName) instanceof Character)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
				break;
			}
			case "string":{
				if(vars.get(varName) instanceof String)
					vars.put(varName,value);
				else
					throw new RunTimeException("Assignment Error");
				break;
			}
			case "double":{
				if(vars.get(varName) instanceof Double)
					vars.put(varName,value);
				else
					if(vars.get(varName) instanceof Integer) {
						double val = (double) value;
						vars.put(varName, (int) val);
					}
					else
						throw new RunTimeException("Assignment Error");
	
				break;
			}
			case "int":{
				if(vars.get(varName) instanceof Integer)
					vars.put(varName,value);
				else
					if(vars.get(varName) instanceof Double) {
						int val = (int) value;
						vars.put(varName, (double)val);
					}
					else
						throw new RunTimeException("Assignment Error");
				break;
			}

			default:
				break;
			}
		}
	}
	
	public void put(String varName, String value) throws RunTimeException {
		try {
			Integer x = Integer.parseInt(value);
			findAndput(varName, x, "int");
		}catch(NumberFormatException e) {
			try {
				Double x = Double.parseDouble(value);
				findAndput(varName, x, "double");
			} catch (NumberFormatException e1) {
				if(value.length() == 1)
					findAndput(varName, value.charAt(0), "char");
				else
					findAndput(varName, value, "string");
			}
		}
	}
	
	public void createVar(String varName, String varType) throws RunTimeException {
		if(!vars.containsKey(varName))
			switch (varType) {
			case "int":{
				vars.put(varName, new Integer(0));
				break;
			}
			case "char":{
				vars.put(varName, new Character('\0'));
				break;
			}
			case "string":{
				vars.put(varName, new String(""));			
				break;
			}
			case "double":{
				vars.put(varName, new Double(0));
				break;
			}
			default:
				throw new RunTimeException(varType + " is not supported");
			}
		else
			throw new RunTimeException("variable already defined");

	}	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Context copy = new Context();
		for(String key : vars.keySet())
			copy.vars.put(key, vars.get(key));
		return copy;
	}
}
