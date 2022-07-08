package domainapp.modules.inventory.dom.suplier;

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

import domainapp.modules.inventory.types.Nama;

@DomainService(
        nature = NatureOfService.VIEW,
        logicalTypeName = "sibis.MenuSuplai"
        
)
@DomainServiceLayout( 
		menuBar = MenuBar.PRIMARY,
		named  = "suplai"
		)
@javax.annotation.Priority(PriorityPrecedence.EARLY)
@lombok.RequiredArgsConstructor(onConstructor_ = {@Inject} )
public class MenuSuplai {

    final RepositoryService repositoryService;
    final JpaSupportService jpaSupportService;
    final SuplaiRepository suplaiRepository;


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
    public Suplai baru(
            @Nama final String name) {
        return repositoryService.persist(Suplai.withName(name));
    }

//
//    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
//    @ActionLayout(promptStyle = PromptStyle.DIALOG_SIDEBAR)
//    public List<Keluar> findByNameLike(
//            @Nama final String name) {
//        return repositoryService.allMatches(
//                Query.named(Keluar.class, Keluar.NAMED_QUERY__FIND_BY_NAME_LIKE)
//                     .withParameter("noNota", "%" + name + "%"));
//    }
//
//
//    @Action(semantics = SemanticsOf.SAFE)
//    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT, promptStyle = PromptStyle.DIALOG_SIDEBAR)
//    public List<Keluar> findByNoNota(
//            @Nama final String name
//            ) {
//        return simpleObjectRepository.findByNoNotaContaining(name);
//    }
//
//
//    @Programmatic
//    public Keluar findByNameExact(final String name) {
//        return simpleObjectRepository.findByNoNota(name);
//    }
//
//

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    public List<Suplai> listAll() {
        return suplaiRepository.findAll();
    }




//    @Programmatic
//    public void ping() {
//        jpaSupportService.getEntityManager(Keluar.class)
//            .ifSuccess(entityManager -> {
//                final TypedQuery<Keluar> q = entityManager.createQuery(
//                        "SELECT p FROM SimpleObject p ORDER BY p.noNota",
//                        Keluar.class)
//                    .setMaxResults(1);
//                q.getResultList();
//            });
//    }


}
