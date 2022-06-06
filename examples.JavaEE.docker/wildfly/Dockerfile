FROM jboss/wildfly:25.0.0.Final

EXPOSE 8080 8443 8787 9990 4447

# Dodanie usera który będzie miał dostęp do konsoli.
# http://www.mastertheboss.com/jbossas/jboss-script/wildfly-how-to-add-an-user/
RUN /opt/jboss/wildfly/bin/add-user.sh -u 'admin' -p 'admin'

# Umożliwienie dostępu do konsoli.
# http://www.mastertheboss.com/jbossas/jboss-configuration/how-to-bind-wildfly-to-an-ip-address/
# CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0