package domainapp.modules.simple.fixture;

import javax.inject.Inject;

import org.apache.isis.testing.fixtures.applib.personas.BuilderScriptWithResult;

import domainapp.modules.simple.dom.so.Pembelian;
import domainapp.modules.simple.dom.so.MenuPembelian;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class SimpleObjectBuilder extends BuilderScriptWithResult<Pembelian> {

    @Getter @Setter
    private String name;

    @Override
    protected Pembelian buildResult(final ExecutionContext ec) {

        checkParam("name", ec, String.class);

        return wrap(simpleObjects).create(name);
    }

    // -- DEPENDENCIES

    @Inject MenuPembelian simpleObjects;

}
