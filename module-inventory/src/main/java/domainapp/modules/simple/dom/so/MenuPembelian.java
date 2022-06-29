package domainapp.modules.simple.dom.so;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.DomainServiceLayout.MenuBar;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.PriorityPrecedence;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.query.Query;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.persistence.jpa.applib.services.JpaSupportService;

import domainapp.modules.simple.types.Name;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "sibis.MenuPembelian"
        
)
@DomainServiceLayout( 
		menuBar = MenuBar.PRIMARY,
		named = "Pembelian"
		)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class MenuPembelian {

    final RepositoryService repositoryService;
    final JpaSupportService jpaSupportService;
    final PembelianRepository simpleObjectRepository;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Pembelian create(
            @Name final String name) {
        return repositoryService.persist(Pembelian.withName(name));
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Pembelian> findByNameLike(
            @Name final String name) {
        return repositoryService.allMatches(
                Query.named(Pembelian.class, Pembelian.NAMED_QUERY__FIND_BY_NAME_LIKE)
                     .withParameter("name", "%" + name + "%"));
    }


    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public List<Pembelian> findByName(
            @Name final String name
            ) {
        return simpleObjectRepository.findByNameContaining(name);
    }


    @Programmatic
    public Pembelian findByNameExact(final String name) {
        return simpleObjectRepository.findByName(name);
    }



    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Pembelian> listAll() {
        return simpleObjectRepository.findAll();
    }




    @Programmatic
    public void ping() {
        jpaSupportService.getEntityManager(Pembelian.class)
            .ifSuccess(entityManager -> {
                final TypedQuery<Pembelian> q = entityManager.createQuery(
                        "SELECT p FROM SimpleObject p ORDER BY p.name",
                        Pembelian.class)
                    .setMaxResults(1);
                q.getResultList();
            });
    }


}
