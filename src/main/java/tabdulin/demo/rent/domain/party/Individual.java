package tabdulin.demo.rent.domain.party;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Individual extends AbstractEntity {
    @NotBlank
    private String name;
}
