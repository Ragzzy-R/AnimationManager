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
 * @author raghuram Iyer Ragzzy-R
 *
 */

public class Animator {

	/**
	 * This is an animator Class.An Animator is an entity that animates an animation.(i.e)
	 * if a character has three types of animation such as walking,jumping,running then we need
	 * to create three animators.
	 */
	Animation animation;
	Texture texture;
	Sprite	sprite;
	TextureRegion[] frames;
	FrameDimension[] frameDimensions;
	float stateTime;
	int row,col;
	int frameCount;
	private TextureRegion currentFrame;
	
	
	public Animator(int frameCount) {
		this.frameCount= frameCount;
		frames = new TextureRegion[row*col];
		frameDimensions = new FrameDimension[row*col];
	}

	public Animator(int row,int col) {
		
		this.row = row;
		this.col = col;
		frameCount=row*col;
		frames = new TextureRegion[row*col];
		frameDimensions = new FrameDimension[row*col];

	}

	public Animator() {
		// TODO Auto-generated constructor stub
	}

	public Animation createAnimation(String pathToSpriteSheet,float frameTransition) {
		texture = new Texture(Gdx.files.internal(pathToSpriteSheet));
		int x1 = 0,y1 = 0,width1 = 0,height1 = 0;
		try {
			for(int i=0;i< (frameCount);i++) {
				x1=frameDimensions[i].x;
				y1=frameDimensions[i].y;
				width1=frameDimensions[i].width;
				height1=frameDimensions[i].height;
				frames[i] = new TextureRegion(texture,x1,y1,width1,height1);
			}
		}
		catch(NullPointerException e) {
			System.out.println("ERROR:trying to create Animation without filling up frameDimensions.");
			System.out.println("use addFrameDimension() or addCoOrdinates() to fill up frameDimensions");
		}
		System.out.println(x1+"-"+y1+"-"+width1+"-"+height1);
		animation = new Animation(frameTransition,frames);
		return animation;
	}
	/*
	 * this is a method used to fill up the dimensions of the frame.It is always recommended to
	 * use spritesheets instead of using separate images for an animation.Hence Animation Manager
	 * only supports SpriteSheet Animation.A addFrameDimesion() must be called once for each frame with its x,
	 * y,width and height.
	 * 
	 * Note:In case all your frames are of same width and height then call setAllFramesDimension(Vector2 dimension)  
	 * and then call addFrameCoOrdinates(Vector2 coOdrinates) for each frame instead.
	 * */
	public void addFrameDimesion(int frameIndex,int x,int y,int width,int height) {
		
		frameDimensions[frameIndex]= new FrameDimension();
		frameDimensions[frameIndex].x=x;
		frameDimensions[frameIndex].y=y;
		frameDimensions[frameIndex].width=width;
		frameDimensions[frameIndex].height=height;
		
		
	}
	
	public void addFrameCoOrdinates(int frameIndex,int x,int y) {
		frameDimensions[frameIndex].x = x;
		frameDimensions[frameIndex].y = y;
	}
	public void setAllFramesDimension(int width,int height) {
		for(int i=0;i<row*col;i++) {
			frameDimensions[i].width=width;
			frameDimensions[i].height=height;
		}
	}
	/*
	 * this need not to be called explicitly unless u want to do some debugging.All animators' 
	 * render are called by its corresponding AnimatableEntity.
	 * */
	public void render(SpriteBatch batch,int x,int y,float stateTime) {
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame =animation.getKeyFrame(stateTime, true);
		batch.draw(currentFrame,100,100);
	}
}
