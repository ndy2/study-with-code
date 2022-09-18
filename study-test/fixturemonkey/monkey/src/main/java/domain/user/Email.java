package domain.user;

import static com.google.common.base.Preconditions.*;

import java.beans.ConstructorProperties;
import java.util.regex.Pattern;

import lombok.Getter;

@Getter
public class Email {

	private static final Pattern EMAIL_PATTERN = Pattern.compile(
		"[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*"
			+ "@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)"
			+ "+[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]");

	private final String value;

	@ConstructorProperties("value")
	public Email(final String value) {
		checkNotNull(value);
		checkArgument(EMAIL_PATTERN.matcher(value).find(), "이메일 형식이 잘못 되었습니다.");

		this.value = value;
	}
}
