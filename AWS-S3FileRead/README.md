	# Code for Reading file from S3 using Java
	
	
		We have a file that is in S3-Bucket and we have to read that file From S3 bucket. So we have write a code in S3FileRead.java.
	
		I am going to explain the one method that reads file from S3, Rest of the functions work same. 
		
		There is a function named s3FileReadInput which will read file from S3 and returns file Content.
		
	Step:1	To read the file from S3 we required two things:
			1. Bucket Name 
			2. file path with file named
			
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
	
	Step:3	Request For File and content
	
			Code:-
			
				GetObjectRequest request = new GetObjectRequest(bucketName,filePath+fileName);
				S3Object object = client.getObject(request);
				S3ObjectInputStream objectContent = object.getObjectContent();
				
				
				if the file contains key value or list or any format data (Map, JSON, LIst, etc...)
				
				then create object mapper and read the data in same format
				
				Code:-
				
				
				ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
				readValue = mapper.readValue(s3Object.getObjectContent(), <data type class name>.class);
				
				
				
				
				
				
				

			
			
			
			
			
			
			
			
		
		

	
