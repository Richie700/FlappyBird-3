package com.example.user.flappybird;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by User on 1/14/2016.
 */
public class PipeFactory {
    private Bitmap _pipeSprite; //Must be wide and tall enough such that can scaled to any
    //height and width
    private GameEnvironment _gameEnv;

    public PipeFactory(Bitmap aPipeSprite, GameEnvironment aGameEnv) {
        _pipeSprite = aPipeSprite;
        _gameEnv = aGameEnv;
    }

    private Bitmap CreateSprite(int aHeight, int aWidth, Boolean aRotate) {
        //Change this to return clone
        Bitmap newBitMap = Bitmap.createScaledBitmap(_pipeSprite, aWidth, aHeight, true);

        if (aRotate) {
            Matrix matrix = new Matrix();
            matrix.postRotate(180);
            newBitMap = Bitmap.createBitmap(newBitMap, 0, 0, newBitMap.getWidth(), newBitMap.getHeight(), matrix, true);
        }

        return newBitMap;
    }

    public GraphicComponent MakePipe(int aXPos, int aHeight, int aWidth, Boolean aIsInverted) {
        GraphicComponent pipe;

        if (aIsInverted) {
            //Rotate pipeImg
            pipe = new GraphicComponent(_gameEnv.GetCanvas(), CreateSprite(aHeight, aWidth, true), aXPos, 0);
        } else {
            pipe = new GraphicComponent(_gameEnv.GetCanvas(), CreateSprite(aHeight, aWidth, false), aXPos, _gameEnv.GetHeight() - aHeight);
        }

        return pipe;
    }
}
