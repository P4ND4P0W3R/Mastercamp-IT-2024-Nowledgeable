import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DnsApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Utilisation : java -jar dns.jar <adresse.ip/domaine> ou java -jar dns.jar ls <domaine>");
            return;
        }

        String command = args[0];
        if (command.equals("ls")) {
            if (args.length != 2) {
                System.out.println("Utilisation : java -jar dns.jar ls <domaine>");
                return;
            }
            listDomainEntries(args[1]);
        } else {
            if (args.length != 1) {
                System.out.println("Utilisation : java -jar dns.jar <adresse.ip/domaine>");
                return;
            }
            resolveEntry(args[0]);
        }
    }

    private static void resolveEntry(String entry) {
        List<DNSItem> dnsEntries = loadDnsEntries();
        for (DNSItem item : dnsEntries) {
            if (item.getIp().equals(entry) || item.getDns().equals(entry)) {
                System.out.println("IP: " + item.getIp() + ", Domaine: " + item.getDns());
                return;
            }
        }
        System.out.println("Aucune entrée trouvée pour : " + entry);
    }

    private static void listDomainEntries(String domain) {
        List<DNSItem> dnsEntries = loadDnsEntries();
        for (DNSItem item : dnsEntries) {
            if (item.getDns().equals(domain)) {
                System.out.println("IP: " + item.getIp());
            }
        }
    }

    private static List<DNSItem> loadDnsEntries() {
        List<DNSItem> dnsEntries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            DNSParser parser = new DNSParser();
            while ((line = br.readLine()) != null) {
                dnsEntries.add(parser.parseSingleEntry(line));
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier data.txt : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur lors du parsing d'une entrée DNS : " + e.getMessage());
        }
        return dnsEntries;
    }
}
