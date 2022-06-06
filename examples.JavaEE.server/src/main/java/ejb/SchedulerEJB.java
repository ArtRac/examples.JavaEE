package ejb;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless 
public class SchedulerEJB
{
	private final static Logger logger = Logger.getLogger( SchedulerEJB.class.getName());

    @EJB ISingleton singletonEJB;

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	public void ping()
	{
  	       logger.info("Ping! " + singletonEJB.getValue() );
	}
}
