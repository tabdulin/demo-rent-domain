package tabdulin.demo.rent.domain.party;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Inheritance
@DiscriminatorValue(PartyType.INDIVIDUAL_VALUE)
public class LandlordIndividual extends Landlord {
    @OneToOne
    @JoinColumn(name = "individual_id")
    @NotNull
    private Individual individual;
}
