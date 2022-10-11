package string;

import org.apache.commons.httpclient.HttpClient;

public class Test {
	
	private static final String URL_PARAM_DELIMETER = "?";
	private static final String MULTIPLE_SPACES = "\\s+";
	private static final String URL_SPACE_MASK_CHARACTER = "+";

	private static final String URL_PARAM_DATA = "data=";
	private static final String URL_PARAM_TASK = "task=";// search
	private static final String URL_PARAM_FIELDS = "fields=";
	private static final String URL_PARAM_TOWN = "town=";
	private static final String URL_PARAM_COUNTY = "county=";
	private static final String URL_PARAM_STREET = "street=";
	private static final String URL_PARAM_POSTCODE = "postcode=";
	private static final String URL_PARAM_APPEND = "&";
	private static final String URL_PARAM_ADDRESS = "address=";
	private static final String URL_PARAM_SERIAL = "serial=";
	
	public static final String SPECIALCHARLIST = "([:~'`!;@#&%^*])-";
	public static final String DELIMITER_COMMA = ",";
	public static final String SPACE = " ";


	public static void main(String[] args) {

		
		
		StringBuffer queryParamBuffer = new StringBuffer(URL_PARAM_DATA)
				.append("address").append(URL_PARAM_APPEND)
				.append(URL_PARAM_TASK).append("RetrieveAddress")
				.append(URL_PARAM_APPEND).append(URL_PARAM_FIELDS)
				.append("standard").append(URL_PARAM_APPEND)
				.append(URL_PARAM_SERIAL).append("828942")
				.append(URL_PARAM_APPEND).append(URL_PARAM_ADDRESS)
				.append("addressLine1");

		queryParamBuffer.append(DELIMITER_COMMA).append(
				"addressLine2");
		
		
			queryParamBuffer.append(DELIMITER_COMMA).append("county");
		
			queryParamBuffer.append(DELIMITER_COMMA).append("city");
		
		queryParamBuffer.append(URL_PARAM_APPEND).append(URL_PARAM_POSTCODE)
				.append("DN211ZA").toString();

		
		String url = ("http://ukgr-afdpostcode-qa.walmart.com/afddata.pcej" + URL_PARAM_DELIMETER + queryParamBuffer
				.toString()).replaceAll(MULTIPLE_SPACES,
				URL_SPACE_MASK_CHARACTER);
		
		System.out.println(url);
		
		
		String queryParams = new StringBuffer(URL_PARAM_DATA)
				.append("address").append(URL_PARAM_APPEND)
				.append(URL_PARAM_TASK).append("lookup").append(URL_PARAM_APPEND)
				.append(URL_PARAM_SERIAL).append("828942")
				.append(URL_PARAM_APPEND).append(URL_PARAM_FIELDS)
				.append("standard").append(URL_PARAM_APPEND)
				.append(URL_PARAM_POSTCODE).append("DN211ZA")
				.toString();
		
		
		String url1 = ("http://ukgr-afdpostcode-qa.walmart.com/afddata.pcej" + URL_PARAM_DELIMETER + queryParams)
				.replaceAll(MULTIPLE_SPACES, URL_SPACE_MASK_CHARACTER);
		
		System.out.println(url1);
		
	}

}
