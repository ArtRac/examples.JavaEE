import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import ejb.IInfo;

// TODO: Wciąż nie działa.
public class RemoteEJBClient {
	private final static Logger logger = Logger.getLogger(RemoteEJBClient.class .getName()); 
	private final static Hashtable jndiProperties = new Hashtable();

	public static void main(String[] args) throws Exception {
        System.out.println("Klient wystartował...");

        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");

        jndiProperties.put(Context.SECURITY_PRINCIPAL, "user");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "user");

        final Context context = new InitialContext(jndiProperties);
        final IInfo info =  (IInfo) context.lookup("ejb:/examples.JavaEE.server-1.0-SNAPSHOT/Info!ejb.IInfo");

        logger.info(info.printInfo());
	}
}
