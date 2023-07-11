package Edabit;

public class VideoLengthInSeconds {
    public static void main(String[] args) {
        System.out.println(minutesToSeconds("13:56"));
    }

    public static int minutesToSeconds(String tm) {
        String[] tokens = tm.split(":");

        int minutes = Integer.parseInt(tokens[0]);
        int seconds = Integer.parseInt(tokens[1]);

        if (seconds >= 60) {
            return -1;
        }

        return minutes * 60 + seconds;
    }
}
