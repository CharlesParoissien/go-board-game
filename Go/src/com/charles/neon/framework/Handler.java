package com.charles.neon.framework;

import java.awt.Graphics;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.LinkedList;

import com.charles.neon.framework.Game.TYPE;

public class Handler extends MouseAdapter {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	public LinkedList<BlockInfo> bi = new LinkedList<BlockInfo>();
	
	private GameObject tempObject;
	
	public void tickA() {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void renderA(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void clearAll() {
		object.clear();
	}
	Game game;
	public void createBoard() {
		int counter = -1;
		
		for(int j = 0; j < 19; j++) {
			for(int i = 0; i < 19; i++) {
				
				
				if(j == 0 && i < 18 && i > 0){
					Game.blockType = TYPE.BorderT;
				}
				else if(j == 18 && i < 18 && i > 0){
					Game.blockType = TYPE.BorderB;
				}
				
				else if(j > 0 && j < 18 && i == 0){
					Game.blockType = TYPE.BorderL;
				}
				else if(j > 0 && j < 18 && i == 18){
					Game.blockType = TYPE.BorderR;
				}
				else if(j == 0 && i == 0){
					Game.blockType = TYPE.CornerTL;
				}
				else if(j == 0 && i == 18){
					Game.blockType = TYPE.CornerTR;
				}
				else if(j == 18 && i == 18){
					Game.blockType = TYPE.CornerBR;
				}
				else if(j == 18 && i == 0){
					Game.blockType = TYPE.CornerBL;
				}
				else if((j == 3 && i == 3) || (j == 3 && i == 9) || (j == 3 && i == 15) || (j == 9 && i == 3) || (j == 9 && i == 9) || (j == 9 && i == 15) || (j == 15 && i == 3) || (j == 15 && i == 9) || (j == 15 && i == 15)){
					Game.blockType = TYPE.Hoshi;
				}
				else {
					Game.blockType = TYPE.Normal;
				}
				counter++;
				addObject(new Block(i*50 + 50, j*50 + 50, ObjectId.Block));
				object.get(counter).setEmpty(true);
				object.get(counter).setB(false);
				object.get(counter).setW(false);
				object.get(counter).setI(i);
				object.get(counter).setJ(j);
				System.out.println(counter);
				
			}
			
		}
		System.out.println(object.size());
	}
	
	
}
