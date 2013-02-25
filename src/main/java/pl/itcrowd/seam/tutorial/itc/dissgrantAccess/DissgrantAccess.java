package pl.itcrowd.seam.tutorial.itc.dissgrantAccess;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.security.AccessDeniedView;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/22/13
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@ViewConfig
public interface DissgrantAccess {

    static enum Pages {

        @AccessDenied
        @RestrictAtPhase(PhaseIdType.RESTORE_VIEW)
        @ViewPattern("/dissgrantAccess/*")
        @AccessDeniedView("/dissgrantAccess/*")
        COMPONENTS,
    }
}