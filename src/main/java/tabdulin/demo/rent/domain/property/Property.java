package tabdulin.demo.rent.domain.property;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;
import tabdulin.demo.rent.domain.contract.Contract;
import tabdulin.demo.rent.domain.party.Landlord;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Inheritance()
@DiscriminatorColumn(name = "type")
public class Property extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @NotNull
    private PropertyType type;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    @NotNull
    private Landlord landlord;

    @ManyToMany(mappedBy = "properties")
    private Set<Contract> contracts;

}
