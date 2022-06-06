import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// TODO: Wciąż nie działa.
public class RemoteEJBClient {
	private final static Logger logger = Logger.getLogger(RemoteEJBClient.class .getName()); 
	private final static Hashtable jndiProperties = new Hashtable();

    static InputStreamReader istream;
    static BufferedReader bufRead;
    static { //Co to za konstrukt?
        istream = new InputStreamReader(System.in) ;
        bufRead = new BufferedReader(istream) ;
    }
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("org.jboss").setLevel(Level.SEVERE);
		Logger.getLogger("org.xnio").setLevel(Level.SEVERE);
		testRemoteEJB();
	}

	private static void testRemoteEJB() throws NamingException {	

		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
//        jndiProperties.put("java.naming.provider.url","remote://localhost:4447");
//        //jndiProperties.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
//        jndiProperties.put("jboss.naming.client.ejb.context", true);

        final Info info = lookupInfoEJB();

		dumpWelcomeMessage();

        logger.info(info.printInfo().toString());
	}

	private static Info lookupInfoEJB() throws NamingException {
		
		final Context context = new InitialContext(jndiProperties);

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
		return (Info) context.lookup("ejb:/sandbox.JavaEE.server/InfoBean!Info");

	}

	public static void dumpWelcomeMessage() {
		System.out.println("Klient wystartował...");
	}
}
