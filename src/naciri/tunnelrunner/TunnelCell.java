package naciri.tunnelrunner;

public class TunnelCell
{
    private CellType type;


    public TunnelCell(CellType t)
    {
        type = t;
    }
    public CellType getCellType() {
        return type;
    }
    public void setCellType(CellType t) {
        type = t;
    }
}
