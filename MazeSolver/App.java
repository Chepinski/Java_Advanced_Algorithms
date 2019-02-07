package MazeSolver;

public class App {

	public static void main(String[] args) {
		
		FileReader fileReader = new FileReader("***ADDRESS TO FILE WOULD GO HERE***", 5, 5);//it has five rows and 5 cols
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
		
	}

}

/***
 * result:
 * 
Visiting i=1, j=1
Visiting i=2, j=1
Visiting i=1, j=2
Visiting i=2, j=2
Visiting i=3, j=2
Visiting i=4, j=2
Visiting i=3, j=3
Visiting i=4, j=3
Visiting i=3, j=4
Route found to exit!!
 * 
 */
