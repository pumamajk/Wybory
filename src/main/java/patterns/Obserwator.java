package patterns;

import java.util.*;
 
 
interface Obserwowany {
public void dodajObserwatora(Obserwator o);
public void usunObserwatora(Obserwator o);
public void powiadamiajObserwatorow();
}
 
 
interface Obserwator {
 
/* aktualizuje dane */
public void update(int[]wyniki);
}
 
 
interface Media {
 
/* publikuje wyniki losowania */
public void informuj();
}
 
/* oberwowany obiekt */
class TotoLotek implements Obserwowany {
private ArrayList<Obserwator> obserwatorzy;
private int[]wyniki;
 
public TotoLotek(){
obserwatorzy = new ArrayList<Obserwator>();
wyniki = new int[]{0,0,0,0,0,0};
}
 
public void dodajObserwatora(Obserwator o){
obserwatorzy.add(o);
}
 
public void usunObserwatora(Obserwator o){
int index = obserwatorzy.indexOf(o);
obserwatorzy.remove(index);
}
 
public void powiadamiajObserwatorow(){
for(Obserwator o : obserwatorzy){
o.update(wyniki);
}
}
 
public void kolejneLosowanie(){
int i = 0;
while(i<6){
boolean powtorka = false;
double x = (Math.random()*47-1);
for(int j = 0 ; j < 6; j++){
if(wyniki[j]==(int)x){
powtorka = true;
}
}
if(powtorka==false){
wyniki[i++]=(int)x;
}
}//while
powiadamiajObserwatorow();
}
 
public int[] getResults(){
return wyniki;
}
}//class
 
 
/* obserwator */
class Telewizja implements Obserwator, Media {
private int[] wyniki;
private TotoLotek lotek;
 
public Telewizja(TotoLotek lotek){
wyniki = new int[6];
this.lotek = lotek;
}
 
public void update(int[]tab){
for(int i=0;i<6;i++){
wyniki[i]=tab[i];
}
}
 
public void informuj(){
System.out.println("Dzisiejsze losowanie Totolotka by TVP");
for(int i:wyniki)
System.out.print(i + " ");
System.out.println();
}
 
public void spadam(){
lotek.usunObserwatora(this);
}
}
 
class Internet implements Obserwator, Media {
private int[] wyniki;
private TotoLotek lotek;
 
public Internet(TotoLotek lotek){
wyniki = new int[6];
this.lotek = lotek;
}
 
public void update(int[] tab){
for(int i=0;i<6;i++){
wyniki[i]=tab[i];  
}
}
 
public void informuj(){
System.out.println("Wyniki TotoLotka na stronie internetowej");
for(int i:wyniki)
System.out.print(i + " ");
System.out.println();
}
 
public void spadam(){
lotek.usunObserwatora(this);
}
}
 
 
