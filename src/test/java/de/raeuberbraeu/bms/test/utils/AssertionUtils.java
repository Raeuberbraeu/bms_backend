package de.raeuberbraeu.bms.test.utils;

import org.junit.Assert;

import de.raeuberbraeu.bms.domain.Hops;
import de.raeuberbraeu.bms.domain.Malt;

public class AssertionUtils {
	
	private static final double ACCURACY_OF_DOUBLE = 0.001;

	public static void checkEachElementOfMalt(Malt expectedMalt, Malt maltToBeTested) {
		Assert.assertEquals("Name is wrong", expectedMalt.getName(), maltToBeTested.getName());
		Assert.assertEquals("Amount is wrong", expectedMalt.getAmount(), maltToBeTested.getAmount(), ACCURACY_OF_DOUBLE);
		Assert.assertEquals("EbcMax is wrong", expectedMalt.getEbcMax(), maltToBeTested.getEbcMax(), ACCURACY_OF_DOUBLE);
		Assert.assertEquals("EbcMin is wrong", expectedMalt.getEbcMin(), maltToBeTested.getEbcMin(), ACCURACY_OF_DOUBLE);
		Assert.assertEquals("Shop is wrong", expectedMalt.getShop(), maltToBeTested.getShop());
		Assert.assertEquals("DateOfPurchase is wrong", expectedMalt.getDateOfPurchase(),
				maltToBeTested.getDateOfPurchase());
		Assert.assertEquals("UseByDate is wrong", expectedMalt.getUseByDate(), maltToBeTested.getUseByDate());
		Assert.assertEquals("Price is wrong", expectedMalt.getPrice(), maltToBeTested.getPrice());
	}

	public static void checkEachElementOfHops(Hops expectedHops, Hops hopsToBeTested) {
		Assert.assertEquals("Name is wrong", expectedHops.getName(), hopsToBeTested.getName());
		Assert.assertEquals("Alpha is wrong", expectedHops.getAlpha(), hopsToBeTested.getAlpha(),ACCURACY_OF_DOUBLE);
		Assert.assertEquals("Amount is wrong", expectedHops.getAmount(), hopsToBeTested.getAmount(),ACCURACY_OF_DOUBLE);
		Assert.assertEquals("DateOfPurchase is wrong", expectedHops.getDateOfPurchase(), hopsToBeTested.getDateOfPurchase());
		Assert.assertEquals("Price is wrong", expectedHops.getPrice(), hopsToBeTested.getPrice());
		Assert.assertEquals("Shop is wrong", expectedHops.getShop(), hopsToBeTested.getShop());
		Assert.assertEquals("UseByDate is wrong", expectedHops.getUseByDate(), hopsToBeTested.getUseByDate());
	}

}
