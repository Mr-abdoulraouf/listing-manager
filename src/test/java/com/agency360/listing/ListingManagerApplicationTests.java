package com.agency360.listing;

import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.daos.ListingDao;
import com.agency360.listing.model.tables.pojos.Dealer;
import com.agency360.listing.model.tables.pojos.Listing;
import com.agency360.listing.service.ListingService;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

import static com.agency360.listing.model.tables.Listing.LISTING;


@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ListingManagerApplicationTests {


	@Autowired
	DealerDao dealerDao;
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@Autowired
	private DSLContext dsl;
	private String createURLWithPort() {
		return "http://localhost:" + port;
	}

	@BeforeAll
	public void initialize(){

		dealerDao.insert(new Dealer(99,"Abdoul"));
	}

	@AfterAll
	public void clear(){
	  dsl.deleteFrom(LISTING).where(LISTING.DEALER_ID.eq(99)).execute();
	  dealerDao.deleteById(99);
	}

	@Test
	void create_ad_with_known_dealer_should_return_success_status() {
		ListingDto listing = new ListingDto();
		listing.setDealerId(99);
		listing.setVehicule("Toyota");
		listing.setPrice(10000L);
		ResponseEntity<ListingDto> postResponse = restTemplate.postForEntity(createURLWithPort() + "/api/listing/save", listing, ListingDto.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
		Assert.assertEquals(201,postResponse.getStatusCodeValue());
	}

	@Test
	void create_ad_with_unknown_dealer_should_throw_exception() {
		ListingDto listing = new ListingDto();
		listing.setDealerId(90);
		listing.setVehicule("Mercedes");
		listing.setPrice(15000L);


		try {
			 restTemplate.postForEntity(createURLWithPort() + "/api/listing/save", listing, ListingDto.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}






}
