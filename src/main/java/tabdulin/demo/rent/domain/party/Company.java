package tabdulin.demo.rent.domain.party;

import lombok.Data;
import tabdulin.demo.rent.domain.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Company extends AbstractEntity {
    @NotBlank
    private String name;

    @OneToOne
    @JoinColumn(name = "representative_id")
    @NotNull
    private Individual representative;
}
