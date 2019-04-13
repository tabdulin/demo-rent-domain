package tabdulin.demo.rent.domain.property;

import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorColumn(name = PropertyType.BUILDING_VALUE)
public class PropertyBuilding extends Property {
    @OneToOne
    @JoinColumn(name = "building_id")
    @NotNull
    private Building building;
}
