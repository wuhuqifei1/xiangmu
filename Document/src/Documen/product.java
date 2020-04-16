package Documen;

public class product {
	private String ID;
	private String name;
	private int price;
	private String color;
	public product(String iD, String name, int price, String color, int xx, int kc) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.color = color;
		this.xx = xx;
		this.kc = kc;
	}
	private int xx;
	private int kc;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getXx() {
		return xx;
	}
	public void setXx(int xx) {
		this.xx = xx;
	}
	public int getKc() {
		return kc;
	}
	public void setKc(int kc) {
		this.kc = kc;
	}
}
