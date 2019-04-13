package tabdulin.demo.rent.domain.property;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@Inheritance
@DiscriminatorValue(PropertyType.BUILDING_VALUE)
public class Building extends AbstractEntity {
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;
}
