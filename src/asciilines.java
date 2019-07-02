import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;

public class asciilines {

    private char [][] solution = null;

    char[][] solveForTVG(String path) {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String [] canvasDimensions = reader.readLine().split(" ");
            String command = reader.readLine();
            setUpCanvas(Integer.parseInt(canvasDimensions[0]),Integer.parseInt(canvasDimensions[1]));

            while(command != null){
                String [] currentCommand = command.split(" ");
                char direction = currentCommand[3].charAt(0);
                if(direction == 'v'){
                    verticalRendering(currentCommand[0].charAt(0),Integer.parseInt(currentCommand[1])
                            ,Integer.parseInt(currentCommand[2]),Integer.parseInt(currentCommand[4]));
                }
                else if(direction == 'h'){
                    horizontalRendering(currentCommand[0].charAt(0),Integer.parseInt(currentCommand[1])
                            ,Integer.parseInt(currentCommand[2]),Integer.parseInt(currentCommand[4]));
                }else{
                    throw new InputMismatchException();
                }
                command = reader.readLine();
            }
        }catch(Exception formatException){
            System.out.println("!!!!!\nBroken Format: Output couldn't be produced by the given tvg file. Check Format!\n!!!!!");
            System.exit(-1);
        }
        return solution;
    }

    private void verticalRendering(char goal, int srow, int scol, int dLen){

        for (int i = checkIfInBound(srow); i<solution.length && i<srow+dLen; i++){
            if (scol < solution[i].length && scol >= 0) {
                solution[i][scol] = goal;
            }
        }
    }

    private void horizontalRendering(char goal, int srow, int scol, int dLen){

        if(srow < solution.length && srow >=0){
            for(int j = checkIfInBound(scol); (j< solution[srow].length && j<scol+dLen); j++){
                solution[srow][j] = goal;
            }
        }
    }

    private int checkIfInBound(int num){
        if (num < 0){
            return 0;
        }
        return num;
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

        if(solution != null){
            for (char[] chars : solution) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Currently holding no solutions");
        }

    }

    public static void main(String [] args ){

        if (args.length < 1){
            System.err.println("Missing argument (.tvg file)");
            System.exit(1);
        }else if (args.length > 1){
            System.err.println("Too many arguments, please run with only one .tvg file at a time");
            System.exit(1);
        }

        if (args[0].length() < 4 || !(args[0].substring(args[0].length() - 4).equals(".tvg"))){
            throw  new IllegalArgumentException("Invalid file");
        }

        asciilines newRenderer = new asciilines();
        newRenderer.solveForTVG(args[0]);
        newRenderer.displaySolution();
    }

}
