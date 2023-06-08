package com.agency360.listing;

import com.agency360.listing.dto.ListingDto;
import com.agency360.listing.model.tables.daos.DealerDao;
import com.agency360.listing.model.tables.pojos.Dealer;
import com.agency360.listing.model.tables.pojos.Listing;
import com.agency360.listing.service.DealerService;
import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static com.agency360.listing.model.tables.Listing.LISTING;
import static com.agency360.listing.model.tables.TierLimit.TIER_LIMIT;


@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ListingManagerApplicationTests {


	@Autowired
	DealerDao dealerDao;

	@Autowired
	DealerService dealerService;
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@Autowired
	private DSLContext dsl;
	private String createURLWithPort() {
		return "http://localhost:" + port +"/api/listing";
	}

	@BeforeAll
	public void initialize(){
		dealerService.save(new Dealer(99,"Abdoul"));
		dealerService.save(new Dealer(98,"Michel"));
		dealerService.save(new Dealer(97,"Karine"));

	}

	@AfterAll
	public void clear(){
	  dsl.deleteFrom(LISTING).where(LISTING.DEALER_ID.in(97,98,99)).execute();
	  dsl.deleteFrom(TIER_LIMIT).execute();
	  dealerDao.deleteById(99,98,97);
	}

	@Test
	void create_ad_with_known_dealer_should_return_success_status() {
		ListingDto listing = new ListingDto();
		listing.setDealerId(99);
		listing.setVehicule("Toyota");
		listing.setPrice(10000L);
		ResponseEntity<ListingDto> postResponse = restTemplate.postForEntity(createURLWithPort() + "/save", listing, ListingDto.class);
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
			 restTemplate.postForEntity(createURLWithPort() + "/save", listing, ListingDto.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(HttpStatus.NOT_FOUND,e.getStatusCode());
		}
	}

	@Test
	void update_existing_ad_should_return_success_status() {
		ListingDto actualListing = new ListingDto();
		actualListing.setDealerId(99);
		actualListing.setVehicule("Renault");
		actualListing.setPrice(15000L);
		actualListing.setState("draft");

		int listingId = getCreatedListingId(actualListing);

		actualListing.setVehicule("Volkswagen");
		actualListing.setPrice(10000L);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<ListingDto> requestEntity = new HttpEntity<>(actualListing,headers);

		ResponseEntity<ListingDto> updatedListing = restTemplate.exchange(createURLWithPort() + "/update/" + listingId, HttpMethod.PUT, requestEntity, ListingDto.class);

		Assert.assertEquals(HttpStatus.OK, updatedListing.getStatusCode());
		Assert.assertNotNull(updatedListing.getBody());

	}


	@Test
	void get_list_of_ads_by_criteria_should_return_success_status() {
		ListingDto actualListing = new ListingDto();
		actualListing.setDealerId(99);
		actualListing.setVehicule("hyundai tucson");
		actualListing.setPrice(30000L);
		actualListing.setState("draft");

		getCreatedListingId(actualListing);
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(createURLWithPort() + "/"+actualListing.getDealerId()+"/"+actualListing.getState(),	HttpMethod.GET, entity, String.class);

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertNotNull(responseEntity.getBody());
		Assert.assertFalse(responseEntity.getBody().isEmpty());

	}

	@Test
	void publish_ad_in_dealer_limit_should_return_success_status() {
		ListingDto actualListing = new ListingDto();
		actualListing.setDealerId(99);
		actualListing.setVehicule("Audi");
		actualListing.setPrice(30000L);
		actualListing.setState("draft");

		int listingId = getCreatedListingId(actualListing);
		insertListingLimit(actualListing.getDealerId(),3);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Listing> requestEntity = new HttpEntity<>(null,headers);

		ResponseEntity<Listing> responseEntity = restTemplate.exchange(createURLWithPort() + "/publish/"+listingId,	HttpMethod.PUT, requestEntity, Listing.class);

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertNotNull(responseEntity.getBody());

	}

	@Test
	void publish_ad_over_dealer_limit_should_return_success_status() {
		ListingDto actualFirstListing = new ListingDto();
		actualFirstListing.setDealerId(98);
		actualFirstListing.setVehicule("SUZUKI");
		actualFirstListing.setPrice(12000L);
		actualFirstListing.setState("published");

		ListingDto actualSecondListing = new ListingDto();
		actualSecondListing.setDealerId(98);
		actualSecondListing.setVehicule("Mazda");
		actualSecondListing.setPrice(11000L);
		actualSecondListing.setState("published");

		ListingDto actualThirdListing = new ListingDto();
		actualThirdListing.setDealerId(98);
		actualThirdListing.setVehicule("Citroen");
		actualThirdListing.setPrice(12000L);
		actualThirdListing.setState("draft");

		getCreatedListingId(actualFirstListing);
		getCreatedListingId(actualSecondListing);

		int listingId = getCreatedListingId(actualThirdListing);
		insertListingLimit(actualFirstListing.getDealerId(),2);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Listing> requestEntity = new HttpEntity<>(null,headers);

		ResponseEntity<Listing> responseEntity = restTemplate.exchange(createURLWithPort() + "/publish/"+listingId,	HttpMethod.PUT, requestEntity, Listing.class);

		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		Assert.assertNotNull(responseEntity.getBody());

	}


	@Test
	void unpublish_ad_should_return_success_status() {
		ListingDto actualListing = new ListingDto();
		actualListing.setDealerId(97);
		actualListing.setVehicule("Peugeot");
		actualListing.setPrice(10000L);
		actualListing.setState("published");

		int listingId = getCreatedListingId(actualListing);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Listing> requestEntity = new HttpEntity<>(null,headers);

		ResponseEntity<Listing> responseEntity = restTemplate.exchange(createURLWithPort() + "/unpublish/"+listingId,	HttpMethod.PUT, requestEntity, Listing.class);

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertNotNull(responseEntity.getBody());

	}

	private void insertListingLimit(Integer dealerId,Integer dealerLimit) {
		dsl.insertInto(TIER_LIMIT,TIER_LIMIT.DEALER_ID,TIER_LIMIT.LISTING_LIMIT).values(dealerId,dealerLimit).execute();
	}


	private int getCreatedListingId(ListingDto actualListing) {
		return dsl.insertInto(LISTING, LISTING.DEALER_ID, LISTING.VEHICULE, LISTING.PRICE, LISTING.STATE)
				  .values(actualListing.getDealerId(), actualListing.getVehicule(), actualListing.getPrice(), actualListing.getState())
				  .returningResult(LISTING.ID).fetchOneInto(Integer.class);
	}


}
