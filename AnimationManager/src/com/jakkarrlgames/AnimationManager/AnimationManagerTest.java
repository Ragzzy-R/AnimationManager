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
import com.badlogic.gdx.math.Vector2;

public class AnimationManagerTest implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private TextureRegion currentFrame;
	private Animator animator;
	private Texture testTexture;
	private Sprite testSprite;
	Entity test;
	private Animation anim;
	float stateTime;

	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		animator = new Animator(2,2);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,w,h);
		batch = new SpriteBatch();
		test = new Entity();
		testTexture = new Texture(Gdx.files.internal("data/libgdx.png"));
		test.getRegionFromTexture(testTexture,0	,0,testTexture.getWidth(),testTexture.getHeight());
		testSprite = test.createSprite(new Vector2(300,300),new Vector2(100,100));
		animator.addFrameDimesion(0, 0f, 0f,100,100);
		animator.addFrameDimesion(1, 100f, 100f, 100, 100);
		animator.addFrameDimesion(2, 100f, 200f, 100, 100);
		animator.addFrameDimesion(3, 100f, 300f, 100, 100);
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
		testSprite.draw(batch);
		animator.render(batch);
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
