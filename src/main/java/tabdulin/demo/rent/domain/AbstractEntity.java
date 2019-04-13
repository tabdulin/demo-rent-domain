package tabdulin.demo.rent.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @NotNull
    private Boolean deleted;
}
