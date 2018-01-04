import java.awt.*;

public class Formes
{
  private Forme [] forme;
  private int total;
  private int totalMine;
  private int [] sauveMine;


  public Formes(int _nombre,int _mine)
  {
    total = _nombre;
    totalMine = _mine;
    forme = new Forme[_nombre];
    for(int i = 0; i< _nombre;i++)
    {
      forme[i] = new Forme(0,0,0,0,0);
    }
  }

  public void setForme(int zoneHauteur,int zoneLargeur,int _hauteur,int _largeur)
  {

        int x=0,y=0;
        int nbrenX = zoneLargeur/_largeur;
        int nbrenY = zoneHauteur/_hauteur;

        for (int i=0;i<nbrenX*nbrenY ;++i )
        {
            forme[i] = new Forme(0,x*_largeur,y*_hauteur,_hauteur,_largeur);

            x++;
            if(x >= nbrenX)
            {
              x=0;
              y++;
            }

        }


  }

  public int getTotal() {return total;}

  public Forme getForme(int i) {return forme[i];}

  public void CreateMine()
  {
    int nombreHasard;
    sauveMine = new int [totalMine];
    for(int i =0;i<totalMine;++i)
    {
      sauveMine[i]=total+1;
    }
    int bon =0;
    boolean erreur = false;

    while(bon < totalMine)
    {
      nombreHasard = (int)((total-1)*Math.random());

      for(int i = 0; i< totalMine;++i)
      {
        if(nombreHasard == sauveMine[i])
        {
          erreur = true;
        }
      }
      if(erreur == false)
      {
        sauveMine[bon] = nombreHasard;
        bon++;
        forme[nombreHasard].setMine(true);
        System.out.println(nombreHasard);
      }
      erreur = false;

    }

  }

  public void placePoint(int _zoneLargeur, int _zoneHauteur)
  {
    for(int i = 0; i < totalMine;++i)
    {
      if(forme[sauveMine[i]].getX() == 0)//X
      {
        forme[sauveMine[i]+1].setNombre(forme[sauveMine[i]+1].getNombre()+1);
      }
      else if(forme[sauveMine[i]].getX() >= (_zoneLargeur - forme[sauveMine[i]].getLargeur()))
      {
        forme[sauveMine[i]-1].setNombre(forme[sauveMine[i]-1].getNombre()+1);
      }
      else
      {
        forme[sauveMine[i]+1].setNombre(forme[sauveMine[i]+1].getNombre()+1);
        forme[sauveMine[i]-1].setNombre(forme[sauveMine[i]-1].getNombre()+1);
      }

      if(forme[sauveMine[i]].getY() == 0)//Y
      {
        forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())].getNombre()+1);
        if(forme[sauveMine[i]].getX() == 0)
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
        }
        else if (forme[sauveMine[i]].getX() >= (_zoneLargeur - forme[sauveMine[i]].getLargeur()))
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }
        else
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }
      }
      else if(forme[sauveMine[i]].getY() >= (_zoneHauteur - forme[sauveMine[i]].getHauteur()))
      {
        forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())].getNombre()+1);
        if(forme[sauveMine[i]].getX() == 0)
        {
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
        }
        else if (forme[sauveMine[i]].getX() >= (_zoneLargeur - forme[sauveMine[i]].getLargeur()))
        {
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }
        else
        {
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }

      }
      else
      {
        forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())].getNombre()+1);
        forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())].getNombre()+1);
        if(forme[sauveMine[i]].getX() == 0)
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
        }
        else if (forme[sauveMine[i]].getX() >= (_zoneLargeur - forme[sauveMine[i]].getLargeur()))
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }
        else
        {
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
          forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]+(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())+1].getNombre()+1);
          forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].setNombre(forme[sauveMine[i]-(_zoneLargeur/forme[i].getLargeur())-1].getNombre()+1);
        }
      }

    }

  }

}
