#!/bin/sh
# usage: fsplit file1 file2

./gradlew build;
sh /home/uladzimir/apache-tomcat-7.0.62/bin/shutdown.sh;
cp /home/uladzimir/workspace/social_network_statistic/social_stat/build/libs/social_stat.war /home/uladzimir/apache-tomcat-7.0.62/webapps/;
rm -rf /home/uladzimir/apache-tomcat-7.0.62/webapps/social_stat;
sh /home/uladzimir/apache-tomcat-7.0.62/bin/startup.sh;
