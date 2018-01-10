import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class ZoneJeux extends JPanel implements MouseListener, Serializable
{
  Formes tab;
  int zoneHauteur;
  int zoneLargeur;
  static final long serialVersionUID = 42L;

  public ZoneJeux(int _zoneHauteur,int _zoneLargeur,int _hauteur,int _largeur,int _mine)
  {
    setPreferredSize(new Dimension(_zoneHauteur,_zoneLargeur));

    zoneHauteur = _zoneHauteur;
    zoneLargeur = _zoneLargeur;

    int total = (zoneHauteur/_hauteur)*(zoneLargeur/_largeur);

    tab = new Formes(total,_mine);
    tab.setForme(zoneHauteur,zoneLargeur,_hauteur,_largeur);

    addMouseListener(this);

  }

  public void paint(Graphics g)
  {
    super.paint(g);
    affiche_fond(g);
    //affiche_graduations(g);
    //affiche_aiguilles(g);
  }

  public void affiche_fond(Graphics g)
  {
    int x = 0,y = 0;
    String nombre;


    for (int i = 0;i < tab.getTotal() ; ++i )
    {
      g.setColor (Color.black);
      g.drawRect(tab.getForme(i).getX(),tab.getForme(i).getY(),tab.getForme(i).getLargeur(),tab.getForme(i).getHauteur());

      nombre = Integer.toString(tab.getForme(i).getNombre());

      if(tab.getForme(i).getMine() == true)
      {
        g.drawString("X",x*tab.getForme(i).getLargeur()+(tab.getForme(i).getLargeur()/2)-5,y*(tab.getForme(i).getHauteur())+25);
      }
      else
      {
        if(tab.getForme(i).getNombre() != 0)
        {
          nombre = Integer.toString(tab.getForme(i).getNombre());
          if(x == 0)
          {
            g.drawString(nombre,(tab.getForme(i).getLargeur()/2)-5,y*tab.getForme(i).getHauteur()+25);
          }
          else
          {
            g.drawString(nombre,x*tab.getForme(i).getLargeur()+(tab.getForme(i).getLargeur()/2)-5,y*(tab.getForme(i).getHauteur())+25);
          }
        }
      }


      x++;
      if(x >= zoneLargeur/tab.getForme(i).getLargeur())
      {
        x=0;
        y++;
      }

      if(!tab.getForme(i).getCocher())
      {
        g.setColor (Color.orange);
        g.fillRect(tab.getForme(i).getX()+3,tab.getForme(i).getY()+3,tab.getForme(i).getLargeur()-6,tab.getForme(i).getHauteur()-6);
      }

    }

  }

  public void mouseClicked(MouseEvent event)
  {
    tab.getForme(event.getX(),event.getY(),zoneHauteur).affichage();

    if(!tab.getDebut())
    {
      tab.setDebut(true,zoneLargeur,zoneHauteur,tab.getIdeForme(event.getX(),event.getY(),zoneHauteur));
      repaint();
    }

    if(!tab.getForme(event.getX(),event.getY(),zoneHauteur).getCocher())
    {
      int l=tab.getIdeForme(event.getX(),event.getY(),zoneHauteur);

      if(tab.getForme(l).getMine() == true)
      {
        tab.getForme(l).setCocher(true);
        System.out.println("TA PERDU");
      }
      else
      {
        tab.cocher(l,zoneHauteur,zoneLargeur);
      }

      repaint();
    }


  }

  public void mouseEntered(MouseEvent event)
  {

  }

  public void mouseExited(MouseEvent event)
  {

  }

  public void mousePressed(MouseEvent event)
  {

    //System.out.println("X ="+ event.getX() + " et Y = " + event.getY());

  }

  public void mouseReleased(MouseEvent event)
  {

  //  System.out.println("X ="+ event.getX() + " et Y = " + event.getY());

  }

}
