public class Klasa {
    private static final double vMax=25; //prędkość m/s
    private static final double kt=0.51; //węzły

    public static void leosia(){
        //(a) Koncert Young Leosi
        //Mag wyleciał ze swojej siedziby o godzinie 17:00. Planuje dotrzeć na koncert Young Leosi w miejscu
        //oddalonym od niego o 300km na zachód. Wiatr wieje ze wschodu z prędkością 10kt, czy Mag zdąży
        //na koncert, który zaczyna się o godzinie 20:30?

        double start = 61200; //start w sekundach
        double koniec = 73800; //koniec w sekundach
        double oporPowietrza = 10 * kt;
        double s = 300000; //odleglosc w metrach
        double v = vMax - oporPowietrza;
        double t = koniec-start;

        if(v*t<s){
            System.out.println("uda sie");
        }
        else{
            System.out.println("nie uda sie");
        }
    }
    public static void stegna(){
        //Nasz Mag wyleciał o godzinie 11:20 ze Stegny. Obrał azymut w kierunku Wrocławia oddalonego o
        //500km (przyjmijmy, że Wrocław leży wprost na południe od Stegny). Przez pierwsze 2h30min wiatr
        //wiał z prędkością 2kt z południa, następnie zmienił on kierunek na wiatr wschodni z prędkością
        //3kt. O której godzinie Mag przyleci do Wrocławia?

        double start = 40800; //start w sekundach
        double s = 500 * 1000; //odleglosc w metrach
        double oporPowietrza = 2 * kt;
        double czasMniejszaPredkosc = 9000;
        double czasKoncowy = 0;
        double v = vMax - oporPowietrza;
        double przejechane = 0;
        double ileZostalo = 0;
        double godzinyKoncowe = 0;
        double minutyKoncowe = 0;

        //pierwsza czesc
        przejechane=v*czasMniejszaPredkosc; //przejechane z mniejszą prędkością

        //druga czesc
        v = vMax; //prędkość bez wiatru zwalniającego
        ileZostalo=s-przejechane; //odległość jaka została do przejechania
        ileZostalo=ileZostalo/v; //czas drugiej części

        czasKoncowy=czasMniejszaPredkosc+ileZostalo+start; //oblicza czas końcowy w sekundach  (ileZostalo/v to jest czas w jakim pokona pozostałą trasę

        minutyKoncowe=(czasKoncowy/60)%60;
        godzinyKoncowe=((czasKoncowy/60)-minutyKoncowe)/60;

        //System.out.println(godzinyKoncowe);
        System.out.println("Godzina o ktorej Mag przyleci do Wroclawia: "+(int)godzinyKoncowe+":"+(int)minutyKoncowe); // intuje aby wyszły zaokrąglone liczby bez przecinka (wiem że przy innych danych trzeba by było inaczej i powinno się printf)
    }
    public static void szczyt(){
        //Z Wrocławia o godzinie 10:15 wyleciał Mag do oddalanego o 270km na wschód Krakowa, 15 minut
        //później z Krakowa wyleciał w przeciwnym kierunku drugi Mag. Obaj Magowie poruszają się z
        //maksymalną prędkością. Wiatr wieje z zachodu z prędkością 8kt. W jakiej odległości o Wrocławia
        //i o której spotkają się Magowie?

        double oporPowietrza = 8 * kt;
        double doKrakowaMag1 = 270 * 1000;
        double doKrakowaMag2 = 0;
        double czas = 0;
        double godzinyKoncowe = 0;
        double minutyKoncowe = 0;
        double vMag1 = vMax+oporPowietrza;
        double vMag2 = vMax-oporPowietrza;

        doKrakowaMag2=doKrakowaMag2-(vMag2*(15*60));//odejmuje odległość jaką by przebył w 15 min

        while(doKrakowaMag1>=doKrakowaMag2){ //kończy jak się miną
            doKrakowaMag1-=vMag1;
            doKrakowaMag2+=vMag2;
            czas++;
        }

        minutyKoncowe=(czas/60)%60;
        godzinyKoncowe=((czas/60)-minutyKoncowe)/60;

        System.out.println("Kilometr spotkania: "+(int)((270-doKrakowaMag1/1000))+"km | Czas spotkania: "+(int)(godzinyKoncowe+10)+":"+(int)(minutyKoncowe+15));
    }

    public static void kontrola(){
        //Na odcinku Świnki - Lenie Wielkie obowiązuje odcinkowy pomiar prędkości w przestrzeni powietrznej.
        //Ograniczenie prędkości względem ziemi wynosi 40kt (ograniczenie prędkości uwzględnia
        //wiatr). Mag wystartował o godzinie 11:55, odcinek 70km pokonał w 40min. Podczas przelotu wiał
        //wiatr o prędkości 4kt z kierunku przeciwnego do lotu (tzn. zwiększał prędkość względem ziemi).
        //Czy Mag przekroczył prędkość?

        double s = 70 * 1000; //odleglosc w metrach
        double oporPowietrza = 4 * kt;
        double czas = 40*60;
        double ograniczenie = 40 * kt;
        double v = s/czas+oporPowietrza;

        v=v*3600/1000;

        if(v>ograniczenie){
            System.out.println("Mag przekroczył prędkość");
        }
        else{
            System.out.println("Mag nie przekroczył prędkości");
        }
    }
}