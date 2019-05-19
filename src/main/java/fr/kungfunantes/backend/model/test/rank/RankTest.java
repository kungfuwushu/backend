package fr.kungfunantes.backend.model.test.rank;

import fr.kungfunantes.backend.model.test.Test;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ApiModel
@DiscriminatorValue(value = "RANK")
public class RankTest extends Test {
}
