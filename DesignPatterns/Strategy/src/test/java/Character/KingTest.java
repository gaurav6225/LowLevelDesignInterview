package Character;

import Weapon.BowAndArrowBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    private Character character;
    @BeforeEach
    void setUp() {
        character = new King();
    }
    @Test
    void charaterNameEqualsKing() {
        assertEquals("King",  character.getCharacter());
    }
    @Test
    void defaultWeaponEqualsSword() {
        assertEquals("Sword", character.getWeapon());
    }
    @Test
    void changeWeaponToBowAndArrow() {
        character.setWeapon(new BowAndArrowBehavior());
        assertEquals("BowAndArrow", character.getWeapon());
    }
}