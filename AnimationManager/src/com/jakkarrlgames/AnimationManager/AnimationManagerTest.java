package com.jakkarrlgames.AnimationManager;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationManagerTest implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private TextureRegion currentFrame;
	private Animator animator;
	private Animation anim;
	float stateTime;

	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		animator = new Animator(1,1);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		batch = new SpriteBatch();
		
		animator.addFrameDimesion(0, 0, 0,w,h);
		anim = animator.createAnimation("data/libgdx.png");
		stateTime = 0;
	}

	@Override
	public void dispose() {
		batch.dispose();
		//texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		 stateTime += Gdx.graphics.getDeltaTime();
		 currentFrame =anim.getKeyFrame(stateTime, true);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(currentFrame,100,100);
	//	sprite.draw(batch);
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
