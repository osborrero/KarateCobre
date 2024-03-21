function createQueueMessageBody(fullFileName, clientCode, bucketName) {
    return {
        "fileName": fullFileName,
        "workplacebankCode": clientCode,
        "bucketName": bucketName
     };
}