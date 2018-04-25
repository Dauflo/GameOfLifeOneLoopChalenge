package com.dauflo.www;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class DisplayComponent extends Component implements Runnable{ 
	private Cell[][] gestion;
	
	public DisplayComponent(Cell[][] gestion) {
		this.gestion = gestion;
	}
	
	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < gestion.length; i++) {
			for (int j = 0; j < gestion.length; j++) {
				gestion[i][j].nextState(nbCloseNeighbours(i, j));
				
				if (gestion[i][j].isActualState()) {
					g.setColor(Color.WHITE);
				} else {
					g.setColor(Color.BLACK);
						
				}
				g.fillRect(MainFrame.width / gestion.length * i, MainFrame.height / gestion.length * j, MainFrame.width / gestion.length, MainFrame.height / gestion.length);
				
			}
		}
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public boolean existingCell(int x, int y) {
		try {
			Cell exist = gestion[x][y];
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int nbCloseNeighbours(int x, int y) {
		int nbNeigh = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (!((i == x) && (j == y))) {
					if (existingCell(i, j))
						if (gestion[i][j].isPreviousState())
							nbNeigh++;
				}
			}
		}
		return nbNeigh;
	}

	@Override
	public void run() {
	}
}
