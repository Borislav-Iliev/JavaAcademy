package Edabit;

public class TranscribeToMRNA {

    /*
    Transcribe the given DNA strand into corresponding mRNA - a type of RNA, that will be formed
    from DNA after transcription. DNA has the bases A, T, G and C, while RNA converts
    to U, A, C and G respectively.
    */

    public static String dnaToRna(String strand) {
        StringBuilder sb = new StringBuilder(strand);

        for (int i = 0; i < sb.length(); i++) {
            char element = sb.charAt(i);
            if (element == 'G') {
                sb.setCharAt(i, 'C');
            } else if (element == 'C') {
                sb.setCharAt(i, 'G');
            }
        }

        return sb
                .toString()
                .replace("A", "U")
                .replace("T", "A");
    }
}
