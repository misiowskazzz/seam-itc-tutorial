package pl.itcrowd.seam.tutorial.itc.view;

import org.jboss.seam.mail.api.MailMessage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/25/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class EmailMsg {

    private String emailAddress;
    private String emailTopic;
    private String emailMsg;

    public EmailMsg() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailTopic() {
        return emailTopic;
    }

    public void setEmailTopic(String emailTopic) {
        this.emailTopic = emailTopic;
    }

    public String getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg;
    }

    @Inject
    private MailMessage mailMessage;

    public void sendEmail() {
        mailMessage.to(emailAddress)
                .subject(emailTopic)
                .bodyText(emailMsg)
                .send();
    }
}
