package domainapp.modules.simple.dom.so;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PembelianRepository extends JpaRepository<Pembelian, Long> {

    List<Pembelian> findByNameContaining(final String name);

    Pembelian findByName(final String name);

}
