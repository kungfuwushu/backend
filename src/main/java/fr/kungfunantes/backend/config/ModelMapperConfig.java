package fr.kungfunantes.backend.config;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.model.exercise.ExerciseDto;
import fr.kungfunantes.backend.model.exercise.type.Physical;
import fr.kungfunantes.backend.model.exercise.type.PhysicalDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Physical.class, ExerciseDto.class).setProvider(request -> {
            ExerciseDto exercise = new PhysicalDto();
            modelMapper.map(request.getSource(), exercise);
            return exercise;
        });
        modelMapper.typeMap(PhysicalDto.class, Exercise.class).setProvider(request -> {
            Exercise exercise = new Physical();
            modelMapper.map(request.getSource(), exercise);
            return exercise;
        });

		return modelMapper;
	}

}