package com.charles.neon.framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1611293238148184904L;
	
	public enum STATE {
		Empty(),
		Black(),
		White();
	};
	
	public enum TYPE {
		Normal(),
		BorderT(),
		BorderR(),
		BorderB(),
		BorderL(),
		CornerTL(),
		CornerTR(),
		CornerBR(),
		CornerBL(),
		Hoshi();
	};
	
	public static STATE blockState = STATE.Empty;
	public static TYPE blockType = TYPE.Normal;

	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	private Handler handler;
	private Menu menu;
	public static BufferedImage sprite_sheet;
	public static BufferedImage background;
	
	
	public Game() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			sprite_sheet = loader.loadImage("/go_sprite_sheet.png");
			System.out.println("loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		new Window(800, 600, "Go", this);
		
	}
	
	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		
		handler.createBoard();
	}
	
	public synchronized void start() {
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick() {
		handler.tickA();
		menu.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0,  0,  getWidth(), getHeight());
		
		
		handler.renderA(g);
		menu.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String args[]) {
		
		new Game();
		
	}
	
}
