package Projekt3;

import java.util.HashMap;
import java.util.Scanner;

public class CommandLine {

    public void commadLine(HashMap <String, Judgment> judgments) {
        try {
            Scanner in = new Scanner(System.in);

            String ord;
            String parameters;
            String line;
            String[] input;
            JudgmentFunc f = new JudgmentFunc(judgments);

            while (true) {
                line = in.nextLine();
                parameters = "";
                input = line.split("\\s+", 2);
                ord = input[0];
                if (input.length == 2) {
                    parameters = input[1];
                }
                if (ord.equals("rubrum")) {
                    System.out.println(f.rubrum(parameters));
                }

                else if (ord.equals("content")) {
                    System.out.println(f.showTextcontent());
                }
                else if (ord.equals("judges")) {
                    System.out.println(f.BestJudges());
                }
                else if (ord.equals("months")) {
                    System.out.println(f.judgementsPerMonth());
                }
                else if (ord.equals("courts")) {
                    System.out.println(f.courtTypeDistribution());
                }
                else if (ord.equals("regulations")) {
                    System.out.println(f.topLaws());
                }
                else if (ord.equals("jury")) {
                    System.out.println(f.judgesPerJudgment());
                }
                else if (ord.equals("help")){
                    System.out.println(f.help());
                }

                else {
                    System.out.println("nieprawidłowa komenda ");
                }



            }

        } catch (Exception e) {
            System.out.println("błąd");
        }
    }


}
