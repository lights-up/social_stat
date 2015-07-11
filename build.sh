#!/bin/sh
# usage: fsplit file1 file2

mvn install;
sh /home/uladzimir/apache-tomcat-7.0.62/bin/shutdown.sh;
cp /home/uladzimir/workspace/social_network_statistic/social_stat/target/testDir/social_stat-1.0.war /home/uladzimir/apache-tomcat-7.0.62/webapps/;
rm -rf /home/uladzimir/apache-tomcat-7.0.62/social_stat-1.0;
sh /home/uladzimir/apache-tomcat-7.0.62/bin/startup.sh;
