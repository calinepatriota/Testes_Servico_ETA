package data;

public class DataRequest {
    public static final  String body = "{\"query\":\"\\r\\nquery{\\r\\n  continents(filter:{\\r\\n    code:\\r\\n    {\\r\\n      in:[\\\"AF\\\"]\\r\\n    }\\r\\n    })\\r\\n\\t{\\r\\n    code\\r\\n    }\\r\\n  }\\r\\n\",\"variables\":{}}";
    public static final  String bodyError = "{\"query\":\"\\r\\nquery{\\r\\n  (filter:{\\r\\n    code:\\r\\n    {\\r\\n      in:[\\\"AF\\\"]\\r\\n    }\\r\\n    })\\r\\n\\t{\\r\\n    code\\r\\n    }\\r\\n  }\\r\\n\",\"variables\":{}}";
    public static final  String continent = "AF";
}
