package MazeSolver;

public class MazeSolver {
	
	private int[][] mazeMap;
	private boolean[][] visited;
	private int startPositionCol;
	private int startPositionRow;
	
	public MazeSolver(int[][] mazeMap, int startPositionCol, int startPositionRow) {
		this.mazeMap = mazeMap;
		this.visited = new boolean[mazeMap.length][mazeMap.length];
		this.startPositionCol = startPositionCol;
		this.startPositionRow = startPositionRow;
	}
	
	public void findWayOut() {
		
		try {
			dfs(startPositionRow, startPositionCol);
			System.out.println("No solution found..");
		}catch(RuntimeException e) {
			System.out.println("Route found to exit!!");
		}
	}
	
	private void dfs(int rowIndex, int colIndex) {
		
		System.out.println("Visiting i="+rowIndex+", j="+colIndex);
		
		if(this.mazeMap[rowIndex][colIndex] == 3) {
			throw new RuntimeException(); //3=exit/success
		}
		
		int endOfMap = this.mazeMap.length-1;
		
		if(visited[rowIndex][colIndex]) {//already visited, skip
			return;
		}
		else if(rowIndex < 0 || rowIndex>=endOfMap) {//out of row range
			return;
		}
		else if(colIndex < 0 || colIndex>=endOfMap) {//out of col range
			return;
		}
		else if(this.mazeMap[rowIndex][colIndex] == 1) {//wall/can't travel down entries with 1
			return;
		}
		else {
			
			this.visited[rowIndex][colIndex] = true; //set location = visited
			
			dfs(rowIndex+1, colIndex); //search next row down
			dfs(rowIndex, colIndex+1); //search next col right
			dfs(rowIndex, colIndex-1); //search previous col left
			dfs(rowIndex-1, colIndex); //search previous row up
		}
	}

}
