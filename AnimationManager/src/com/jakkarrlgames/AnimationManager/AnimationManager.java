package com.jakkarrlgames.AnimationManager;

import java.util.Hashtable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AnimationManager {
	Hashtable<String, AnimatableEntity> entityTable;
	AnimationManager() {
		entityTable = new Hashtable<String, AnimatableEntity>();
	}
	public void update(SpriteBatch batch) {
		
	}
}
