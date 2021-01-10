package de.raeuberbraeu.bms.test.domain;

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
import de.raeuberbraeu.bms.domain.StorageSingleton;
import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;
import de.raeuberbraeu.bms.test.utils.AssertionUtils;
import de.raeuberbraeu.bms.test.utils.TestDataGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BMSApplication.class)
public class StorageSingletonTest {

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
	 * Requesting the storage with malt and hops, when the storage is already
	 * filled.
	 */
	@Test
	public void getStorageWithMaltAndHops() {
		// WHEN
		StorageSingleton storage = StorageSingleton.getStorage(maltRepo, hopsRepo);
		// THEN
		// Malt in storage should be equal to initialMaltTestData
		List<Malt> allMaltsInStorage = storage.getAllMalts();
		for (int i = 0; i < allMaltsInStorage.size(); i++) {
			AssertionUtils.checkEachElementOfMalt(initialMaltTestData.get(i), allMaltsInStorage.get(i));
		}
		// Hops in storage should be equal to initialHopsTestData
		List<Hops> allHopsInStorage = storage.getAllHops();
		for (int i = 0; i < allHopsInStorage.size(); i++) {
			AssertionUtils.checkEachElementOfHops(initialHopsTestData.get(i), allHopsInStorage.get(i));
		}
	}

	/**
	 * Requesting the storage with malt and hops, when the storage is empty.
	 */
	@Test
	public void getStorageWithMaltAndHopsWhenStorageIsEmpty() {
		// GIVEN
		StorageSingleton storage = StorageSingleton.getStorage();
		storage.setAllHops(null);
		storage.setAllMalts(null);
		// WHEN
		storage = StorageSingleton.getStorage(maltRepo, hopsRepo);
		// THEN
		// Malt in storage should be equal to initialMaltTestData
		List<Malt> allMaltsInStorage = storage.getAllMalts();
		for (int i = 0; i < allMaltsInStorage.size(); i++) {
			AssertionUtils.checkEachElementOfMalt(initialMaltTestData.get(i), allMaltsInStorage.get(i));
		}
		// Hops in storage should be equal to initialHopsTestData
		List<Hops> allHopsInStorage = storage.getAllHops();
		for (int i = 0; i < allHopsInStorage.size(); i++) {
			AssertionUtils.checkEachElementOfHops(initialHopsTestData.get(i), allHopsInStorage.get(i));
		}
	}

	// When adding one malt, the new malt should be contained in the storage and the
	// number of malts in the storage has increased by one.
	@Test
	public void addOneMalt() {
		// GIVEN
		StorageSingleton storage = StorageSingleton.getStorage();
		Malt newMalt = testDataGenerator.build().oneMalt();
		int numberOfMaltInStorageBeforeAddingNewMalt = storage.getAllMalts().size();
		// WHEN
		storage.addOneMalt(newMalt);
		List<Malt> allMaltsInStorageAfterAddingNewMalt = storage.getAllMalts();
		// THEN
		// Number of malts in storage is increased by one
		Assert.assertEquals(numberOfMaltInStorageBeforeAddingNewMalt + 1, allMaltsInStorageAfterAddingNewMalt.size());
		// newMalt is contained in storage
		Assert.assertTrue(allMaltsInStorageAfterAddingNewMalt.contains(newMalt));
	}

	// When adding one hops, the new hops should be contained in the storage and the
	// number of hops in the storage has increased by one.
	@Test
	public void addOneHops() {
		// GIVEN
		StorageSingleton storage = StorageSingleton.getStorage();
		Hops newHops = testDataGenerator.build().oneHops();
		int numberOfHopsInStorageBeforeAddingNewHops = storage.getAllHops().size();
		// WHEN
		storage.addOneHops(newHops);
		List<Hops> allHopsInStorageAfterAddingNewHops = storage.getAllHops();
		// THEN
		// Number of hops in storage is increased by one
		Assert.assertEquals(numberOfHopsInStorageBeforeAddingNewHops + 1, allHopsInStorageAfterAddingNewHops.size());
		// newHops is contained in storage
		Assert.assertTrue(allHopsInStorageAfterAddingNewHops.contains(newHops));
	}

	// When deleting one hops it should not be contained anymore in the storage.
	@Test
	public void deleteHops() {
		// GIVEN
		StorageSingleton storage = StorageSingleton.getStorage();
		Hops hopsToBeDelted = storage.getAllHops().get(0);
		int numberOfHopsBeforeDeletingHops = storage.getAllHops().size();
		// WHEN
		storage.removeHops(hopsToBeDelted.getId());
		List<Hops> allHopsInStorageAfterDeletingNewHops = storage.getAllHops();
		// THEN
		// Number of hops in storage is one less
		Assert.assertEquals(numberOfHopsBeforeDeletingHops - 1, allHopsInStorageAfterDeletingNewHops.size());
		// hopsToBeDelted is not contained in storage
		Assert.assertFalse(allHopsInStorageAfterDeletingNewHops.contains(hopsToBeDelted));
	}
	
	// When deleting one malt it should not be contained anymore in the storage.
		@Test
		public void deleteMalt() {
			// GIVEN
			StorageSingleton storage = StorageSingleton.getStorage();
			Malt maltToBeDelted = storage.getAllMalts().get(0);
			int numberOfMaltsBeforeDeletingMalt = storage.getAllMalts().size();
			// WHEN
			storage.removeMalt(maltToBeDelted.getId());
			List<Malt> allMaltsInStorageAfterDeletingNewMalt = storage.getAllMalts();
			// THEN
			// Number of malts in storage is one less
			Assert.assertEquals(numberOfMaltsBeforeDeletingMalt - 1, allMaltsInStorageAfterDeletingNewMalt.size());
			// maltToBeDelted is not contained in storage
			Assert.assertFalse(allMaltsInStorageAfterDeletingNewMalt.contains(maltToBeDelted));
		}
}
