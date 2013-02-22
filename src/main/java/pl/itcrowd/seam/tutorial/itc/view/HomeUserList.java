package pl.itcrowd.seam.tutorial.itc.view;

import pl.itcrowd.seam.tutorial.itc.dao.AppUserDAO;
import pl.itcrowd.seam.tutorial.itc.domain.AppUser;
import pl.itcrowd.seam.tutorial.itc.framework.Removed;
import pl.itcrowd.seam.tutorial.itc.framework.Save;
import pl.itcrowd.seam.tutorial.itc.framework.Selected;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HomeUserList {

    @Inject
    private AppUserDAO appUserDAO;

    private List<AppUser> users;

    private AppUser selectedUser=new AppUser();

    public AppUser getSelectedUser() {
        return selectedUser;
    }
    public void setSelectedUser(AppUser selectedUser) {
        this.selectedUser = selectedUser;
    }
    public void addNewUser(){
        selectedUser=new AppUser();
    }


    public List<AppUser> getUsers()
    {
        if (users == null) {
            users = appUserDAO.getAllUsers();
        }
        return users;
    }

    @Removed
    @Inject
    private Event<AppUser> appUserRemovedEvent;
    public void remove(AppUser appUser)
    {
        appUserRemovedEvent.fire(appUser);
    }
    @Save
    @Inject
    private Event<AppUser> appUserSaveEvent;
    public void save()
    {
        appUserSaveEvent.fire(selectedUser);
    }
}
