package fr.kungfunantes.backend.model.test.program;


import fr.kungfunantes.backend.model.test.TestResult;
import io.swagger.annotations.ApiModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@ApiModel
@DiscriminatorValue(value = "PROGRAM")
public class ProgramTestResult extends TestResult {
}
