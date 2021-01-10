package de.raeuberbraeu.bms.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hops")
public class Hops {

	// PrimaryKey
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private double alpha;
	private BigDecimal price;
	private double amount;
	private String shop;
	private LocalDate dateOfPurchase;
	private LocalDate useByDate;

	// **************** Constructors *********************
	public Hops(String name, double alpha, BigDecimal price, double amount, String shop, LocalDate dateOfPurchase,
			LocalDate useByDate) {
		this.name = name;
		this.alpha = alpha;
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.amount = amount;
		this.shop = shop;
		this.dateOfPurchase = dateOfPurchase;
		this.useByDate = useByDate;
	}

	public Hops() {
	}

	// **************** toString, hashCode, equals *********************
	@Override
	public String toString() {
		return "Hops [id=" + id + ", name=" + name + ", alpha=" + alpha + ", price=" + price + ", amount=" + amount
				+ ", shop=" + shop + ", dateOfPurchase=" + dateOfPurchase + ", useByDate=" + useByDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(alpha);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOfPurchase == null) ? 0 : dateOfPurchase.hashCode());
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
		Hops other = (Hops) obj;
		if (Double.doubleToLongBits(alpha) != Double.doubleToLongBits(other.alpha))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateOfPurchase == null) {
			if (other.dateOfPurchase != null)
				return false;
		} else if (!dateOfPurchase.equals(other.dateOfPurchase))
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

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
