package com.charles.neon.framework;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import com.charles.neon.framework.Game.STATE;
import com.charles.neon.framework.Game.TYPE;

public class Menu extends MouseAdapter {
	
	private Game game;
	Handler handler;
	private GameObject tempObject;
	private Stones tempStone;
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	public LinkedList<Stones> stones = new LinkedList<Stones>();
	
	int x;
	int y;
	
	int x2;
	int y2;
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(int index) {
		this.object.remove(index);
	}
	
	public void addStone(Stones stones) {
		this.stones.add(stones);
	}
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		handler = new Handler();
		int counter = -1;
		
		//HERE
		for(int j = 0; j < 19; j++) {
			for(int i = 0; i < 19; i++) {
				counter++;
				
				if(mouseOver(mx, my, j*50 + 50, i*50 + 50, 50, 50)) {
					if(j == 0 && i == 0){
						Game.blockType = TYPE.CornerTL;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j < 18 && j > 0 && i == 0){
						Game.blockType = TYPE.BorderT;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j < 18 && j > 0 && i == 18){
						Game.blockType = TYPE.BorderB;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j == 18 && i == 0){
						Game.blockType = TYPE.CornerTR;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j == 0 && i < 18 && i > 0){
						Game.blockType = TYPE.BorderL;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;				
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j == 0 && i == 18){
						Game.blockType = TYPE.CornerBL;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;		
						} else {
							Game.blockState = STATE.Black;		
						}
					}
					else if(j == 18 && i == 18){
						Game.blockType = TYPE.CornerBR;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;
						} else {
							Game.blockState = STATE.Black;
						}
					}
					else if(j == 18 && i < 18 && i > 0){
						
						Game.blockType = TYPE.BorderR;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;		
						} else {
							Game.blockState = STATE.Black;	
						}
					}
					else if((j == 3 && i == 3) || (j == 3 && i == 9) || (j == 3 && i == 15) || (j == 9 && i == 3) || (j == 9 && i == 9) || (j == 9 && i == 15) || (j == 15 && i == 3) || (j == 15 && i == 9) || (j == 15 && i == 15)){
						Game.blockType = TYPE.Hoshi;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;	
						} else {
							Game.blockState = STATE.Black;		
						}
					}
					else {
						Game.blockType = TYPE.Normal;
						if(Game.blockState == STATE.Black){
							Game.blockState = STATE.White;		
						} else {
							Game.blockState = STATE.Black;
						}
					}
					addObject(new Block(j*50 + 50, i*50 + 50, ObjectId.Block));
				}
			}
		}
		
		
		if(mouseOver(mx, my, 1100, 200, 200, 70)) {
			stones.remove(stones.size() - 1);
			object.remove(object.size() - 1);
			if(Game.blockState == STATE.Black){
				Game.blockState = STATE.White;
			} else Game.blockState = STATE.Black;
		}
		
		//test btn
		/*if(mouseOver(mx, my, 1100, 400, 200, 70)) {
			
		}*/
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				for(int k = 0; k < stones.size(); k++) {
					if(x == stones.get(k).getX() && y == stones.get(k).getY()) {
						return false;
					}
					this.x = (int)stones.get(k).getX();
					this.y = (int)stones.get(k).getY();
				}
				
				this.x2 = x;
				this.y2 = y;
				addStone(new Stones(x, y));
				return true;
			} else return false;
		}else return false;
	}
	
	
	/*private String takeXY(int x, int y) {
		return "X: " + x + " Y: " + y;
	}*/

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
		
		Font fnt = new Font("arial", 1, 50);
		
		g.setColor(Color.gray);
		g.fillRect(1100, 200, 200, 70);
		g.setColor(Color.black);
		g.drawRect(1100, 200, 200, 70);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Back", 1140, 250);
		
		/*Test btn
		 * 
		 * g.setColor(Color.gray);
		g.fillRect(1100, 400, 200, 70);
		g.setColor(Color.black);
		g.drawRect(1100, 400, 200, 70);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Test", 1140, 450);*/
	}
	
}
