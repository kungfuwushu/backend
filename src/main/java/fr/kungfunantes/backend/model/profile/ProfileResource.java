package fr.kungfunantes.backend.model.profile;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

// TODO add access control
@RestController
public class ProfileResource {

	@Autowired
	private ProfileRepository profileRepository;

	@GetMapping("/profile")
	public List<Profile> retrieveAllProfiles() {
		return profileRepository.findAll();
	}

	@GetMapping("/profile/{id}")
	@ApiOperation(value = "Find profile by id",
    notes = "Also returns a link to retrieve all profiles with relation all-profiles")
	public Resource<Profile> retrieveProfile(@PathVariable long id) {
		Optional<Profile> profile = profileRepository.findById(id);

		if (!profile.isPresent())
			throw new ProfileNotFoundException("id-" + id);

		Resource<Profile> resource = new Resource<Profile>(profile.get());

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllProfiles());

		resource.add(linkTo.withRel("all-profiles"));

		return resource;
	}

	@DeleteMapping("/profile/{id}")
	@ApiOperation(value = "Delete a profile based on its id")
	public void deleteProfile(@PathVariable long id) {
		profileRepository.deleteById(id);
	}

	// TODO the id should be calculated on the server, so we should not expect the client to provide it
	@PostMapping("/profile")
	@ApiOperation(value = "Creates a profile with the provided parameters",
    notes = "TODO the id should be calculated on the server, so we should not expect the client to provide it")
	public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
		Profile savedProfile = profileRepository.save(profile);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProfile.getId()).toUri();

		return ResponseEntity.created(location).body(profile);

	}
	
	@PutMapping("/profile/{id}")
	@ApiOperation(value = "Updates the profile with the given id with the provided parameters")
	public ResponseEntity<Profile> updateStudent(@RequestBody Profile profile, @PathVariable long id) {

		Optional<Profile> optionalProfile = profileRepository.findById(id);

		if (!optionalProfile.isPresent())
			return ResponseEntity.notFound().build();

		profile.setId(id);
		
		profileRepository.save(profile);

		return ResponseEntity.ok(profile);
	}
}
