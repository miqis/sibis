package domainapp.modules.inventory.dom.pengadaan.suplier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface SuplierRepository extends JpaRepository<Suplier, Long> {

    List<Suplier> findByNamaContaining(final String nama);

    Suplier findByNama(final String nama);

}
