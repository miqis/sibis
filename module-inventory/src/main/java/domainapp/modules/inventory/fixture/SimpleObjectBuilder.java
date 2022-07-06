package domainapp.modules.inventory.fixture;

import javax.inject.Inject;

import org.apache.isis.testing.fixtures.applib.personas.BuilderScriptWithResult;

import domainapp.modules.inventory.dom.so.MenuPengeluaran;
import domainapp.modules.inventory.dom.so.Pengeluaran;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class SimpleObjectBuilder extends BuilderScriptWithResult<Pengeluaran> {

    @Getter @Setter
    private String name;

    @Override
    protected Pengeluaran buildResult(final ExecutionContext ec) {

        checkParam("name", ec, String.class);

        return wrap(simpleObjects).create(name);
    }

    // -- DEPENDENCIES

    @Inject MenuPengeluaran simpleObjects;

    
}
