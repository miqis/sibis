package domainapp.modules.inventory.dom.so;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface KeluarRepository extends JpaRepository<Keluar, Long> {

    List<Keluar> findByNoNotaContaining(final String noNotaa);

    Keluar findByNoNota(final String noNota);

}
