package Character;

import Weapon.SwordBehavior;

public class King extends Character {

    public King() {
        super.setCharacter("King");
        super.setWeapon(new SwordBehavior());
    }
    @Override
    public void fight() {
        System.out.println("King is fighting");
    }
}
