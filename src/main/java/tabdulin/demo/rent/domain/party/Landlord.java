package tabdulin.demo.rent.domain.party;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;
import tabdulin.demo.rent.domain.contract.Contract;
import tabdulin.demo.rent.domain.property.Property;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public class Landlord extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @NotNull
    private PartyType type;

    @OneToMany(mappedBy = "landlord")
    private Set<Contract> contracts;

    @OneToMany(mappedBy = "landlord")
    private Set<Property> properties;
}
