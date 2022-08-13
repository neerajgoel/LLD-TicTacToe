package com.neeraj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @Test
    @DisplayName("Default char in player")
    void test1(){
        assertThrows(Error.class, () -> new Player.PlayerBuilder().setName("abc")
                .setCh('_').build() );
    }

    @Test
    @DisplayName("Name not set in player")
    void test2(){
        assertThrows(Error.class, () -> new Player.PlayerBuilder()
                .setCh('_').build() );
    }
}
