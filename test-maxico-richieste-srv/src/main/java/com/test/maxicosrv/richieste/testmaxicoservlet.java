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

import com.sap.cloud.sdk.odatav2.connectivity.ODataQueryBuilder;
import com.sap.cloud.sdk.odatav2.connectivity.FilterExpression;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpClientAccessor;

import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_POD;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES_TRADER;
import vdm.namespaces.zscpmaxiconguagliosrv01.ZSCP_CHECK_VALUES;

import vdm.services.DefaultZSCPMAXICONGUAGLIOSRV01Service;

@WebServlet("/TestMaxiCo")
public class testmaxicoservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		// Creo stringa response
		String sResponse = "ciao Carmine 1";
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

			JsonArray richiesteArray = newObject2.getAsJsonArray("richieste");
			Integer contatoreKORichieste = 0;
			String sCheckPOD = "";
			String sCheckDISPACCIAMENTO = "";
			String sCheckCOPPIA = "";

			for (int i = 0; i < richiesteArray.size(); i++) {
				JsonObject richiesta = new JsonObject();
				richiesta = (JsonObject) richiesteArray.get(i);

				String sPod = richiesta.get("POD").toString().replace("\"", "");
				String sDispacciamento = richiesta.get("DISPACCIAMENTO").toString().replace("\"", "");

				// Controllo il campo check POD, se è già in Errore non faremo il check su MELT
				// per l'esistenza
				try {
					sCheckPOD = richiesta.get("CHECKPOD").toString().replace("\"", "");
					richiesta.addProperty("CHECKPOD", sCheckPOD);

					if (sCheckPOD.substring(0, 1).equals("S")) {

						final List<ZSCP_CHECK_VALUES_POD> checkPOD = new DefaultZSCPMAXICONGUAGLIOSRV01Service()
								.getAllZSCP_CHECK_VALUES_POD().filter(ZSCP_CHECK_VALUES_POD.POD.eq(sPod))
								.execute(new ErpConfigContext("INPBIDITR_sap_biditr_IT_H"));

						// Aggiorno il campo con lo stato ricevuto da MELT
						sCheckPOD = checkPOD.get(0).getStatus().toString();
						richiesta.addProperty("CHECKPOD", sCheckPOD);

					}
				} catch (ODataException e) {
					response.setStatus(501);
					response.getWriter().append("Error ODATA: " + e.getMessage().toString());
				}

				// Controllo il campo check DISPACCIAMENTO, se è già in Errore non faremo il
				// check su MELT per l'esistenza
				try {
					sCheckDISPACCIAMENTO = richiesta.get("CHECKDISPACCIAMENTO").toString().replace("\"", "");
					richiesta.addProperty("CHECKDISPACCIAMENTO", sCheckDISPACCIAMENTO);

					if (sCheckDISPACCIAMENTO.substring(0, 1).equals("S")) {

						final List<ZSCP_CHECK_VALUES_TRADER> checkDispacciamento = new DefaultZSCPMAXICONGUAGLIOSRV01Service()
								.getAllZSCP_CHECK_VALUES_TRADER()
								.filter(ZSCP_CHECK_VALUES_TRADER.TRADER.eq(sDispacciamento))
								.execute(new ErpConfigContext("INPBIDITR_sap_biditr_IT_H"));

						// Aggiorno il campo con lo stato ricevuto da MELT
						sCheckDISPACCIAMENTO = checkDispacciamento.get(0).getStatus().toString();
						richiesta.addProperty("CHECKDISPACCIAMENTO", sCheckDISPACCIAMENTO);

					}
				} catch (ODataException e) {
					response.setStatus(501);
					response.getWriter().append("Error ODATA: " + e.getMessage().toString());
				}

				sCheckPOD = richiesta.get("CHECKPOD").toString().replace("\"", "");
				sCheckDISPACCIAMENTO = richiesta.get("CHECKDISPACCIAMENTO").toString().replace("\"", "");

				// Se il POD o il DISPACCIAMENTO presentano errori, non procedo con il check di
				// coerenza sulla coppia
				if (!sCheckPOD.equals("S") || !sCheckDISPACCIAMENTO.equals("S")) {
					contatoreKORichieste = contatoreKORichieste + 1;
					richiesta.addProperty("CHECKCOPPIA", "E");
				} else {
					// Check di Coerenza POD-DISPACCIAMENTO
					// sPod;
					// sDispacciamento
					try {
						final List<ZSCP_CHECK_VALUES> checkCoppia = new DefaultZSCPMAXICONGUAGLIOSRV01Service()
								.getAllZSCP_CHECK_VALUES()
								.filter(ZSCP_CHECK_VALUES.POD.eq(sPod))
								.filter(ZSCP_CHECK_VALUES.TRADER.eq(sDispacciamento))
								.execute(new ErpConfigContext("INPBIDITR_sap_biditr_IT_H"));

						// Aggiorno il campo con lo stato ricevuto da MELT
						sCheckCOPPIA = checkCoppia.get(0).getStatus().toString();
						richiesta.addProperty("CHECKCOPPIA", sCheckCOPPIA);
						
						if (!sCheckCOPPIA.equals("S")){
							contatoreKORichieste = contatoreKORichieste + 1;
						}

					} catch (ODataException e) {
						response.setStatus(501);
						response.getWriter().append("Error ODATA: " + e.getMessage().toString());
					}
				}
			}
			
			System.out.println(richiesteArray);
			System.out.println("Numero Errori: " + contatoreKORichieste.toString());
			response.setStatus(200);
			response.getWriter().append("Numero Errori: " + contatoreKORichieste.toString());
		} catch (Exception e) {
			response.setStatus(500);

			response.getWriter().append("Error CR: " + e.getMessage().toString());
		}
	}
}
