package de.raeuberbraeu.bms.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;

/**
 * StorageSingleton-Object which holds all items of the storage. This
 * storage-object is used when it is not required to work directly on the
 * managed entities. The StorageSingleton holds the same items that are in the
 * database. When an item in StorageSingelton is deleted/saved, then it is also
 * deleted/saved in the DB.
 *
 */
public class StorageSingleton {

	private static StorageSingleton storage = new StorageSingleton();

	private static final Logger log = LoggerFactory.getLogger(StorageSingleton.class);

	private List<Malt> allMalts;
	private List<Hops> allHops;

	private StorageSingleton() {
	}

	/**
	 * get StorageSingleton-Object without checking if racks need to be filled.
	 * 
	 * @return StorageSingleton-Object
	 */
	public static StorageSingleton getStorage() {
		return storage;
	}
	
	/**
	 * get StorageSingleton-Object and fill all racks if they are not yet filled
	 * 
	 * @param maltRepo Malt-Repository
	 * @param hopsRepo Hops-Repository
	 * @return StorageSingleton-Object
	 */
	public static StorageSingleton getStorage(MaltRepository maltRepo, HopsRepository hopsRepo) {
		storage = getStorage(maltRepo);
		storage = getStorage(hopsRepo);
		return storage;
	}

	/**
	 * get StorageSingleton-Object and fill malt rack if not yet filled
	 * 
	 * @param maltRepo
	 * @return StorageSingleton-Object
	 */
	public static StorageSingleton getStorage(MaltRepository maltRepo) {
		if (storage.allMalts == null) {
			storage.addAllMaltsFromDbToStorage(maltRepo);
		}
		return storage;
	}

	/**
	 * get StorageSingleton-Object and fill hops rack if not yet filled
	 * 
	 * @param hopsRepo
	 * @return StorageSingleton-Object
	 */
	public static StorageSingleton getStorage(HopsRepository hopsRepo) {
		if (storage.allHops == null) {
			storage.addAllHopsFromDbToStorage(hopsRepo);
		}
		return storage;
	}

	private StorageSingleton addAllMaltsFromDbToStorage(MaltRepository maltRepo) {
		log.info("Initializing malt in storage.");
		allMalts = maltRepo.findAll();
		return storage;
	}

	private StorageSingleton addAllHopsFromDbToStorage(HopsRepository hopsRepo) {
		log.info("Initializing hops in storage.");
		allHops = hopsRepo.findAll();
		return storage;
	}

	/**
	 * Add one malt to the storage
	 * 
	 * @param maltToBeSaved
	 */
	public void addOneMalt(Malt maltToBeSaved) {
		storage.getAllMalts().add(maltToBeSaved);
	}

	/**
	 * Add one hops to the storage
	 * 
	 * @param hopsToBeSaved
	 */
	public void addOneHops(Hops hopsToBeSaved) {
		storage.getAllHops().add(hopsToBeSaved);
	}

	/**
	 * Remove hops from storage
	 * 
	 * @param id of hops
	 */
	public void removeHops(long id) {
		Hops hopsToBeDeleted = storage.getAllHops().stream().filter(h -> h.getId()==id).findFirst().orElse(null);
		log.info("hopsToBeDeleted: {}", hopsToBeDeleted);
		boolean result = allHops.remove(hopsToBeDeleted);
		if (result) {
			log.info("hops removed from storage: {}", hopsToBeDeleted);
		} else {
			log.error("hops with id {} coult not be deleted", id);
		}
	}
	
	/**
	 * Remove malt from storage
	 * 
	 * @param id of malt
	 */
	public void removeMalt(long id) {
		Malt maltToBeDeleted = storage.getAllMalts().stream().filter(m -> m.getId()==id).findFirst().orElse(null);
		log.info("maltToBeDeleted: {}", maltToBeDeleted);
		boolean result = allMalts.remove(maltToBeDeleted);
		if (result) {
			log.info("malt removed from storage: {}", maltToBeDeleted);
		} else {
			log.error("malt with id {} coult not be deleted", id);
		}
	}

	@Override
	public String toString() {
		return "Storage [malts=" + allMalts + ", hops=" + allHops + "]";
	}

	// **************** Getter and Setter *********************

	public List<Malt> getAllMalts() {
		return allMalts;
	}

	public void setAllMalts(List<Malt> allMalts) {
		this.allMalts = allMalts;
	}

	public List<Hops> getAllHops() {
		return allHops;
	}

	public void setAllHops(List<Hops> allHops) {
		this.allHops = allHops;
	}
}
