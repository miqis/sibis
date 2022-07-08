package domainapp.modules.inventory.dom.suplier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface SuplaiRepository extends JpaRepository<Suplai, Long> {

    List<Suplai> findByNamaContaining(final String nama);

    Suplai findByNama(final String nama);

}
