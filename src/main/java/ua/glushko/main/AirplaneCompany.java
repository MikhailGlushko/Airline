package ua.glushko.main;

import ua.glushko.command.Command;
import ua.glushko.command.CommandFactory;

import java.util.Objects;
import java.util.Scanner;

class AirplaneCompany {
    public static void main(String[] args){
        char ch = 0;
        do{
            mainMenu();
            ch = readAnswer(ch);
            Command command = CommandFactory.getCommand(ch);
            command.execute();
            System.out.println("Please ENTER to continue");
            ch = readAnswer(ch);

        } while (ch!='Q' && ch!='q');
    }

    private static char readAnswer(char ch) {
        if(ch=='Q' || ch=='q')
            return ch;
        char answer = 0;
        Scanner scanner = new Scanner(System.in);
            String readString = scanner.nextLine();
            if(Objects.nonNull(readString) && readString.isEmpty())
                answer= 0xd;
            if(Objects.nonNull(readString) && !readString.isEmpty())
                answer = readString.charAt(0);
        return answer;
    }

    private static void mainMenu() {
        System.out.println("AirplaneCompany");
        System.out.println("*******");
        System.out.println("Please choose:");
        System.out.println("1-Calculate the total capacity and carrying capacity of all the aircraft in the airline");
        System.out.println("2-Display the list of aircraft of the company sorted by flight range");
        System.out.println("3-Find airplanes corresponding to a given range of fuel consumption parameters");
        System.out.println("Q-Stop");
        System.out.println("***************************************************************************************");
        System.out.println("");
    }
}
