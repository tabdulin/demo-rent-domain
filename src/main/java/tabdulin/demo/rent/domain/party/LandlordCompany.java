package tabdulin.demo.rent.domain.party;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Inheritance
@DiscriminatorValue(PartyType.COMPANY_VALUE)
public class LandlordCompany extends Landlord {
    @OneToOne
    @JoinColumn(name = "company_id")
    @NotNull
    private Company company;
}
