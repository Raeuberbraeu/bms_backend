package de.raeuberbraeu.bms.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.raeuberbraeu.bms.BMSApplication;
import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;
import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;
import de.raeuberbraeu.bms.service.StorageService;
import de.raeuberbraeu.bms.test.utils.AssertionUtils;
import de.raeuberbraeu.bms.test.utils.TestDataGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BMSApplication.class)
public class StorageServiceTest {

	@Autowired
	private StorageService storageService;
	
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
	 * getAllMalts() should return all malts that are in storageSingleton.
	 */
	@Test
	public void getAllMalts() {
		// WHEN
		List<Malt> allMaltsInStorage = storageService.getAllMalts();
		int expectedNumberOfMalts = initialMaltTestData.size();
		// THEN
		// check number of malts in storage
		Assert.assertEquals("Number of malts in storage is wrong.", expectedNumberOfMalts, allMaltsInStorage.size());
		// check if each malt in storage is the correct malt
		for (int i = 0; i < allMaltsInStorage.size(); i++) {
			Malt maltToBeTested = allMaltsInStorage.get(i);
			Malt expectedMalt = initialMaltTestData.get(i);
			AssertionUtils.checkEachElementOfMalt(expectedMalt, maltToBeTested);
		}
	}

	/**
	 * getAllHops() should return all hops that are in storageSingleton.
	 */
	@Test
	public void getAllHops() {
		// WHEN
		List<Hops> allHopsInStorage = storageService.getAllHops();
		int expectedNumberOfHops = initialHopsTestData.size();
		// THEN
		// check number of hops in storage
		Assert.assertEquals("Number of hops in storage is wrong.", expectedNumberOfHops, allHopsInStorage.size());
		// check if each hops in storage is the correct hops
		for (int i = 0; i < allHopsInStorage.size(); i++) {
			Hops hopsToBeTested = allHopsInStorage.get(i);
			Hops expectedHops = initialHopsTestData.get(i);
			AssertionUtils.checkEachElementOfHops(expectedHops, hopsToBeTested);
		}
	}

	/**
	 * When adding a new malt to the storage it should be contained in the DB and
	 * the number of malts in the storage increases by one.
	 */
	@Test
	public void addAndPersistMalt() {
		// GIVEN
		Malt newMalt = testDataGenerator.build().oneMalt();
		int numberOfMaltsBeforeAddingNewMalt = initialMaltTestData.size();
		// WHEN
		Malt savedMalt = storageService.addAndPersistMalt(newMalt);
		List<Malt> allMaltsInStorageAfterAddingNewMalt = storageService.getAllMalts();
		List<Malt> allMaltsInDBAfterAddingNewMalt = maltRepo.findAll();
		// THEN
		// number of malts in storage should be one more than before and it should be
		// equal to the number of malts in DB
		Assert.assertEquals("Number of malts in storage is wrong.", numberOfMaltsBeforeAddingNewMalt + 1,
				allMaltsInStorageAfterAddingNewMalt.size());
		Assert.assertEquals("Number of malts in DB is wrong.", allMaltsInStorageAfterAddingNewMalt.size(),
				allMaltsInDBAfterAddingNewMalt.size());
		// savedMalt (return value of addAndPersistMalt()) should be equal to newMalt
		AssertionUtils.checkEachElementOfMalt(newMalt, savedMalt);
		// new malt should be contained in storage and in DB
		Assert.assertTrue("New malt is not contained in storage",
				allMaltsInStorageAfterAddingNewMalt.contains(newMalt));
		Assert.assertTrue("New malt is not contained in DB", allMaltsInDBAfterAddingNewMalt.contains(newMalt));
	}

	/**
	 * When adding a new hops to the storage it should be contained in the DB and
	 * the number of hops in the storage increases by one.
	 */
	@Test
	public void addAndPersistHops() {
		// GIVEN
		Hops newHops = testDataGenerator.build().oneHops();
		int numberOfHopsBeforeAddingNewHops = initialHopsTestData.size();
		// WHEN
		Hops savedHops = storageService.addAndPersistHops(newHops);
		List<Hops> allHopsInStorageAfterAddingNewHops = storageService.getAllHops();
		List<Hops> allHopsInDBAfterAddingNewHops = hopsRepo.findAll();
		// THEN
		// number of hops in storage should be one more than before and it should be
		// equal to the number of hops in DB
		Assert.assertEquals("Number of hops in storage is wrong.", numberOfHopsBeforeAddingNewHops + 1,
				allHopsInStorageAfterAddingNewHops.size());
		Assert.assertEquals("Number of hops in DB is wrong.", allHopsInStorageAfterAddingNewHops.size(),
				allHopsInDBAfterAddingNewHops.size());
		// savedHops (return value of addAndPersistHops()) should be equal to newHops
		AssertionUtils.checkEachElementOfHops(newHops, savedHops);
		// new hops should be contained in storage and in DB
		Assert.assertTrue("New hops is not contained in storage", allHopsInStorageAfterAddingNewHops.contains(newHops));
		Assert.assertTrue("New hops is not contained in DB", allHopsInDBAfterAddingNewHops.contains(newHops));
	}

	// When deleting a hops, this hops should not be contained anymore in the
	// storage and in DB.
	@Test
	public void deleteHops() {
		// GIVEN
		List<Hops> allHopsInDBBeforeDeletingHops = hopsRepo.findAll();
		List<Hops> allHopsInStorageBeforeDeletingHops = storageService.getAllHops();
		int numberOfHopsInStorageBeforeDeletingHops = allHopsInStorageBeforeDeletingHops.size();
		Hops hopsToBeDeleted = allHopsInDBBeforeDeletingHops.get(0);
		// WHEN
		Hops deletedHops = storageService.deleteHops(hopsToBeDeleted.getId());
		List<Hops> allHopsInStorageAfterDeletingHops = storageService.getAllHops();
		List<Hops> allHopsInDBAfterDeletingHops = hopsRepo.findAll();
		// THEN
		// Number of hops in DB and in Storage is decreased by one
		Assert.assertEquals("Number of hops in DB is wrong.", allHopsInDBBeforeDeletingHops.size() - 1,
				allHopsInDBAfterDeletingHops.size());
		Assert.assertEquals("Number of hops in storage is wrong.", numberOfHopsInStorageBeforeDeletingHops - 1,
				allHopsInStorageAfterDeletingHops.size());
		// deletedHops (return value of deleteHops()) should be equal to hopsToBeDeleted
		AssertionUtils.checkEachElementOfHops(hopsToBeDeleted, deletedHops);
		// hopsToBeDeleted should not be contained in storage and in DB
		Assert.assertFalse("hopsToBeDeleted is still contained in storage",
				allHopsInStorageAfterDeletingHops.contains(hopsToBeDeleted));
		Assert.assertFalse("hopsToBeDeleted is still contained in DB",
				allHopsInDBAfterDeletingHops.contains(hopsToBeDeleted));
	}

	// When deleting a malt, this malt should not be contained anymore in the
	// storage and in DB.
	@Test
	public void deleteMalt() {
		// GIVEN
		List<Malt> allMaltsInDBBeforeDeletingMalt = maltRepo.findAll();
		List<Malt> allMaltsInStorageBeforeDeletingMalt = storageService.getAllMalts();
		int numberOfMaltInStorageBeforeDeletingMalt = allMaltsInStorageBeforeDeletingMalt.size();
		Malt maltToBeDeleted = allMaltsInDBBeforeDeletingMalt.get(0);
		// WHEN
		Malt deletedMalt = storageService.deleteMalt(maltToBeDeleted.getId());
		List<Malt> allMaltsInStorageAfterDeletingMalt = storageService.getAllMalts();
		List<Malt> allMaltsInDBAfterDeletingMalt = maltRepo.findAll();
		// THEN
		// Number of hops in DB and in Storage is decreased by one
		Assert.assertEquals("Number of malts in DB is wrong.", allMaltsInDBBeforeDeletingMalt.size() - 1,
				allMaltsInDBAfterDeletingMalt.size());
		Assert.assertEquals("Number of malts in storage is wrong.", numberOfMaltInStorageBeforeDeletingMalt - 1,
				allMaltsInStorageAfterDeletingMalt.size());
		// deletedMalt (return value of deleteHops()) should be equal to maltToBeDeleted
		AssertionUtils.checkEachElementOfMalt(maltToBeDeleted, deletedMalt);
		// hopsToBeDeleted should not be contained in storage and in DB
		Assert.assertFalse("maltToBeDeleted is still contained in storage",
				allMaltsInStorageAfterDeletingMalt.contains(maltToBeDeleted));
		Assert.assertFalse("maltToBeDeleted is still contained in DB",
				allMaltsInDBAfterDeletingMalt.contains(maltToBeDeleted));
	}
}
