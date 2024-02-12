package cz.itnetwork;

public class FormatovaniTextu {
    /**
     * Metoda naformatuje text - nejlépe - jméno, příjmení
     * @param text  Text k formátování
     * @return      Naformátovaný text
     */
    public String formatujText(String text){
        return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
