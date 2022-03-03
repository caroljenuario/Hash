package hash.corrigido;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Hash_solucao {
    private MessageDigest algoritmo;
    private Hash_solucao()
    {
        try {
            algoritmo = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private static Hash_solucao hash = null;

    public synchronized static Hash_solucao getInstance()
    {
        if(hash == null )
            hash = new Hash_solucao();
        return hash;
    }

    public String toString(String entrada) {
        algoritmo.update(entrada.getBytes());
        byte[] bytes = algoritmo.digest();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
}

