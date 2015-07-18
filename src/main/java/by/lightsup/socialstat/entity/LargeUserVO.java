package by.lightsup.socialstat.entity;

import java.util.List;
import java.util.Map;

import by.lightsup.socialstat.builder.LargeUserBuilder;
import by.lightsup.socialstat.builder.MediaBuilder;
import by.lightsup.socialstat.entity.requestor.EntityRequestor;
import by.lightsup.socialstat.parser.SimpleParser;

public class LargeUserVO {
	
	private LargeUser user;
	private List<Media> mediaList;

	public LargeUserVO() {
	}

	public LargeUser getUser() {
		return user;
	}

	public void setUser(LargeUser user) {
		this.user = user;
	}

	public List<Media> getMediaList() {
		return mediaList;
	}

	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mediaList == null) ? 0 : mediaList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LargeUserVO other = (LargeUserVO) obj;
		if (mediaList == null) {
			if (other.mediaList != null)
				return false;
		} else if (!mediaList.equals(other.mediaList))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public static LargeUserVO newInstance(Map<String, String> parameters){
		LargeUserVO user = new LargeUserVO();
		LargeUser largeUser = new EntityRequestor<>(new SimpleParser(), new LargeUserBuilder(), parameters).getEntityList().get(0);
		List<Media> mediaList = new EntityRequestor<>(new SimpleParser(), new MediaBuilder(), parameters).getEntityList();
		user.setUser(largeUser);
		user.setMediaList(mediaList);
		return user;
	}

}
