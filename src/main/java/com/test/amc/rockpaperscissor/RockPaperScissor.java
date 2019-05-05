package com.test.amc.rockpaperscissor;

import java.util.Map;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum RockPaperScissor {

    ROCK(1){
        @Override
        public boolean beats(RockPaperScissor other) {
            return other == SCISSOR;
        }
    },
    PAPER(2){
        @Override
        public boolean beats(RockPaperScissor other) {
            return other == ROCK;
        }

    },
    SCISSOR(3){
        @Override
        public boolean beats (RockPaperScissor other) {
            return other == PAPER;
        }

    };

    int index;

    public abstract boolean beats(RockPaperScissor other);

    private final static Map<Integer, RockPaperScissor> map =
            stream(RockPaperScissor.values()).collect(toMap(rockPaperScissor -> rockPaperScissor.index, rockPaperScissor -> rockPaperScissor));

    private RockPaperScissor(final int value) {
        index = value;
    }

    public static RockPaperScissor valueOf(int optionValue) {
        RockPaperScissor rockPaperScissor = map.get(optionValue);
        if (rockPaperScissor == null) {
            throw new IllegalArgumentException("Invalid option received; Please enter 1 for ROCK, 2 for PAPER, 3 for SCISSOR");
        }
        return rockPaperScissor;
    }
}
