/**
*
*/
package com.jakkarrlgames.AnimationManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
* @author Raghuram Iyer
*
*/
public class Entity {

/**
*
*/
public Sprite sprite;
public TextureRegion region;
public World world;
public BodyDef bodyDef;
public Body body;
public PolygonShape box;
public CircleShape ball;
public FixtureDef fixtureDef;
public Entity(World world) {
this.world = world;
}
public Entity() {

}
public TextureRegion getRegionFromTexture(Texture texture,int tx,int ty,int width,int height) {
region =new TextureRegion(texture, tx, ty,width,height);
return region;

}
public Sprite createSprite(Vector2 size,Vector2 origin,Vector2 position) {

sprite = new Sprite(region);
sprite.setSize(size.x, size.y);
sprite.setOrigin(origin.x,origin.y);
sprite.setPosition(position.x,position.y);
return sprite;
}
public Sprite createSprite(Vector2 size,Vector2 position) {

sprite = new Sprite(region);
sprite.setSize(size.x, size.y);
sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
sprite.setPosition(position.x,position.y);
return sprite;
}


public void createBoxPhysics(World world,BodyDef.BodyType type,Vector2 position,float hx,float hy,float density,float friction,float restit) {
bodyDef = new BodyDef();
bodyDef.type = type;
bodyDef.position.set(position.x,position.y);
body = world.createBody(bodyDef);
box = new PolygonShape();
box.setAsBox(hx, hy);
FixtureDef fixtureDef = new FixtureDef();
fixtureDef.shape = box;
fixtureDef.density = density;
fixtureDef.friction = friction;
fixtureDef.restitution = restit;
body.createFixture(fixtureDef);

}
public void createCirclePhysics(World world,BodyDef.BodyType type,Vector2 position,float radius,float density,float friction,float restit) {
bodyDef = new BodyDef();
bodyDef.type = type;
bodyDef.position.set(position.x,position.y);
body = world.createBody(bodyDef);
ball = new CircleShape();
ball.setRadius(radius);
fixtureDef = new FixtureDef();
fixtureDef.shape = ball;
fixtureDef.density = density;
fixtureDef.friction = friction;
fixtureDef.restitution = restit;
body.createFixture(fixtureDef);

}
public void disposeEntity() {
world.destroyBody(body);
world.dispose();
}
}