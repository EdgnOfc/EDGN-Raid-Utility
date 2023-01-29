package net.edgn.utils;

public class Chronometer {

	public static class Chrono {

	    private static long tempsDepart=0;
	    private static long tempsFin=0;
	    private static long pauseDepart=0;
	    private static long pauseFin=0;
	    private static long duree=0;

	    public static void start()
	        {
	        tempsDepart=System.currentTimeMillis();
	        tempsFin=0;
	        pauseDepart=0;
	        pauseFin=0;
	        duree=0;
	        }

	    public static void pause()
	        {
	        if(tempsDepart==0) {return;}
	        pauseDepart=System.currentTimeMillis();
	        }

	    public static void resume()
	        {
	        if(tempsDepart==0) {return;}
	        if(pauseDepart==0) {return;}
	        pauseFin=System.currentTimeMillis();
	        tempsDepart=tempsDepart+pauseFin-pauseDepart;
	        tempsFin=0;
	        pauseDepart=0;
	        pauseFin=0;
	        duree=0;
	        }
	        
	    public static void stop()
	        {
	        if(tempsDepart==0) {return;}
	        tempsFin=System.currentTimeMillis();
	        duree=(tempsFin-tempsDepart) - (pauseFin-pauseDepart);
	        tempsDepart=0;
	        tempsFin=0;
	        pauseDepart=0;
	        pauseFin=0;
	        }        

	    public static long getDureeSec()
	        {
	        return duree/1000;
	        }
	        
	    public static long getDureeMs()
	        {
	        return duree;
	        }        

	    public static String getDureeTxt()
	        {
	        return timeToHMS(getDureeSec());
	        }

	    public static String timeToHMS(long tempsS) {

	        // IN : (long) temps en secondes
	        // OUT : (String) temps au format texte : "1 h 26 min 3 s"

	        int h = (int) (tempsS / 3600);
	        int m = (int) ((tempsS % 3600) / 60);
	        int s = (int) (tempsS % 60);

	        String r="";

	        if(h>0) {r+=h+" h ";}
	        if(m>0) {r+=m+" min ";}
	        if(s>0) {r+=s+" s";}
	        if(h<=0 && m<=0 && s<=0) {r="0 s";}

	        return r;
	        }

	    }
}
