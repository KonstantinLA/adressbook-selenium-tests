package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	public String name;
	public String header;
	public String footer;

	public GroupData(String groupname, String header, String footer) {
		this.name = groupname;
		this.header = header;
		this.footer = footer;
	}
	
	public GroupData() {}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "GroupData [name=" + name + ", header=" + header + ", footer=" + footer + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}
	
	
}