package eu.codecache.haagahelia.tehtava2.domain;

import javax.validation.constraints.Size;

public class Friend implements Comparable<Friend> {
	private long id;
	@Size(min=2, max=50)
	private String name;

	public Friend() {
	}

	public Friend(String name) {
		this.name = name;
	}

	public Friend(long id, String name) {
		this(name);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Friend o) {
		return name.compareTo(o.name);
	}

}
