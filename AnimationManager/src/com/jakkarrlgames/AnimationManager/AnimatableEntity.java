package com.jakkarrlgames.AnimationManager;
/**
 * this Class is used to manage all animators.(i.e)one per character.
 */
import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimatableEntity {
	Hashtable<String,Animator> animationTable;
	Animator anim;
	AnimatableEntity(int noOfAnimators) {
		animationTable = new Hashtable<String,Animator>(noOfAnimators);
		anim = new Animator();
	}
	/**
	 * This method is used to add animators to the Animatable Entity.(i.e) walk,fight etc to character
	 * @param anim An Animator.
	 * @param name A string to ID animator
	 */
	public void attachAnimator(Animator anim,String name) {
		animationTable.put(name, anim);
	}
	public void setCurrentAnimator(String name) {
	
			anim=animationTable.get(name);

	}
	public void render(SpriteBatch batch,int x,int y,float stateTime) {
		anim.render(batch, x, y, stateTime);
	}
}
