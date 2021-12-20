package metal_solid.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UImanageCharacter extends Uiobject{

	private BufferedImage images;
	private ClickListener clicker;
	
	
	public UImanageCharacter(float x, float y, int width, int height,BufferedImage images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(images, (int)x , (int)y, width, height,null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
