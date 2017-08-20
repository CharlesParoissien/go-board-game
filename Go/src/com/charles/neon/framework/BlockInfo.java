package com.charles.neon.framework;

public class BlockInfo {
	boolean isEmpty = true;
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public boolean isB() {
		return isB;
	}
	public void setB(boolean isB) {
		this.isB = isB;
	}
	public boolean isW() {
		return isW;
	}
	public void setW(boolean isW) {
		this.isW = isW;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	boolean isB = false;
	boolean isW = false;
	int i;
	int j;
}
