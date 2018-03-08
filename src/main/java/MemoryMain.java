import java.awt.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class MemoryMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        MemoryMethods pam = new MemoryMethods();
        String[][] tmp;
        String[][] tmpNumbers;
        tmp = pam.creatingArray();
        List<String> listWithletters= pam.filligBoard();
        pam.display(tmp);
        Thread.sleep(10000);
        List<String>  listofLettersSorted=pam.sorting(tmp);
      MemoryMethods.clrscr();
    tmpNumbers=pam.fillingnumbers(tmp);
    pam.emptySpace();
        pam.display(tmp);

     pam.guessing(listofLettersSorted);




    }
}
