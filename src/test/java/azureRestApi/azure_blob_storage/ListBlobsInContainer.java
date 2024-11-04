package azureRestApi.azure_blob_storage;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobItem;

public class ListBlobsInContainer {

    public static void main(String[] args) {
        // Azure Blob Storage connection string
        String connectionString = "<your-connection-string>";
        // Name of the blob container
        String containerName = "<your-container-name>";

        // Create a BlobContainerClient
        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName(containerName)
                .buildClient();

        // List blobs in the container
        System.out.println("Listing blobs in container:");
        for (BlobItem blobItem : containerClient.listBlobs()) {
            System.out.println(" - " + blobItem.getName());
        }
    }
}
