package Projekt3;

import java.util.Scanner;

public class CommandLine {

    public void commadLine() {
        try {
            Scanner in = new Scanner(System.in);
            String result = null;
            String ord;
            String parameters;
            String line;
            String[] input;
            JudgmentFunc f = new JudgmentFunc();

            while (true) {
                line = in.nextLine();
                parameters = "";
                input = line.split("\\s+", 2);
                ord = input[0];
                if (input.length == 2) {
                    parameters = input[1];
                }
                if (ord.equals("rubrum")) {
                    result = f.rubrum(parameters);
                }
                else if (ord.equals("orzeczeniaNaSedzeigo")) {
                    result = f.judgementsPerJudge(parameters);
                }
                else if (ord.equals("najSędziowie")) {

                }
                else {
                    result = "nieprawidłowa komenda ";
                }


                System.out.println(result);
            }

        } catch (Exception e) {
            System.out.println("błąd");
        }
    }


}
