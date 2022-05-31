FROM jboss/wildfly:25.0.0.Final

EXPOSE 8080 8443 8787 9990

ENV CONFIGURATION_FILE="standalone.xml"
ENV SERVER_CONFIG_FILE="standalone.xml"
ENV WILDFLY_RUN_PARAMS="-b=0.0.0.0 -bmanagement=0.0.0.0"

CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0