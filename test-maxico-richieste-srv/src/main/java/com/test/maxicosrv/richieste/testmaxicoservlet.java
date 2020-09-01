package com.test.maxicosrv.richieste;

//CHECK SERVLET SCIM ANTONIO (CANCELLO QUELLI CHE NON USO)

import java.io.IOException;
import com.google.gson.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;

import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.connectivity.ErpConfigContext;
import com.sap.cloud.sdk.service.prov.api.operations.Query;
import com.sap.cloud.sdk.service.prov.api.request.QueryRequest;
import com.sap.cloud.sdk.service.prov.api.response.ErrorResponse;
import com.sap.cloud.sdk.service.prov.api.response.QueryResponse;
import java.util.List;

import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_POD;
import vdm.services.DefaultZSCPMAXICONGUAGLIOSRV01Service;

@WebServlet("/TestMaxiCo")
public class testmaxicoservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		// Creo stringa response
		String sResponse = "ciao Carmine";
		response.getWriter().append(sResponse);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			JsonObject newObject = new JsonObject();
			StringBuffer jb = new StringBuffer();
			String line = null;
			response.setContentType("application/json");
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
			newObject = new JsonParser().parse(jb.toString()).getAsJsonObject();

			JsonObject newObject2 = newObject.deepCopy();

			// direct in post
			JsonArray richiesteArray = newObject2.getAsJsonArray("richieste");

			for (int i = 0; i < richiesteArray.size(); i++) {
				JsonObject richiesta = new JsonObject();
				richiesta = (JsonObject) richiesteArray.get(i);
				// richiesta.get("POD").toString();
				try {
					String sPod = richiesta.get("POD").toString();

					final List<ZSCP_CHECK_VALUES_POD> checkPOD = new DefaultZSCPMAXICONGUAGLIOSRV01Service().getAllZSCP_CHECK_VALUES_POD()
					.filter(ZSCP_CHECK_VALUES_POD.POD.eq(sPod))
					.execute(new ErpConfigContext("INPBIDITR_sap_biditr_IT_H"));
							
							
					String sCheckPod = checkPOD.get(0).getStatus();
					String sResponse = "";

					if (sCheckPod == "S") {
						sResponse = "Il POD inserito esiste";
						response.setStatus(200);
						response.getWriter().append(sResponse);
					} else {
						sResponse = "Il POD inserito non esiste";
						response.setStatus(500);
						response.getWriter().append(sResponse);
					}
					

				} catch (ODataException e) {
					response.setStatus(501);
					response.getWriter().append("Error: CR" + e.getMessage().toString());
				}
			}

		} catch (Exception e) {
			response.setStatus(500);
			response.getWriter().append("Error: " + e.getMessage().toString());
		}
	}
}
