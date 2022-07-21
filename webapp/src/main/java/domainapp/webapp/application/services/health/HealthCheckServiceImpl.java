package domainapp.webapp.application.services.health;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import domainapp.modules.inventory.dom.pengadaan.MenuBiaya;

import org.apache.isis.applib.services.health.Health;
import org.apache.isis.applib.services.health.HealthCheckService;

@Service
@Named("domainapp.HealthCheckServiceImpl")
public class HealthCheckServiceImpl implements HealthCheckService {

    private final MenuBiaya simpleObjects;

    @Inject
    public HealthCheckServiceImpl(MenuBiaya simpleObjects) {
        this.simpleObjects = simpleObjects;
    }

    @Override
    public Health check() {
        try {
            simpleObjects.ping();
            return Health.ok();
        } catch (Exception ex) {
            return Health.error(ex);
        }
    }
}
