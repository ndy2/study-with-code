package domain.profile;

import static com.google.common.base.Preconditions.*;
import static java.lang.String.*;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Profile {

	private long id;
	private final String username;
	private final Set<Follow> follows;

	public Profile(final String username) {
		this.username = username;
		this.follows = new HashSet<>();
	}

	/* 팔로우 */
	public void follow(final Profile target) {
		checkArgument(!isFollow(target),
			format("illegal follow command of profileId: %d on targetProfileId: %d", this.getId(), target.getId()));

		this.follows.add(new Follow(this.getId(), target.getId()));
	}

	/* 언팔로우 */
	public void unfollow(final Profile target) {
		checkArgument(isFollow(target),
			format("illegal unfollow command of profileId: %d on targetProfileId: %d", this.getId(), target.getId()));

		this.follows.remove(new Follow(this.getId(), target.getId()));
	}

	/* 프로필 팔로우 중인지 확인 */
	public boolean isFollow(final Profile profile) {
		return this.follows.stream().anyMatch(f -> f.isFolloweeOf(profile));
	}
}
