package app.entities;

public class Phrase implements Comparable<Phrase> {
    private String originalPhrase;
    private String invertedPhrase;

    public String getOriginalPhrase() {
        return originalPhrase;
    }

    public void setOriginalPhrase(String originalPhrase) throws Exception {
        if (originalPhrase != null && !originalPhrase.isBlank()) {
            this.originalPhrase = originalPhrase.trim().replaceAll("\\s+", " ");
        } else {
            throw new Exception("The phrase cannot be null or blank");
        }
    }

    public String getInvertedPhrase() {
        return invertedPhrase;
    }

    public void setInvertedPhrase(String invertedPhrase) {
        this.invertedPhrase = invertedPhrase;
    }

    @Override
    public int compareTo(Phrase anotherPhrase){
        return this.originalPhrase.compareTo(anotherPhrase.getOriginalPhrase());
    }
}
