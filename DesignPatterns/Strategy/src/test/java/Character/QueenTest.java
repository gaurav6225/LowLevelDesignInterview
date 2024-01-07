package Character;

import Weapon.AxeBehavior;
import Weapon.SwordBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    private Character character;
    @BeforeEach
    void setUp() {
        this.character = new Queen();
    }

    @Test
    void charaterNameEqualsQueen() {
        assertEquals("Queen",  character.getCharacter());
    }
    @Test
    void defaultWeaponEqualsKnife() {
        assertEquals("Knife", character.getWeapon());
    }
    @Test
    void changeWeaponToAxe() {
        character.setWeapon(new AxeBehavior());
        assertEquals("Axe", character.getWeapon());
    }
}