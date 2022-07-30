package domainapp.webapp.application.services.homepage;

import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.HomePage;
import org.apache.isis.applib.annotation.Nature;

// import domainapp.modules.simple.dom.so.SimpleObject;
// import domainapp.modules.simple.dom.so.SimpleObjects;

@DomainObject(
        nature = Nature.VIEW_MODEL,
        logicalTypeName = "miq.incode.HomePageViewModel"
        )
@HomePage
@DomainObjectLayout()
public class HomePageViewModel {

    public String title() {
        return "DashBoard";
    }


//     @Inject SimpleObjects simpleObjects;
}
