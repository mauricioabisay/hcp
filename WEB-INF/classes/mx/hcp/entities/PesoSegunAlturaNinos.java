package mx.hcp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabla_peso_segun_altura_ninos")
public class PesoSegunAlturaNinos {
	private double Height;
	private double SD4neg;
	private double SD3neg;
	private double SD2neg;
	private double SD1neg;
	private double SD0;
	private double SD1;
	private double SD2;
	private double SD3;
	private double SD4;
	
	@Id
	public double getHeight() {
		return Height;
	}
	public void setHeight(double height) {
		Height = height;
	}
	public double getSD4neg() {
		return SD4neg;
	}
	public void setSD4neg(double sD4neg) {
		SD4neg = sD4neg;
	}
	public double getSD3neg() {
		return SD3neg;
	}
	public void setSD3neg(double sD3neg) {
		SD3neg = sD3neg;
	}
	public double getSD2neg() {
		return SD2neg;
	}
	public void setSD2neg(double sD2neg) {
		SD2neg = sD2neg;
	}
	public double getSD1neg() {
		return SD1neg;
	}
	public void setSD1neg(double sD1neg) {
		SD1neg = sD1neg;
	}
	public double getSD0() {
		return SD0;
	}
	public void setSD0(double sD0) {
		SD0 = sD0;
	}
	public double getSD1() {
		return SD1;
	}
	public void setSD1(double sD1) {
		SD1 = sD1;
	}
	public double getSD2() {
		return SD2;
	}
	public void setSD2(double sD2) {
		SD2 = sD2;
	}
	public double getSD3() {
		return SD3;
	}
	public void setSD3(double sD3) {
		SD3 = sD3;
	}
	public double getSD4() {
		return SD4;
	}
	public void setSD4(double sD4) {
		SD4 = sD4;
	}
}
