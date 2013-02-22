package pl.itcrowd.seam.tutorial.itc;

import org.jboss.seam.transaction.Transactional;
import org.jboss.solder.servlet.WebApplication;
import org.jboss.solder.servlet.event.Initialized;
import pl.itcrowd.seam.tutorial.itc.domain.AppUser;
import pl.itcrowd.seam.tutorial.itc.framework.Standalone;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class Startup {

    @Standalone
    @Inject
    private EntityManager entityManager;

    @Transactional
    public void seed(@Observes @Initialized WebApplication webApplication) {
        entityManager.persist(new AppUser("Rafal@gmail.com", "aaaaa", "admin"));
        entityManager.persist(new AppUser("jack@itcrowd.pl", "aaaaa", "user"));
        entityManager.persist(new AppUser("piterk@itcrowd.pl", "aaaaa", "user"));
        entityManager.flush();
    }
}
