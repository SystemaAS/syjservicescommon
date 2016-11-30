package no.systema.jservices.common.mail;

import org.junit.Before;
import org.junit.Test;

public class TestJGmail {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public final void testSendMail() {

		GMail mail = new GMail();
		StringBuilder subject = new StringBuilder("TEST MAIL.");
		StringBuilder message = new StringBuilder("eSpedsg tester GMmail ...");
		message.append("\n\n\n\n");
		message.append("::Detta mail har skickats av eSpedsg.::");
		message.append("\n");
		message.append("::fra:"+GMailProperties.MAIL_USERNAME);
		message.append(" til:"+GMailProperties.MAIL_BOX_SUPPORT+"::");
		mail.sendMail(GMailProperties.MAIL_BOX_SUPPORT,subject.toString(), message.toString());

	}

}
