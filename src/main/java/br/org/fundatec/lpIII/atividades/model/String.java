//package br.org.fundatec.lpIII.atividades.model;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import org.apache.hc.core5.net.URIBuilder;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//public class String {
//    private static String GOOGLEAPI = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=AIzaSyARagy3X2XFVQ9V5GR4795SiVV0BkPDMMA";
//}
//
//    URI uri = null;
//     try {
//        uri = new URIBuilder(GEMINI_PROMPT_URL)
//                .addParameter("key", HttpConstants.TOKEN)
//                .build();
//    } catch (
//    URISyntaxException exception) {
//        throw new RuntimeException(exception);
//    }
//
//    HttpRequest request = HttpRequest.newBuilder(uri)
//            .header(HttpConstants.HEADER_CONTENT_TYPE, HttpConstants.APPLICATION_JSON)
//            .POST(HttpRequest.BodyPublishers.ofString(prompt))
//            .build();
//
//    HttpResponse<String> response = null;
//        try {
//        response = httpClient.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        JsonNode responseJson = objectMapper.readTree(response.body());
//
//        String responseText = responseJson
//                .at("/candidates/0/content/parts/0/text")
//                .asText();
//    JsonNode responseJson = objectMapper.readTree(response.body());
//
//    String lat = responseJson
//            .at(" /results/0/geometry/location/lat")
//            .asDouble();
//    String lng = responseJson
//            .at(" /results/0/geometry/location/lng")
//            .asDouble();
//}
