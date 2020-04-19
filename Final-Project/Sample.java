public class Sample {
    public static void main(String args[]) {
        URL url = new URL("https://www.stackabuse.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    }
}