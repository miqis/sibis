package domainapp.modules.inventory.dom.pengadaan.suplier;

import static org.apache.isis.applib.annotation.SemanticsOf.IDEMPOTENT;
import static org.apache.isis.applib.annotation.SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE;

import java.util.Comparator;

import javax.inject.Inject;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.PromptStyle;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.jaxb.PersistentEntityAdapter;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.apache.isis.persistence.jpa.applib.integration.IsisEntityListener;

import domainapp.modules.inventory.types.Alamat;
import domainapp.modules.inventory.types.Nama;
import domainapp.modules.inventory.types.Notes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.val;


// Suplier =) nama, alamat, 
@javax.persistence.Entity
@javax.persistence.Table(
    schema="inventaris",
    uniqueConstraints = {
        @javax.persistence.UniqueConstraint(name = "suplier__name__UNQ", columnNames = {"NAME"})
    }
)
//@javax.persistence.NamedQueries({
//        @javax.persistence.NamedQuery(
//                name = Suplier.NAMED_QUERY__FIND_BY_NAME_LIKE,
//                query = "SELECT so " +
//                        "FROM Pengeluaran so " +
//                        "WHERE so.noNota LIKE :noMota"
//        )
//})
@javax.persistence.EntityListeners(IsisEntityListener.class)
@DomainObject(logicalTypeName = "inventaris.suplier", entityChangePublishing = Publishing.ENABLED)
@DomainObjectLayout(cssClassFa = "fa-building")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@XmlJavaTypeAdapter(PersistentEntityAdapter.class)
@ToString(onlyExplicitlyIncluded = true)
public class Suplier implements Comparable<Suplier> {

    static final String NAMED_QUERY__FIND_BY_NAME_LIKE = "Pembelian.findByNameLike";

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Column(name = "id", nullable = false)
    private Long id;

    @javax.persistence.Version
    @javax.persistence.Column(name = "version", nullable = false)
    @PropertyLayout(fieldSetId = "metadata", sequence = "999")
    @Getter @Setter
    private long version;

    
    // constructor
    public static Suplier withName(String name) {
        val simpleObject = new Suplier();
        simpleObject.setNama(name);
        return simpleObject;
    }

    @Inject @javax.persistence.Transient RepositoryService repositoryService;
    @Inject @javax.persistence.Transient TitleService titleService;
    @Inject @javax.persistence.Transient MessageService messageService;



    @Title
    @Nama
    @javax.persistence.Column(length = Nama.MAX_LEN, nullable = false)
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String nama;


    @Title
    @Alamat
    @javax.persistence.Column(length = Alamat.MAX_LEN, nullable = false)
    @Getter @Setter @ToString.Include
    @PropertyLayout(fieldSetId = "name", sequence = "1")
    private String alamat = "";

    
    @Notes
    @javax.persistence.Column(length = Notes.MAX_LEN, nullable = true)
    @Getter @Setter
    @Property(commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @PropertyLayout(fieldSetId = "name", sequence = "2")
    private String notes;


    @Action(semantics = IDEMPOTENT, commandPublishing = Publishing.ENABLED, executionPublishing = Publishing.ENABLED)
    @ActionLayout(associateWith = "noNota", promptStyle = PromptStyle.INLINE)
    public Suplier updateNama(
            @Nama final String name) {
        setNama(name);
        return this;
    }
    public String default0UpdateNama() {
        return getNama();
    }
    public String validate0UpdateNama(String newName) {
        for (char prohibitedCharacter : "&%$!".toCharArray()) {
            if( newName.contains(""+prohibitedCharacter)) {
                return "Character '" + prohibitedCharacter + "' is not allowed.";
            }
        }
        return null;
    }


    @Action(semantics = NON_IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(
            position = ActionLayout.Position.PANEL,
            describedAs = "Deletes this object from the persistent datastore")
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }



    private final static Comparator<Suplier> comparator =
            Comparator.comparing(Suplier::getNama);

    @Override
    public int compareTo(final Suplier other) {
        return comparator.compare(this, other);
    }

}
