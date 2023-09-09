import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.AmazonS3Client;
import java.io.ByteArrayInputStream;
	//upload file on AWS S3			
	public String s3Upload(String bucketName , String fileName , byte[] bytes) throws Exception{
		ObjectMetadata metaData = new ObjectMetadata();
		// creating S3 client
		AmazonS3Client s3Client = new AmazonS3Client();
		metaData.setContentLength(bytes.length);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		PutObjectRequest request = new PutObjectRequest(bucketName, fileName, byteArrayInputStream , metaData);
		s3Client.putObject(request);
		return "Success";
	}