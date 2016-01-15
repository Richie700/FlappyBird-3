package com.example.user.flappybird;

import android.graphics.Bitmap;

/**
 * Created by User on 1/14/2016.
 */
public class PipeFactory {
    private Bitmap _pipeSprite;
    private GameEnvironment _gameEnv;

    public PipeFactory(Bitmap aPipeSprite, GameEnvironment aGameEnv) {
        _pipeSprite = aPipeSprite;
        _gameEnv = aGameEnv;
    }

    private Bitmap GetCopyOfSprite() {
        //Change this to return clone
        return _pipeSprite.copy(_pipeSprite.getConfig(), true);
    }

    public GraphicComponent MakePipe(int aXPos, int aHeight, int aWidth, Boolean aIsInverted) {
        GraphicComponent pipe;
        Bitmap pipeImg = GetCopyOfSprite();

        //Modify pipeImg so that it has height aHeight and width aWidth

        if (aIsInverted) {
            //Rotate pipeImg

            pipe = new GraphicComponent(_gameEnv.GetCanvas(), pipeImg, aXPos, aHeight);
        } else {
            pipe = new GraphicComponent(_gameEnv.GetCanvas(), pipeImg, aXPos, _gameEnv.GetHeight() - aHeight);
        }

        return pipe;
    }
}
