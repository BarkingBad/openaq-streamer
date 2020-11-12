# OpenAQ streamer

## Build

- Build docker image
```bash
docker build .
```
- Name obtained image
```bash
docker tag shaFromPreviousStep imageName
```
- Run docker
```bash
docker run -p 8888:8888 -p 4040:4040 -v mountPoint:/home/jovyan/work imageName
```
## Using
Create AWS SQS, subscribe to SNS `arn:aws:sns:us-east-1:470049585876:OPENAQ_NEW_MEASUREMENT`   
Python example:
```python
from pyspark.sql import SparkSession
spark = SparkSession\
    .builder\
    .config("spark.sql.streaming.schemaInference", True)\
    .getOrCreate()
stream = spark\
    .readStream\
    .format("sqs")\
    .option("queueUrl", "https://sqs.us-east-1.amazonaws.com/...")\
    .option("accessKey", "...")\
    .option("secretKey", "...")\
    .option("region", "us-east-1")\
    .load()
stream.select("city").writeStream\
    .format("console")\
    .outputMode("append")\
    .start()
```