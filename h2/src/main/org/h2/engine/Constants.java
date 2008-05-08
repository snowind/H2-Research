/*
 * Copyright 2004-2008 H2 Group. Multiple-Licensed under the H2 License, 
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.engine;


/*
 * Release checklist
 * - Test with Hibernate
 * - Run FindBugs
 * - build jarClient, check jar file size
 * - build jar, test with IKVM
 * - Compile with JDK 1.4, 1.5 and 1.6:
 *   set path=C:\Programme\Java\jdk1.6.0\bin;%PATH%
 *   set JAVA_HOME=C:\Programme\Java\jdk1.6.0
 *   set path=C:\Program Files\Java\jdk1.6.0_05\bin;%PATH%
 *   set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_05
 *   build compile
 *   set classpath=
 *   build javadoc
 *   build javadocImpl (to find missing javadocs)
 *   build switchSourceJdk14
 *   build javadocImpl
 *
 * - Change version and build number in
 *     Constants.java
 *     build.html
 *     mainWeb.html
 *     download.html
 * - Maybe increase TCP_DRIVER_VERSION (old clients must be compatible!)
 * - Check code coverage
 * - No "  Message.get" (must be "throw Message.get")
 * - No TODO in the docs, remove @~ in .utf8.txt files
 * - Run regression test with JDK 1.4 and 1.5
 * - Use latest versions of other dbs (Derby 10.4.1.3; 
 *      PostgreSQL 8.3.1; MySQL 5.0.51)
 * - Change version(s) in performance.html
 * - Run 'ant benchmark' (with JDK 1.4 currently)
 * - Copy the benchmark results and update the performance page and diagram
 *
 * - Documentation: if there are new files, add them to MergeDocs
 * - Documentation: check if all Javadoc files are in the index
 * - Update the changelog (add new version)
 * - Update newsfeed and create files
 * - build docs
 * - PDF
 *      - footer
 *      - front page
 *      - orphan control
 *      - check images
 *      - table of contents
 * - Switch off auto-build
 * - build all
 * - Copy the pdf file to h2/docs
 * - Remove onePage.html
 * - Remove files in bin
 * - build zip
 * - Windows installer (nsis)
 * - Test Console
 * - Test all languages
 * - Test the windows service
 * - Scan for viruses
 * - build mavenDeployCentral
 * - Upload to SourceForge
 * - svn copy: /svn/trunk /svn/tags/version-1.0.x; Version 1.0.x (yyyy-mm-dd)
 * - Newsletter: prepare, send (always send to BCC!!)
 * - Add to freshmeat
 * - Upload to http://code.google.com/p/h2database/downloads/list
 * - http://en.wikipedia.org/wiki/H2_%28DBMS%29 (change version)
 * - http://www.heise.de/software/
 */
/**
 * Constants are fixed values that are used in the whole database code.
 */
public class Constants {

    /**
     * The build id is incremented for each public release.
     */
    public static final int BUILD_ID = 72;
    
    /**
     * The build date is updated for each public release.
     */
    private static final String BUILD_DATE = "2008-04-30";

    /**
     * The major version of this product.
     */
    public static final int VERSION_MAJOR = 1;
    
    /**
     * The minor version of this product.
     */
    public static final int VERSION_MINOR = 0;

    /**
     * If empty b-tree pages are allowed. This is supported for backward
     * compatibility.
     */
    public static final boolean ALLOW_EMPTY_BTREE_PAGES = true;
    
    /**
     * Constant meaning no literals are allowed in SQL statements.
     */
    public static final int ALLOW_LITERALS_NONE = 0;
    
    /**
     * Constant meaning only numbers are allowed in SQL statements (but no
     * texts).
     */
    public static final int ALLOW_LITERALS_NUMBERS = 1;
    
    /**
     * Constant meaning both numbers and text is allowed in SQL statements.
     */
    public static final int ALLOW_LITERALS_ALL = 2;
    
    /**
     * Automatically convert large LOB objects to files even if they have been
     * set using setBytes.
     */
    public static final boolean AUTO_CONVERT_LOB_TO_FILES = true;
    
    /**
     * The version of this product, consisting of major version, minor version, and build id.
     */
    public static final String VERSION = VERSION_MAJOR + "." + VERSION_MINOR + "." + BUILD_ID;

    /**
     * The 'word size' of a file (the minimum allocation size).
     */
    public static final int FILE_BLOCK_SIZE = 16;
    
    /**
     * The file header used for text files.
     */
    public static final String MAGIC_FILE_HEADER_TEXT = "-- H2 0.5/T --      ".substring(0, FILE_BLOCK_SIZE - 1) + "\n";
    
    /**
     * The file header used for binary files.
     */
    public static final String MAGIC_FILE_HEADER = "-- H2 0.5/B --      ".substring(0, FILE_BLOCK_SIZE - 1) + "\n";
    
    /**
     * The TCP protocol version number 5. This protocol is used by the TCP
     * server and remote JDBC client.
     */
    public static final int TCP_PROTOCOL_VERSION_5 = 5;
    
    /**
     * The TCP protocol version number 6. This protocol is used by the TCP
     * server and remote JDBC client.
     */
    public static final int TCP_PROTOCOL_VERSION_6 = 6;
    
    /**
     * The major version number of the supported JDBC API.
     */
    public static final int VERSION_JDBC_MAJOR = 3;

    /**
     * The minor version number of the supported JDBC API.
     */
    public static final int VERSION_JDBC_MINOR = 0;

    /**
     * Get the complete version number of this database, consisting of 
     * the major version, the minor version, the build id, and the build date.
     * 
     * @return the complete version
     */
    public static String getFullVersion() {
        return VERSION+ " (" + BUILD_DATE + ")";
    }

    public static final int DEFAULT_SERVER_PORT = 9092; // this is also in the docs
    public static final String START_URL = "jdbc:h2:";
    public static final String URL_FORMAT = START_URL + 
        "{ {.|mem:}[name] | [file:]fileName | {tcp|ssl}:[//]server[:port][,server2[:port]]/name }[;key=value...]";
    
    // must stay like that, see
    // http://opensource.atlassian.com/projects/hibernate/browse/HHH-2682
    public static final String PRODUCT_NAME = "H2"; 
    public static final String DRIVER_NAME = "H2 JDBC Driver";
    public static final int IO_BUFFER_SIZE = 4 * 1024;
    public static final int IO_BUFFER_SIZE_COMPRESS = 128 * 1024;
    public static final int DEFAULT_CACHE_SIZE_LINEAR_INDEX = 64 * 1024;
    public static final int FILE_PAGE_SIZE = 8 * 1024;
    public static final int FILE_MIN_SIZE = 128 * 1024;
    public static final int FILE_MAX_INCREMENT = 32 * 1024 * 1024;
    public static final String SUFFIX_DB_FILE = ".db";
    public static final String SUFFIX_DATA_FILE = ".data.db";
    public static final String SUFFIX_LOG_FILE = ".log.db";
    public static final String SUFFIX_INDEX_FILE = ".index.db";
    public static final String SUFFIX_HASH_FILE = ".hash.db";
    public static final String SUFFIX_LOCK_FILE = ".lock.db";
    public static final String SUFFIX_TEMP_FILE = ".temp.db";
    public static final String SUFFIX_TRACE_FILE = ".trace.db";
    public static final String SUFFIX_LOB_FILE = ".lob.db";
    public static final String SUFFIX_TRACE_START_FILE = ".start";
    public static final String SUFFIX_LOBS_DIRECTORY = ".lobs.db";
    public static final String UTF8 = "UTF8";
    public static final int DEFAULT_TABLE_TYPE = 0;
    public static final int DEFAULT_MAX_LENGTH_INPLACE_LOB = 1024;
    public static final int DEFAULT_MAX_LENGTH_CLIENTSIDE_LOB = 65536;
    public static final int SALT_LEN = 8;
    public static final int DEFAULT_DATA_PAGE_SIZE = 512;
    public static final String PREFIX_PRIMARY_KEY = "PRIMARY_KEY_";
    public static final String PREFIX_INDEX = "INDEX_";
    public static final int LOCK_SLEEP = 1000;

    // TODO for testing, the lock timeout is smaller than for interactive use cases
    // public static final int INITIAL_LOCK_TIMEOUT = 60 * 1000;
    public static final int INITIAL_LOCK_TIMEOUT = 1000;
    public static final char DEFAULT_ESCAPE_CHAR = '\\';
    public static final int DEFAULT_HTTP_PORT = 8082; // also in the docs
    public static final boolean DEFAULT_HTTP_SSL = false;
    public static final boolean DEFAULT_HTTP_ALLOW_OTHERS = false;
    public static final int DEFAULT_FTP_PORT = 8021;
    public static final int DEFAULT_MAX_MEMORY_ROWS = 10000;
    public static final int DEFAULT_WRITE_DELAY = 500;
    public static final String SERVER_PROPERTIES_TITLE = "H2 Server Properties";
    public static final String SERVER_PROPERTIES_FILE = ".h2.server.properties";
    public static final long LONG_QUERY_LIMIT_MS = 100;
    public static final String PUBLIC_ROLE_NAME = "PUBLIC";
    public static final String TEMP_TABLE_PREFIX = "TEMP_TABLE_";
    public static final int BIG_DECIMAL_SCALE_MAX = 100000;
    public static final String SCHEMA_MAIN = "PUBLIC";
    public static final String SCHEMA_INFORMATION = "INFORMATION_SCHEMA";
    public static final String DBA_NAME = "DBA";
    public static final String CHARACTER_SET_NAME = "Unicode";
    public static final String CLUSTERING_DISABLED = "''";
    public static final int LOCK_MODE_OFF = 0;
    public static final int LOCK_MODE_TABLE = 1;
    public static final int LOCK_MODE_TABLE_GC = 2;
    public static final int LOCK_MODE_READ_COMMITTED = 3;
    public static final int SELECTIVITY_DISTINCT_COUNT = 10000;
    public static final int SELECTIVITY_DEFAULT = 50;
    public static final int SELECTIVITY_ANALYZE_SAMPLE_ROWS = 10000;
    public static final boolean CONVERT_TO_LONG_ROUND = true;

    // the cost is calculated on rowcount + this offset, 
    // to avoid using the wrong or no index if the table 
    // contains no rows _currently_ (when preparing the statement)
    public static final int COST_ROW_OFFSET = 1000;
    public static final long FLUSH_INDEX_DELAY = 0;
    public static final int THROTTLE_DELAY = 50;
    public static final String MANAGEMENT_DB_PREFIX = "management_db_";
    public static final String MANAGEMENT_DB_USER = "sa";
    public static final boolean SERIALIZE_JAVA_OBJECTS = true;
    public static final long DEFAULT_MAX_LOG_SIZE = 32 * 1024 * 1024;
    public static final long LOG_SIZE_DIVIDER = 10;
    public static final int DEFAULT_ALLOW_LITERALS = ALLOW_LITERALS_ALL;
    public static final String CONN_URL_INTERNAL = "jdbc:default:connection";
    public static final String CONN_URL_COLUMNLIST = "jdbc:columnlist:connection";
    public static final int VIEW_INDEX_CACHE_SIZE = 64;
    public static final int VIEW_COST_CACHE_MAX_AGE = 10000; // 10 seconds
    public static final int MAX_PARAMETER_INDEX = 100000;

    /**
     * The password is hashed this many times
     * to slow down dictionary attacks.
     */
    public static final int ENCRYPTION_KEY_HASH_ITERATIONS = 1024;
    public static final String SCRIPT_SQL = "script.sql";
    public static final int CACHE_MIN_RECORDS = 16;

}
