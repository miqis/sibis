package domainapp.modules.inventory.fixture;

import javax.inject.Inject;

import org.apache.isis.testing.fixtures.applib.personas.BuilderScriptWithResult;

import domainapp.modules.inventory.dom.pengadaan.MenuBiaya;
import domainapp.modules.inventory.dom.so.Keluar;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class SimpleObjectBuilder extends BuilderScriptWithResult<Keluar> {

    @Getter @Setter
    private String name;

    @Override
    protected Keluar buildResult(final ExecutionContext ec) {

        checkParam("name", ec, String.class);

        return wrap(simpleObjects).create(name);
    }

    // -- DEPENDENCIES

    @Inject MenuBiaya simpleObjects;

    
}
