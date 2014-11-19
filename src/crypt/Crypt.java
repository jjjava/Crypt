package crypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author bp12214
 */
public class Crypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String mensagem = "teste de crypto";
            System.out.println("Mensagem original: " + mensagem);

            KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
            SecretKey chave = kgen.generateKey();
            System.out.println(chave.getFormat());
            System.out.println(Arrays.toString(chave.getEncoded()));

            byte[] c = chave.getEncoded();

            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, chave);

            byte criptografada[] = cipher.doFinal(mensagem.getBytes());
            System.out.println("Mensagem cripotografada: " + Arrays.toString(criptografada));

            cipher.init(Cipher.DECRYPT_MODE, chave);

            byte descriptografada[] = cipher.doFinal(criptografada);
            System.out.println("Mensagem descripotografada: " + new String(descriptografada));

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.toString());
        } catch (NoSuchPaddingException e) {
            System.out.println(e.toString());
        } catch (InvalidKeyException e) {
            System.out.println(e.toString());
        } catch (IllegalBlockSizeException e) {
            System.out.println(e.toString());
        } catch (BadPaddingException e) {
            System.out.println(e.toString());
        }
    }
}
