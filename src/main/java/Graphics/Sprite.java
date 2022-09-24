package Graphics;

import Graphics.SpriteSheet;
import javafx.scene.image.*;

import java.util.Arrays;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {

    public static final int DEFAULT_SIZE = 16;
    public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite grass = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite wall = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite portal = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 14, 14);

    /*
    |--------------------------------------------------------------------------
    | Bomber Sprites
    |--------------------------------------------------------------------------
     */

    public static Sprite[] PLAYER_RIGHT = {
            new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 10, 16),
            new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 11, 16),
            new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 12, 16),
    };

    public static Sprite[] PLAYER_LEFT = {
            new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 10, 15),
            new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 11, 16),
            new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 12 ,15)
    };


    public static Sprite[] PLAYER_UP = {
            new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 12, 15),
            new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 12, 16),
            new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 12, 15),
    };

    public static Sprite[] PLAYER_DOWN = {
            new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 12, 15),
            new Sprite(DEFAULT_SIZE, 2, 1, SpriteSheet.tiles, 12, 16),
            new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 12, 15)
    };

    public static Sprite[] PLAYER_DEAD = {
            new Sprite(DEFAULT_SIZE, 4, 2, SpriteSheet.tiles, 14, 15),
            new Sprite(DEFAULT_SIZE, 5, 2, SpriteSheet.tiles, 13, 16),
            new Sprite(DEFAULT_SIZE, 6, 2, SpriteSheet.tiles, 16, 15)
    };


    /*
    |--------------------------------------------------------------------------
    | Character
    |--------------------------------------------------------------------------
     */
    //BALLOON
    public static final Sprite[] BALLOON_LEFT = {
            new Sprite(DEFAULT_SIZE, 9, 0, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 2, SpriteSheet.tiles, 16, 13)
    };

    public static final Sprite[] BALLOON_RIGHT = {
            new Sprite(DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 10, 2, SpriteSheet.tiles, 16, 13)
    };

    public static final Sprite[] BALLOON_DEAD = {
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 13),
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 16),
            new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 13)
    };

    //ONEAL
    public static Sprite oneal_left1 = new Sprite(DEFAULT_SIZE, 11, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_left2 = new Sprite(DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_left3 = new Sprite(DEFAULT_SIZE, 11, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite oneal_right1 = new Sprite(DEFAULT_SIZE, 12, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_right2 = new Sprite(DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite oneal_right3 = new Sprite(DEFAULT_SIZE, 12, 2, SpriteSheet.tiles, 16, 16);

    public static Sprite oneal_dead = new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16);

    //BOSS
    public static Sprite boss_down1 = new Sprite(DEFAULT_SIZE, 6, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_down2 = new Sprite(DEFAULT_SIZE, 7, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_down3 = new Sprite(DEFAULT_SIZE, 6, 11, SpriteSheet.tiles, 16, 16);

    public static Sprite boss_left1 = new Sprite(DEFAULT_SIZE, 8, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_left2 = new Sprite(DEFAULT_SIZE, 9, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_left3 = new Sprite(DEFAULT_SIZE, 8, 11, SpriteSheet.tiles, 16, 16);

    public static Sprite boss_right1 = new Sprite(DEFAULT_SIZE, 10, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_right2 = new Sprite(DEFAULT_SIZE, 11, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_right3 = new Sprite(DEFAULT_SIZE, 10, 11, SpriteSheet.tiles, 16, 16);

    public static Sprite boss_up1 = new Sprite(DEFAULT_SIZE, 12, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_up2 = new Sprite(DEFAULT_SIZE, 13, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite boss_up3 = new Sprite(DEFAULT_SIZE, 12, 11, SpriteSheet.tiles, 16, 16);

    public static Sprite fire_down = new Sprite(DEFAULT_SIZE, 6, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite fire_right = new Sprite(DEFAULT_SIZE, 7, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite fire_up = new Sprite(DEFAULT_SIZE, 8, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite fire_left = new Sprite(DEFAULT_SIZE, 9, 12, SpriteSheet.tiles, 16, 16);

    // GHOST
    public static Sprite ghost_right1 = new Sprite(DEFAULT_SIZE, 10, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite ghost_right2 = new Sprite(DEFAULT_SIZE, 11, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite ghost_right3 = new Sprite(DEFAULT_SIZE, 10, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite ghost_left1 = new Sprite(DEFAULT_SIZE, 12, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite ghost_left2 = new Sprite(DEFAULT_SIZE, 13, 12, SpriteSheet.tiles, 16, 16);
    public static Sprite ghost_left3 = new Sprite(DEFAULT_SIZE, 12, 12, SpriteSheet.tiles, 16, 16);

    // MINVO
    public static Sprite minvo_left1 = new Sprite(DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_left2 = new Sprite(DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_left3 = new Sprite(DEFAULT_SIZE, 8, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite minvo_right1 = new Sprite(DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_right2 = new Sprite(DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite minvo_right3 = new Sprite(DEFAULT_SIZE, 9, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite minvo_dead = new Sprite(DEFAULT_SIZE, 8, 8, SpriteSheet.tiles, 16, 16);

    //KONDORIA
    public static Sprite kondoria_left1 = new Sprite(DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_left2 = new Sprite(DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_left3 = new Sprite(DEFAULT_SIZE, 10, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite kondoria_right1 = new Sprite(DEFAULT_SIZE, 11, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_right2 = new Sprite(DEFAULT_SIZE, 11, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite kondoria_right3 = new Sprite(DEFAULT_SIZE, 11, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite kondoria_dead = new Sprite(DEFAULT_SIZE, 10, 8, SpriteSheet.tiles, 16, 16);

    //ALL
    public static Sprite mob_dead1 = new Sprite(DEFAULT_SIZE, 15, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead2 = new Sprite(DEFAULT_SIZE, 15, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite mob_dead3 = new Sprite(DEFAULT_SIZE, 15, 2, SpriteSheet.tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(DEFAULT_SIZE, 0, 3, SpriteSheet.tiles, 15, 15);
    public static Sprite bomb_1 = new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.tiles, 13, 15);
    public static Sprite bomb_2 = new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.tiles, 12, 14);

    /*
    |--------------------------------------------------------------------------
    | FlameSegment Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb_exploded = new Sprite(DEFAULT_SIZE, 0, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded1 = new Sprite(DEFAULT_SIZE, 0, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded2 = new Sprite(DEFAULT_SIZE, 0, 6, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical = new Sprite(DEFAULT_SIZE, 1, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical1 = new Sprite(DEFAULT_SIZE, 2, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical2 = new Sprite(DEFAULT_SIZE, 3, 5, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal = new Sprite(DEFAULT_SIZE, 1, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal1 = new Sprite(DEFAULT_SIZE, 1, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal2 = new Sprite(DEFAULT_SIZE, 1, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_left_last = new Sprite(DEFAULT_SIZE, 0, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(DEFAULT_SIZE, 0, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(DEFAULT_SIZE, 0, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_right_last = new Sprite(DEFAULT_SIZE, 2, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(DEFAULT_SIZE, 2, 8, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(DEFAULT_SIZE, 2, 9, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_top_last = new Sprite(DEFAULT_SIZE, 1, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last1 = new Sprite(DEFAULT_SIZE, 2, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last2 = new Sprite(DEFAULT_SIZE, 3, 4, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_down_last = new Sprite(DEFAULT_SIZE, 1, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_down_last1 = new Sprite(DEFAULT_SIZE, 2, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_down_last2 = new Sprite(DEFAULT_SIZE, 3, 6, SpriteSheet.tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Brick FlameSegment
    |--------------------------------------------------------------------------
     */
    public static Sprite brick_exploded = new Sprite(DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded1 = new Sprite(DEFAULT_SIZE, 7, 2, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded2 = new Sprite(DEFAULT_SIZE, 7, 3, SpriteSheet.tiles, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | PowerUps
    |--------------------------------------------------------------------------
     */
    public static Sprite powerUp_bombs = new Sprite(DEFAULT_SIZE, 0, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerUp_flames = new Sprite(DEFAULT_SIZE, 1, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerUp_speed = new Sprite(DEFAULT_SIZE, 2, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerUp_wallPass = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerUp_bombPass = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerUp_flamePass = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);

    public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realWidth = rw * 2;
        _realHeight = rh * 2;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        Arrays.fill(_pixels, color);
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                _pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
            }
        }
    }

    public static Sprite movingSprite(Sprite[] sprites, int time) {
        return sprites[time % 3];
    }

    public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if ( _pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                }
                else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input);
    }

    private Image resample(Image input) {
        final int W = (int) input.getWidth();
        final int H = (int) input.getHeight();
        final int S = 2;

        WritableImage output = new WritableImage(
                W * S,
                H * S
        );

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < S; dy++) {
                    for (int dx = 0; dx < S; dx++) {
                        writer.setArgb(x * S + dx, y * S + dy, argb);
                    }
                }
            }
        }

        return output;
    }
}
