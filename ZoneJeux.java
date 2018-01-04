import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ZoneJeux extends JPanel
{
  Formes tab;
  int zoneHauteur;
  int zoneLargeur;

  public ZoneJeux(int _zoneHauteur,int _zoneLargeur,int _hauteur,int _largeur,int _mine)
  {
    setPreferredSize(new Dimension(_zoneHauteur,_zoneLargeur));

    zoneHauteur = _zoneHauteur;
    zoneLargeur = _zoneLargeur;

    int total = (zoneHauteur/_hauteur)*(zoneLargeur/_largeur);

    tab = new Formes(total,_mine);
    tab.setForme(zoneHauteur,zoneLargeur,_hauteur,_largeur);
    tab.CreateMine();
    tab.placePoint(zoneLargeur,zoneHauteur);

  }

  public void paint(Graphics g)
  {
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

    }

  }

}
