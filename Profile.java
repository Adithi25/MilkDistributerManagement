package jdbcexample;

public class Profile {
	private String name;
	private String address;
	private int id;
	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile() {
		super();
	}

	public Profile(String name, String address, int id, int uid) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
		this.uid = uid;
	}

}
