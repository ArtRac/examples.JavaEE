package ejb;

import java.util.logging.Logger;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote( IInfo.class)
public class Info implements IInfo
{
    private final static Logger logger = Logger.getLogger(Info.class .getName());
    @Override
    public String printInfo() {
	logger.info( "InfoBean.printInfo()" );
	return "InfoBean.printInfo()";
    }
}
