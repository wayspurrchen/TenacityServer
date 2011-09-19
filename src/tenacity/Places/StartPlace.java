package tenacity.Places;

public class StartPlace extends Place {
	
	public StartPlace() {
		xMax = 10;
		yMax = 10;
		zMax = 1;
		defaultAreaXYZ[0] = 0;
		defaultAreaXYZ[1] = 0;
		defaultAreaXYZ[2] = 0;
		createMap();
		areaMap[0][0][0] = new Start();
		areaMap[0][1][0] = new SouthofStart();
		verifyMap();
	}

}
