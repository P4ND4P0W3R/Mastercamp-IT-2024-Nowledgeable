public class DNSItem {
    private String ip;
    private String domainName;

    public DNSItem(String ip, String domainName) throws IllegalArgumentException {
        if (!isValidIPAddress(ip)) {
            throw new IllegalArgumentException("Format d'adresse IP invalide : " + ip);
        }

        this.ip = ip;
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public String getDns() {
        return domainName;
    }

    private boolean isValidIPAddress(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4)
            return false;

        try {
            for (String part : parts) {
                int octet = Integer.parseInt(part);
                if (octet < 0 || octet > 255)
                    return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
