package MazeSolver;

import java.io.File;
import java.util.Scanner;

public class FileReader {
	
	private int[][] map;
	private String filename;
	private int numOfRows;
	private int numOfColumns;
	private int startPositionCol;//start index 2 col
	private int startPositionRow;//start index 2 row
	
	public FileReader(String fileName, int numOfRows, int numOfColumns) {
		this.filename = fileName;
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		this.map = new int[numOfRows][numOfColumns];
	}
	
	public void parseFile() {
		
		try {
			
			Scanner scanner = new Scanner(new File(this.filename));
			
			for(int i=0;i<this.numOfRows;i++) {
				for(int j=0;j<this.numOfColumns;j++) {
					
					map[i][j] = scanner.nextInt();  //read in map file
					
					
					startPositionCol = 1;
					startPositionRow = 1;
					if( map[i][j] == 2) {
						startPositionCol = j;
						startPositionRow = i;
					}
				}
			}
			
			scanner.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getStartPositionCol() {
		return startPositionCol;
	}

	public int getStartPositionRow() {
		return startPositionRow;
	}

	public int[][] getMap() {
		return this.map;
	}

}
