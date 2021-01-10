package de.raeuberbraeu.bms.service;

import java.util.List;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;

public interface StorageService {

	public Malt addAndPersistMalt(Malt newMalt);

	public Hops addAndPersistHops(Hops newHops);
	
	public List<Malt> getAllMalts();

	public List<Hops> getAllHops();

	public Hops deleteHops(long id);

	public Malt deleteMalt(long id);

}
