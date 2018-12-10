package io.github.oliviercailloux.sample_service_dependency;

import io.github.oliviercailloux.sample_service_dependency.service.IRandomizer;
import io.github.oliviercailloux.sample_service_dependency.service.Randomizer;

public class Voter {
	public String castVote() {
		final IRandomizer randomizer = new Randomizer();
		return randomizer.pickCandidate();
	}
}
