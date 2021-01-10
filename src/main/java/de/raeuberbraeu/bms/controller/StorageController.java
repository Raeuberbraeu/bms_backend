package de.raeuberbraeu.bms.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;
import de.raeuberbraeu.bms.service.StorageService;

@RestController()
@RequestMapping("/api")
public class StorageController {

	private static final Logger log = LoggerFactory.getLogger(StorageController.class);

	@Autowired
	private StorageService storageService;

	/**
	 * Get-Request: Get all malts in storage.
	 * 
	 * @return allMalts all malts in storage
	 */
	@RequestMapping(path = "/malts")
	public List<Malt> allMalts() {
		log.info("GET called on /malts");
		List<Malt> allMalts = storageService.getAllMalts();
		return allMalts;
	}

	/**
	 * Get-Request: Get all hops in storage.
	 * 
	 * @return allHops all hops in storage
	 */
	@RequestMapping(path = "/hops")
	public List<Hops> allHops() {
		log.info("GET called on /hops");
		List<Hops> allHops = storageService.getAllHops();
		return allHops;
	}

	/**
	 * Post-Request: Add one malt to storage.
	 * 
	 * @param name name of malt
	 * @return idOfSavedMalt
	 */
	@RequestMapping(path = "/storage/addMalt/{name}/{price}/{ebcMin}/{ebcMax}/{amount}/{ground}/{shop}/{dateOfPurchase}/{useByDate}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Malt addMalt(@PathVariable("name") String name, @PathVariable("price") String price,
			@PathVariable("ebcMin") double ebcMin, @PathVariable("ebcMax") double ebcMax,
			@PathVariable("amount") double amount, @PathVariable("ground") boolean ground,
			@PathVariable("shop") String shop, @PathVariable("dateOfPurchase") String dateOfPurchase,
			@PathVariable("useByDate") String useByDate) {
		// TODO use a malt object as parameter instead of name
		log.info("POST called on /storage/addMalt/{}/{}/{}/{}/{}/{}/{}/{}/{}", name, price, ebcMin, ebcMax, amount,
				ground, shop, dateOfPurchase, useByDate);
		Malt newMalt = new Malt(name, new BigDecimal(price), ebcMin, ebcMax, amount, ground, shop,
				LocalDate.parse(dateOfPurchase), LocalDate.parse(useByDate));
		Malt savedMalt = storageService.addAndPersistMalt(newMalt);
		return savedMalt;
	}

	/**
	 * Post-Request: Add one hops to storage.
	 * 
	 * @param name name of hops
	 * @return idOfSavedHops
	 */
	@RequestMapping(path = "/storage/addHops/{name}/{alpha}/{price}/{amount}/{shop}/{dateOfPurchase}/{useByDate}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Hops addHops(@PathVariable("name") String name, @PathVariable("alpha") double alpha,
			@PathVariable("price") String price, @PathVariable("amount") double amount,
			@PathVariable("shop") String shop, @PathVariable("dateOfPurchase") String dateOfPurchase,
			@PathVariable("useByDate") String useByDate) {
		log.info("POST called on /storage/addHops/{}/{}/{}/{}/{}/{}/{}", name, alpha, price, amount, shop,
				dateOfPurchase, useByDate);
		Hops newHops = new Hops(name, alpha, new BigDecimal(price), amount, shop, LocalDate.parse(dateOfPurchase),
				LocalDate.parse(useByDate));
		Hops savedHops = storageService.addAndPersistHops(newHops);
		return savedHops;
	}
	
	/**
	 * Delete-Request: Delete hops from storage.
	 * 
	 * @param name name of hops
	 * @return idOfDeletedHops
	 */
	@RequestMapping(path = "/storage/deleteHops/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public Hops deleteHops(@PathVariable("id") long id) {
		log.info("DELETE called on /storage/deleteHops/{}", id);
		Hops deletedHops = storageService.deleteHops(id);
		return deletedHops;
	}
	
	/**
	 * Delete-Request: Delete malt from storage.
	 * 
	 * @param name name of hops
	 * @return idOfDeletedHops
	 */
	@RequestMapping(path = "/storage/deleteMalt/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public Malt deleteMalt(@PathVariable("id") long id) {
		log.info("DELETE called on /storage/deleteMalt/{}", id);
		Malt deletedMalt = storageService.deleteMalt(id);
		return deletedMalt;
	}
}
