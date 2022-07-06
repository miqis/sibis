package domainapp.modules.inventory.fixture;

import org.apache.isis.applib.services.registry.ServiceRegistry;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithBuilderScript;
import org.apache.isis.testing.fixtures.applib.personas.PersonaWithFinder;
import org.apache.isis.testing.fixtures.applib.setup.PersonaEnumPersistAll;

import domainapp.modules.inventory.dom.so.MenuPengeluaran;
import domainapp.modules.inventory.dom.so.Pengeluaran;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SimpleObject_persona
implements PersonaWithBuilderScript<SimpleObjectBuilder>, PersonaWithFinder<Pengeluaran> {

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
    public Pengeluaran findUsing(final ServiceRegistry serviceRegistry) {
        MenuPengeluaran simpleObjects = serviceRegistry.lookupService(MenuPengeluaran.class).orElse(null);
        return simpleObjects.findByNameExact(name);
    }

    public static class PersistAll
    extends PersonaEnumPersistAll<SimpleObject_persona, Pengeluaran> {

        public PersistAll() {
            super(SimpleObject_persona.class);
        }
    }
}
