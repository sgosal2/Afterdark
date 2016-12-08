package game;

public class EndBlock extends Block {

	public EndBlock(String imageName, double x, double y) {
		super(imageName, x, y);
		isBlockSolid = true;
	}

}
