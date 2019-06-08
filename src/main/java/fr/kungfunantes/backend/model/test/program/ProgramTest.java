package fr.kungfunantes.backend.model.test.program;

import fr.kungfunantes.backend.model.Program;
import fr.kungfunantes.backend.model.test.Test;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "PROGRAM")
public class ProgramTest extends Test {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programId")
    @NotNull
    private Program program;
}
