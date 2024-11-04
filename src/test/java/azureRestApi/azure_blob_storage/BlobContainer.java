package azureRestApi.azure_blob_storage;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BlobContainer {

    public static void main(String[] args) {
        /*
         * The default credential first checks environment variables for configuration
         * If environment configuration is incomplete, it will try managed identity
         */
        /**
         * DefaultAzureCredential first checks environment variables for configuration.
         * If environment configuration is incomplete, it tries managed identity.
         */
        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder().build();
//        defaultCredential.getToken("");


// Azure SDK client builders accept the credential as a parameter
// TODO: Replace <storage-account-name> with your actual storage account name
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://<storage-account-name>.blob.core.windows.net/")
                .credential(defaultCredential)
                .buildClient();
    }

    public static void uploadFile() {
        // Create the ./data/ directory and a file for uploading and downloading
        String localPath = "./data/";
        new File(localPath).mkdirs();
        String fileName = "quickstart" + java.util.UUID.randomUUID() + ".txt";
        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder().build();
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://<storage-account-name>.blob.core.windows.net/")
                .credential(defaultCredential)
                .buildClient();
        // Create a unique name for the container
        String containerName = "quickstartblobs" + java.util.UUID.randomUUID();

// Create the container and return a container client object
        BlobContainerClient blobContainerClient = blobServiceClient.createBlobContainer(containerName);

// Get a reference to a blob
        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);

// Write text to the file
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(localPath + fileName, true);
            writer.write("Hello, World!");
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

// Upload the blob
        blobClient.uploadFromFile(localPath + fileName);

    }
//------------------------------------------------------------------------------------------------------------------------------------------
    public static void checkFile() {
        // Create the ./data/ directory and a file for uploading and downloading
        String localPath = "./data/";
        new File(localPath).mkdirs();
        String fileName = "quickstart" + java.util.UUID.randomUUID() + ".txt";
        DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder().build();
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://<storage-account-name>.blob.core.windows.net/")
                .credential(defaultCredential)
                .buildClient();
        // Create a unique name for the container
        String containerName = "quickstartblobs" + java.util.UUID.randomUUID();

// Create the container and return a container client object
        BlobContainerClient blobContainerClient = blobServiceClient.createBlobContainer(containerName);

// Get a reference to a blob
        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);

// Write text to the file
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(localPath + fileName, true);
            writer.write("Hello, World!");
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

// Upload the blob
        blobClient.uploadFromFile(localPath + fileName);
        blobClient.getBlockBlobClient().exists();
    }

}
