package de.raeuberbraeu.bms.test.controller;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;
import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;
import de.raeuberbraeu.bms.test.utils.AssertionUtils;
import de.raeuberbraeu.bms.test.utils.ControllerTestUtils;
import de.raeuberbraeu.bms.test.utils.TestDataGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
public class StorageControllerTest extends RestAssuredConfig {

	@Autowired
	private MaltRepository maltRepo;
	@Autowired
	private HopsRepository hopsRepo;

	private TestDataGenerator testDataGenerator;
	private List<Malt> initialMaltTestData;
	private List<Hops> initialHopsTestData;

	@Before
	public void initDB() {
		testDataGenerator = new TestDataGenerator(maltRepo, hopsRepo);
		testDataGenerator.clearDB();
		initialMaltTestData = testDataGenerator.build().listWith2Malts();
		initialHopsTestData = testDataGenerator.build().listWith2Hops();
		testDataGenerator.saveDataInDB(initialMaltTestData, initialHopsTestData);
		testDataGenerator.resetStorageSingleton();
	}

	/**
	 * The list of initialMaltTestData should match the list of malts returned by
	 * the rest-api.
	 */
	@Test
	public void allMalts() {
		// When
		Response response = RestAssured.when().get("/api/malts");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.OK);
		// allMaltsFromRestApi should be equal to initialMaltTestData
		List<Malt> allMaltsFromRestApi = response.then().extract().body().jsonPath().getList(".", Malt.class);
		for (int i = 0; i < allMaltsFromRestApi.size(); i++) {
			AssertionUtils.checkEachElementOfMalt(initialMaltTestData.get(i), allMaltsFromRestApi.get(i));
		}
	}

	/**
	 * The list of initialHopsTestData should match the list of hops returned by the
	 * rest-api.
	 */
	@Test
	public void allHops() {
		// When
		Response response = RestAssured.when().get("/api/hops");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.OK);
		// allHopsFromRestApi should be equal to initialHopsTestData
		List<Hops> allHopsFromRestApi = response.then().extract().body().jsonPath().getList(".", Hops.class);
		for (int i = 0; i < allHopsFromRestApi.size(); i++) {
			AssertionUtils.checkEachElementOfHops(initialHopsTestData.get(i), allHopsFromRestApi.get(i));
		}
	}

	/**
	 * When adding one malt the rest-api should respond with the new malt and it
	 * should be contained in DB.
	 */
	@Test
	public void addMalt() {
		// Given
		Malt maltToBeAdded = testDataGenerator.build().oneMalt();
		RequestSpecification request = given().pathParam("name", maltToBeAdded.getName())
				.pathParam("price", String.valueOf(maltToBeAdded.getPrice()))
				.pathParam("ebcMin", maltToBeAdded.getEbcMin()).pathParam("ebcMax", maltToBeAdded.getEbcMax())
				.pathParam("amount", maltToBeAdded.getAmount()).pathParam("ground", maltToBeAdded.isGround())
				.pathParam("shop", maltToBeAdded.getShop())
				.pathParam("dateOfPurchase", String.valueOf(maltToBeAdded.getDateOfPurchase()))
				.pathParam("useByDate", String.valueOf(maltToBeAdded.getUseByDate()));
		// When
		Response response = request.when().post(
				"/api/storage/addMalt/{name}/{price}/{ebcMin}/{ebcMax}/{amount}/{ground}/{shop}/{dateOfPurchase}/{useByDate}");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.CREATED);
		// Response contains the new malt which should be equal to maltToBeAdded
		Malt newMalt = response.then().extract().body().as(Malt.class);
		Assert.assertNotNull(newMalt);
		AssertionUtils.checkEachElementOfMalt(maltToBeAdded, newMalt);
		// new malt should be found in DB
		Malt malt = maltRepo.findById(newMalt.getId()).orElseGet(null);
		Assert.assertNotNull(malt);
	}

	/**
	 * When adding one hops the rest-api should respond with the new hops and it
	 * should be contained in DB.
	 */
	@Test
	public void addHops() {
		// Given
		Hops hopsToBeAdded = testDataGenerator.build().oneHops();
		RequestSpecification request = given().pathParam("name", hopsToBeAdded.getName())
				.pathParam("alpha", hopsToBeAdded.getAlpha())
				.pathParam("price", String.valueOf(hopsToBeAdded.getPrice()))
				.pathParam("amount", hopsToBeAdded.getAmount()).pathParam("shop", hopsToBeAdded.getShop())
				.pathParam("dateOfPurchase", String.valueOf(hopsToBeAdded.getDateOfPurchase()))
				.pathParam("useByDate", String.valueOf(hopsToBeAdded.getUseByDate()));
		// When
		Response response = request.when()
				.post("/api/storage/addHops/{name}/{alpha}/{price}/{amount}/{shop}/{dateOfPurchase}/{useByDate}");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.CREATED);
		// Response contains the new hops which should be equal to hopsToBeAdded
		Hops newHops = response.then().extract().body().as(Hops.class);
		Assert.assertNotNull(newHops);
		AssertionUtils.checkEachElementOfHops(hopsToBeAdded, newHops);
		// new hops should be found in DB
		Hops hops = hopsRepo.findById(newHops.getId()).orElseGet(null);
		Assert.assertNotNull(hops);
	}

	/**
	 * When deleting one hops then the rest-api should respond with the deleted hops
	 * and it should not be contained anymore in the DB.
	 */
	@Test
	public void deleteHops() {
		// Given
		Hops hopsToBeDeleted = initialHopsTestData.get(0);
		RequestSpecification request = given().pathParam("id", hopsToBeDeleted.getId());
		// When
		Response response = request.when().delete("/api/storage/deleteHops/{id}");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.OK);
		// Response contains the deleted hops which should be equal to hopsToBeDeleted
		Hops deletedHops = response.then().extract().body().as(Hops.class);
		Assert.assertNotNull(deletedHops);
		AssertionUtils.checkEachElementOfHops(hopsToBeDeleted, deletedHops);
		// deleted hops should not be in DB anymore
		Hops hops = hopsRepo.findById(deletedHops.getId()).orElse(null);
		Assert.assertNull(hops);
	}

	/**
	 * When deleting one malt then the rest-api should respond with the deleted malt
	 * and it should not be contained anymore in the DB.
	 */
	@Test
	public void deleteMalt() {
		// Given
		Malt maltToBeDeleted = initialMaltTestData.get(0);
		RequestSpecification request = given().pathParam("id", maltToBeDeleted.getId());
		// When
		Response response = request.when().delete("/api/storage/deleteMalt/{id}");
		// Then
		ControllerTestUtils.basicCheckOfResponse(response, HttpStatus.OK);
		// Response contains the deleted malt which should be equal to maltToBeDeleted
		Malt deletedMalt = response.then().extract().body().as(Malt.class);
		Assert.assertNotNull(deletedMalt);
		AssertionUtils.checkEachElementOfMalt(maltToBeDeleted, deletedMalt);
		// deleted malt should not be in DB anymore
		Malt malt = maltRepo.findById(deletedMalt.getId()).orElse(null);
		Assert.assertNull(malt);
	}
}
