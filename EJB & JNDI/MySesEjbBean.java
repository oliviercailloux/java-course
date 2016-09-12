package ejb;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

@Stateless
public class MySesEjbBean implements MySesEjb {
	@Resource
	int zeNumber = 0;

	private static Logger logger = Logger.getLogger(MySesEjbBean.class.getName());

	public MySesEjbBean() {
		// Auto-generated constructor stub
	}

	@Override
	public int getZeNumber() {
		InitialContext ic;
		try {
			ic = new InitialContext();
			final NamingEnumeration<NameClassPair> l = ic.list("java:comp/env/ejb.MySesEjbBean");
			while (l.hasMore()) {
				logger.info(l.next().getName());
			}
			logger.info("custom resources from lookup: val=" + ic.lookup("java:module/MySesEjbBean"));
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return zeNumber;
	}
}
