import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Info.class)
public class InfoBean implements Info  {

	@Override
	public String printInfo() {
        return "InfoBean.printInfo()";
	}
}
