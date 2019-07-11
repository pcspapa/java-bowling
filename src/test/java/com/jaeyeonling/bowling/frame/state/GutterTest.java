package com.jaeyeonling.bowling.frame.state;

import com.jaeyeonling.bowling.frame.KnockdownPins;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GutterTest {

    private FrameState state;

    @BeforeEach
    void setUp() {
        state = new Ready().bowl(KnockdownPins.GUTTER);
    }

    @DisplayName("시각화를 한다.")
    @Test
    void readyVisualize() {
        assertThat(state.visualize()).isEqualTo("-");
        assertThat(state.bowl(KnockdownPins.GUTTER).visualize()).isEqualTo("-|-");
    }

    @DisplayName("거터 1번 시 끝나지 않았다.")
    @Test
    void singleFinished() {
        assertThat(state.isFinished()).isFalse();
    }

    @DisplayName("거터 2번 시 끝난다.")
    @Test
    void doubleFinished() {
        assertThat(state.bowl(KnockdownPins.GUTTER).isFinished()).isTrue();
    }

    @DisplayName("게임이 끝난 후 게임 시 예외처리 한다.")
    @Test
    void throwAlreadyFinishedFrameStateException() {
        assertThatExceptionOfType(AlreadyFinishedFrameStateException.class)
                .isThrownBy(() -> state.bowl(KnockdownPins.GUTTER).bowl(KnockdownPins.GUTTER));
    }
}
