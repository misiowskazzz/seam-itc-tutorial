package pl.itcrowd.seam.tutorial.itc.framework;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * Created with IntelliJ IDEA.
 * User: misiek
 * Date: 2/22/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Selected {

}
