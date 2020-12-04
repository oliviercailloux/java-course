package io.github.oliviercailloux.sample_service_dependency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		new App().proceed();
	}

	public void proceed() {
		LOGGER.info("Started.");
		LOGGER.info("Voting for {}.", new Voter().castVote());
		LOGGER.info("Ended.");
	}
}
