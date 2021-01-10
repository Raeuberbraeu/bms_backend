package de.raeuberbraeu.bms.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Malts")
public class Malt {

	// PrimaryKey
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private BigDecimal price;
	private double ebcMin;
	private double ebcMax;
	private double amount;
	private boolean ground;
	private String shop;
	private LocalDate dateOfPurchase;
	private LocalDate useByDate;

	// **************** Constructors *********************
	public Malt(String name, BigDecimal price, double ebcMin, double ebcMax, double amount, boolean ground, String shop,
			LocalDate dateOfPurchase, LocalDate useByDate) {
		this.name = name;
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.ebcMin = ebcMin;
		this.ebcMax = ebcMax;
		this.amount = amount;
		this.ground = ground;
		this.shop = shop;
		this.dateOfPurchase = dateOfPurchase;
		this.useByDate = useByDate;
	}

	public Malt() {
	}

	// **************** toString, hashCode, equals *********************
	@Override
	public String toString() {
		return "Malt [id=" + id + ", name=" + name + ", price=" + price + ", ebcMin=" + ebcMin + ", ebcMax=" + ebcMax
				+ ", amount=" + amount + ", ground=" + ground + ", shop=" + shop + ", dateOfPurchase=" + dateOfPurchase
				+ ", useByDate=" + useByDate + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOfPurchase == null) ? 0 : dateOfPurchase.hashCode());
		temp = Double.doubleToLongBits(ebcMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ebcMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (ground ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		result = prime * result + ((useByDate == null) ? 0 : useByDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Malt other = (Malt) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateOfPurchase == null) {
			if (other.dateOfPurchase != null)
				return false;
		} else if (!dateOfPurchase.equals(other.dateOfPurchase))
			return false;
		if (Double.doubleToLongBits(ebcMax) != Double.doubleToLongBits(other.ebcMax))
			return false;
		if (Double.doubleToLongBits(ebcMin) != Double.doubleToLongBits(other.ebcMin))
			return false;
		if (ground != other.ground)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		if (useByDate == null) {
			if (other.useByDate != null)
				return false;
		} else if (!useByDate.equals(other.useByDate))
			return false;
		return true;
	}

	// **************** Getter and Setter *********************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getEbcMin() {
		return ebcMin;
	}

	public void setEbcMin(double ebcMin) {
		this.ebcMin = ebcMin;
	}

	public double getEbcMax() {
		return ebcMax;
	}

	public void setEbcMax(double ebcMax) {
		this.ebcMax = ebcMax;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isGround() {
		return ground;
	}

	public void setGround(boolean ground) {
		this.ground = ground;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public LocalDate getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(LocalDate useByDate) {
		this.useByDate = useByDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
