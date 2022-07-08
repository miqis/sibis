package domainapp.modules.inventory;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import domainapp.modules.inventory.dom.so.Keluar;

import org.apache.isis.testing.fixtures.applib.fixturescripts.FixtureScript;
import org.apache.isis.testing.fixtures.applib.modules.ModuleWithFixtures;

@Configuration
@ComponentScan
@EnableJpaRepositories
@EntityScan(basePackageClasses = {ModuleInventory.class})
public class ModuleInventory implements ModuleWithFixtures {

    @Override
    public FixtureScript getTeardownFixture() {
        return new FixtureScript() {
            @Override
            protected void execute(ExecutionContext executionContext) {
                repositoryService.removeAll(Keluar.class);
            }
        };
    }
}
