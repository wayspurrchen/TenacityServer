package tenacity.Places;

public abstract class Place {
	Area[][][] areaMap;
	int xMax;
	int yMax;
	int zMax;
	
	int[] defaultAreaXYZ = new int[3];
	
	Place() {
		
	}
	
	protected void createMap() {
		areaMap = new Area[xMax][yMax][zMax];
	}
	
	protected void verifyMap() {
		for (int i=0;i<xMax;i++) {
			for (int j=0;j<yMax;j++) {
				for (int k=0;k<zMax;k++) {
					Area tmpArea = getAreaByCoords(i,j,k);
					if (tmpArea!=null) {
						for (int l=0;l<=10;l++) {
							if (tmpArea.getExitBoolByIndex(l)==true) {
								Area tmpConnectedArea = null;
								boolean tmpConnectorConnects = false;
								switch (l) {
									case 1: //N
										tmpConnectedArea = getAreaByCoords(i,j-1,k);
									if (tmpConnectedArea.exitExistsS()) tmpConnectorConnects = true;
										break;
									case 2: //E
										tmpConnectedArea = getAreaByCoords(i+1,j,k);
									if (tmpConnectedArea.exitExistsW()) tmpConnectorConnects = true;
										break;
									case 3: //W
										tmpConnectedArea = getAreaByCoords(i-1,j,k);
									if (tmpConnectedArea.exitExistsE()) tmpConnectorConnects = true;
										break;
									case 4: //S
										tmpConnectedArea = getAreaByCoords(i,j+1,k);
									if (tmpConnectedArea.exitExistsN()) tmpConnectorConnects = true;
										break;
									case 5: //NW
										tmpConnectedArea = getAreaByCoords(i-1,j-1,k);
									if (tmpConnectedArea.exitExistsSE()) tmpConnectorConnects = true;
										break;
									case 6: //NE
										tmpConnectedArea = getAreaByCoords(i+1,j-1,k);
									if (tmpConnectedArea.exitExistsSW()) tmpConnectorConnects = true;
										break;
									case 7: //SW
										tmpConnectedArea = getAreaByCoords(i-1,j+1,k);
									if (tmpConnectedArea.exitExistsNE()) tmpConnectorConnects = true;
										break;
									case 8: //SE
										tmpConnectedArea = getAreaByCoords(i+1,j+1,k);
									if (tmpConnectedArea.exitExistsNW()) tmpConnectorConnects = true;
										break;
									case 9: //U
										tmpConnectedArea = getAreaByCoords(i,j,k+1);
									if (tmpConnectedArea.exitExistsU()) tmpConnectorConnects = true;
										break;
									case 10: //D
										tmpConnectedArea = getAreaByCoords(i,j,k-1);
									if (tmpConnectedArea.exitExistsD()) tmpConnectorConnects = true;
										break;
								}
								if (tmpConnectedArea!=null)  {
									if (tmpConnectorConnects==true) {
										tmpArea.setAdjacentAreaByIndex(l, tmpConnectedArea);
										//System.out.println(tmpArea+" has had area "+tmpConnectedArea+" assigned to exit at index "+l);
										//System.out.println(tmpArea.getAreaByIndex(l));
									} else System.out.println("ERROR: DESTINATION DOES NOT ALLOW EXIT");
								} else System.out.println("ERROR! DESTINATION DOES NOT EXIST");
							} //else System.out.println("Boolean checked, does not have exit");
						}
					} else {
						//System.out.println("No Area at Place["+i+"]["+j+"]["+k+"]");
					}
				}
			}
		}
		
	}
	
	public Area[][][] getAreaMap() {
		return areaMap;
	}
	
	public Area getAreaByCoords(int x, int y, int z) {
		return areaMap[x][y][z];
	}
	
	public int[] getDefaultAreaXYZ() {
		return defaultAreaXYZ;
	}
}
