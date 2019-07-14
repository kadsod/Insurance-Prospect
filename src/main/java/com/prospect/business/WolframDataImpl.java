package com.prospect.business;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.prospect.model.WolframMapping;
import com.prospect.util.Constants;
import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

@Service
public class WolframDataImpl implements WolframData {

	public static final String apikey = "Q475QA-TPWG84Q6KJ";

	@Override
	public String saveData(String actualZipVal) {
		WAEngine engine = new WAEngine();
		WolframMapping mappingObj = new WolframMapping();
		// These properties will be set in all the WAQuery objects created from this
		// WAEngine.
		engine.setAppID(apikey);
		engine.addFormat("plaintext");

		// Create the query.
		WAQuery query = engine.createQuery();

		// Set properties of the query.
		query.setInput("zip" + " " + actualZipVal);

		try {
			// For educational purposes, print out the URL we are about to send:
			System.out.println("Query URL:");
			System.out.println(engine.toURL(query));
			System.out.println("");

			// This sends the URL to the Wolfram|Alpha server, gets the XML result
			// and parses it into an object hierarchy held by the WAQueryResult object.
			WAQueryResult queryResult = engine.performQuery(query);

			if (queryResult.isError()) {
				System.out.println("Query error");
				System.out.println("  error code: " + queryResult.getErrorCode());
				System.out.println("  error message: " + queryResult.getErrorMessage());
			} else if (!queryResult.isSuccess()) {
				System.out.println("Query was not understood; no results available.");
			} else {
				// Got a result.
				System.out.println("Successful query. Pods follow:\n");
				for (WAPod pod : queryResult.getPods()) {
					if (!pod.isError()) {
						//System.out.println(pod.getTitle());
						//System.out.println("------------");
						for (WASubpod subpod : pod.getSubpods()) {
							for (Object element : subpod.getContents()) {
								if (element instanceof WAPlainText) {
									//System.out.println(((WAPlainText) element).getText());
									//System.out.println("");
									extractData(pod.getTitle(), element, mappingObj);
								}
							}
						}
						//System.out.println("");
					}
				}
				System.out.println(mappingObj.toString());
				// We ignored many other types of Wolfram|Alpha output, such as warnings,
				// assumptions, etc.
				// These can be obtained by methods of WAQueryResult or objects deeper in the
				// hierarchy.
			}
		} catch (WAException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void extractData(String title, Object data, WolframMapping mappingObj) {

		if (title.equals(Constants.LOCATION)) {
			String str = ((WAPlainText) data).getText();
			String result = str.substring(str.indexOf("|") + 1, str.indexOf(","));
			System.out.println(result);
			mappingObj.setLocation(result);
		}
		
		if (title.equals(Constants.EDUCATIONAL_ATTAIN)) {
			String str = ((WAPlainText) data).getText();
			String result = str.substring(str.indexOf("|") + 1, str.indexOf("%"));
			System.out.println(result);
			mappingObj.setDegrePercentage(Double.parseDouble(result));
		}
		
		if (title.equals(Constants.MEDIAN_INCOME)) {
			String str = ((WAPlainText) data).getText();
			ArrayList<String> incomeValues = new ArrayList<String>() ;
			Scanner scanner = new Scanner(str);
			while(scanner.hasNextLine()) {
				incomeValues.add(scanner.nextLine());
			}
			int count = 0;
			for (String income : incomeValues) {
				String result = income.substring(income.indexOf("|") + 1, income.indexOf("per year"));
				System.out.println(result);
				if(count == 0) {
					mappingObj.setMedianIncome(Double.parseDouble(result.substring(result.indexOf("$")+1)));
				}if(count == 1) {
					mappingObj.setPercapitaIncome(Double.parseDouble(result.substring(result.indexOf("$")+1)));
				}
				count++;
				if(count==2) break;
			}
			scanner.close();
			
		}

	}
}
