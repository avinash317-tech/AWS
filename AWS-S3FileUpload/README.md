	# S3 upload in java....
	
	import com.amazonaws.services.s3.model.ObjectMetadata;
	import com.amazonaws.services.s3.model.PutObjectRequest;
	import com.amazonaws.services.s3.model.S3Object;
	import com.amazonaws.services.s3.AmazonS3Client;
	import java.io.ByteArrayInputStream;
	
	
	We have a file that is in byte array format and we have to upload that file in S3 bucket. So we have write a code in S3Upload.java class.
	
		I am going to explain the method that uploads the file in S3. 
		
		There is a function named s3Upload which will read byte array of file and uploads on S3.
		
	Step:1	To upload the file on S3 we required three things:
			1. Bucket Name 
			2. file path with file named
			3. byte array of file
			
	Step:2 Create a client to access S3 service
		
			There are two way from which we can create a client for S3.
				1. Role based Client (in role base client it will authorised the client on the role permission.
					in simple word, we have to privide S3 get permissionins in role)
					
					Code:- 
					
					AmazonS3Client client = new AmazonS3Client();
					
				2. Security key based client (in Security based client we have to provide access key and secret key )
					
					Code:- 
					
					private final static AWSCredentials AWS_CREDENTIALS = new BasicAWSCredentials(Access_key_ID, Secret_access_key);
					AmazonS3Client s3Client = new AmazonS3Client(AWS_CREDENTIALS);
					
					or you can visit here for more details 
					https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
	
	Step:3	Create metadata object for file and the set metadata of that file like (content-length, etc)
	
			Code:-
			
				ObjectMetadata metaData = new ObjectMetadata();
				metaData.setContentLength(bytes.length);
				
				convert byte array in ByteArrayInputStream
				
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(<byte array>);
				
				Create object of PutObjectRequest and pass the arguments (<bucket name>, <file-path+file-name>,<ByteArrayInputStream>, <metadata>)
				
				PutObjectRequest request = new PutObjectRequest(bucketName, filepath+fileName, byteArrayInputStream , metaData);
				
				to upload the file call putObject method
				
				s3Client.putObject(request);
