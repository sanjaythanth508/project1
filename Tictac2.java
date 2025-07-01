import java.util.*;
class Tictac2 {
    static {
        System.out.println("  Welcome to Tic-Tac-Toe game  ");
        System.out.println("\n\nJava Concepts Used in Tic-Tac-Toe Project:");

        System.out.println("1. Object-Oriented Programming (OOP)");
        System.out.println("   - Classes and Objects");
        System.out.println("   - Inheritance");
        System.out.println("   - Polymorphism");
        System.out.println("2. Control Flow Statements");
        System.out.println("   - if-else, switch");
        System.out.println("   - Loops (for, while, do-while)");
        System.out.println("3. Arrays");
        System.out.println("4. Methods (Functions)");
        System.out.println("5. Recursion ");
        System.out.println("6. Exception Handling ");
        System.out.println("7. User Input Handling (Scanner)");
        System.out.println("8. Randomization ");

        System.out.println("\n\nRules of the Game:");
        System.out.println("1. The game is played on a 3x3 grid.");
        System.out.println("2. One player is 'X', and the other is 'O'.");
        System.out.println("3. Players take turns placing their marks in empty squares.");
        System.out.println("4. The first player to get 3 marks in a row (horizontal, vertical, or diagonal) wins.");
        System.out.println("5. If all 9 squares are filled and no one wins, it's a draw.");
        System.out.println("6. Players cannot place their mark in an already occupied square.");
        System.out.println("7. The game continues until a player wins or it's a draw.");
        System.out.println("\n\nLet's Play the Game!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name1 = "";
        String name2 = "";
        System.out.println("Press \n 1 for play game with computer \n 2 for play with friend ");
        String select = sc.next();
        while(!(select.equals("1") || select.equals("2")))
        {
            System.out.println("Enter valid choice ");
            System.out.println("Press \n 1 for play game with computer \n 2 for play with friend ");
            select = sc.next();
            
        }
        int a = Integer.parseInt(select);
        switch (a) {
            case 1:
                System.out.print("Enter your name : ");
                name1 = sc.next();
                name2 = "Computer";
                break;
            case 2:
                System.out.print("Enter name of player 1 : ");
                name1 = sc.next();
                System.out.print("Enter name of player 2 : ");
                name2 = sc.next();
                break;
        }
        while (a != 0) {
            switch (a) {
                case 1:
                    if (!(name2.equals("Computer"))) {
                        name2 = "Computer";
                    }
                    playwithComputer T = new playwithComputer(name1, name2);
                    T.yourturn();
                    break;
                case 2:
                    if (name2.equals("Computer")) {
                        System.out.print("Enter name of player 2 : ");
                        name2 = sc.next();
                    }
                    playWithFriend F = new playWithFriend(name1, name2);
                    F.player1();
                    break;
                default:
                    System.out.println("Enter valid choice ");
            }
            System.out.println("Press \n 1 for play game with computer \n 2 for play with friend \n 0 for exit game");
            select = sc.next();
            while(!(select.equals("1") || select.equals("2") || select.equals("0")))
            {
                System.out.println("Enter valid choice ");
                System.out.println("Press \n 1 for play game with computer \n 2 for play with friend \n 0 for exit game");
                select = sc.next();
                
            }
            a = Integer.parseInt(select);
        }
        if (a == 0) {
            System.out.println("\n Thanks for playing game ");
        }
    }
}

class Tictac {
    Scanner sc = new Scanner(System.in);
    char[][] Met = new char[5][5];
    String name1, name2;
    static int count1, count2;
    boolean check = false;
    char choice1;
    char choice2;
    Tictac(String name1, String name2) {
        System.out.println(name1 + " choose O or X ");
        String choice = sc.next();
        while(!(choice.equalsIgnoreCase("O") || choice.equalsIgnoreCase("X")))
        {
            System.out.println("Enter valid choice \n" );
            System.out.println(name1 + " choose O or X ");
            choice = sc.next();
        }
        if (choice.equalsIgnoreCase("O")) {
            System.out.println(name1 + " choose O ");
            System.out.println(name2 + " choose X " );
            choice1 = 'O';
            choice2 = 'X';
        } else {
            System.out.println(name1 + " choose X ");
            System.out.println(name2 + " choose O " );
            choice1 = 'X';
            choice2 = 'O';
        }
        this.name1 = name1;
        this.name2 = name2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i % 2 != 0) {
                    Met[i][j] = '-';
                }
                if (j % 2 != 0 && i % 2 != 0) {
                    Met[i][j] = '+';
                } else if ((j % 2 != 0) && (i % 2 == 0)) {
                    Met[i][j] = '|';
                }
            }
        }
        Met[0][0] = ' ';
        Met[0][2] = ' ';
        Met[2][0] = ' ';
        Met[4][0] = ' ';
        Met[2][2] = ' ';
        Met[4][2] = ' ';
        Met[0][4] = ' ';
        Met[2][4] = ' ';
        Met[4][4] = ' ';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(  Met[i][j] );
            }
            System.out.println();
        }
        check = false;
    }
    void checkCondition() {
        boolean a1, a2, a3, a4, a5, a6, a7, a8;
        char c1, c2, c3, c4, c5, c6, c7, c8;
        char C1 = 'O';
        char C2 = 'X';
        a1 = ((Met[0][0] == C1 && Met[0][2] == C1 && Met[0][4] == C1) || (Met[0][0] == C2 && Met[0][2] == C2 && Met[0][4] == C2));
        a2 = ((Met[0][2] == C1 && Met[2][2] == C1 && Met[4][2] == C1) || (Met[0][2] == C2 && Met[2][2] == C2 && Met[4][2] == C2));
        a3 = ((Met[4][0] == C1 && Met[4][2] == C1 && Met[4][4] == C1) || (Met[4][0] == C2 && Met[4][2] == C2 && Met[4][4] == C2));
        a4 = ((Met[0][0] == C1 && Met[2][0] == C1 && Met[4][0] == C1) || (Met[0][0] == C2 && Met[2][0] == C2 && Met[4][0] == C2));
        a5 = ((Met[2][0] == C1 && Met[2][2] == C1 && Met[2][4] == C1) || (Met[2][0] == C2 && Met[2][2] == C2 && Met[2][4] == C2));
        a6 = ((Met[0][4] == C1 && Met[2][4] == C1 && Met[4][4] == C1) || (Met[0][4] == C2 && Met[2][4] == C2 && Met[4][4] == C2));
        a7 = ((Met[0][0] == C1 && Met[2][2] == C1 && Met[4][4] == C1) || (Met[0][0] == C2 && Met[2][2] == C2 && Met[4][4] == C2));
        a8 = ((Met[0][4] == C1 && Met[2][2] == C1 && Met[4][0] == C1) || (Met[0][4] == C2 && Met[2][2] == C2 && Met[4][0] == C2));
        if (a1&&(check == false)) {
            c1 = Met[0][0];
            if (c1 == choice1) {
                count1++;
                System.out.println(  this.name1 + " won !!");
                System.out.println( this.name1 + " score is : " + count1);
                System.out.println( this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a2 && (check == false)) {
            c2 = Met[0][2];
            if (c2 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a3 && (check == false)) {
            c3 = Met[4][0];
            if (c3 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a4 && (check == false)) {
            c4 = Met[0][0];
            if (c4 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a5 && (check == false)) {
            c5 = Met[2][0];
            if (c5 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a6 && (check == false)) {
            c6 = Met[0][4];
            if (c6 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a7 && (check == false)) {
            c7 = Met[0][0];
            if (c7 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        }
        if (a8 && (check == false)) {
            c8 = Met[0][4];
            if (c8 == choice1) {
                count1++;
                System.out.println(this.name1 + " won !!");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            } else {
                count2++;
                System.out.println(this.name2 + " Won !! ");
                System.out.println(this.name1 + " score is : " + count1);
                System.out.println(this.name2 + " score is : " + count2);
                check = true;
            }
        } else if ((Met[0][0] == 'X' || Met[0][0] == 'O') && (Met[0][2] == 'X' || Met[0][2] == 'O') && (Met[2][0] == 'X' || Met[2][0] == 'O') && (Met[4][0] == 'X' || Met[4][0] == 'O') && (Met[2][2] == 'X' || Met[2][2] == 'O') && (Met[4][2] == 'X' || Met[4][2] == 'O') && (Met[0][4] == 'X' || Met[0][4] == 'O') && (Met[2][4] == 'X' || Met[2][4] == 'O') && (Met[4][4] == 'X' || Met[4][4] == 'O') && (check == false)) {
            System.out.println("Game tied !! ");
            check = true;
        }
    }
}

class playwithComputer extends Tictac {
    playwithComputer(String name1, String name2) {
        super(name1, name2);
    }

    void yourturn() {
        System.out.println("===================YOUR TURN===================");
        System.out.print("Enter the row: ");
        String checkRow = sc.next();
        while(!(checkRow.equals("1") || checkRow.equals("2") || checkRow.equals("3")))
        {
            System.out.println("Enter valid row ");
            System.out.print("Enter the row: ");
            checkRow = sc.next();
        }
        int row = Integer.parseInt(checkRow);
        System.out.print("Enter the column: ");
        String checkColum = sc.next();
        while(!(checkColum.equals("1") || checkColum.equals("2") || checkColum.equals("3")))
        {
            System.out.println("Enter valid colum ");
            System.out.print("Enter the colum: ");
            checkColum = sc.next();
        }
        int colum = Integer.parseInt(checkColum);
        int a = 0;
        int b = 0;
        switch (row) {
            case 1:
                a = 0;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                a = 4;
                break;
        }
        switch (colum) {
            case 1:
                b = 0;
                break;
            case 2:
                b = 2;
                break;
            case 3:
                b = 4;
                break;
        }
        if (row <= 5 && colum <= 5 && Met[a][b] != 'O' && Met[a][b] != 'X') {
            Met[a][b] = choice1;
        } else {
            System.out.println("Invalid column or row !!");
            yourturn();
        }
        if (!check) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(Met[i][j]);
                }
                System.out.println();
            }
            checkCondition();
        }
        if (!check) {
            System.out.println("===================COMPUTER's TURN===================");
            Computerturn();
        }
    }

    void Computerturn() {
        int row = (int) (Math.random() * 3 + 1);
        int column = (int) (Math.random() * 3 + 1);
        int a = 0;
        int b = 0;
        switch (row) {
            case 1:
                a = 0;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                a = 4;
                break;
        }
        switch (column) {
            case 1:
                b = 0;
                break;
            case 2:
                b = 2;
                break;
            case 3:
                b = 4;
                break;
        }
        if (row <= 5 && column <= 5 && Met[a][b] != 'O' && Met[a][b] != 'X') {
            Met[a][b] = choice2;
        } else {
            Computerturn();
        }
        if (!check) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(Met[i][j]);
                }
                System.out.println();
            }
            checkCondition();
        }
        if (!check) {
            yourturn();
        }
    }
}

class playWithFriend extends Tictac {
    playWithFriend(String name1, String name2) {
        super(name1, name2);
        System.out.println(" player 1 : " + name1 + " \n player2 : " + name2);
    }
    void player1() {
        System.out.println("===================Player1 TURN===================");
        System.out.print("Enter the row: ");
        String checkRow = sc.next();
        while(!(checkRow.equals("1") || checkRow.equals("2") || checkRow.equals("3")))
        {
            System.out.println("Enter valid row ");
            System.out.print("Enter the row: ");
            checkRow = sc.next();
        }
        int row = Integer.parseInt(checkRow);
        System.out.print("Enter the column: ");
        String checkColum = sc.next();
        while(!(checkColum.equals("1") || checkColum.equals("2") || checkColum.equals("3")))
        {
            System.out.println("Enter valid colum ");
            System.out.print("Enter the colum: ");
            checkColum = sc.next();
        }
        int column = Integer.parseInt(checkColum);
        int a = 0;
        int b = 0;
        switch (row) {
            case 1:
                a = 0;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                a = 4;
                break;
        }
        switch (column) {
            case 1:
                b = 0;
                break;
            case 2:
                b = 2;
                break;
            case 3:
                b = 4;
                break;
        }
        if (row <= 5 && column <= 5 && Met[a][b] != 'O' && Met[a][b] != 'X') {
            Met[a][b] = choice1;
        } else {
            System.out.println("Invalid column or row !!");
            player1();
        }
        if (!check) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(Met[i][j]);
                }
                System.out.println();
            }
            checkCondition();
        }
        if (!check) {
            System.out.println("===================Player2 TURN===================");
            player2();
        }
    }

    void player2() {
        System.out.print("Enter the row: ");
        String checkRow = sc.next();
        while(!(checkRow.equals("1") || checkRow.equals("2") || checkRow.equals("3")))
        {
            System.out.println("Enter valid row ");
            System.out.print("Enter the row: ");
            checkRow = sc.next();
        }
        int row = Integer.parseInt(checkRow);
        System.out.print("Enter the column: ");
        String checkColum = sc.next();
        while(!(checkColum.equals("1") || checkColum.equals("2") || checkColum.equals("3")))
        {
            System.out.println("Enter valid colum ");
            System.out.print("Enter the colum: ");
            checkColum = sc.next();
        }
        int column = Integer.parseInt(checkColum);
        int a = 0;
        int b = 0;
        switch (row) {
            case 1:
                a = 0;
                break;
            case 2:
                a = 2;
                break;
            case 3:
                a = 4;
                break;
        }
        switch (column) {
            case 1:
                b = 0;
                break;
            case 2:
                b = 2;
                break;
            case 3:
                b = 4;
                break;
        }
        if (row <= 5 && column <= 5 && Met[a][b] != 'O' && Met[a][b] != 'X') {
            Met[a][b] = choice2;
        } else {
            System.out.println("Invalid column or row !!");
            player2();
        }
        if (!check) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(Met[i][j]);
                }
                System.out.println();
            }
            checkCondition();
        }
        if (!check) {
            player1();
        }
    }
}