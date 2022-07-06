package domainapp.modules.inventory.dom.so;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface PengeluaranRepository extends JpaRepository<Pengeluaran, Long> {

    List<Pengeluaran> findByNoNotaContaining(final String noNotaa);

    Pengeluaran findByNoNota(final String noNota);

}
