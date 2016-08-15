package test;

import lombok.Getter;
import sizebay.kikaha.jdbi.serializers.*;

@Getter
@Entity
public class User {

	@Column
	public Long id;

	@Column( "user_name" )
	public String name;

	@Optional
	@Column( "role_name" )
	public String role;
}
