package tabdulin.demo.rent.domain.party;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;
import tabdulin.demo.rent.domain.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public class Tenant extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @NotNull
    private PartyType type;

    @ManyToMany(mappedBy = "tenants")
    private Set<Contract> contracts;
}
