package de.raeuberbraeu.bms.test.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;
import de.raeuberbraeu.bms.domain.StorageSingleton;
import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;

public class TestDataGenerator {

	// Parameter for all
	private static final BigDecimal PRICE_WITH_2_DECIMALS = new BigDecimal("2.54");
	private static final BigDecimal PRICE_WITH_1_DECIMALS = new BigDecimal("3.4");
	private static final BigDecimal PRICE_WITHOUT_DECIMAL = new BigDecimal("4");
	private static final String SHOP = "Hobbybrauerversand";
	private static final LocalDate DATE_OF_PURCHASE = LocalDate.of(2019, 4, 23);
	private static final LocalDate USE_BY_DATE = LocalDate.of(2020, 3, 22);

	// Parameter for malt
	private static final double EBC_MIN = 2;
	private static final double EBC_MAX = 6;
	private static final double MALT_AMOUNT = 4000;
	private static final boolean GROUND = false;

	// Parameter for hops
	private static final double ALPHA = 12;
	private static final double HOPS_AMOUNT = 40;

	private MaltRepository maltRepo;
	private HopsRepository hopsRepo;
	
	public TestDataGenerator(MaltRepository maltRepo, HopsRepository hopsRepo) {
		this.maltRepo = maltRepo;
		this.hopsRepo = hopsRepo;
	}

	/**
	 * Deleting all data in DB.
	 */
	public void clearDB() {
		maltRepo.deleteAll();
		hopsRepo.deleteAll();
	}

	/**
	 * Emptying storage and then refill it with data from DB.
	 */
	public void resetStorageSingleton() {
		StorageSingleton storage = StorageSingleton.getStorage(maltRepo, hopsRepo);
		storage.setAllMalts(null);
		storage.setAllHops(null);
		StorageSingleton.getStorage(maltRepo, hopsRepo);
	}

	public void saveDataInDB(List<Malt> allMalts, List<Hops> allHops) {
		maltRepo.saveAll(allMalts);
		hopsRepo.saveAll(allHops);
	}

	public Builder build() {
		return new Builder();
	}

	public class Builder {

		public List<Hops> listWith2Hops() {
			Hops testHops1 = new Hops("TestHopsName", ALPHA, PRICE_WITH_2_DECIMALS, HOPS_AMOUNT, SHOP, DATE_OF_PURCHASE,
					USE_BY_DATE);
			Hops testHops2 = new Hops("TestHopsName2", ALPHA, PRICE_WITH_1_DECIMALS, HOPS_AMOUNT, SHOP,
					DATE_OF_PURCHASE, USE_BY_DATE);
			List<Hops> allHops = new ArrayList<>();
			allHops.add(testHops1);
			allHops.add(testHops2);
			return allHops;
		}

		public List<Malt> listWith2Malts() {
			Malt testMalt1 = new Malt("TestMaltName", PRICE_WITH_2_DECIMALS, EBC_MIN, EBC_MAX, MALT_AMOUNT, GROUND,
					SHOP, DATE_OF_PURCHASE, USE_BY_DATE);
			Malt testMalt2 = new Malt("TestMaltName2", PRICE_WITH_1_DECIMALS, EBC_MIN, EBC_MAX, MALT_AMOUNT, GROUND,
					SHOP, DATE_OF_PURCHASE, USE_BY_DATE);
			List<Malt> allMalts = new ArrayList<>();
			allMalts.add(testMalt1);
			allMalts.add(testMalt2);
			return allMalts;
		}

		public Malt oneMalt() {
			Malt testMalt1 = new Malt("TestMaltName3", PRICE_WITHOUT_DECIMAL, EBC_MIN, EBC_MAX, MALT_AMOUNT, GROUND,
					SHOP, DATE_OF_PURCHASE, USE_BY_DATE);
			return testMalt1;
		}

		public Hops oneHops() {
			Hops testHops1 = new Hops("TestHopsName3", ALPHA, PRICE_WITHOUT_DECIMAL, HOPS_AMOUNT, SHOP,
					DATE_OF_PURCHASE, USE_BY_DATE);
			return testHops1;
		}
	}

}
