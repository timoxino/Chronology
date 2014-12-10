package by.chronology.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Provides implementation of hashing mechanism for storing passwords.
 *
 * @author Tsimafei_Shchytkavets
 */
public class SecurityUtil
{
    /**
     * Apply SHA-1 hashing function to password to secure it.
     *
     * @param passwordToHash password to be secured.
     * @return secured value of password that might be stored in DB.
     * @throws NoSuchAlgorithmException if requested Algorithm hasn't been found.
     */
    public static String getSHA1SecuredPassword(String passwordToHash) throws NoSuchAlgorithmException
    {
        return getSHA1SecuredPassword(passwordToHash, null);
    }

    /**
     * Apply SHA-1 hashing function with <code>salt</code> to password to secure it.
     *
     * @param passwordToHash password to be secured.
     * @param salt           some value that will be used as a <code>salt</code>.
     * @return secured value of password that might be stored in DB.
     * @throws NoSuchAlgorithmException if requested Algorithm hasn't been found.
     */
    public static String getSHA1SecuredPassword(String passwordToHash, String salt) throws NoSuchAlgorithmException
    {
        if (passwordToHash == null)
        {
            return null;
        }

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        if (salt != null)
        {
            md.update(salt.getBytes());
        }

        byte[] bytes = md.digest(passwordToHash.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    /**
     * Generate <code>Salt</code> that might be used for securing passwords.
     *
     * @return random generated <code>Salt</code>.
     * @throws NoSuchAlgorithmException if requested Algorithm hasn't been found.
     */
    public static String generateSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
}
