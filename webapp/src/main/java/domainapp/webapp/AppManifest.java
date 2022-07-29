package domainapp.webapp;

import org.apache.isis.core.config.presets.IsisPresets;
import org.apache.isis.core.runtimeservices.IsisModuleCoreRuntimeServices;
import org.apache.isis.extensions.flyway.impl.IsisModuleExtFlywayImpl;
import org.apache.isis.persistence.jpa.eclipselink.IsisModulePersistenceJpaEclipselink;
import org.apache.isis.security.shiro.IsisModuleSecurityShiro;
import org.apache.isis.testing.fixtures.applib.IsisModuleTestingFixturesApplib;
import org.apache.isis.testing.h2console.ui.IsisModuleTestingH2ConsoleUi;
import org.apache.isis.viewer.restfulobjects.jaxrsresteasy4.IsisModuleViewerRestfulObjectsJaxrsResteasy4;
import org.apache.isis.viewer.wicket.viewer.IsisModuleViewerWicketViewer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import org.apache.isis.extensions.secman.integration.IsisModuleExtSecmanIntegration;
import org.apache.isis.extensions.secman.encryption.spring.IsisModuleExtSecmanEncryptionSpring;

import domainapp.webapp.application.ApplicationModule;
import domainapp.webapp.application.fixture.scenarios.DomainAppDemo;
import domainapp.webapp.custom.CustomModule;
import domainapp.webapp.quartz.QuartzModule;

@Configuration
@Import({
		// Security Manager Extension (secman)
		IsisModuleExtSecmanIntegration.class, 
		IsisModuleExtSecmanEncryptionSpring.class,

		IsisModuleCoreRuntimeServices.class, 
		IsisModuleSecurityShiro.class, 
		IsisModulePersistenceJpaEclipselink.class,
		IsisModuleViewerRestfulObjectsJaxrsResteasy4.class, 
		IsisModuleViewerWicketViewer.class,

		IsisModuleTestingFixturesApplib.class, 
		IsisModuleTestingH2ConsoleUi.class,

		IsisModuleExtFlywayImpl.class,

		ApplicationModule.class, 
		CustomModule.class, 
		QuartzModule.class,

		// discoverable fixtures
		DomainAppDemo.class })
@PropertySources({ @PropertySource(IsisPresets.DebugDiscovery), })
public class AppManifest {
}
