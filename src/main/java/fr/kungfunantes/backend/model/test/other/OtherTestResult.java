package fr.kungfunantes.backend.model.test.other;


import fr.kungfunantes.backend.model.test.TestResult;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "OTHER")
public class OtherTestResult extends TestResult {
}
