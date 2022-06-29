package domainapp.modules.simple.fixture;

import org.apache.isis.applib.services.registry.ServiceRegistry;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithBuilderScript;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithFinder;
import org.apache.isis.testing.fixtures.applib.setup.PersonaEnumPersistAll;

import domainapp.modules.simple.dom.so.Pembelian;
import domainapp.modules.simple.dom.so.MenuPembelian;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SimpleObject_persona
implements PersonaWithBuilderScript<SimpleObjectBuilder>, PersonaWithFinder<Pembelian> {

    FOO("Foo"),
    BAR("Bar"),
    BAZ("Baz"),
    FRODO("Frodo"),
    FROYO("Froyo"),
    FIZZ("Fizz"),
    BIP("Bip"),
    BOP("Bop"),
    BANG("Bang"),
    BOO("Boo");

    private final String name;

    @Override
    public SimpleObjectBuilder builder() {
        return new SimpleObjectBuilder().setName(name);
    }

    @Override
    public Pembelian findUsing(final ServiceRegistry serviceRegistry) {
        MenuPembelian simpleObjects = serviceRegistry.lookupService(MenuPembelian.class).orElse(null);
        return simpleObjects.findByNameExact(name);
    }

    public static class PersistAll
    extends PersonaEnumPersistAll<SimpleObject_persona, Pembelian> {

        public PersistAll() {
            super(SimpleObject_persona.class);
        }
    }
}
