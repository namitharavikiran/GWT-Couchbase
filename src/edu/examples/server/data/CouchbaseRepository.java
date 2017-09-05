package edu.examples.server.data;

import com.couchbase.client.core.CouchbaseException;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.document.JsonDocument;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.examples.client.model.Customer;
import edu.examples.server.exception.RepositoryException;

public class CouchbaseRepository implements Repository {
	private Bucket bucket;

	public CouchbaseRepository(Cluster cluster, String bucketName) {
		try {
			bucket = cluster.openBucket(bucketName);
		} catch (CouchbaseException e) {
			throw new RepositoryException(e);
		}
	}
	@Override
	public JsonDocument findById(String id)
	{
		JsonDocument doc = bucket.get(id);
		return doc;
	}
	@Override
	public JsonDocument create(Customer cust) {
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonstring = gson.toJson(cust);

        JsonDocument document = JsonDocument.create(cust.getId(),
                com.couchbase.client.java.document.json.JsonObject.fromJson(jsonstring));
        JsonDocument docOut = bucket.insert(document);
        return docOut;
	}

	@Override
	public JsonDocument update(Customer cust) {
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonstring = gson.toJson(cust);
        System.out.println("cust.getId() " +cust.getId());
        JsonDocument document = JsonDocument.create(cust.getId(),
                com.couchbase.client.java.document.json.JsonObject.fromJson(jsonstring));
        JsonDocument docOut = bucket.replace(document);
        
        return docOut;
	}

	@Override
	public JsonDocument upsert(Customer cust) {
		return null;
	}

	@Override
	public void delete(String custId) {
		
			bucket.remove(custId);
		} 
}