package com.jakkarrlgames.AnimationManager;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatableEntity {
	Hashtable<String,Animator> animationTable;
	Animator anim;
	AnimatableEntity(int noOfAnimators) {
		animationTable = new Hashtable<String,Animator>(noOfAnimators);
		anim = new Animator();
	}
	
	public void registerAnimator(Animator anim,String name) {
		animationTable.put(name, anim);
	}
	public void setCurrentAnimator(String name) {
	
			anim=animationTable.get(name);

	}
	public void render(SpriteBatch batch,int x,int y,float stateTime) {
		anim.render(batch, x, y, stateTime);
	}
}
