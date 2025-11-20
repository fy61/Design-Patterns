package BehavioralPatterns.StatePattern;

import org.junit.jupiter.api.Test;

public class StateTest {
    @Test
    public void testState() {
        Player player = new Player(new PausedState());
        player.pressButton(); // 切到暂停
        player.pressButton(); // 切回播放
    }

    interface State {
        void handle(Player player);
    }

    class PlayingState implements State {
        public void handle(Player player) {
            System.out.println("Now playing...");
            player.setState(new PausedState());
        }
    }

    class PausedState implements State {
        public void handle(Player player) {
            System.out.println("Now paused.");
            player.setState(new PlayingState());
        }
    }

    class Player {
        private State state;
        public Player(State state) { this.state = state; }
        public void setState(State state) { this.state = state; }
        public void pressButton() { state.handle(this); }
    }

}
