package jdbcexample;

import java.sql.Connection;

public interface DBInterface {
	public Connection getConnection();

	public void createMember(Profile p);

	public void display();

	public void releaseResources();

}
