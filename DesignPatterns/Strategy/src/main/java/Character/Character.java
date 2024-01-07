package Character;

import Weapon.WeaponBehavior;

public abstract class Character {
    private WeaponBehavior weapon;
    private String character;

    public abstract void fight();

    /* Getters and Setters */
    public void setCharacter(String character) {
        this.character = character;
    }
    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    public String getCharacter() {
        return this.character;
    }
    public String getWeapon() {
        return weapon.getWeaponType();
    }


}
