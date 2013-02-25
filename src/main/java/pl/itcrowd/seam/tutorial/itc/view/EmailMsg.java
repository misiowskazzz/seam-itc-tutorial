package pl.itcrowd.seam.tutorial.itc.view;

import org.jboss.seam.mail.api.MailMessage;
import org.jboss.seam.mail.attachments.InputStreamAttachment;
import org.jboss.seam.mail.core.enumerations.ContentDisposition;
import org.jboss.seam.mail.templating.freemarker.FreeMarkerTemplate;
import org.jboss.seam.security.Identity;
import org.jboss.solder.resourceLoader.ResourceProvider;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

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
    @Inject
    private Identity identity;
    @Inject
    private MailMessage mailMessage;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private ResourceProvider resourceProvider;

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

    public String appUserName() {
        if (identity.isLoggedIn()) {
            return identity.getUser().getId();
        }
        return "not loged";
    }

    public String mailDate(){
        Date date = new Date();
        return  date.toString();
    }

    public void sendEmail() {
        mailMessage.to(emailAddress)
                .subject(emailTopic)
                .bodyText(emailMsg)
                .send();
    }

    public void send() {
        mailMessage.to(emailAddress)
                .subject(emailTopic)
                .bodyHtml(new FreeMarkerTemplate(resourceProvider.loadResourceStream("mail/mailTemplate.ftl")))
                .put("content", emailTopic)
                .put("currentUser", appUserName())
                .put("date", new Date())
                .addAttachment(new InputStreamAttachment("footer-logo.png", "image/png", ContentDisposition.ATTACHMENT, resourceProvider.loadResourceStream("mail/logo.png")))
                .send();
    }
}
