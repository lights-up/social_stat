package by.lightsup.socialstat.statistic;

import by.lightsup.socialstat.builder.FollowsBuilder;
import by.lightsup.socialstat.entity.LargeUserVO;
import by.lightsup.socialstat.entity.LargeUserWithCoeff;
import by.lightsup.socialstat.entity.Like;
import by.lightsup.socialstat.entity.Media;
import by.lightsup.socialstat.entity.ShortUser;
import by.lightsup.socialstat.entity.requestor.EntityRequestor;
import by.lightsup.socialstat.parser.SimpleParser;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Statistic {

	private static final Logger LOG = Logger.getLogger(Statistic.class);

	/**
	 * Create list of sorted LargeUserWithCoeff by count of likes
	 * 
	 * @param parameters
	 *            ValueObject of parameters
	 * @return sorted list of users
	 */
	public List<LargeUserWithCoeff> getStatistic(Map<String, String> parameters) {
		List<ShortUser> follows = new EntityRequestor<>(new SimpleParser(), new FollowsBuilder(), parameters).getEntityList();
		List<LargeUserWithCoeff> usersWithCoeffs = new ArrayList<>();
		for (ShortUser shortUser : follows) {
			parameters.put("userId", shortUser.getId());
			LargeUserVO userVO = LargeUserVO.newInstance(parameters);
			usersWithCoeffs.add(createLargeUserWithCoeff(userVO));
		}
		usersWithCoeffs.sort((LargeUserWithCoeff a, LargeUserWithCoeff b) -> Double.compare(a.getCoeff(), b.getCoeff()));
		return usersWithCoeffs;
 	}
	
	private LargeUserWithCoeff createLargeUserWithCoeff(LargeUserVO userVO){
		LargeUserWithCoeff userWithCoeff = new LargeUserWithCoeff();
		List<Media> mediaList = userWithCoeff.getUser().getMediaList();
		int i = 0;
		for (Media media : mediaList) {
			if(isLikedByUser(userVO.getUser().getId(), media)){
				++i;
			}
		}
		userWithCoeff.setCoeff(i/mediaList.size());
		return userWithCoeff;
	}

	private boolean isLikedByUser(String userId, Media media) {
		boolean flaq = false;
		for (Like like : media.getLikes()) {
			if(like.getUser().getId().equals(userId)){
				flaq = true;
			}
		}
		return flaq;
	}

}
