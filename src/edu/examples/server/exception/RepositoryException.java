package edu.examples.server.exception;

public class RepositoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable t) {
		super(t);
	}

	public RepositoryException(String message, Throwable t) {
		super(message, t);
	}
}