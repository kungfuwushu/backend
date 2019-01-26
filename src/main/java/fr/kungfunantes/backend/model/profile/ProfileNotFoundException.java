package fr.kungfunantes.backend.model.profile;

public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -631341766686864594L;

	public ProfileNotFoundException(String exception) {
		super(exception);
	}

}
