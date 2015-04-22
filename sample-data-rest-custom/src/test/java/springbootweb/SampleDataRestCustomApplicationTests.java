package springbootweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleDataRestCustomApplication.class)
@WebAppConfiguration
public class SampleDataRestCustomApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testHome() throws Exception {

		this.mvc.perform(get("/api")).andExpect(status().isOk())
				.andExpect(content().string(containsString("headquarters")));

	}

	@Test
	public void findByCapitalAndHeadquarters() throws Exception {

		this.mvc.perform(
			get("/api/headquarters/search/findByCapitalAndHeadquartersAllIgnoringCase?capital=London&headquarters=Surrey"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("_embedded.headquarters[0].language", equalTo("English")))
		.andExpect(jsonPath("_embedded.headquarters[0].capital", equalTo("London")));
	}

	@Test
	public void findByContaining() throws Exception {

		this.mvc.perform(
				get("/api/headquarters/search/findByCapitalContainingAndHeadquartersContainingAllIgnoringCase?capital=London&headquarters="))
				.andExpect(status().isOk())
				.andExpect(jsonPath("_embedded.headquarters", hasSize(4)));
	}
}
