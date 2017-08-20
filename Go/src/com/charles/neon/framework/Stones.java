package com.charles.neon.framework;

import java.util.LinkedList;

import com.charles.neon.framework.Game.STATE;
import com.charles.neon.framework.Game.TYPE;

public class Stones {
	
	protected float x, y;
	
	public Stones(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
}
