package org.eclipse.epsilon.emc.mylyn;

public class PrefixedProperty {
	
	protected String prefix;
	protected String name;
	
	public PrefixedProperty(String prefix, String name) {
		this.prefix = prefix;
		this.name = name;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
