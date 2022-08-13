package domainapp.modules.inventory.dom.Subsidiaries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface SubsidiariesRepository extends JpaRepository<Subsidiaries, Long> {

  //  List<Subsidiaries> findByNoNotaContaining(final String noNotaa);

  //  Subsidiaries findByName(final String name);

}
