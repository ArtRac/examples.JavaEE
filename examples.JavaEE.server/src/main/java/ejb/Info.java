package ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote( IInfo.class)
public class Info implements IInfo
{

	@Override
	public String printInfo() {
        return "InfoBean.printInfo()";
	}
}
