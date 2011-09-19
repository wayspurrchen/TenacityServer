package tenacity.Entity.Mind.Data;

import java.util.Vector;

public abstract class Data implements Cloneable {
	protected String type;
	protected String value;
	protected boolean duplicable = false;
	protected boolean inheritMemorizable = false;
	protected int priority;
	
	public Vector<Data> parents = new Vector<Data>();
	public Vector<Data> children = new Vector<Data>();
	
	public Data clone() throws CloneNotSupportedException {
		Data clonedData = (Data) super.clone();
		Vector<Data> tmpChildren = new Vector<Data>();
		for (int i=0;i<children.size();i++) {
			Data child = children.get(i);
			System.out.println("Iterating through "+children.get(i));
			if (child.inheritMemorizable) {
				tmpChildren.add(i,child.clone());
			}
		}
		clonedData.parents = new Vector<Data>();
		clonedData.children = new Vector<Data>();
		for (int i=0;i<tmpChildren.size();i++) {
			clonedData.children.add(tmpChildren.get(i));
		}
		return clonedData;
	}
	
	public String type() {
		return type;
	}
	
	public String value() {
		return value;
	}
	
	public Data getChildrenByType(String type) {
		for (int i = 0;i<children.size();i++) {
			if (children.get(i).type().equals(type)) return children.get(i);
		}
		return null;
	}
	
	public Data getParentsByType(String type) {
		for (int i = 0;i<parents.size();i++) {
			if (parents.get(i).type().equals(type)) return parents.get(i);
		}
		return null;
	}
	
	public void addDataChild(Data data) {
		children.add(data);
	}
	
	public void addDataParent(Data data) {
		parents.add(data);
	}
	
	public void clearChildren() {
		children.removeAllElements();
	}
	
	public void clearParents() {
		parents.removeAllElements();
	}
}
