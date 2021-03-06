package a12;

import java.util.Random;

public class Carnivore extends Lifeform {

	/***
	 * Make a herbivore at an x,y pixel location
	 * @param _x
	 * @param _y
	 */
	public Carnivore(double _x, double _y) {

		super(_x, _y, 50.0, 300.0, 0.011, 2.0, 6.0);
		super.loadSprite("images/player3.png");
	}
	
	/***
	 * Make a child of Carnivore type
	 */
	@Override
	public Lifeform makeChild() {
		Carnivore C =  new Carnivore(this.getLocationX(), this.getLocationY());
		return C;
	}

	/***
	 * A carnivore can eat a herbivore prey.
	 */
	@Override
	public boolean canEat(Lifeform prey) {
		if (prey instanceof Herbivore)
			return true;
		return false;
	}
	
	/***
	 * A Carnivore reproduces if it has enough energy and 
	 * has luck.
	 */
	@Override
	public void tryToReproduce(World world) {
		Random rng = new Random();
		if (this.getFoodValue() > 80 && rng.nextDouble() < this.getReproductionRate()) {
			Lifeform l = makeChild();
			world.addToPopulation(l);
			l.useCalories(40);
		}
	}
	
	/***
	 * Some creatures don't hunt, so return that status for efficiency
	 * @return
	 */
	public boolean isHunter() {
		return true;
	}

}
