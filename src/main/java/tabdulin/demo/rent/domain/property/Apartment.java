package tabdulin.demo.rent.domain.property;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@DiscriminatorValue(PropertyType.APARTMENT_VALUE)
public class Apartment extends AbstractEntity {
    @NotBlank
    private String address;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
