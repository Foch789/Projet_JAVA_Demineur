import java.awt.*;

public class Formes
{
  private Forme [] forme;
  private int total;
  private int totalMine;
  private int [] sauveMine;
  private boolean debut;


  public Formes(int _nombre,int _mine)
  {
    total = _nombre;
    totalMine = _mine;
    debut = false;
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

  public boolean getDebut(){return debut;}

  public void setDebut(boolean l,int zoneL,int zoneH,int i)
  {
    debut = l;
    CreateMine(i);
    placePoint(zoneL,zoneH);
  }

  public int getIdeForme(int _x,int _y,int _zoneHauteur)
  {
    int largeur = forme[0].getLargeur();
    int hauteur = forme[0].getHauteur();
    int nbrY = _zoneHauteur/hauteur;

    int caseX = _x/largeur;
    int caseY = _y/hauteur;

    int resultat = caseY*nbrY+caseX;

    return resultat;
  }

  public Forme getForme(int i) {return forme[i];}

  public Forme getForme(int _x,int _y,int _zoneHauteur)
  {
    int largeur = forme[0].getLargeur();
    int hauteur = forme[0].getHauteur();
    int nbrY = _zoneHauteur/hauteur;

    int caseX = _x/largeur;
    int caseY = _y/hauteur;

    return forme[caseY*nbrY+caseX];
  }

  public void CreateMine(int c)
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
        else if(nombreHasard == c)
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

  public void cocher(int _x,int _y,int zoneH, int zoneL)
  {
    int largeur = forme[0].getLargeur();
    int hauteur = forme[0].getHauteur();
    int id = getIdeForme(_x,_y,zoneH);
    getForme(id).setCocher(true);
    boolean arrete =false;
    int test = id;
    int nbrX = zoneL/largeur;
    int nbrY = zoneH/hauteur;

    if(forme[id].getNombre() == 0)
    {
      if(id < total-1 && forme[id].getX() < zoneL-largeur)
      {
        while(!arrete)
        {

          test++;

          if(forme[test].getX() < zoneL-largeur)
          {

            forme[test].setCocher(true);
            if(forme[test].getNombre() > 0)
            {
              arrete = true;
            }

          }
          else
          {

              forme[test].setCocher(true);

              arrete = true;
          }

        }

      }
      //Gauche
      test=id;
      arrete=false;

      if(id > 0 && forme[id].getX() > 0)
      {

        while(!arrete)
        {

          test--;

          if(forme[test].getX() > 0)
          {

            forme[test].setCocher(true);
            if(forme[test].getNombre() > 0)
            {
              arrete = true;
            }

          }
          else
          {

              forme[test].setCocher(true);
              arrete = true;
          }

        }

      }

      //Haut
      test=id;
      arrete=false;

      if((id-nbrX) >= 0 && forme[id].getY() > 0)
      {

        while(!arrete)
        {
          test-=nbrX;

          if(forme[test].getY() > 0)
          {

            forme[test].setCocher(true);
            if(forme[test].getNombre() > 0)
            {
              arrete = true;
            }

          }
          else
          {

              forme[test].setCocher(true);
              arrete = true;
          }

        }

      }

      //Bas
      test=id;
      arrete=false;

      if((id+nbrX) <= total-1  && forme[id].getY() < zoneH-hauteur)
      {

        while(!arrete)
        {
          test+=nbrX;

          if(forme[test].getY() < zoneH-hauteur)
          {

            forme[test].setCocher(true);
            if(forme[test].getNombre() > 0)
            {
              arrete = true;
            }

          }
          else
          {

              forme[test].setCocher(true);
              arrete = true;
          }

        }

      }





    }

  }

  public void cocherHautBas(int index,int zoneH, int zoneL,int largeur, int hauteur)
  {

  }

}
