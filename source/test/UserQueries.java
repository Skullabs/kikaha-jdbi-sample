package test;

import java.util.List;
import org.jdbi.v3.sqlobject.*;
import sizebay.kikaha.jdbi.JDBI;

@JDBI
public interface UserQueries {

	String SELECT_USERS = "SELECT u.id, u.user_name, r.role_name FROM users u JOIN roles r ON r.user_id = u.id";

	@Transaction
	default void insertUserAndRole(User user, String role) {
		long id = insertUser( user );
		setUserRole( id, role );
	}

	@GetGeneratedKeys
	@SqlUpdate( "INSERT INTO users(id, user_name) VALUES (:id, :name)" )
	long insertUser(@BindBean User user);

	@SqlUpdate( "INSERT INTO roles(user_id, role_name) VALUES (:user_id, :name)" )
	void setUserRole(@Bind("user_id") long userId, @Bind("name") String name);

	@SqlQuery( "SELECT * FROM users WHERE id = :id" )
	User retrieveUserById(@Bind("id") long id);

	@SqlQuery( SELECT_USERS )
	List<User> retrieveUsers();
}
