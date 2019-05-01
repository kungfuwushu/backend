package fr.kungfunantes.backend.utils;

import fr.kungfunantes.backend.exception.ResourceNotFoundException;

import java.util.Optional;

public class RestPreconditions {
    public static <T> T checkFound(Optional<T> resource) {
        if (!resource.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return resource.get();
    }
}