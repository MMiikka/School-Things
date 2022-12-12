
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;



import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
class hashExample{
	static int iterationCount = 0;
  public static void main(String[] args){
	  
	if(args.length > 0){
     iterationCount = iterationCount + Integer.parseInt(args[0]);
	}else{
		iterationCount += 80000;
	}
  /*I am using a SecureRandom class from java.security
  to generate a secure random number
  */ 
  SecureRandom random = new SecureRandom();
  /*
   * Then I'll declare the salt which is a 16 bit byte array.
   * Next the array is filled with random numbers from the SecureNumber instance
   * 
   */
  byte[] suola = new byte[16];
  random.nextBytes(suola);

  /*
   * Here is the instance of PBEKeySpec which takes the password, salt, iteration count and key lenght as parameters.
   * The iteration count is basically the parameter of strength. Here it can be given from the command prompt. Usually high number like "80000". The longer the number is the longer the algorithm takes to generate the hash.
   */
  KeySpec spec = new PBEKeySpec("salasana".toCharArray(), suola, iterationCount,128);
  /*
   * Next is created a SecretKeyFactory which is instantiated with the PBKDF2WithHmacsSHA1 algorithm.
   */
  try {
    SecretKeyFactory tehdas = SecretKeyFactory.getInstance(("PBKDF2WithHmacSHA1"));
     /*
   * Now we generate the hash with our SecretKeyFactory
   */
    byte[] hash = tehdas.generateSecret(spec).getEncoded();
    System.out.println(hash);
	//Prints B@7de26db8 which is the hash for password "salasana" + salt
  } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
    
    System.out.println(e.getMessage());
  }
  
 

}

  
  }