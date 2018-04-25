package com.dauflo.www;

public class Cell {
	private boolean previousState;
	private boolean actualState;
	
	public Cell() {
		if (Math.random() < 0.25) {
			this.previousState = true;
			this.actualState = true;
		} else {
			this.previousState = false;
			this.actualState = false;
		}
	}
	
	public void nextState(int nei) {
		this.previousState = this.actualState;
		int nbNei = nei;
		if (previousState) {
			if (nbNei == 2 || nbNei == 3) {
				this.actualState = true;
			} else {
				this.actualState = false;
			}
		} else {
			if (nbNei == 3) {
				this.actualState = true;
			} else {
				this.actualState = false;
			}
		}
	}
	
	@Override
	public String toString() {
		if (actualState) {
			return "+ ";
		} else {
			return "- ";
		}
	}

	public boolean isActualState() {
		return actualState;
	}

	public boolean isPreviousState() {
		return this.previousState;
	}
}
