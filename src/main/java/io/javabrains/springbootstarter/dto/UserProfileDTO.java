package io.javabrains.springbootstarter.dto;

/**
 * @author Kusma Singh
 * @time 10:52:30 AM
 * @date 28-Feb-2018
 */
public class UserProfileDTO extends BaseDTO {
	

	private static final long serialVersionUID = 4034114523716435793L;

	private Long profileId;

	private byte[] profile;

	private Long userId;
	
	/**
	 * @param profileId
	 * @param profile
	 * @param userId
	 */
	public UserProfileDTO(Long profileId, byte[] profile, Long userId) {
		super();
		this.profileId = profileId;
		this.profile = profile;
		this.userId = userId;
	}

	/**
	 * @return the profileId
	 */
	public Long getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the profile
	 */
	public byte[] getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
