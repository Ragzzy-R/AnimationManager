package com.jakkarrlgames.AnimationManager;

/*
 *AnimationManager for libgdx
Copyright (C) 2014  Raghuram Iyer Ragzzy-R"

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
* 
* */

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AnimationManagerTest implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private AnimatableEntity player;
	private Animator walkAnimator;
	private Animator slideAnimator;
	Entity test;
	private Animation anim;
	float stateTime;

	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		walkAnimator = new Animator(1,7);
		slideAnimator= new Animator(1,3);
		player = new AnimatableEntity(1);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		batch = new SpriteBatch();
		test = new Entity();
		
		
		/*adding frame dimensions(this is a really cumbersome task if u have a complex
			sprite sheet.But its totally worth it.when managing animations in render().
		*/
		walkAnimator.addFrameDimesion(0, 0,   0, 70, 64);
		walkAnimator.addFrameDimesion(1, 82,  0, 70, 64);
		walkAnimator.addFrameDimesion(2, 152, 0, 70, 64);
		walkAnimator.addFrameDimesion(3, 236, 0, 70, 64);
		walkAnimator.addFrameDimesion(4, 312, 0, 70, 64);
		walkAnimator.addFrameDimesion(5, 382, 0, 70, 64);
		walkAnimator.addFrameDimesion(6, 457, 0, 70, 64);
		
		/*create animation from  the spritesheet.As we have already given the co ordinates 
			for a particular animation,just sit back and watch.Animator class will create 
			the animation for u.
		*/
		anim = walkAnimator.createAnimation("data/walk.png",.2f);
		
		
		slideAnimator.addFrameDimesion(0, 0,   0, 78, 64);
		slideAnimator.addFrameDimesion(1, 78,  0, 90, 64);
		slideAnimator.addFrameDimesion(2, 168, 0, 90, 64);
		slideAnimator.createAnimation("data/slide.png",.2f);
		
		stateTime = 0;
		/*
		 * finally adding all animators to Animatable entity.
		 * */
		player.attachAnimator(walkAnimator, "walk");
		player.attachAnimator(slideAnimator, "slide");
		player.setCurrentAnimator("walk");
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		 stateTime += Gdx.graphics.getDeltaTime();
		 
		 
		 if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			 
			 player.setCurrentAnimator("slide"); //just set current Animation of the Animatable Entity
		 }
		 if(!Gdx.input.isKeyPressed(Keys.SPACE)) {
			 player.setCurrentAnimator("walk");   //walk
		 }

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
		player.render(batch,100,100,stateTime); //finally render our player :)
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
