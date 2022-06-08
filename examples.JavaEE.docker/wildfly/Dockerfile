FROM bitnami/wildfly:26.1.1

EXPOSE 8080 8443 8787 9990 4447

# Dodanie usera który będzie miał dostęp do konsoli.
# http://www.mastertheboss.com/jbossas/jboss-script/wildfly-how-to-add-an-user/
RUN /opt/bitnami/wildfly/bin/add-user.sh -u 'admin' -p 'admin'
RUN /opt/bitnami/wildfly/bin/add-user.sh -a -u 'quickstartUser' -p 'quickstartPwd1!'


# Umożliwienie dostępu do konsoli.
# http://www.mastertheboss.com/jbossas/jboss-configuration/how-to-bind-wildfly-to-an-ip-address/
CMD /opt/bitnami/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0