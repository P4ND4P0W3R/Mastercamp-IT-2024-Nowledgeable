public class DNSParser {
    public DNSItem parseSingleEntry(String entry) {
        String[] parts = entry.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Format d'entrée invalide : " + entry);
        }
        return new DNSItem(parts[0], parts[1]);
    }
}
