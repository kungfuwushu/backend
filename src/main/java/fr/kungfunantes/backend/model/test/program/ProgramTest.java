package fr.kungfunantes.backend.model.test.program;

import fr.kungfunantes.backend.model.Program;
import fr.kungfunantes.backend.model.test.Test;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel
@DiscriminatorValue(value = "PROGRAM")
public class ProgramTest extends Test {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programId")
    @NotNull
    private Program program;

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
