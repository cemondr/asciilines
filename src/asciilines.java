import java.io.BufferedReader;
import java.io.FileReader;

public class asciilines {

    private char [][] solution;

    char[][] solveForTVG(String path) {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String [] canvasDimensions = reader.readLine().split(" ");
            String command = reader.readLine();
            setUpCanvas(Integer.parseInt(canvasDimensions[0]),Integer.parseInt(canvasDimensions[1]));


            while(command != null){
                String [] currentCommand = command.split(" ");
                char goalChar = currentCommand[0].charAt(0);
                int startRow = Integer.parseInt(currentCommand[1]);
                int startCol = Integer.parseInt(currentCommand[2]);
                char direction = currentCommand[3].charAt(0);
                int dirLength = Integer.parseInt(currentCommand[4]);
                if(direction == 'v'){
                    verticalRendering(goalChar,startRow,startCol,dirLength);
                }
                else if(direction == 'h'){
                    horizantalRendering(goalChar,startRow,startCol,dirLength);
                }
                command = reader.readLine();
            }
        }catch(Exception formatException){
            System.out.println("!!!!!\nCanvas could not be set up based on given tvg file. Check Format\n" +
                    "Exception Type: " + formatException.getClass().getName() + "\n" +
                    "Problem Encountered At Line: " + formatException.getCause());
            System.exit(-1);
        }

        return solution;
    }


    private void verticalRendering(char goal, int srow, int scol, int dLen){
        if (srow < 0){
            srow = 0;
        }
        if (scol < 0){
            scol = 0;
        }
        for (int i = srow; i<solution.length && i<srow+dLen; i++){
            solution[i][scol] = goal;
        }
    }

    private void horizantalRendering(char goal, int srow, int scol, int dLen){
        if(srow < 0){
            srow = 0;
        }
        if(scol < 0){
            scol = 0;
        }

        if(srow < solution.length){
            for(int j = scol; (j< solution[srow].length && j<scol+dLen); j++){
                solution[srow][j] = goal;
            }
        }
    }

    /* initializes the canvas */
    private void setUpCanvas(int row, int col){
        solution = new char[row][col];
        for (int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                solution[i][j] = '.';
            }
        }
    }

    private void displaySolution(){

        for (char[] chars : solution) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static void main(String [] args ){
        asciilines newRenderer = new asciilines();
        newRenderer.solveForTVG(args[0]);

        newRenderer.displaySolution();
    }

}
