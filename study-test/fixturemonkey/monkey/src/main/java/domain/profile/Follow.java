package domain.profile;

import static com.google.common.base.Preconditions.*;

import java.beans.ConstructorProperties;

import lombok.Getter;

public class Follow {

	private final FollowId id;

	@ConstructorProperties(value = {"followerId", "followeeId"})
	public Follow(final long followerId, final long followeeId) {
		this.id = new FollowId(followerId, followeeId);
	}

	public boolean isFolloweeOf(final Profile profile) {
		return id.getFolloweeId() == profile.getId();
	}


	@Getter
	static class FollowId {

		private final long followerId;
		private final long followeeId;

		@ConstructorProperties(value = {"followerId", "followeeId"})
		public FollowId(final long followerId, final long followeeId) {
			checkArgument(followerId != followeeId, "자기 자신을 팔로우 할 수 없습니다");

			this.followerId = followerId;
			this.followeeId = followeeId;
		}
	}
}
