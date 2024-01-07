package Character;

import Weapon.BowAndArrowBehavior;

public class Knight extends Character {

    public Knight() {
        super.setCharacter("Knight");
        super.setWeapon(new BowAndArrowBehavior());
    }

    @Override
    public void fight() {
        System.out.println("Knight is fighting");
    }
}
