/**
 * 
 */
package com.jakkarrlgames.AnimationManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author raghuram
 *
 */

public class Animator {

	/**
	 * 
	 */
	Animation animation;
	Texture texture;
	Sprite	sprite;
	TextureRegion[] frames;
	FrameDimension[] frameDimensions;
	float stateTime;
	int row,col;
	public Animator(int row,int col) {
		
		this.row = row;
		this.col = col;
		frames = new TextureRegion[row*col];
		frameDimensions = new FrameDimension[row*col];

	}

	public Animation createAnimation(String pathToSpriteSheet) {
		texture = new Texture(Gdx.files.internal(pathToSpriteSheet));
		int x1 = 0,y1 = 0,width1 = 0,height1 = 0;
		for(int i=0;i< (row*col);i++) {
			x1=frameDimensions[i].x;
			y1=frameDimensions[i].y;
			width1=frameDimensions[i].width;
			height1=frameDimensions[i].height;
		frames[i] = new TextureRegion(texture,x1,y1,texture.getWidth(),texture.getHeight());
		}
		System.out.println(x1+"-"+y1+"-"+width1+"-"+height1);
		animation = new Animation(0.025f,frames);
		return animation;
	}
	
	public void addFrameDimesion(int frameIndex,float x,float y,float width,float height) {
		frameDimensions[frameIndex]= new FrameDimension();
		frameDimensions[frameIndex].x=x;
		frameDimensions[frameIndex].y=y;
		frameDimensions[frameIndex].width=width;
		frameDimensions[frameIndex].height=height;
		
	}
	public void render(SpriteBatch batch) {
		batch.draw(frames[0], 0, 0, 200, 200);
	}
}
