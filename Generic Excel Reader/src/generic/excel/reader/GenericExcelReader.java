/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.excel.reader;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ob
 */
public class GenericExcelReader 
{
    private static String filePath = null;
    private static boolean confirmExit;

    /**
     * @param confirmExit
     */
    public GenericExcelReader(boolean confirmExit)
    {
        GenericExcelReader.confirmExit = confirmExit;
        
    }

    public static String fileChoser() {
        //creates filechoser with desktop as default directory
        String userhome = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userhome + "\\Desktop");
        
        int status = fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        
        if(confirmExit && status != JFileChooser.APPROVE_OPTION)
        {
            confirmChoice("No File Chosen");
        } else {
            filePath = file.getAbsolutePath();
        }
        
        return filePath;
    }
    
    private static void confirmChoice(String chooseError)
    {
        int choice = JOptionPane.showConfirmDialog(null, "Do You want to quit?", chooseError, JOptionPane.YES_NO_OPTION);
        
        //only tries filechooser again if they explicitly say they don't want to quit
        if(choice == JOptionPane.NO_OPTION)
        {
            fileChoser();
        } else
            System.exit(0);
    }
    
}
