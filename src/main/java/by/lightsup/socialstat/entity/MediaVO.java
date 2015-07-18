package by.lightsup.socialstat.entity;

import java.util.List;
import java.util.Map;

import by.lightsup.socialstat.builder.CommentBuilder;
import by.lightsup.socialstat.builder.LikeBuilder;
import by.lightsup.socialstat.builder.MediaBuilder;
import by.lightsup.socialstat.entity.requestor.EntityRequestor;
import by.lightsup.socialstat.parser.SimpleParser;

public class MediaVO {
	
	private Media media;
	private List<Like> likes;
	private List<Comment> comments;

	public MediaVO() {
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
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
		MediaVO other = (MediaVO) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		return true;
	}

	
	public static MediaVO newInstance(Map<String, String> parameters){
		MediaVO mediaVO = new MediaVO();
		Media media = new EntityRequestor<>(new SimpleParser(), new MediaBuilder(), parameters).getEntityList().get(0);
		List<Like> likes = new EntityRequestor<>(new SimpleParser(), new LikeBuilder(), parameters).getEntityList();
		List<Comment> comments = new EntityRequestor<>(new SimpleParser(), new CommentBuilder(), parameters).getEntityList();
		mediaVO.setMedia(media);
		mediaVO.setLikes(likes);
		mediaVO.setComments(comments);
		return mediaVO;
	}
	
}
