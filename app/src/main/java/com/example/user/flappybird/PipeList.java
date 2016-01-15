package com.example.user.flappybird;

import java.util.Random;
import java.util.Vector;

/**
 * Created by User on 1/10/2016.
 */
public class PipeList {
    //Add reference to drawing board

    private Vector<GraphicComponent> _pipes;
    private GameEnvironment _gameEnv;
    private int _pipeWidth;
    private PipeFactory _pipeFactory;

    //Constructor should take in drawing board
    public PipeList(int aPipeWidth, int aNumOfPipes, GameEnvironment aGameEnv) {
        _pipeWidth = aPipeWidth;
        _pipes = new Vector<GraphicComponent>();
        _gameEnv = aGameEnv;
        //_pipeFactory = new PipeFactory() //Need instantiate PipeFactory object

        for (int i = 0; i < aNumOfPipes; ++i) {
            GenerateSinglePipe();
        }
    }

    public int NumOfPipes() {
        return _pipes.size();
    }

    public void Clear() {
        _pipes.clear();
    }

    public Boolean GenerateSinglePipe() {
        Random rand = new Random();
        int startOfAvailableZone = _pipes.lastElement().GetXPos() + _pipeWidth;
        Boolean result = _gameEnv.GetWidth() - startOfAvailableZone >= _pipeWidth;

        if (result) {
            //Determine if this is an inverted pipe
            Boolean isInverted = rand.nextBoolean();
            int pipeXPos = rand.nextInt(_gameEnv.GetWidth() - startOfAvailableZone) + startOfAvailableZone;
            int pipeHeight = rand.nextInt(_gameEnv.GetHeight());

            //Create pipe with height pipeHeight and at pipeXPos and with inverted-ness isInverted
            GraphicComponent newPipe = _pipeFactory.MakePipe(pipeXPos, pipeHeight, _pipeWidth, isInverted);

            //Add the created pipe into _pipes
            _pipes.add(newPipe);
        }

        return result;
    }

    public Boolean WillHit(GraphicComponent aComponent) {
        Boolean result = false;

        for (GraphicComponent pipe :
                _pipes) {
            if (pipe.WillHit(aComponent)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public void Draw() {
        for (GraphicComponent pipe :
                _pipes) {
            pipe.Draw();
        }
    }
}
