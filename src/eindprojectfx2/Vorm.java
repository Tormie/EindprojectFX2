/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindprojectfx2;

/**
 *
 * @author Vermeulen
 */
public class Vorm {
    public int x = (int) (400 * Math.random() + 25);
    public int y = (int) (400 * Math.random() + 25);
    public int dx = 3, dy = 2;
    public boolean visible;
    
    public Vorm(){//bij aanmaak op onzichtbaar zetten
        this.visible = false;
    }
    public boolean getVisible(){//zichtbaarheid opvragen
        return visible;
    }

    public void setVisible(boolean visible){//zichtbaarheid wijzigen
        this.visible = visible;
    }
    
    public void move(){//verplaatsen van de vorm (begrensd door de uitersten van het canvas)
        if (x +dx <= 1 || x + dx + 25 >= 1050 )
            dx = -dx;
        if ( y + dy <= 1 || y + dy + 25 >= 675)
            dy = -dy;

        x += dx; y += dy;
    }
}
