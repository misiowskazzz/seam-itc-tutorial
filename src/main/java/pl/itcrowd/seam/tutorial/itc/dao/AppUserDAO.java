package pl.itcrowd.seam.tutorial.itc.dao;

import pl.itcrowd.seam.tutorial.itc.domain.AppUser;
import pl.itcrowd.seam.tutorial.itc.framework.Removed;
import pl.itcrowd.seam.tutorial.itc.framework.Save;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class AppUserDAO {

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<AppUser> getAllUsers() {
        return entityManager.createQuery("select u from AppUser u").getResultList();
    }

    public AppUser getUserByEmail(String email) {
        return entityManager.find(AppUser.class, email);
    }

    public void onAppUserRemoveAction(@Observes @Removed AppUser appUser) {
        this.deleteAppUser(appUser);
    }
    public void deleteAppUser(AppUser appUser) {          //3a wskazac jeszcze raz
        AppUser appUser1 = entityManager.find(AppUser.class, appUser.getId());
        entityManager.remove(appUser1);
    }





    public void onAppUserSaveAcction(@Observes @Save AppUser appUser){
        this.saveAppUser(appUser);
    }

    public void saveAppUser(AppUser appUser1) {
        if (appUser1 != null) {
            if (null != appUser1.getId()) {
                entityManager.merge(appUser1);
            } else {
                entityManager.persist(appUser1);
            }
        }
    }

}
