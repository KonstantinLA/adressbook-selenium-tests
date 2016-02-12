package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	public String id;
	private String name;
	private String header;
	private String footer;

	public GroupData(String id, String groupname, String header, String footer) {
		this.id = id;
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

	public GroupData withId(String id) {
		this.id = id;
		return this;
	}
	
	public GroupData withName(String name) {
		this.name = name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}
	
	public String getId() {
		return id;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}
}