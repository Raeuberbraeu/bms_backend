package de.raeuberbraeu.bms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;
import de.raeuberbraeu.bms.domain.StorageSingleton;
import de.raeuberbraeu.bms.repository.HopsRepository;
import de.raeuberbraeu.bms.repository.MaltRepository;

/**
 * StorageService which offers methods for operations on all items in the
 * storage. Some Methods only operate on the Storage Singleton, other perform
 * operations also on the DB.
 *
 */
@Service
public class StorageServiceImpl implements StorageService {

	private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);
	private StorageSingleton storage = StorageSingleton.getStorage();

	@Autowired
	private MaltRepository maltRepo;
	@Autowired
	private HopsRepository hopsRepo;

	// These methods grab the objects from the sotrageSingleton. When they are
	// called the first time the storage singleton will request the Objects from the
	// DB, otherwise the objects that are already in memory will be used.

	@Override
	public List<Malt> getAllMalts() {
		storage = StorageSingleton.getStorage(maltRepo);
		List<Malt> malts = storage.getAllMalts();
		return malts;
	}

	@Override
	public List<Hops> getAllHops() {
		storage = StorageSingleton.getStorage(hopsRepo);
		List<Hops> hops = storage.getAllHops();
		return hops;
	}

	// ---------- operations on DB -------------------------
	// These methods do operation on the DB. The same operations are performed on
	// the storageSingleton.

	public Malt addAndPersistMalt(Malt maltToBeSaved) {
		Malt savedMalt = maltRepo.save(maltToBeSaved);
		storage.addOneMalt(savedMalt);
		log.info("Created malt: {}", savedMalt);
		return savedMalt;
	}

	public Hops addAndPersistHops(Hops hopsToBeSaved) {
		Hops savedHops = hopsRepo.save(hopsToBeSaved);
		storage.addOneHops(savedHops);
		log.info("Created hops: {}", savedHops);
		return savedHops;
	}

	@Override
	public Hops deleteHops(long id) {
		storage.removeHops(id);
		Hops hopsToBeDeleted = hopsRepo.findById(id).get();
		hopsRepo.delete(hopsToBeDeleted);
		return hopsToBeDeleted;
	}

	@Override
	public Malt deleteMalt(long id) {
		storage.removeMalt(id);
		Malt maltToBeDeleted = maltRepo.findById(id).get();
		maltRepo.delete(maltToBeDeleted);
		return maltToBeDeleted;
	}
}
