import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless 
public class Scheduler
{
	private final static Logger logger = Logger.getLogger(Scheduler.class.getName());

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	public void ping()
	{
  	       logger.info("Ping!");
	}
}
