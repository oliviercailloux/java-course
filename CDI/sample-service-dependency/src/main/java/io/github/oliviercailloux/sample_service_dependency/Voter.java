package io.github.oliviercailloux.sample_service_dependency;

import io.github.oliviercailloux.sample_service_dependency.service.Randomizer;

public class Voter {
	public String castVote() {
		final Randomizer randomizer = new Randomizer();
		return randomizer.pickCandidate();
	}
}
