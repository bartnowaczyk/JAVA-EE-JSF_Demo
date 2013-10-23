#!/bin/sh

echo "************ UNDEPLOYING *******************"
/usr/glassfishv3/bin/asadmin -u admin --passwordfile pass undeploy jsfKoop
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
/usr/glassfishv3/bin/asadmin -u admin --passwordfile pass deploy target/jsfKoop.war
