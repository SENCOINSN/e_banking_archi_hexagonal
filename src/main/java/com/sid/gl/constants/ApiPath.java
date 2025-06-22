package com.sid.gl.constants;

public class ApiPath {
    public static final String API_VERSION = "/api/v1";

    public static final String URI_JPEG = API_VERSION + "/user/formatjpeg/";
    public static final String URI_PNG = API_VERSION + "/user/formatpng/";
    public static final String URI_PDF = API_VERSION + "/user/formatpdf";

    public static final String URI_BUCKET = API_VERSION + "/user/download/";
    public static final String URI_DOWNLOAD_CSV = API_VERSION + "/admin/generate-csv";

    private ApiPath() {}
}
