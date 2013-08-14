package org.c99.androidxo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    int winner = -1;
    int player = R.drawable.x;
    Board board;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView)findViewById(R.id.message);
        message.setText("X's turn");
        board = new Board(findViewById(android.R.id.content));
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(winner == -1 && v.getBackground().getClass().equals(ColorDrawable.class)) {
                    if(player == R.drawable.x) {
                        v.setBackground(board.X);
                        player = R.drawable.o;
                    } else {
                        v.setBackground(board.O);
                        player = R.drawable.x;
                    }

                    winner = board.checkWinner();
                    if(winner == R.drawable.x)
                        message.setText("X wins!");
                    else if(winner == R.drawable.o)
                        message.setText("O wins!");
                    else if(board.checkDraw())
                        message.setText("It's a draw!");
                    else if(player == R.drawable.x)
                        message.setText("X's turn");
                    else
                        message.setText("O's turn");
                }
            }
        });
    }
}
