package by.lightsup.socialstat.statistic;

import by.lightsup.socialstat.builder.EntityBuilder;
import by.lightsup.socialstat.entity.LargeUser;
import by.lightsup.socialstat.handler.AbstractHandler;
import by.lightsup.socialstat.handler.UserHandler;
import by.lightsup.socialstat.parser.SimpleParser;
import by.lightsup.socialstat.util.RequestParameters;
import org.apache.log4j.Logger;

public class Statistic {

    private static final Logger LOG = Logger.getLogger(Statistic.class);

    public static LargeUser getStatistic(RequestParameters parameters) {
        AbstractHandler<LargeUser> userHandler = UserHandler.newInstance();
        LargeUser largeUser = new EntityBuilder<>(new SimpleParser(), userHandler, parameters).getEntityList().get(0);

        return largeUser;
    }
}

