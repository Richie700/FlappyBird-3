package com.example.user.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by User on 1/9/2016.
 * Background game environment which the flappy bird will occupy
 * Flappy bird will be instantiated by Main Activity
 */
public class GameEnvironment {
    //Add a reference to a drawing board
    private Canvas _canvas; //Should be 1 game screen wide
    private Bitmap _bufferedBitmap; //Should be 2 game screens wide
    private PipeList _pipes;
    private int _offsetOfBufferedBitmap;

    public GameEnvironment(Bitmap aBackGround, int aPipeWidth, int aNumOfPipes) {
        _bufferedBitmap = aBackGround;
        _pipes = new PipeList(aPipeWidth, aNumOfPipes, this);
        _offsetOfBufferedBitmap = 0;
    }

    private void GenerateCanvas() {
        //If have shifted 1 screen width, then time to shift right screen to left and generate
        //new right screen
        if (_offsetOfBufferedBitmap == GetWidth()) {
            //Time to generate new _bufferedBitmap

            _offsetOfBufferedBitmap = 0;
        }

        Bitmap croppedBitmap = Bitmap.createBitmap(_bufferedBitmap, _offsetOfBufferedBitmap, 0, _bufferedBitmap.getWidth() / 2,
                _bufferedBitmap.getHeight()); //Canvas should be half the width of buffered bitmap
        _canvas = new Canvas(croppedBitmap);
        ++_offsetOfBufferedBitmap;
    }

    public int GetWidth() {
        return _bufferedBitmap.getWidth() / 2;
    }

    public int GetHeight() {
        return _bufferedBitmap.getHeight();
    }

    public Canvas GetCanvas() {
        return _canvas;
    }

    public void Draw() {
        //Generate current canvas
        GenerateCanvas();

        //Draws pipes
        _pipes.Draw();
    }

    //Move left 1 step
    public void MoveLeft() {
        //Scroll the drawing board 1 step to the left with wrap around

        //Move the x-coord of flappy bird 1 step to right
    }
}
