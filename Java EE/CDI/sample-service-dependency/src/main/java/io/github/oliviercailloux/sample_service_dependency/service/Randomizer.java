package io.github.oliviercailloux.sample_service_dependency.service;

public class Randomizer implements IRandomizer {
	@Override
	public String pickCandidate() {
		return "Batman";
	}
}
