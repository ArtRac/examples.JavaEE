FROM jboss/wildfly:25.0.0.Final

EXPOSE 8080 8443 8787 9990

# Dodanie usera który będzie miał dostęp do konsoli.
RUN /opt/jboss/wildfly/bin/add-user.sh -u 'admin' -p 'admin'

CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0