package se.svt.test.pathmatch.pattern.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.svt.test.pathmatch.pattern.model.Result;

/**
 * TODO write documentation
 */
@RestController
public class TestResource {
	@GetMapping(path = "/{first}/{second}")
	public Result get(@PathVariable String first,
	                  @PathVariable String second) {
		return Result.builder()
				.first(first)
				.second(second)
				.build();
	}
}
