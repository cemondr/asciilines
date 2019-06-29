import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class asciilinesTest {

    public char[][] getSolutionMatrix(String testSolutionPath,String testSolutionTVG){
        BufferedReader reader;
        char [][] solution = null;
        int i = 0;
        try{
            reader = new BufferedReader(new FileReader(testSolutionTVG));
            String line = reader.readLine();
            String [] sizestr = line.split(" ");
            solution = new char [Integer.parseInt(sizestr[0])][Integer.parseInt(sizestr[1])];
            reader.close();
            reader = new BufferedReader(new FileReader(testSolutionPath));
            line = reader.readLine();
            while(line != null){
                char [] currentRow = line.replaceAll(" ", "").toCharArray();
                for (int j = 0; j<solution[i].length; j++) {
                    solution[i][j] = currentRow[j];
                }
                line = reader.readLine();
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return solution;
    }



    @Test
    void testSolveForTVG1(){
        char [][] expected = getSolutionMatrix("tests/test1.out", "tests/test1.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test1.tvg");
        assertArrayEquals(expected,result);
    }

    @Test
    void testSolveForTVG2(){
        char [][] expected = getSolutionMatrix("tests/test2.out", "tests/test2.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test2.tvg");
        assertArrayEquals(expected,result);
    }

    @Test
    void testSolveForTVG3(){
        char [][] expected = getSolutionMatrix("tests/test3.out", "tests/test3.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test3.tvg");
        assertArrayEquals(expected,result);
    }

    @Test
    void testSolveForTVG4(){
        char [][] expected = getSolutionMatrix("tests/test4.out", "tests/test4.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test4.tvg");
        assertArrayEquals(expected,result);
    }

    @Test
    void testSolveForTVG5(){
        char [][] expected = getSolutionMatrix("tests/test5.out", "tests/test5.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test5.tvg");
        assertArrayEquals(expected,result);
    }


    @Test
    void testSolveForTVG6(){
        char [][] expected = getSolutionMatrix("tests/test7.out", "tests/test7.tvg");
        asciilines testAsciiLinesObject = new asciilines();
        char [][] result = testAsciiLinesObject.solveForTVG("tests/test7.tvg");
        assertArrayEquals(expected,result);

    }


}