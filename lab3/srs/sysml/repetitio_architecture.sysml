
package RepetitioArchitecture {
  part def RepetitioSystem {
    part webClient : WebClient;
    
    part applicationServer : ApplicationServer;
    
    part database : Database;
    
    flow from RepetitioSystem to WebClient;
  }
  
  part def WebClient {
    part userInterface;
    
    part navigation;
    
    part apiClient;
    
    flow from WebClient to ApplicationServer;
  }
  
  part def ApplicationServer {
    part authenticationModule;
    
    part examManagementModule;
    
    part topicManagementModule;
    
    part repetitionModule;
    
    part resultManagementModule;
    
    part analyticsModule;
    
    flow from ApplicationServer to Database;
  }
  
  part def Database {
    part usersStorage;
    
    part examsStorage;
    
    part topicsStorage;
    
    part repetitionsStorage;
    
    part resultsStorage;
  }
}

// Element overrides
// @pos "RepetitioArchitecture::RepetitioSystem" 100,170
// @pos "RepetitioArchitecture::WebClient" 320,170
// @pos "RepetitioArchitecture::ApplicationServer" 520,170
// @pos "RepetitioArchitecture::Database" 720,170
// @size "RepetitioArchitecture" 912,210