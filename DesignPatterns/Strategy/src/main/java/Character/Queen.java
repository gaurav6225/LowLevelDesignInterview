package Character;

import Weapon.KnifeBehavior;

public class Queen extends Character {
    public Queen() {
        super.setCharacter("Queen");
        super.setWeapon(new KnifeBehavior());
    }

    @Override
    public void fight() {
        System.out.println("Queen is fighting");
    }
}
