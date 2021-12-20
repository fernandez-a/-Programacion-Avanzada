package metal_solid.gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 * Clase mediante la cual se inicializan y cortan todas las imagenes
 * @author Alejandro
 *
 */
public class Assets {
	private static final int width = 32, height = 32;
	private ImageLoader img;
	public static BufferedImage free,floor_image,floor_image2,techo,inter1,inter2,inter3,floor_image4,floor_image5,floor_image6,player_righ,player_lef,icon1,icon2,icon3,flag;
	public static BufferedImage ladder1,ladder2,ladder3;
	public static BufferedImage tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8,tile9,tile10,tile11,tile12,tile13,tile14,tile15,tile16,tile17,tile18,tile19,tile20,tile21,tile22,tile23,tile24,tile25,tile26,tile27;
	public static ArrayList<BufferedImage>floor_images = new ArrayList<BufferedImage>();
	public static BufferedImage[] right1_walk;
	public static BufferedImage[] left1_walk;
	public static BufferedImage[] right2_walk;
	public static BufferedImage[] left2_walk;
	public static BufferedImage[] right3_walk;
	public static BufferedImage[] left3_walk;
	public static BufferedImage[] climb1;
	public static BufferedImage[] climb2;
	public static BufferedImage[] climb3;
	public static BufferedImage[] water;
	public static BufferedImage[] floor1;
	public static BufferedImage[] air;
	public static BufferedImage[] ladder;
	public static BufferedImage[] menu_start;
	public static BufferedImage[] attac1;
	public static BufferedImage[] idle_1;
	public static ArrayList<BufferedImage[]>animationsCharacter1 = new ArrayList<BufferedImage[]>();
	public static ArrayList<BufferedImage[]>animationsCharacter2= new ArrayList<BufferedImage[]>();
	public static ArrayList<BufferedImage[]>animationsCharacter3= new ArrayList<BufferedImage[]>();
	/**
	 * Inicializacion de todas las imagenes que vamos a usar en el juego
	 */
	public void init() {
		img = new ImageLoader();
		
		SpriteSheet part1 = new SpriteSheet(img.loadImage("/tiles/free_tile_set_Finished.png"));
		SpriteSheet part2 = new SpriteSheet(img.loadImage("/tiles/Tileset.png"));
		SpriteSheet ladder_sprite = new SpriteSheet(img.loadImage("/tiles/ladders.png"));
		SpriteSheet attack1 = new SpriteSheet(img.loadImage("/characters/Woodcutter_attack2.png"));
		SpriteSheet player1_right = new SpriteSheet(img.loadImage("/characters/Woodcutter_walk_right.png"));
		SpriteSheet player1_left = new SpriteSheet(img.loadImage("/characters/Woodcutter_walk_left.png"));
		SpriteSheet player1_climb = new SpriteSheet(img.loadImage("/characters/Woodcutter_climb.png"));
		SpriteSheet player2_climb = new SpriteSheet(img.loadImage("/characters/GraveRobber_climb.png"));
		SpriteSheet player3_climb = new SpriteSheet(img.loadImage("/characters/SteamMan_climb.png"));
		SpriteSheet player2_right = new SpriteSheet(img.loadImage("/characters/grave_rob_right.png"));
		SpriteSheet player2_left = new SpriteSheet(img.loadImage("/characters/grave_rob_left.png"));
		SpriteSheet player3_right = new SpriteSheet(img.loadImage("/characters/SteamMan_walk.png"));
		SpriteSheet player3_left = new SpriteSheet(img.loadImage("/characters/SteamMan_walk_left.png"));
		SpriteSheet idle1 = new SpriteSheet(img.loadImage("/characters/Woodcutter_idle.png"));
		SpriteSheet icons1 = new SpriteSheet(img.loadImage("/portraits/Icons_01.png"));
		SpriteSheet icons2 = new SpriteSheet(img.loadImage("/portraits/Icons_02.png"));
		SpriteSheet icons3 = new SpriteSheet(img.loadImage("/portraits/Icons_03.png"));
		SpriteSheet flag_sheet = new SpriteSheet(img.loadImage("/tiles/flag_32.png"));
		menu_start = new BufferedImage[2];
		right1_walk = new BufferedImage[6];
		left1_walk = new BufferedImage[6];
		climb1 = new BufferedImage[6];
		right2_walk = new BufferedImage[6];
		left2_walk = new BufferedImage[6];
		climb2 = new BufferedImage[6];
		right3_walk = new BufferedImage[6];
		left3_walk = new BufferedImage[6];
		climb3 = new BufferedImage[6];
		water = new BufferedImage[4];
		floor1 = new BufferedImage[9];
		air = new BufferedImage[4];
		ladder = new BufferedImage[6];
		flag = flag_sheet.crop(0, 0, width, height);
		
		
		attac1 = new BufferedImage[5];
		idle_1 = new BufferedImage[4];
		floor1[0] = part2.crop(0, 0, width, height);
		floor1[1] = part2.crop(32, 0, width, height);
		floor1[2] = part2.crop(64, 0, width, height);
		
		floor1[3] = part2.crop(0, 32, width, height);
		floor1[4] = part2.crop(32, 32, width, height);
		floor1[5] = part2.crop(64, 32, width, height);
		
		floor1[6] = part2.crop(0, 64, width, height);
		floor1[7] = part2.crop(32, 64, width, height);
		floor1[8] = part2.crop(64, 64, width, height);
		icon1 = icons1.crop(0,0, width, height);
		icon2 = icons2.crop(0, 0, width, height);
		icon3 = icons3.crop(0, 0, width, height);
		free = part1.crop(0, 0, width, height);
		techo = part1.crop(0,0,width,height);
		inter1 = part1.crop(0,width,width,height);
		inter2 = part1.crop(0,width * 2,width,height);
		inter3 = part1.crop(0,width * 3,width,height);
		floor_image2 = part1.crop(height * 2,0,width,height);
		floor_image = part1.crop(height,0,width,height);
		floor_images.add(floor_image);
		floor_images.add(floor_image2);
		attac1[0] = attack1.crop(0,0, width, height);
		attac1[1] = attack1.crop(32,0, width, height);
		attac1[2] = attack1.crop(64,0, width, height);
		attac1[3] = attack1.crop(96,0, width, height);
		attac1[4] = attack1.crop(128,0, width, height);
		
		idle_1[0] = idle1.crop(0,14, width, height);
		idle_1[1] = idle1.crop(32,14, width, height);
		idle_1[2] = idle1.crop(64,14, width, height);
		
		animationsCharacter1.add(right1_walk);
		animationsCharacter1.add(left1_walk);
		animationsCharacter1.add(climb1);
		animationsCharacter2.add(right2_walk);
		animationsCharacter2.add(left2_walk);
		animationsCharacter2.add(climb2);
		animationsCharacter3.add(right3_walk);
		animationsCharacter3.add(left3_walk);
		animationsCharacter3.add(climb3);
		/**
		 * Creamos un for para poder cortar las imagenes de una forma mas dinamica
		 */
		int watercount = 13;
		for(int i = 0; i < 4; i++) {
			water[i] = part1.crop(width * watercount, height * 6, width, height);
			watercount++;
		}
		int floor_count = 0;
		for(int i = 0; i < 4; i++) {
			air[i] = part2.crop(floor_count,96, width, height);
			floor_count+= 32;
		}
		
		int ladder_count = 0;
		for(int i = 0; i < 6; i++) {
			ladder[i] = ladder_sprite.crop(0,ladder_count, width, height);
			ladder_count+= 32;
		}
		
		int count = 0;
		for(int i = 0; i < 6; i++) {
			right1_walk[i] = player1_right.crop(count, 0, width, height);
			left1_walk[i] = player1_left.crop(count, 0, width, height);
			right2_walk[i] = player2_right.crop(count, 0, width, height);
			left2_walk[i] = player2_left.crop(count, 0, width, height);
			right3_walk[i] = player3_right.crop(count, 0, width, height);
			left3_walk[i] = player3_left.crop(count, 0, width, height);
			climb1[i] = player1_climb.crop(count, 0, width, height);
			climb2[i] = player2_climb.crop(count, 0, width, height);
			climb3[i] = player3_climb.crop(count, 0, width, height);
			count+= 32;
		}
		
	}
}




