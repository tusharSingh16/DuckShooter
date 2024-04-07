package utility;

// To save values that will stay constant throughout the game
public class Constants {
    public static class Hud {
        public static final int CROSSHAIR_BLUE_LARGE = 0;
        public static final int CROSSHAIR_BLUE_SMALL = 1;
        public static final int CROSSHAIR_OUTLINE_LARGE = 2;
        public static final int CROSSHAIR_OUTLINE_SMALL = 3;
        public static final int CROSSHAIR_RED_LARGE = 4;
        public static final int CROSSHAIR_RED_SMALL = 5;
        public static final int CROSSHAIR_WHITE_LARGE = 6;
        public static final int CROSSHAIR_WHITE_SMALL = 7;
        public static final int ICON_BULLET_EMPTY_LONG = 8;
        public static final int ICON_BULLET_EMPTY_SHORT = 9;
        public static final int ICON_BULLET_GOLD_LONG = 10;
        public static final int ICON_BULLET_GOLD_SHORT = 11;
        public static final int ICON_BULLET_SILVER_LONG = 12;
        public static final int ICON_BULLET_SILVER_SHORT = 13;
        public static final int ICON_DUCK = 14;
        public static final int ICON_TARGET = 15;
        public static final int TEXT_0 = 16;
        public static final int TEXT_0_SMALL = 17;
        public static final int TEXT_1 = 18;
        public static final int TEXT_1_SMALL = 19;
        public static final int TEXT_2 = 20;
        public static final int TEXT_2_SMALL = 21;
        public static final int TEXT_3 = 22;
        public static final int TEXT_3_SMALL = 23;
        public static final int TEXT_4 = 24;
        public static final int TEXT_4_SMALL = 25;
        public static final int TEXT_5 = 26;
        public static final int TEXT_5_SMALL = 27;
        public static final int TEXT_6 = 28;
        public static final int TEXT_6_SMALL = 29;
        public static final int TEXT_7 = 30;
        public static final int TEXT_7_SMALL = 31;
        public static final int TEXT_8 = 32;
        public static final int TEXT_8_SMALL = 33;
        public static final int TEXT_9 = 34;
        public static final int TEXT_9_SMALL = 35;
        public static final int TEXT_CROSS = 36;
        public static final int TEXT_CROSS_SMALL = 37;
        public static final int TEXT_DOTS = 38;
        public static final int TEXT_DOTS_SMALL = 39;
        public static final int TEXT_GAMEOVER = 40;
        public static final int TEXT_GO = 41;
        public static final int TEXT_PLUS = 42;
        public static final int TEXT_PLUS_SMALL = 43;
        public static final int TEXT_READY = 44;
        public static final int TEXT_SCORE = 45;
        public static final int TEXT_SCORE_SMALL = 46;
        public static final int TEXT_TIMEUP = 47;
    }
    public static class objects {
        public static final int DUCK_BACK = 0;
        public static final int DUCK_BROWN = 1;
        public static final int DUCK_OUTLINE_BACK = 2;
        public static final int DUCK_OUTLINE_BROWN = 3;
        public static final int DUCK_OUTLINE_TARGET_BROWN = 4;
        public static final int DUCK_OUTLINE_TARGET_WHITE = 5;
        public static final int DUCK_OUTLINE_TARGET_YELLOW = 6;
        public static final int DUCK_OUTLINE_WHITE = 7;
        public static final int DUCK_OUTLINE_YELLOW = 8;
        public static final int DUCK_TARGET_BROWN = 9;
        public static final int DUCK_TARGET_WHITE = 10;
        public static final int DUCK_TARGET_YELLOW = 11;
        public static final int DUCK_WHITE = 12;
        public static final int DUCK_YELLOW = 13;
        public static final int RIFLE = 14;
        public static final int RIFLE_RED = 15;
        public static final int SHOT_BLUE_LARGE = 16;
        public static final int SHOT_BLUE_SMALL = 17;
        public static final int SHOT_BROWN_LARGE = 18;
        public static final int SHOT_BROWN_SMALL = 19;
        public static final int SHOT_GREY_LARGE = 20;
        public static final int SHOT_GREY_SMALL = 21;
        public static final int SHOT_YELLOW_LARGE = 22;
        public static final int SHOT_YELLOW_SMALL = 23;
        public static final int STICK_METAL = 24;
        public static final int STICK_METAL_BROKEN = 25;
        public static final int STICK_METAL_OUTLINE = 26;
        public static final int STICK_METAL_OUTLINE_BROKEN = 27;
        public static final int STICK_WOOD = 28;
        public static final int STICK_WOODFIXED = 29;
        public static final int STICK_WOODFIXED_OUTLINE = 30;
        public static final int STICK_WOOD_BROKEN = 31;
        public static final int STICK_WOOD_OUTLINE = 32;
        public static final int STICK_WOOD_OUTLINE_BROKEN = 33;
        public static final int TARGET_BACK = 34;
        public static final int TARGET_BACK_OUTLINE = 35;
        public static final int TARGET_COLORED = 36;
        public static final int TARGET_COLORED_OUTLINE = 37;
        public static final int TARGET_RED1 = 38;
        public static final int TARGET_RED1_OUTLINE = 39;
        public static final int TARGET_RED2 = 40;
        public static final int TARGET_RED2_OUTLINE = 41;
        public static final int TARGET_RED3 = 42;
        public static final int TARGET_RED3_OUTLINE = 43;
        public static final int TARGET_WHITE = 44;
        public static final int TARGET_WHITE_OUTLINE = 45;

//        public static final int[] DUCKS = new int[]{DUCK_BROWN,  DUCK_TARGET_BROWN, DUCK_TARGET_WHITE, DUCK_TARGET_YELLOW, DUCK_WHITE, DUCK_YELLOW, };
//        public static final int[] TARGETS = new int[]{TARGET_COLORED, TARGET_RED1, TARGET_RED2, TARGET_RED3, TARGET_WHITE};
        public static final int[] DUCKS = new int[]{DUCK_OUTLINE_BROWN,  DUCK_OUTLINE_TARGET_BROWN, DUCK_OUTLINE_TARGET_WHITE, DUCK_OUTLINE_TARGET_YELLOW, DUCK_OUTLINE_WHITE, DUCK_OUTLINE_YELLOW, };
        public static final int[] TARGETS = new int[]{TARGET_COLORED_OUTLINE, TARGET_RED1_OUTLINE, TARGET_RED2_OUTLINE, TARGET_RED3_OUTLINE, TARGET_WHITE_OUTLINE};
        public static final int[] SHOTS = new int[]{SHOT_GREY_SMALL, SHOT_BROWN_SMALL, SHOT_BLUE_SMALL, SHOT_YELLOW_SMALL};

        public static final int[] STICKS = new int[]{STICK_METAL, STICK_WOOD_OUTLINE, STICK_WOODFIXED_OUTLINE};
        public static final int[] STICKS_BROKEN = new int[]{STICK_METAL_BROKEN, STICK_WOOD_OUTLINE_BROKEN, STICK_WOOD_OUTLINE_BROKEN};

    }
    public static class stall {
        public static final int BG_BLUE = 0;
        public static final int BG_GREEN = 1;
        public static final int BG_RED = 2;
        public static final int BG_WOOD = 3;
        public static final int CLOUD1 = 4;
        public static final int CLOUD2 = 5;
        public static final int CURTAIN = 6;
        public static final int CURTAIN_ROPE = 7;
        public static final int CURTAIN_STRAIGHT = 8;
        public static final int CURTAIN_TOP = 9;
        public static final int GRASS1 = 10;
        public static final int GRASS2 = 11;
        public static final int TREE_OAK = 12;
        public static final int TREE_PINE = 13;
        public static final int WATER1 = 14;
        public static final int WATER2 = 15;
    }
}
