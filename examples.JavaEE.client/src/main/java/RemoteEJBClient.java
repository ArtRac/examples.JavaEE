import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.IInfo;

// TODO: Wciąż nie działa.
public class RemoteEJBClient {
	private final static Logger logger = Logger.getLogger(RemoteEJBClient.class .getName()); 
	private final static Hashtable jndiProperties = new Hashtable();

	public static void main(String[] args) throws Exception {
		Logger.getLogger("org.jboss").setLevel(Level.SEVERE);
		Logger.getLogger("org.xnio").setLevel(Level.SEVERE);
		testRemoteEJB();
	}

	private static void testRemoteEJB() throws NamingException {
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
        final IInfo info = lookupInfoEJB();

		dumpWelcomeMessage();

        logger.info(info.printInfo());
	}

	private static IInfo lookupInfoEJB() throws NamingException {
        /*
        Nazwa JDNI używana do wywołania bezstanowego ziarna sesyjnego.
        ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>

        <app-name>
        To nazwa aplikacji typu enterprise (bez elementu .ear), jeśli komponent EJB znajduje się w pakiecie EAR.

        <module-name>
        To nazwa modułu (bez elementu .jar lub .war), w którym znajduje się komponent EJB.

        <distinct-name>
        Można opcjonalnie ustawić nazwę wyróżniającą dla każdej jednostki wdrożenia.

        <bean-name>
        To nazwa klasy ziarna.

        Stanowe komponenty EJB zawierają dodatkowy atrybut — ?stateful — na końcu tekstu JNDI,
        więc pełny adres ma wówczas postać:
        ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>?stateful
        */
        final Context context = new InitialContext(jndiProperties);
		return (IInfo) context.lookup("ejb:/examples.JavaEE.server-1.0-SNAPSHOT/Info!ejb.IInfo");

        //ejb:/examples.JavaEE.server-1.0-SNAPSHOT/Info!ejb.IInfo

	}

	public static void dumpWelcomeMessage() {
		System.out.println("Klient wystartował...");
	}
}
