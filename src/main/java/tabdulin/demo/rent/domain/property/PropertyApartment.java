package tabdulin.demo.rent.domain.property;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorValue(PropertyType.APARTMENT_VALUE)
public class PropertyApartment extends Property {
    @OneToOne
    @JoinColumn(name = "apartment_id")
    @NotNull
    private Apartment apartment;
}
