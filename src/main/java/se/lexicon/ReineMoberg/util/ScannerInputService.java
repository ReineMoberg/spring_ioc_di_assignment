package se.lexicon.ReineMoberg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService{

    @Autowired
    private Scanner scanner;

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        int intNumber;
        String intString = scanner.nextLine();
        if (intString.matches("\\d+")) {
            try {
                intNumber = Integer.parseInt(intString);
                if (intNumber > 0) {
                    return intNumber;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
