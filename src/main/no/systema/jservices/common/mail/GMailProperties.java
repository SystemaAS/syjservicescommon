package no.systema.jservices.common.mail;

/**
 * This class hold properties form GMail config, and from-user.
 * 
 * @author Fredrik Möller
 * @date Nov 29, 2016
 *
 */
public class GMailProperties {

    /**
     * true
     */
	public static final String MAIL_SMTP_AUTH="true";
	/**
	 * 10000
	 */
    public static final int MAIL_SMTP_TIMEOUT=10000;
    /**
     * 10000
     */
    public static final int MAIL_SMTP_CONNECTIONTIMEOUT=10000;
    /**
     * true
     */
    public static final String MAIL_SMTP_STARTTLS_ENABLE="true";
    /**
     * false
     */
    public static final String MAIL_DEBUG="false";
    /**
     * "smtp.gmail.com"
     */
    public static final String MAIL_HOST="smtp.gmail.com";
    /**
     * 25
     */
    public static final int MAIL_PORT=25;
    /**
     * smtp
     */
    public static final String MAIL_PROTOCOL="smtp";
    /**
     * fredrik@systema.no
     */
    public static final String MAIL_USERNAME="fredrik@systema.no";
    /**
     * fredrik10121
     */
    public static final String MAIL_PASSWORD="fredrik10121";
    /**
     * fredrik@systema.no
     */
    public static final String MAIL_BOX_SUPPORT="fredrik@systema.no";
    /**
     * true
     */
    public static final boolean SEND_MAIL_TO_SUPPORT_BOX=true;

}
