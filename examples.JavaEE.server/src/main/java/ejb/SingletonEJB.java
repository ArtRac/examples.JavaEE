package ejb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Startup;

// @Stateless   // Ziarno bezstanowe.
// @Stateful    // Ziarno sesyjne
@Singleton      // Tworzona jest jedna instancja ziarna stanowego. Istnieje do wyłączenia aplikacji.
@Startup        // Obiekt jest tworzony natychmiast po uruchomieniu aplikacji.
@Remote( ISingleton.class) // Ziarno jest udostępnione klientom zdalnym.
public class SingletonEJB implements ISingleton
{
    private final static Logger logger = Logger.getLogger( SingletonEJB.class.getName());

    private  int counter;

    @PostConstruct // Metoda jest uruchamiana natychmiast po utworzeniu obiektu.
    public void setupTheatre()
    {
        counter = 0;
        logger.info( "setupTheatre @PostConstruct" );
    }

    @Override
    public String getValue()
    {
        return "SingletonEJB.getValue() counter = " + String.valueOf( counter++ );
    }
}
