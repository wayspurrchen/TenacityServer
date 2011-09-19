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
								//System.out.println("Boolean check, has exit");
								int reverseDirectionInt = 0;
								Area tmpConnectedArea = null;
								boolean tmpConnectorConnects = false;
								switch (l) {
									case 1: //N
										tmpConnectedArea = getAreaByCoords(i,j-1,k);
										reverseDirectionInt = 4;
										if (tmpConnectedArea.exitExistsS()) tmpConnectorConnects = true;
										break;
									case 2: //E
										tmpConnectedArea = getAreaByCoords(i+1,j,k);
										reverseDirectionInt = 3;
										if (tmpConnectedArea.exitExistsW()) tmpConnectorConnects = true;
										break;
									case 3: //W
										tmpConnectedArea = getAreaByCoords(i-1,j,k);
										reverseDirectionInt = 2;
										if (tmpConnectedArea.exitExistsE()) tmpConnectorConnects = true;
										break;
									case 4: //S
										tmpConnectedArea = getAreaByCoords(i,j+1,k);
										reverseDirectionInt = 1;
										if (tmpConnectedArea.exitExistsN()) tmpConnectorConnects = true;
										break;
									case 5: //NW
										tmpConnectedArea = getAreaByCoords(i-1,j-1,k);
										reverseDirectionInt = 8;
										if (tmpConnectedArea.exitExistsSE()) tmpConnectorConnects = true;
										break;
									case 6: //NE
										tmpConnectedArea = getAreaByCoords(i+1,j-1,k);
										reverseDirectionInt = 7;
										if (tmpConnectedArea.exitExistsSW()) tmpConnectorConnects = true;
										break;
									case 7: //SW
										tmpConnectedArea = getAreaByCoords(i-1,j+1,k);
										reverseDirectionInt = 6;
										if (tmpConnectedArea.exitExistsNE()) tmpConnectorConnects = true;
										break;
									case 8: //SE
										tmpConnectedArea = getAreaByCoords(i+1,j+1,k);
										reverseDirectionInt = 5;
										if (tmpConnectedArea.exitExistsNW()) tmpConnectorConnects = true;
										break;
									case 9: //U
										tmpConnectedArea = getAreaByCoords(i,j,k+1);
										reverseDirectionInt = 10;
										if (tmpConnectedArea.exitExistsU()) tmpConnectorConnects = true;
										break;
									case 10: //D
										tmpConnectedArea = getAreaByCoords(i,j,k-1);
										reverseDirectionInt = 9;
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
