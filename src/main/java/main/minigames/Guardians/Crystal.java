package main.minigames.Guardians;

import org.bukkit.block.Block;

public class Crystal {
	private boolean isAlive;
	private int health;
	private Block diamondBlock;

	public Crystal(boolean isAlive, Block diamondBlock) {
		this.isAlive = isAlive;
		this.health = 100;
		this.diamondBlock = diamondBlock;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Block getDiamondBlock() {
		return diamondBlock;
	}

	public void setDiamondBlock(Block diamondBlock) {
		this.diamondBlock = diamondBlock;
	}
}
