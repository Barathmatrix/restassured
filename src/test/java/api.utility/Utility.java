package api.utility;
import java.util.UUID;
import java.util.Random;
import java.util.Arrays;


import api.payload.Corporate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class Utility {
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandom(String type, int size) {
        Random random = new Random();
        StringBuilder generatedString = new StringBuilder();

        String numberChars = "0123456789";
        String alphaChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphaNumericChars = numberChars + alphaChars.toLowerCase() + alphaChars;

        if ("N".equalsIgnoreCase(type)) {
            for (int i = 0; i < size; i++) {
                generatedString.append(numberChars.charAt(random.nextInt(numberChars.length())));
            }
        } else if ("A".equalsIgnoreCase(type)) {
            for (int i = 0; i < size; i++) {
                generatedString.append(alphaChars.charAt(random.nextInt(alphaChars.length())));
            }
        } else if ("AN".equalsIgnoreCase(type)) {
            for (int i = 0; i < size; i++) {
                generatedString.append(alphaNumericChars.charAt(random.nextInt(alphaNumericChars.length())));
            }
        } else {
            throw new IllegalArgumentException("Invalid type. Use 'N', 'A', or 'A'.");
        }

        return generatedString.toString();
    }

    public static String modifyValue(Object originalObject, String keyToModify, Object newValue) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalJsonNode = objectMapper.valueToTree(originalObject);

        // Create a new structure to hold our modified information
        JsonNode modifiedJsonNode = modifyValue(originalJsonNode, keyToModify, newValue, objectMapper.createObjectNode());

        return objectMapper.writeValueAsString(modifiedJsonNode);
    }

    public static String modifyValue(String originalJsonString, String keyToModify, Object newValue) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalJsonNode = objectMapper.readTree(originalJsonString);

        // Create a new structure to hold our modified information
        JsonNode modifiedJsonNode = modifyValue(originalJsonNode, keyToModify, newValue, objectMapper.createObjectNode());

        return objectMapper.writeValueAsString(modifiedJsonNode);
    }
    private static JsonNode modifyValue(JsonNode originalNode, String keyToModify, Object newValue, ObjectNode modifiedNode) {
        originalNode.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();

            // If the current part is not the one we want to modify, add it to the modified information
            if (!key.equals(keyToModify)) {
                // If the value is an object, recursively modify the value in it
                if (value.isObject()) {
                    modifiedNode.set(key, modifyValue(value, keyToModify, newValue, modifiedNode.objectNode()));
                } else {
                    modifiedNode.set(key, value);
                }
            } else {
                // If the current part is the one we want to modify, update its value
                if (newValue instanceof Number) {
                    modifiedNode.set(key, modifiedNode.numberNode(((Number) newValue).doubleValue()));
                } else {
                    // For non-numeric values, create a TextNode
                    modifiedNode.put(key, newValue.toString());
                }
            }
        });

        return modifiedNode;
    }



    public static String convertKey(Object originalObject, String oldKey, String newKey) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
       // JsonNode originalJsonNode= objectMapper.readTree(originalObject);
       JsonNode originalJsonNode = objectMapper.valueToTree(originalObject);

        // Create a new structure to hold our modified information
        JsonNode modifiedJsonNode = convertKey(originalJsonNode, oldKey, newKey, objectMapper.createObjectNode());

        return objectMapper.writeValueAsString(modifiedJsonNode);
    }
    public static String convertKey(String originalJsonString, String oldKey, String newKey) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalJsonNode = objectMapper.readTree(originalJsonString);

        // Create a new structure to hold our modified information
        JsonNode modifiedJsonNode = convertKey(originalJsonNode, oldKey, newKey, objectMapper.createObjectNode());

        return objectMapper.writeValueAsString(modifiedJsonNode);
    }
    private static JsonNode convertKey(JsonNode originalNode, String oldKey, String newKey, ObjectNode modifiedNode) {
        originalNode.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();

            // If the current part is not the one we want to convert, add it to the modified information
            if (!key.equals(oldKey)) {
                // If the value is an object, recursively convert the key in it
                if (value.isObject()) {
                    modifiedNode.set(key, convertKey(value, oldKey, newKey, modifiedNode.objectNode()));
                } else {
                    modifiedNode.set(key, value);
                }
            } else {
                // If the current part is the one we want to convert, add the new key to the modified information
                modifiedNode.set(newKey, value);
            }
        });

        return modifiedNode;
    }

    public static String addKeyAndValue(String originalJsonString, String fullPath, String newValue) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalNode = objectMapper.readTree(originalJsonString);
        return addKeyAndValue(originalNode, fullPath, newValue, objectMapper);
    }

    public static String addKeyAndValue(Object originalObject, String fullPath, String newValue) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalNode = objectMapper.valueToTree(originalObject);
        return addKeyAndValue(originalNode, fullPath, newValue, objectMapper);
    }

    private static String addKeyAndValue(JsonNode originalNode, String fullPath, String newValue, ObjectMapper objectMapper) throws Exception {
        // Create a new ObjectNode for the modified JSON
        ObjectNode modifiedNode = objectMapper.createObjectNode();

        // Split the full path into individual keys
        String[] keys = fullPath.split("\\.");

        // Create a reference to the modifiedNode for dynamic structure creation
        ObjectNode currentNode = modifiedNode;

        // Traverse the JSON structure and create missing nodes
        for (int i = 0; i < keys.length - 1; i++) {
            String currentKey = keys[i];
            JsonNode existingNode = originalNode.has(currentKey) ? originalNode.get(currentKey) : null;

            // If the node doesn't exist or is not an object, create a new object node
            if (existingNode == null || !existingNode.isObject()) {
                ObjectNode newNode = objectMapper.createObjectNode();
                currentNode.set(currentKey, newNode);
                currentNode = newNode;
            } else {
                currentNode.set(currentKey, existingNode);
                currentNode = (ObjectNode) existingNode;
            }
        }

        // Add the new key and value to the last node
        String lastKey = keys[keys.length - 1];
        JsonNode existingValue = originalNode.has(lastKey) ? originalNode.get(lastKey) : null;
        if (existingValue != null && existingValue.isObject()) {
            currentNode.set(lastKey, existingValue);
        } else {
            currentNode.put(lastKey, newValue);
        }

        // Merge modifiedNode with originalNode
        modifiedNode.setAll((ObjectNode) originalNode);

        // Convert the merged ObjectNode back to JSON string
        return objectMapper.writeValueAsString(modifiedNode);
    }












    // Method to remove a key from the POJO
    private static String removeKey(Object originalObject, String keyToRemove) throws Exception {
        // ObjectMapper helps us work with JSON in Java
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the pojo information to a special structure (JsonNode)
        JsonNode originalJsonNode = objectMapper.valueToTree(originalObject);

        // Step 3: Remove the specified key from the JSON structure
        JsonNode modifiedJsonNode = removeKey(originalJsonNode, keyToRemove);

        // Step 4: Convert the modified JsonNode back to JSON string
        return objectMapper.writeValueAsString(modifiedJsonNode);
    }

    // Entry point method to remove a key from a JSON string
    public static String removeKeyFromString(String originalJsonString, String keyToRemove) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode originalJsonNode = objectMapper.readTree(originalJsonString);
        JsonNode modifiedJsonNode = removeKey(originalJsonNode, keyToRemove);
        return objectMapper.writeValueAsString(modifiedJsonNode);
    }

    // Helper method to remove the specified key from a JsonNode
    private static JsonNode removeKey(JsonNode originalNode, String keyToRemove) {
        // ObjectMapper helps us work with JSON in Java
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a new structure to hold our modified information
        ObjectNode modifiedNode = objectMapper.createObjectNode();

        // Split the keyToRemove into parts
        String[] keys = keyToRemove.split("\\.");

        // Go through each part of the original information
        originalNode.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();

            // If the current part is not the one we want to remove, add it to the modified information
            if (!key.equals(keys[0])) {
                // If the value is an object, recursively remove the key from it
                if (value.isObject()) {
                    modifiedNode.set(key, removeKey(value, keyToRemove.substring(key.length() + 1)));
                } else {
                    modifiedNode.set(key, value);
                }
            }
        });

        // Return the modified information
        return modifiedNode;
    }
}


