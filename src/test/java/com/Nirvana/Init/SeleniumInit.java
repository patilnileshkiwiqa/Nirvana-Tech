package com.Nirvana.Init;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Nirvana.ApplicationsList.ApplicationsListIndexPage;
import com.Nirvana.ApplicationsList.ApplicationsListVerification;
import com.Nirvana.Claims.ClaimsIndexPage;
import com.Nirvana.Claims.ClaimsVerification;
import com.Nirvana.CommonMethods.CommonMethodsIndexPage;
import com.Nirvana.CommonMethods.CommonMethodsVerification;
import com.Nirvana.Login.LoginIndexPage;
import com.Nirvana.Login.LoginVerification;
import com.Nirvana.Utility.TestData;
import com.microsoft.edge.seleniumtools.EdgeDriver;
import com.microsoft.edge.seleniumtools.EdgeOptions;

public class SeleniumInit{
	public String suiteName = "";
	public String testName = "";
	public static String PayertestURL="";
	public static String testUrl;
	public static String seleniumHub; // Selenium hub IP
	public static String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	public static String currentWindowHandle = "";// Get Current Window handle
	public static String browserName = "";
	public static String osName = "";
	public String HomeDir="";
	public static String browserVersion = "";
	public static String browseruse = "";
	public static String Url="";
	public static String AuthorName;
	public static String ModuleName;
	public static String Version="";
	/*public static String header="";*/
	public static int col=0;

	protected static String screenshot_folder_path = null;
	public static String currentTest; // current running test
	protected static Logger logger = Logger.getLogger("testing");
	protected static WebDriver driver;
	
	
	//Object Creation
    protected LoginIndexPage loginIndexPage;
    protected LoginVerification loginVerification;

    protected CommonMethodsVerification commonMethodsVerification;
    protected CommonMethodsIndexPage commonMethodsIndexPage;
    
    protected ApplicationsListIndexPage applicationsListIndexPage;
    protected ApplicationsListVerification applicationsListVerification;
    
    protected ClaimsIndexPage claimsIndexPage;
    protected ClaimsVerification claimsVerification;
   
	@SuppressWarnings("deprecation")
	@BeforeSuite(alwaysRun = true)
	public void fetchSuite(ITestContext testContext) throws IOException
	{
		
		 String execution=testContext.getCurrentXmlTest().getParameter("ExecutionByXML");
		 try
		 {
			 TestData.deletePastScreenshots(System.getProperty("user.dir") +"\\test-output\\screenshots");
		 }catch(Exception e)
		 {}
		 TestData.clearProperties("uploadConfig.properties");
		 TestData.setValueConfig("uploadConfig.properties","downloadZip", "");  
		
		if(execution.equalsIgnoreCase("true"))
		{
			testUrl=testContext.getCurrentXmlTest().getParameter("URL");
			targetBrowser =testContext.getCurrentXmlTest().getParameter("Browser");
		}else
		{
			testUrl=TestData.getValueFromConfig("config.properties","URL");
			targetBrowser =TestData.getValueFromConfig("config.properties","Browser");
		}
		
		browserName=targetBrowser;
		
		//URL remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";
		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		try{
		DesiredCapabilities capability = null;		
		if (targetBrowser == null || targetBrowser.contains("firefox") || targetBrowser.equalsIgnoreCase("firefox")) 
		{
			File driverpath = new File("Resource/geckodriver.exe");
			String path1 = driverpath.getAbsolutePath();
			System.setProperty("webdriver.gecko.driver",path1);
			
//			FirefoxProfile profile = new FirefoxProfile();
//			profile.setPreference("browser.download.dir",
//	                new File("DownloadData").getAbsolutePath());
//			profile.setPreference("browser.download.folderList", 2);
//			profile.setPreference("browser.helperApps.alwaysAsk.force",false);
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			profile.setPreference("browser.download.manager.showWhenStarting",false);
//			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//					"application/zip;application/octet-stream;application/x-zip;application/x-zip-compressed");
//			profile.setPreference("pdfjs.disabled",true);
			
			
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.helperApps.alwaysAsk.force", false);
			options.addPreference("browser.download.dir", new File("DownloadData").getAbsolutePath()); 
			options.addPreference("browser.download.defaultFolder",new File("DownloadData").getAbsolutePath()); 
			options.addPreference("browser.download.manager.showWhenStarting", false);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");

//			options.addPreference("browser.helperApps.neverAsk.saveToDisk",
//		"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
			
			capability = DesiredCapabilities.firefox();
						
			capability.setJavascriptEnabled(true);
			osName = System.getProperty("os.name");
			HomeDir=System.getProperty("user.home");
			capability.setCapability("marionette", true);
//			driver= new FirefoxDriver(capability);
			driver = new FirefoxDriver(options);
			
			//driver = new RemoteWebDriver(remote_grid, capability);
		}else if (targetBrowser.contains("Edge")||targetBrowser.equalsIgnoreCase("Edge"))
		{
			capability = DesiredCapabilities.internetExplorer();
//			WebDriverManager.edgedriver().setup();
			File driverpath = new File("Resource/msedgedriver.exe");
			String path1 = driverpath.getAbsolutePath();
			System.setProperty("webdriver.edge.driver",path1 );
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
			prefs.put("download.default_directory",
		                new File("DownloadData").getAbsolutePath());
			prefs.put("download.prompt_for_download", false);
			
			EdgeOptions options = new EdgeOptions();
			options.setExperimentalOption("prefs",prefs);
			
			capability.setBrowserName("Microsoft Edge");
			/*WebDriverManager manager = WebDriverManager.edgedriver();
			manager.config().setEdgeDriverVersion("84.0.522.49");
			manager.setup();*/

			//capability.setJavascriptEnabled(true);
			osName = capability.getPlatform().name();
//			driver= new EdgeDriver();
			driver= new EdgeDriver(options);

			//driver = new RemoteWebDriver(remote_grid, capability);
		}
		else if (targetBrowser.contains("ie11")||targetBrowser.equalsIgnoreCase("ie11"))
		{
			capability = DesiredCapabilities.internetExplorer();
			File driverpath = new File("Resource/IEDriverServer.exe");
			String path1 = driverpath.getAbsolutePath();
			System.setProperty("webdriver.ie.driver",path1 );
			capability.setBrowserName("internet explorer");
			capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capability.setCapability("nativeEvents", false);
			capability.setJavascriptEnabled(true);
			osName = capability.getPlatform().name();
			driver= new InternetExplorerDriver(capability);
			//driver = new RemoteWebDriver(remote_grid, capability);
		}else if (targetBrowser.contains("chrome") || targetBrowser.equalsIgnoreCase("chrome"))
		{
			capability = DesiredCapabilities.chrome();
			File driverpath = new File("Resource/chromedriver.exe");
			String path1 = driverpath.getAbsolutePath();
			System.setProperty("webdriver.chrome.driver",path1);
			final ChromeOptions chromeOptions = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			
			prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
			 prefs.put("download.default_directory",
		                new File("DownloadData").getAbsolutePath());
			chromeOptions.setExperimentalOption("prefs", prefs);
			capability.setBrowserName("chrome");
			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			//capability.setCapability("disable-popup-blocking", true);
			osName = capability.getPlatform().name();
			capability.setJavascriptEnabled(true);
			osName = capability.getPlatform().name();
			browserVersion = capability.getVersion();
			//driver = new RemoteWebDriver(remote_grid, capability);
			driver= new ChromeDriver(capability);
		}else if (targetBrowser.contains("safari"))
		{
			capability = DesiredCapabilities.safari();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("safari");
			driver = new SafariDriver(capability);
		}
		
		//suiteName = testContext.getSuite().getName();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(testUrl);
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) throws IOException 
	{
		/*seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");*/
		//testUrl=TestData.getValueFromConfig("config.properties","URL");
	}
	/**
	 * WebDriver initialization
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, ITestContext testContext,ITestResult testResult) throws IOException, InterruptedException 
	{
		
		driver.get(testUrl);
		
		suiteName = testContext.getSuite().getName();
		
		// Login
		loginIndexPage = new LoginIndexPage(driver);
		loginVerification = new LoginVerification(driver);
		
		commonMethodsVerification = new CommonMethodsVerification(driver);
	    commonMethodsIndexPage = new CommonMethodsIndexPage(driver);
	    
	    applicationsListIndexPage = new ApplicationsListIndexPage(driver);
	    applicationsListVerification = new ApplicationsListVerification(driver);
	    
	    claimsIndexPage = new ClaimsIndexPage(driver);
	    claimsVerification = new ClaimsVerification(driver);
		 
	}
	/**
	 * After Method
	 * 
	 * @param testResult
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult,ITestContext testContext)
	{
		String screenshotName="";
		testName = testResult.getName();
		
		try 
		{
			screenshotName = Common.getCurrentTimeStampString(); //+ testName;
			if (!testResult.isSuccess()) 
			{
				/* Print test result to Jenkins Console */
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);
				/* Make a screenshot for test that failed */
				if(testResult.getStatus()==ITestResult.FAILURE)
				{ 
					System.out.println("1 message from tear down");
					log("Please look to the screenshot :- "+ Common.makeScreenshot(driver, screenshotName));
		        }
			}
		}catch (Throwable throwable)
		{
		System.out.println(throwable);
		}
	}
	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	@AfterSuite(alwaysRun = true)
	public void postConfigue()
	{
		driver.manage().deleteAllCookies();
		driver.close();
	}
	public void log(String msg) 
	{
		Reporter.log(msg + "</br>");
		System.out.println(msg);
	}
	public void logStep(int msg1, String msg2) 
	{
		//Reporter.log("Step-"+msg1+" : "+msg2 + "</br>");
		Reporter.log(msg2 + "</br>");
		System.out.println("Step-"+msg1+" : "+msg2);// for jenkins  
	}
	public void logCase(String msg)
	{
		Reporter.log("Test Case : "+msg+"</br>");
		System.out.println("Test Case : "+msg);
	}
	public static void slog(String msg)
	{
		Reporter.log(msg + "</br>");
		System.out.println(msg);
	}
	
	public void logStatus(final int test_status,String msg) 
	{
		switch (test_status) 
		{
			case ITestStatus.PASSED:
				//test.log(Status.PASS,"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp "+msg+" ");
				log(msg+" <Strong><font color=#008000>Pass</font></strong>");
				break;
			case ITestStatus.FAILED:
				System.out.println("test_status>>>>>>>>"+test_status);
				String screenshotName = Common.getCurrentTimeStampString();
				log(msg+" <Strong><font color=#FF0000>Fail</font></strong> -> Please look to the screenshot :- "+ Common.makeScreenshot(driver, screenshotName));
				//MakeScreenshots();
				break;
			case ITestStatus.SKIPPED:
				log(msg);
				break;
			default:
				break;
		}
	}
	
	public void MakeScreenshots()
	{
		String screenshotName = Common.getCurrentTimeStampString() + testName;
		Common.makeScreenshot2(driver, screenshotName);
	}
}