package com.charles.neon.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.charles.neon.framework.Game.STATE;
import com.charles.neon.framework.Game.TYPE;

public class Block extends GameObject {
	
	private BufferedImage block_image;

	public Block(float x, float y, ObjectId id) {
		super(x, y, id);
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		//normal
		if(Game.blockState == STATE.Empty && Game.blockType == TYPE.Normal) {
			block_image = ss.grabImage(1, 1, 50, 50);
		}
		else if(Game.blockState == STATE.Black && (Game.blockType == TYPE.Normal || Game.blockType == TYPE.Hoshi)) {
			block_image = ss.grabImage(2, 1, 50, 50);
		}
		else if(Game.blockState == STATE.White && (Game.blockType == TYPE.Normal || Game.blockType == TYPE.Hoshi)) {
			block_image = ss.grabImage(3, 1, 50, 50);
		}
		
		//corner bottom right
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.CornerBR) {
			block_image = ss.grabImage(4, 4, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.CornerBR) {
			block_image = ss.grabImage(5, 4, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.CornerBR) {
			block_image = ss.grabImage(6, 4, 50, 50);
		}
		
		//corner top left
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.CornerTL) {
			block_image = ss.grabImage(4, 3, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.CornerTL) {
			block_image = ss.grabImage(5, 3, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.CornerTL) {
			block_image = ss.grabImage(6, 3, 50, 50);
		}
		
		//border right
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.BorderR) {
			block_image = ss.grabImage(4, 1, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.BorderR) {
			block_image = ss.grabImage(5, 1, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.BorderR) {
			block_image = ss.grabImage(6, 1, 50, 50);
		}
		
		//border left
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.BorderL) {
			block_image = ss.grabImage(1, 2, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.BorderL) {
			block_image = ss.grabImage(2, 2, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.BorderL) {
			block_image = ss.grabImage(3, 2, 50, 50);
		}

		//border bottom
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.BorderB) {
			block_image = ss.grabImage(4, 2, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.BorderB) {
			block_image = ss.grabImage(5, 2, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.BorderB) {
			block_image = ss.grabImage(6, 2, 50, 50);
		}

		//border top
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.BorderT) {
			block_image = ss.grabImage(1, 3, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.BorderT) {
			block_image = ss.grabImage(2, 3, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.BorderT) {
			block_image = ss.grabImage(3, 3, 50, 50);
		}
		


		//corner top right
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.CornerTR) {
			block_image = ss.grabImage(1, 4, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.CornerTR) {
			block_image = ss.grabImage(2, 4, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.CornerTR) {
			block_image = ss.grabImage(3, 4, 50, 50);
		}

		
		
		//corner bottom left
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.CornerBL) {
			block_image = ss.grabImage(1, 5, 50, 50);
		}
		else if(Game.blockState == STATE.Black && Game.blockType == TYPE.CornerBL) {
			block_image = ss.grabImage(2, 5, 50, 50);
		}
		else if(Game.blockState == STATE.White && Game.blockType == TYPE.CornerBL) {
			block_image = ss.grabImage(3, 5, 50, 50);
		}
		
		//hoshi
		else if(Game.blockState == STATE.Empty && Game.blockType == TYPE.Hoshi) {
			block_image = ss.grabImage(4, 5, 50, 50);
		}
		
	}

	public void tick(LinkedList<GameObject> object) {
		
		
	}

	public void render(Graphics g) {
		/*g.setColor(Color.white);
		g.drawRect((int)x, (int)y, 50, 50);*/
		g.drawImage(block_image, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
}
