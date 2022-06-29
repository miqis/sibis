package domainapp.webapp.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import domainapp.modules.inventory.ModuleInventory;
import domainapp.modules.simple.SimpleModule;

@Configuration
@Import( 
		{SimpleModule.class, ModuleInventory.class }
		)
@ComponentScan
public class ApplicationModule {

}
