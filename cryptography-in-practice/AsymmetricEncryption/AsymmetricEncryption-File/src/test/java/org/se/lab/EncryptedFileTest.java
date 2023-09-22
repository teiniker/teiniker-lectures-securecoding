package org.se.lab;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class EncryptedFileTest
{
    private EncryptedFile file;

    private String publicKeyString  = "30820122300d06092a864886f70d01010105000382010f003082010a02820101009861042dab67c4ea74f36003fde47f443c0d9b5429c5ad5db052423d5c7bef8a1e4d26d9c1f152263cab6571f83c28b0a951c000314bfb4d20a9eb67c406011c7ef9975f00ca693663ae913223312705097135d57d7911aad0073745506ef0a917bbb3e4f29f396159c8733c78b6069b0f943a537bb1efaa5b0f6be7dd032a38c7e550dc733a39eb65769931f4e5fdd547bc045bb72c2c59b0a75604c74a95989af309a7a164c777690c35cbb76a5f465941d1314cb2a926003ab710c77e7582e2d8ad6b538481cbfec173667f88eea9848544af3893552cb64c3fd3fb5c48b1ac41850ff6c3f3554e11e7881c030fb47666421e87b523050ceaad96a96caba50203010001";
    private String privateKeyString = "308204bc020100300d06092a864886f70d0101010500048204a6308204a202010002820101009861042dab67c4ea74f36003fde47f443c0d9b5429c5ad5db052423d5c7bef8a1e4d26d9c1f152263cab6571f83c28b0a951c000314bfb4d20a9eb67c406011c7ef9975f00ca693663ae913223312705097135d57d7911aad0073745506ef0a917bbb3e4f29f396159c8733c78b6069b0f943a537bb1efaa5b0f6be7dd032a38c7e550dc733a39eb65769931f4e5fdd547bc045bb72c2c59b0a75604c74a95989af309a7a164c777690c35cbb76a5f465941d1314cb2a926003ab710c77e7582e2d8ad6b538481cbfec173667f88eea9848544af3893552cb64c3fd3fb5c48b1ac41850ff6c3f3554e11e7881c030fb47666421e87b523050ceaad96a96caba50203010001028201002cbadde52219b5fe3512742ef7caa969384fae370884149e19f22baba388660a9f567a7f15a5673dfe3539f438b040298baa89b804c08f2656de4a520d82cdb4b5b942ac0aa960352d11c3617a5f255b1f28726b1708011da92f55142dc64332ffda83b6435a6617a3a969da687cd677921d2af9f2a78af8f0fe17e8da41e1949066c9610dc9b5f2bb1c4c5ddbcd1f89d05b76cdb98bd66c6b7923d6547e4dc18b69c53e842e6d33a37cd48cd5bcf1e854e9ef20e24ead0a2dca424c86542567d8b649c889ed5e108f101f75c0468f4b94ac9fd978a39ec76e4012dcf81a2e3ff52d471b755c22dabed8dc97f152446a4fb976def98c01b170278bc7666107c902818100e1fe0fb7fad01fd3cfbbb12dd088ba208c5042e12a9fbc2d9ca0e62a52896ae17bcf3913385a4af9d336475cf85f2e1f50e377819138aa2a53032624c07f42f0106bccb5c276f17574d71b705ad409b170a114411cc5be001a7905d35b6e076f4a7f8b6df889e2f77a8d5e46a5c175036ec8432825b2045e3aa2fe0f03b4e62f02818100ac9caf5a66c25b80e1e2ba515fa5b09fe50e084f30aed2e81b8270d18936584e9e9a7a51e8dafd0fd8bcac9812ef17a3a7b3f78cbe105fafde727630ec3009aafc64cea0994057ead7f04585099533ee4f8ea513f5e3e69a60b2062bce6fc7d15c202f547ca60f879d3afb8686c10feb205164986e0e25e5e60a8710634f6a6b0281804675a0cefacb02f156162dd29beed5212abe276bee8f28eb8ba6fabbfd49cce20a68fc618ab35426f9fc3559be3266bdeac950cc3bcbcffa2c319225e942844b36c3756ac1fbb5a2aa501ac4f7fc9e1d0d819b4005c97d48a8f84ca1ae22eafc7edcaf4b152f606d4a6f631261c1a44af2b24b85ebe2c9cbdb3a503dbc291d8f0281805950adef7212897473ed74891c9bc87bc3f2f1dbc00e05f5b21e59b02276ab54eafe75e2a24186064818c099e3da317a2e11923b1231b8c170b1fb742f12603e48610505d6a6939761eae29e072a5bf7a8d4df982778a85f233f9aafda1ebedf16f3546a3c215511d00ab01198f297010bf4f1bf69db0a431e383e50fd821f4702818036fb01f7bd22084f40b7c6f190bd5397462b6be95bde9ddc46ad9597d648c92635e35a11c7116453d2288ce755aeb953928250a744b757812fa2c6e24932baf14d697fba95fc63481be91c6d8e6daed4c3fa515bb8d5709c7eae5af96b945c4f15aaf504cb3decf1c5231344fb3e54107e11e0e1db687581c6af8a8d0f43b08f";

    @Before
    public void setup()
    {
        file = new EncryptedFile(publicKeyString, privateKeyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidKeyString_Null()
    {
        new EncryptedFile(null, privateKeyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidIvString_Null()
    {
        new EncryptedFile(publicKeyString, null);
    }

    @Test
    public void testSaveFile() throws DecoderException, IOException
    {
        byte[] data = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());

        file.save("target/data.bin", data);

        String dataString = hexDump("target/data.bin");
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
        System.out.println(dataString);
    }

    @Test
    public void testLoadFile()
    {
        byte[] data = file.load("target/data.bin");

        String dataString = Hex.encodeHexString(data);
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
    }

    /*
    * Note that RSA encryption uses a random value as part of the encryption process
    * to ensure that the ciphertext has a different value every time, even when the
    * same plaintext is encrypted multiple times.
    */
    @Test
    public void testSaveAndLoadEncryptedFile() throws DecoderException, IOException
    {
        // Save encrypted data
        byte[] dataOut = Hex.decodeHex("000102030405060708090a0b0c0d0e0f".toCharArray());
        System.out.println("plain text : " + Hex.encodeHexString(dataOut));
        file.saveEncrypted("target/encrypted_data.bin", dataOut);

        // Dump cipher text
        System.out.println("cipher text: " + hexDump("target/encrypted_data.bin"));

        // Load encrypted data
        byte[] dataIn = file.loadEncrypted("target/encrypted_data.bin");
        String dataString = Hex.encodeHexString(dataIn);
        System.out.println("plain text : " + dataString);
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveEncryptedFile_InvalidFilename() throws DecoderException
    {
        byte[] data = Hex.decodeHex("".toCharArray());
        file.saveEncrypted(null, data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveEncryptedFile_InvalidData()
    {
        file.saveEncrypted("target/encrypted_data.bin", null);
    }


    @Test
    public void testLoadEncryptedFile()
    {
        byte[] data = file.loadEncrypted("target/encrypted_data.bin");
        String dataString = Hex.encodeHexString(data);
        Assert.assertEquals("000102030405060708090a0b0c0d0e0f", dataString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadEncryptedFile_InvalidFilename()
    {
        file.loadEncrypted(null);
    }


    private String hexDump(String filename) throws IOException
    {
        FileInputStream fis = new FileInputStream(new File(filename));
        byte[] dataFromFile = fis.readAllBytes();
        fis.close();
        return Hex.encodeHexString(dataFromFile);
    }
}
