package org.zywx.wbpalmstar.plugin.uexpdf.util;

public class EMMConsts {

    /** PLATFORM 4.0 add start */
    /**
     * v4环境
     */
    public final static int PLATFORM_V4 = 4;
    /**
     * appIn环境
     */
    public final static int PLATFORM_V3 = 3;
    public final static int UPGRADE_PROGRESS_STRAIGHT = 0;
    public final static int UPGRADE_PROGRESS_CIRCLE = 1;
    public final static int UPGRADE_PROGRESS_ROLL = 2;
    public final static int UPGRADE_PROGRESS_GRADUAL_CIRCLE = 3;

    public final static String HTTP_REQUEST_JSON_OBJ = "jsonObj";

    /**
     * 1.应用标识
     */
    public final static String APP_ID = "appId";
    /**
     * 2.租户标识
     */
    public final static String HTTP_REQUEST_TENANT_ACCOUNT = "tenantAccount";
    /**
     * 3.应用名称
     */
    public final static String WGT_STARTUP_APP_NAME = "appName";
    /**
     * 4.应用版本
     */
    public final static String WGT_STARTUP_VERSION = "version";
    /**
     * 5.渠道号
     */
    public final static String WGT_STARTUP_CHANNEL = "channel";
    /**
     * 6.硬件版本
     */
    public final static String WGT_STARTUP_MODEL = "model";
    /**
     * 7.设备的操作系统
     */
    public final static String WGT_STARTUP_OS_VERSION = "osVersion";
    /**
     * 8.设备imei号
     */
    public final static String WGT_STARTUP_IMEI = "imei";
    /**
     * 9.设备屏幕分辨率
     */
    public final static String WGT_STARTUP_SCREEN_SIZE = "screenSize";
    /**
     * 10.运营商
     */
    public final static String WGT_STARTUP_MOBILE_CARRIER = "mobileCarrier";
    /**
     * 11.联网方式
     */
    public final static String WGT_STARTUP_MOBILE_NETWORK = "mobileNetwork";
    /**
     * 12.启动时间
     */
    public final static String WGT_STARTUP_WGT_STARTUP_AT = "widgetStartupAt";
    /**
     * 13.MD5校验值 md5(appId:appKey)
     */
    public final static String WGT_STARTUP_MD5_CODE = "md5Code";
    /**
     * 14.在线时长 （秒数）
     */
    public final static String WGT_STARTUP_DURATION = "duration";
    /**
     * 15.mac地址
     */
    public final static String WGT_STARTUP_MAC = "mac";
    /**
     * 16.序列号
     */
    public final static String WGT_STARTUP_SID = "sid";
    /**
     * 17.新加手机唯一标识
     */
    public final static String WGT_STARTUP_DEV_TOKEN = "deviceToken";
    /**
     * 18.手机厂商
     */
    public final static String WGT_STARTUP_BRAND_NAME = "brandName";
    /**
     * 19.地区信息
     */
    public final static String WGT_STARTUP_MOBILE_LOCATION = "mobileLocation";
    /**
     * 20.softToken
     */
    public final static String JK_SOFT_TOKEN = "softToken";
    /**
     * 21.clientId
     */
    public final static String JK_CLIENT_ID = "clientId";
    /**
     * 22.eraseData
     */
    public final static String JK_ERASED_DATA = "eraseData";
    /**
     * 23.isCrossed
     */
    public final static String JK_IS_CROSSED = "isCrossed";
    /**
     * 24.appIdentifier
     */
    public final static String JK_APP_IDENTIFIER = "appIdentifier";

    public final static String SP_KEY_APP_PARAM = "appParam";
    public final static String SP_KEY_DISABLE_PLUGINS = "disablePlugins";
    public final static String SP_KEY_DISABLE_WINDOWS = "disableWindows";
    public final static String SP_KEY_REPORT_TIME = "reportTime";
    public final static String SP_KEY_REPORT_DATA = "reportData";
    public final static String SP_KEY_APP_TOTAL_TIME = "appTotalTime";
    // public final static String SP_KEY_ERROR_REPORT = "errorReport";
    public final static String SP_ENABLE_SCREEN_SHOT = "enableScreenshot";
    public final static String JK_RET = "ret";
    public final static String JK_ERROE_MSG = "msg";
    public final static String JK_OK_DATA = "data";
    public final static String JK_TENANT_ACCOUNT = "tenantAccount";
    public final static String JK_GET_OFF_LINE_DATA = "isGetOfflineData";

    public final static String SERVER_ERROR = "error";
    public final static String SERVER_SUCCESS = "success";
    public final static String APP_STATUS_CLOSE = "000";
    public final static String APP_STATUS_OPEN = "001";
    /**
     * emm 4.0 add end
     */

    public final static int WGT_TYPE_MAIN = 0;
    public final static int WGT_TYPE_SUB = 1;

    public final static String KEY_VERIFYAPP_V3 = "varifyApp";
    public final static String KEY_CHANNEL = "channel";
    public final static String KEY_VERIFYAPP = "appverify";
    public final static String KEY_X_MAS_APP_ID = "x-mas-app-id";
    public final static String STRING_KEY_APP_SIGN = "app_sign";
    public final static String HTTP_HEARD_ACCEPT = "Accept";
    public final static String HTTP_HEARD_ACCEPT_VALUE = "*/*";
    public final static String HTTP_HEARD_ACCEPT_LANGUAGE = "Accept-Language";
    public final static String HTTP_HEARD_ACCEPT_LANGUAGE_WEIGHT = "q=";
    public final static float HTTP_HEARD_ACCEPT_LANGUAGE_WEIGHT_VALUE = 1;
    public final static String HTTP_HEARD_USER_AGENT = "User-Agent";
    /**
     * 淘宝IP定位http请求User-Agent暂定为空格
     */
    public final static String HTTP_HEARD_IP_TAOBAO_USER_AGENT = " ";

    public final static String KEY_AT_ENCRYPT = "AppCan";
    public final static String CHARSET_UTF8 = "utf-8";

    public final static int TYPE_WIDGET_STARTUP = 0;
    public final static int TYPE_GET_LOGIN_PROPERTY = 1;
    public final static int TYPE_REGIST = 2;
    public final static int TYPE_LOGIN = 3;
    public final static int TYPE_SSO_LOGIN = 4;
    public final static int TYPE_BIND_USER_RELATION = 5;
    public final static int TYPE_VALIDATE_CODE = 6;
    public final static int TYPE_BOUND_OTHER_INFO = 7;
    public final static int TYPE_VALIDATE_BIND_CODE = 8;
    public final static int TYPE_LOGOUT = 9;
    public final static int TYPE_GET_VERIFICATION_IMAGE = 10;
    public final static int TYPE_CHANGE_PASSWORD = 11;
    public final static int TYPE_QUERY_CERT = 12;
    public final static int TYPE_RELEASE_USER_RELATION = 13;
    public final static int TYPE_GET_GRID_LIST = 14;
    public final static int TYPE_VALITION_JWT_TOKEN = 15;

    public final static int WHAT_cbStartReportSuccess = 0;
    public final static int WHAT_cbGetLoginProperty = 1;
    public final static int WHAT_cbRegist = 2;
    public final static int WHAT_cbLogin = 3;
    public final static int WHAT_cbSsoLogin = 4;
    public final static int WHAT_cbBindUserRelation = 5;
    public final static int WHAT_cbValidateCode = 6;
    public final static int WHAT_cbBoundOtherInfo = 7;
    public final static int WHAT_cbValidateBindCode = 8;
    public final static int WHAT_cbLogout = 9;
    public final static int WHAT_cbGetAppParams = 10;
    public final static int WHAT_cbGetAccessToken = 11;
    public final static int WHAT_cbGetDisablePlugins = 12;
    public final static int WHAT_cbGetDisableWindows = 13;
    public final static int WHAT_cbGetVerificationImage = 14;
    public final static int WHAT_cbFileEncrypt = 15;
    public final static int WHAT_cbFileDecrypt = 16;
    public final static int WHAT_cbGetWidgetInfo = 17;
    public final static int WHAT_cbGetSoftToken = 18;
    public final static int WHAT_cbChangePassword = 19;
    public final static int WHAT_onWidgetPatchUpdate = 20;
    public final static int WHAT_RequryCert = 21;
    public final static int WHAT_onStartReportCompleteAuto = 22;
    public final static int WHAT_onStartReportComplete = 23;
    public final static int WHAT_onAppFirstStart = 24;
    public final static int WHAT_cbReleaseUserRelation = 25;
    public final static int WHAT_cbInitEMM = 26;
    public final static int WHAT_cnGetTenantAccount = 27;
    public final static int WHAT_FINISH_MAIN_WIDGET = 28;
    public final static int WHAT_FINISH_SUB_WIDGET = 29;
    public final static int WHAT_ERROR_CALL_BACK = 30;
    public final static int WHAT_cbGetGridList = 31;
    public final static int WHAT_cbValitionJwtToken = 32;

    public final static String JK_STATUE = "status";
    public final static String JK_CB_MSG = "msg";
    public final static String WIDGET_UPDATE_FORCE = "forceUpdate";
    public final static String WIDGET_UPDATE_CONFIRM = "needConfirm";

    public final static String JK_ORIINFO = "oriInfo";
    public final static String JK_INFO = "info";
    public final static String JK_TYPE = "type";
    public final static String JK_ACCESSTOKEN = "accessToken";
    public final static String JK_IS_FIRST_LOGIN = "isFirstLogin";
    public final static String JK_MAIN_ACCESSTOKEN = "mainAccessToken";

    public final static int HTTP_REQUEST_TIME_OUT = 40 * 1000;
    public final static int GET_NET_STATUES_TIME_OUT = 60 * 1000;

    public final static String SP_FILE_NAME_APP = "app";
    public final static String SP_FILE_NAME_ACCESS_TOKEN = "accessToken";
    public final static String ACCESS_TOKEN_KEY_HEADER = "accessToken_";
    public final static String SP_FILE_NAME_CERT_INFOR = "cert_infor";
    public final static String SP_WIDGET_ONE_CONFIG = "widgetOneConfig";
    public final static String SP_KEY_APP_ID = "appid";
    public final static String SP_KEY_IS_EMM_SAVE_LEGAL_ST = "isEMMSaveLegalSoftToken";
    public final static String SP_FILE_NAME_DOMAINID = "domainId";
    public final static String DOMAINID_KEY_HEADER = "domainId_";

    public final static String KEY_SUB_WIDGET_IS_BIND_DEVICE = "subWidgetIsBindDevice";
    // 主应用标识
    public final static String KEY_BIND_DEVICE_APP_ID = "appId";
    // 子应用标识
    public final static String KEY_BIND_DEVICE_CHILD_APP_ID = "childAppId";
    // 主应用登陆时的AccessToken
    public final static String KEY_BIND_DEVICE_ACCESSTOKEN = "accessToken";
    // 主应用登陆时的域id
    public final static String KEY_BIND_DEVICE_DOMAIN_ID = "domainId";

    /**
     * 补丁包
     */
    public final static String SP_FILE_UPDATE_INFO_PATCH = "updateInfo";
    /**
     * 全量包
     */
    public final static String SP_FILE_UPDATE_INFO_FULL = "updateInfoFull";
    public final static String SP_KEY_UPDATE_INFO_URL = "url";
    public final static String SP_KEY_UPDATE_INFO_FILE_PATH = "filePath";
    public final static String SP_KEY_UPDATE_INFO_TOTAL_SIZE = "totalSize";
    public final static String SP_KEY_UPDATE_INFO_DOWNLOADED = "downloaded";
    public final static String SP_KEY_EMM_HOST = "emmHost";

    public final static String URL_APP_ID_PLACE = "{appId}";

    public final static int NETWORK_TYPE_UNKNOWN = 0;
    /**
     * Current network is GPRS
     */
    public final static int NETWORK_TYPE_GPRS = 1;
    /**
     * Current network is EDGE
     */
    public final static int NETWORK_TYPE_EDGE = 2;
    /**
     * Current network is UMTS
     */
    public final static int NETWORK_TYPE_UMTS = 3;
    /**
     * Current network is CDMA: Either IS95A or IS95B
     */
    public final static int NETWORK_TYPE_CDMA = 4;
    /**
     * Current network is EVDO revision 0
     */
    public final static int NETWORK_TYPE_EVDO_0 = 5;
    /**
     * Current network is EVDO revision A
     */
    public final static int NETWORK_TYPE_EVDO_A = 6;
    /**
     * Current network is 1xRTT
     */
    public final static int NETWORK_TYPE_1xRTT = 7;
    /**
     * Current network is HSDPA
     */
    public final static int NETWORK_TYPE_HSDPA = 8;
    /**
     * Current network is HSUPA
     */
    public final static int NETWORK_TYPE_HSUPA = 9;
    /**
     * Current network is HSPA
     */
    public final static int NETWORK_TYPE_HSPA = 10;
    /**
     * Current network is iDen
     */
    public final static int NETWORK_TYPE_IDEN = 11;
    /**
     * Current network is EVDO revision B
     */
    public final static int NETWORK_TYPE_EVDO_B = 12;
    /**
     * Current network is LTE
     */
    public final static int NETWORK_TYPE_LTE = 13;
    /**
     * Current network is eHRPD
     */
    public final static int NETWORK_TYPE_EHRPD = 14;
    /**
     * Current network is HSPA+
     */
    public final static int NETWORK_TYPE_HSPAP = 15;

    public final static String JK_DOMAINS = "domains";
    public final static String JK_DOMAIN_ID = "domainId";
    public final static String JK_DOMAIN_NAME = "domainName";
    public final static String JK_CANREG = "canReg";

    public final static String JK_LOGIN_NAME = "loginName";
    public final static String JK_CERTIFICATE = "isCertificate";
    public final static String JK_CERT_PATH = "certPath";
    public final static String JK_CERT_PWD = "certPwd";
    public final static String JK_CA_URL = "caurl";
    public final static String JK_IS_OFF_LINE_LOGIN = "isOfflineLogin";

    public final static String EXCEPTION_PARM_ERROR = "Wrong Cert Params";

    public final static String ERROR_MSG_OK = "ok";
    public final static String ERROR_MSG_ERROR = "fail";
    public final static String ERROR_MSG_PARM_ERROR = "参数错误";
    public final static String ERROR_MSG_LOGIN_ERROR = "登录失败";
    public final static String ERROR_MSG_NO_CERT = "证书不存在";
    public final static String ERROR_MSG_CERT_DOWN_ERROR = "CA证书下载失败";
    public final static String ERROR_MSG_NETWORK_ERROR = "无法连接至服务器，请检查网络";
    public final static String ERROR_MSG_NETWORKDATA_ERROR = "请检查您的网络状态";

    public final static String TIME_FORMAT_STR = "yyyyMMddhhmmss";

    public final static String BROADCAST_ACTION_WIDGETUPDATE_EVENT_ACK = "org.zywx.emm" + "" +
            ".widgetupdate.event.ack.action";
    public final static String BROADCAST_TYPE_UPDATE_EVENT_CANCELLED = "updateCancelled";
    public final static String BROADCAST_TYPE_UPDATE_EVENT_DO_WITH_CONFIRM = "doUpdateWithConfirm";
    public final static String BROADCAST_INTENT_KEY_TYPE = "type";

    public final static String BROADCAST_ACTION_WIDGETUPDATE_EVENT = "org.zywx.emm.widgetupdate"
            + ".event.action";
    public final static String BROADCAST_INTENT_UPDATE_INFOR = "updateInfo";
    public final static String BROADCAST_INTENT_UPDATE_APPID = "updateAppId";
    /**
     * 是否检测应用开关
     */
    public final static String BROADCAST_INTENT_UPDATE_IS_CHECK_APP_STATUS = "isCheckAppStatus";

    /**
     * split emm and dataAnalysis source from dataAnalytics start
     */
    // public final static String M_APP = "app";
    public final static String SP_SAVEDATA = "saveData";
    public final static String SP_KEY_ADDRESS_ANALYTICS = "addressAnalytics";
    public final static String SP_KEY_REPORT_RESULT = "reportResult";
    /**
     * 离线登录，回调给网页认证字段等信息
     */
    public final static String SP_KEY_LOGIN_PROPERTY_RESULT = "loginPropertyResult";
    /**
     * 离线登录时，与前端传来的数据做比较
     */
    public final static String SP_KEY_LOGIN_INFOR = "loginInfo";
    /**
     * 离线登录成功后，回调给网页结果
     */
    public final static String SP_KEY_LOGIN_RESULT = "loginResult";

    // 有关手机的基本数据
    public final static int APP_BASE_MSG_FLAG = 4;
    public final static int INTERVAL_TIME = 5 * 1000;
    /**
     * 最多重试次数
     */
    public final static int RETRY_TIMES = 3;
    /**
     * split emm and dataAnalysis source from dataAnalytics end
     */

    public final static int EMM_DIALOG_INIT_PROGRESS_DIALOG = 0;
    /**
     * 在原dataAnalytics为4
     */
    public final static int EMM_DIALOG_DISMISS_PROGRESS_DIALOG = 1;

    public final static String HTTPS_SCHEME = "https://";
    public final static String HTTP_SCHEME = "http://";
    public final static String METHOD_POST = "POST";
    public final static String METHOD_GET = "GET";
    public final static String HTTP_CONTENT_TYPE = "Content-Type";
    public final static String HTTP_CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public final static String HTTP_CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";

    public final static int DOWN_LOAD_100PERCENT = 100;
    public final static int DOWN_LOAD_DONE = -1;
    public final static int DOWN_LOAD_ERROR_NO_SD_CARD = -2;
    public final static int DOWN_LOAD_STOP = -3;
    public final static int DOWN_LOAD_ERROR = -4;
    public final static String EMM_CONFIG = "EMMConfig";
    public final static String SHOW_UPGRADE_AUTO_REPORT = "ShowUpgradeAuto";
    public final static String SHOW_UPGRADE_MANUAL_REPORT = "ShowUpgradeManual";
    public final static String IS_AUTO_START_REPOT = "AutoStartReport";
    public final static String BAIDU_LOCATION_AK = "BaiduLocationAK";
    public final static String REAL_TIME_PATCH_UPDATE = "RealTimePatchUpdate";
    public final static String IS_EXIT_APP = "IsExitApp";

    public final static int WIDGET_REPORT_RETRY_TIMES = 3;

    /** EMM4.0接口返回的ret */
    /**
     * 成功
     */
    public final static int EMM_ERROR_CODE_OK = 0;
    /**
     * 失败
     */
    public final static int EMM_ERROR_CODE_FAIL = -1;
    /**
     * 启动上报与租户信息相关的错误
     */
    public final static int EMM_ERROR_CODE_TENANT_ACCOUNT_FAIL = -2;
    /**
     * 启动上报：当前应用不存在、应用Id非法、系统不存在当前版本、XX.XX.XXXX已关闭、该应用暂停服务
     */
    public final static int EMM_ERROR_CODE_EXIT_APP_ERROR = -3;

    public final static String DISABLE_PLUGINS_LIST = "disablePluginsList";
    public final static String DISABLE_ROOT_WIN_LIST = "disableRootWindowsList";
    public final static String DISABLE_SON_WIN__LIST = "disableSonWindows";

    public final static String APP_KEY = "appKey";
    public final static String WGT_CHANNEL_CODE = "channelCode";

    public final static String TRUE_STR = "true";
    public final static String FALSE_STR = "false";

    public final static int ERASE_APP_DATA_TIME_OUT = 3 * 1000;
    public final static String SP_ERASED_DATA_FLG = "erased_data_flg";
    /**
     * 引擎是否往沙箱copy完widget包
     */
    public final static String SP_COPY_ASSETS_FINISH = "copyAssetsFinish";
    /**
     * 灰度发布应用是否安装 key:version;value:StrategyId
     */
    public final static String SP_FILE_IS_INSTALL_GRAY_RELEASE_APP = "isInstallGrayReleaseApp";
    /**
     * 灰度发布策略id key:StrategyId;value:version
     */
    public final static String SP_FILE_UPGRADE_STRATEGY_ID = "upgradeStrategyId";

    public final static int START_REPORT_RETRY = 0;
    public final static int START_REPORT_SUCCESS = 1;
    public final static int START_REPORT_THREAD_BREAK = 2;
    public final static String JK_WIDGET_DISABLE_WNDS = "widgetWnds";
    public static final String DEF_MAIN_APP_ID = "undefined";

    /**
     * app更新
     */
    public static final int UPDATE_UI_TYPE_START_DOWNLOAD = 0;
    public static final int UPDATE_UI_TYPE_DOWNLOAD_COMPLETED = 1;
    public static final int UPDATE_UI_TYPE_DOWNLOAD_ERROR = 2;
    public final static int NEW_APP_RIGHT_BTN_ID = 0;
    public final static int NEW_APP_LEFT_BTN_ID = 1;

    public final static String PKGTYPE_PATCH = "patch";
    public final static String PKGTYPE_UPGRADE = "upgrade";

    public final static String EMM_START_UP_STRATEGY_ID = "strategyId";
    public final static String EMM_START_UP_NEW_VERRSION = "version";
    public final static String EMM_START_UP_SCREEN_SHOT = "enableScreenshot";

    public static final int GET_SOFT_TOKEN_ERROR = 0;
    public static final int GET_SOFT_TOKEN_OK = 1;

    /**
     * emm error callback type
     */
    public static final int EMM_ERROR_CALLBACK_GET_SOFT_TOKEN = 0;
    public static final int EMM_ERROR_CALLBACK_WITHOUT_METHOD = 1;
    public static final String WITHOUT_METHOD_INFO = "emm3.0 plugin, without method";

    public final static String URL_STRATEGY_ID_REPLESE = "{strategyId}";

    /**
     * 半小时 单位：ms
     */
    public final static long APP_AT_BACKGROUND_TIME_MAX = 60 * 30 * 1000;
    public final static String DEFAULT_TENANT_ACCOUNT = "default_null";

    /**
     * MAMFail type
     **/
    public static final int ERROR_TYPE_DEV_NETWORK_ANMOALY = 0;
    public static final int ERROR_TYPE_CONNECT_SERVER_ANMOALY = 1;

    /**
     * 原AnalyticsConstants start
     **/
    // 页面跳转
    public static final int viewTransformFlag = 0;
    // 页面停留
    public static final int viewDurationFlag = 1;
    // 自定义点击事件
    public static final int eventClickFlag = 2;
    // 自定义停留事件
    public static final int eventDurationFlag = 3;
    // 有关手机的基本数据
    public static final int appBaseMsgFlag = 4;
    // 错误信息上报
    public static final int errorReportFlag = 5;
    // 实时上报
    public static final int REPORT_STRATEGY_REALTIME = 1;
    // 启动上报
    public static final int REPORT_STRATEGY_START = 0;
    // wifi上报
    public static final int REPORT_STRATEGY_WIFI = 3;
    // 每日上报
    public static final int REPORT_STRATEGY_DAILY = 2;
    public static final int REPORT_STRATEGY_NEW = -1;
    public static final int REPORT_STRATEGY_DEFAULT = -2;
    // 第一次的opener
    public static final String FIRST_OPENER = "application";

    /**
     * 原AnalyticsConstants end
     **/

    public static final String TENANT_FILTER = "0";

    public static final String JK_LOGIN_PASS = "loginPass";
    public static final String JK_LOGIN_PASS_NEW = "loginPass1";
    public static final String JK_LOGIN_PASS_NEW_CONFIRM = "loginPass2";
    public static final String JK_AUTH_TYPE = "authType";

    public static final String WIDGET_CONFIG_FILE_NAME = "config.xml";
    public static final String WIDGET_CONFIG_PARENT_FILE_NAME = "widget";
    public static final String DYNAMIC_PLUGIN_ASSEST_PATH_NAME = "plugin";
    public static final String DYNAMIC_PLUGIN_SANDBOX_PATH_NAME = "apkfile";
    public final static int INSTALL_PATCH_WIDGET = 1;
    public final static int INSTALL_PATCH_PLUGIN = 2;
    public final static int INSTALL_PATCH_ALL = 3;
    public static final String JK_EMM_HOST = "EMMHost";
    public static final String JK_ERROR_CODE = "errorCode";
    public static final String JK_ERROR_INFO = "errorInfo";
    public static final String INVALID_MAC = "020000000000";

    public static final String SET_COOKIE = "Set-Cookie";
    public static final String SET_COOKIE2 = "Set-Cookie2";
    public static final String COOKIE = "Cookie";
    public static final String COOKIE2 = "Cookie2";
    public static final String CONNECTOR_EQUAL = "=";
    public static final String CONNECTOR_AND = "&";
    public static final String ANDROID_INSTALL_PACKAGE_EXTENSION = "apk";
    public static final String PATCH_PACKAGE_EXTENSION = "zip";
    public static final String PLATFORM_V3_FLG = "appIn";
    public static final String GRID_ID = "token";
    public static final String SP_FILE_GRID_LIST = "gridlist";
    public static final String SP_KEY_GRID_IP = "currentGridIP";
    public static final int HEADQUARTERS_SERVICE = 0;
    public static final int GRID_SERVICE = 1;
    public static final String JWT_TOKEN = "jwtToken";
    public static final String USER_ID = "userId";
    public static final String JWT_KEY = "jwtKey";
    public static final String SERVICE_TYPE = "serviceType";
    public static final String APP_SERVICE_INFO = "appServiceInfo";

}
