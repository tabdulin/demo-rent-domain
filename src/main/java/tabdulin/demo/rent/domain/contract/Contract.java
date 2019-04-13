package tabdulin.demo.rent.domain.contract;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;
import tabdulin.demo.rent.domain.party.Landlord;
import tabdulin.demo.rent.domain.party.Tenant;
import tabdulin.demo.rent.domain.property.Property;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Contract extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "landlord_id")
    @NotNull
    private Landlord landlord;

    @ManyToMany
    @JoinTable(
            name = "contract_tenant",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "tenant_id")
    )
    @NotEmpty
    private Set<Tenant> tenants;

    @ManyToMany
    @JoinTable(
            name = "contract_property",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns =  @JoinColumn(name = "property_id")
    )
    @NotEmpty
    private Set<Property> properties;

    @Column(name = "start_date")
    @NotNull
    private LocalDate startDate;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;

    @NotNull
    private BigDecimal price;
}
