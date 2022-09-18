package domain.user;

import static com.google.common.base.Preconditions.*;

import java.beans.ConstructorProperties;

import lombok.Getter;

@Getter
public class User {

	private final Email email;
	private final OAuthType oAuthType;

	@ConstructorProperties(value = {"email", "oAuthType"})
	public User(Email email, OAuthType oAuthType) {
		checkNotNull(email);
		checkNotNull(oAuthType);

		this.email = email;
		this.oAuthType = oAuthType;
	}
}
