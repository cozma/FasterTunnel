package naciri.tunnelrunner;

import java.util.Random;

public class Tunnel
{
    private int            rows;
    private int            columns;
    private TunnelCell[][] tunnel;
    private int            tunnelWidth;


    public Tunnel(int w, int h)
    {
        rows = w;
        columns = h;
        tunnel = new TunnelCell[w][h];
        tunnelWidth = 3 * columns / 4;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                tunnel[i][j]= new TunnelCell(CellType.SPACE);
            }
        }
        tunnel[0][0]= new TunnelCell(CellType.WALL);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public int getRows() {
        return rows;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public int getColumns() {
        return columns;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void move()
    {
        for(int i=rows-1;i>0;i--) {
            for(int j=0;j<columns;j++) {
                tunnel[i][j] = tunnel[i-1][j];
            }
        }
        tunnel[0] = newRow();
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void shrink()
    {
        tunnelWidth--;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public TunnelCell[] newRow()
    {
        TunnelCell[] newRow = new TunnelCell[columns];
        TunnelCell[] lastCreatedRow = tunnel[0];
        // left and right indicies of walls
        int leftIndex = getLeftWallIndex(lastCreatedRow);
        int rightIndex = getRightWallIndex(lastCreatedRow);
        Random rgen = new Random();
        int shift;
        if (leftIndex == 0 && rightIndex == columns - 1)
        {
            shift = 0;
        }
        else if (leftIndex == 0)
        {
            shift = rgen.nextInt(2);
        }
        else if (rightIndex == columns - 1)
        {
            shift = rgen.nextInt(2) * -1;
        }
        else
        {
            shift = rgen.nextInt(3) - 1;
        }
        leftIndex = leftIndex + shift;
        rightIndex = rightIndex + shift;
        for (int i = 0; i < columns; i++)
        {
            if (i > leftIndex && i< rightIndex)
            {
                newRow[i] = new TunnelCell(CellType.SPACE);
            }
            else
            {
                newRow[i] = new TunnelCell(CellType.WALL);
            }
        }
        return newRow;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param row
     * @return
     */
    public int getLeftWallIndex(TunnelCell[] row)
    {
        for (int i = 0; i < row.length; i++)
        {
            if (row[i].getCellType() == CellType.SPACE)
            {
                return i - 1;
            }
        }
        return (Integer)null;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param row
     * @return
     */
    public int getRightWallIndex(TunnelCell[] row)
    {
        for (int i = row.length - 1; i > -1; i--)
        {
            if (row[i].getCellType() == CellType.SPACE)
            {
                return i + 1;
            }
        }
        return (Integer)null;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param rowNumber
     * @return
     */
    public TunnelCell[] getRow(int rowNumber)
    {
        TunnelCell[] row = new TunnelCell[columns];
        for (int i = 0; i < columns; i++)
        {
            row[i] = tunnel[rowNumber][i];
        }
        return row;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public TunnelCell[][] getTunnel()
    {
        return tunnel;
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public String firstRowToString() {
        StringBuffer buffer = new StringBuffer("[");
        for(int i=0;i<columns;i++) {
            if(tunnel[0][i].getCellType()==CellType.WALL) {
                buffer.append("X");
            }
            else {
                buffer.append("O");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }
}
