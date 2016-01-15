package com.example.user.flappybird;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by User on 1/9/2016.
 */
public class GraphicComponent {
    //Add reference to a drawing board
    protected int _xPos;
    protected int _yPos;
    protected Bitmap _bitmap;
    private Canvas _canvas;

    //Constructor should take in drawing board
    protected GraphicComponent(Canvas aCanvas, Bitmap aBitmap, int aXPos, int aYPos) {
        _bitmap = aBitmap;
        _xPos = aXPos;
        _yPos = aYPos;
        _canvas = aCanvas;
    }

    public int GetXPos() {
        return _xPos;
    }

    public int GetYPos() {
        return _yPos;
    }

    public int GetWidth() {
        return _bitmap.getWidth();
    }

    public int GetHeight() {
        return _bitmap.getHeight();
    }

    public void SetCoord(int aXPos, int aYPos) {
        _xPos = aXPos;
        _yPos = aYPos;
    }

    public void Draw() {
        //Draw _bitmap at (_xPos, _yPos) onto the _canvas
        _canvas.drawBitmap(_bitmap, GetXPos(), GetXPos(), null);
    }

    //Check if will hit with other Graphic object
    public Boolean WillHit(GraphicComponent aGraphic) {
        return ((GetXPos() >= aGraphic.GetXPos()
                && GetXPos() <= aGraphic.GetXPos() + aGraphic.GetWidth())
                || (aGraphic.GetXPos() >= GetXPos()
                && aGraphic.GetXPos() <= GetXPos() + GetWidth()))
                && ((GetYPos() >= aGraphic.GetYPos()
                && GetYPos() <= aGraphic.GetYPos() + aGraphic.GetHeight())
                || (aGraphic.GetYPos() >= GetYPos()
                && aGraphic.GetYPos() <= GetYPos() + GetHeight()));
    }
}
