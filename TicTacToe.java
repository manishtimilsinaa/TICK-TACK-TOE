import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.*;

public class TicTacToe  implements ActionListener {

    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;


    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
frame.setTitle("tick tack toe");
        frame.setVisible(true);

textfield.setBackground(new Color(25,25,25));
textfield.setForeground(new Color(25,255,0));
textfield.setFont(new Font("Ink Free",Font.BOLD,75));
textfield.setText("tick tack toe");
textfield.setHorizontalAlignment(JLabel.CENTER);
textfield.setOpaque(true);

title_panel.setLayout(new BorderLayout());
title_panel.setBounds(0,0,800,100);

button_panel.setLayout(new GridLayout(3,3));
button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i <9 ; i++) {
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

title_panel.add(textfield);
frame.add(title_panel,BorderLayout.NORTH);
frame.add(button_panel);

firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
           if(e.getSource()==buttons[i]){
               if(player1_turn){
                   if (buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(255,0,0));
                       buttons[i].setText("X");
                       player1_turn=false;
                       textfield.setText("O turn");
check();
                   }
               }
               else {
                   if (buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(0,0,255));
                       buttons[i].setText("O");
                       player1_turn=true;
                       textfield.setText("X turn");
check();
                   }
               }
           }
        }
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2)==0) {
    player1_turn = true;
    textfield.setText("X turn");
}
else {
    player1_turn = false;
    textfield.setText("O turn");
}
    }
    public void check(){
        boolean draw = true;



        //for x
        if ((buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) ||
                (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) ||
                (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) ||
                (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) ||
                (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) ||
                (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) ||
                (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) ||
                (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))) {
            xWins();
        }
        // Winning combinations for O
        else if ((buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) ||
                (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) ||
                (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) ||
                (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) ||
                (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))) {
            oWins();

        }
    }
    public void xWins(){

        for (int i = 0; i <9; i++) {
            buttons[i].setEnabled(false);

        }
        textfield.setText("X wins");

    }
    public void oWins(){

        for (int i = 0; i <9; i++) {
            buttons[i].setEnabled(false);

        }
        textfield.setText("O wins");
    }



}
