package model;

public class Player {
    private String name;
    private int hp;
    private boolean win;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
        win = false;
    }

    public boolean isDead() {
        return hp > 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
