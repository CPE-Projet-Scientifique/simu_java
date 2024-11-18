public class Fire {
    private int x;
    private int y;
    private String intensity; // "faible", "moyenne", "forte"
    private int frequency;    // Intervalle de génération en secondes

    public Fire(int x, int y, String intensity, int frequency) {
        this.x = x;
        this.y = y;
        this.intensity = intensity;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("🔥 Feu [x: %d, y: %d, intensité: %s, fréquence: %d secondes]", x, y, intensity, frequency);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIntensity() {
        return intensity;
    }
}
