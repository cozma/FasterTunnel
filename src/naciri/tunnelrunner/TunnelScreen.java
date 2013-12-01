package naciri.tunnelrunner;

import sofia.graphics.Shape;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

// -------------------------------------------------------------------------
/**
 *
 * @author dag
 * @version Apr 9, 2013
 */
public class TunnelScreen
    extends ShapeScreen
{

    private int[][] tunnel = new int[1][1];

    /**
     * initialize
     */
    public void initialize()
    {
        float minDim = Math.min(getShapeView().getWidth(), getShapeView().getHeight());
        float squareHeight = minDim / tunnel.length;
        float squareWidth = minDim / tunnel.length;
        for (int i = 0; i < tunnel.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                RectangleShape rect =
                    new RectangleShape(
                        i * squareHeight,
                        j * squareWidth,
                        (i + 1) * squareHeight,
                        (j + 1) * squareWidth);
                // If cell is a wall
//                if (tunnel.getTunnel()[i][j].getCellType() == CellType.WALL)
//                {
//                    rect.setFillColor(Color.black);
//                    rect.setFilled(true);
//                }
//                else if (tunnel.getTunnel()[i][j].getCellType() == CellType.SPACE)
//                {
//                    rect.setFillColor(Color.white);
//                    rect.setFilled(true);
//                }
                add(rect);
            }
        }
    }
}
