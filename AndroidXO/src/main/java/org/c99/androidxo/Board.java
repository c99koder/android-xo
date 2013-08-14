package org.c99.androidxo;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by sam on 8/14/13.
 */
public class Board {
    public ImageButton board[][] = new ImageButton[3][3];
    public Drawable X;
    public Drawable O;

    public Board(View v) {
        board[0][0] = (ImageButton)v.findViewById(R.id.b0_0);
        board[0][1] = (ImageButton)v.findViewById(R.id.b0_1);
        board[0][2] = (ImageButton)v.findViewById(R.id.b0_2);

        board[1][0] = (ImageButton)v.findViewById(R.id.b1_0);
        board[1][1] = (ImageButton)v.findViewById(R.id.b1_1);
        board[1][2] = (ImageButton)v.findViewById(R.id.b1_2);

        board[2][0] = (ImageButton)v.findViewById(R.id.b2_0);
        board[2][1] = (ImageButton)v.findViewById(R.id.b2_1);
        board[2][2] = (ImageButton)v.findViewById(R.id.b2_2);

        X = v.getResources().getDrawable(R.drawable.x);
        O = v.getResources().getDrawable(R.drawable.o);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                board[x][y].setOnClickListener(listener);
            }
        }
    }

    private int checkRow(int row) {
        if(board[row][0].getBackground().equals(board[row][1].getBackground()) && board[row][0].getBackground().equals(board[row][2].getBackground())) {
            if(board[row][0].getBackground().equals(X))
                return R.drawable.x;
            else if(board[row][0].getBackground().equals(O))
                return R.drawable.o;
            else
                return -1;
        }
        return -1;
    }

    private int checkCol(int col) {
        if(board[0][col].getBackground().equals(board[1][col].getBackground()) && board[0][col].getBackground().equals(board[2][col].getBackground())) {
            if(board[0][col].getBackground().equals(X))
                return R.drawable.x;
            else if(board[0][col].getBackground().equals(O))
                return R.drawable.o;
            else
                return -1;
        }
        return -1;
    }

    public int checkWinner() {
        int winner = -1;

        for(int row = 0; row < 3; row++) {
            winner = checkRow(row);
            if(winner != -1)
                return winner;
        }

        for(int col = 0; col < 3; col++) {
            winner = checkCol(col);
            if(winner != -1)
                return winner;
        }

        if((board[1][1].getBackground().equals(board[0][0].getBackground()) && board[1][1].getBackground().equals(board[2][2].getBackground())) ||
                (board[1][1].getBackground().equals(board[0][2].getBackground()) && board[1][1].getBackground().equals(board[2][0].getBackground()))) {
            if(board[1][1].getBackground().equals(X))
                return R.drawable.x;
            else if(board[1][1].getBackground().equals(O))
                return R.drawable.o;
            else
                return -1;
        }

        return -1;
    }

    public boolean checkDraw() {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(board[x][y].getBackground().getClass().equals(ColorDrawable.class))
                    return false;
            }
        }
        return true;
    }
}
