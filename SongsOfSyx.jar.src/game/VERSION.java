/*    */ package game;
/*    */ 
/*    */ public final class VERSION
/*    */ {
/*    */   public static final int VERSION_MAJOR = 71;
/*    */   public static final int VERSION_MINOR = 38;
/*  7 */   public static final int VERSION = version(71, 38);
/*  8 */   public static final String VERSION_STRING = versionString(VERSION);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean versionIsBefore(int major, int minor) {
/* 19 */     return (GAME.version() < version(major, minor));
/*    */   }
/*    */   
/*    */   public static boolean versionIs(int major, int minor) {
/* 23 */     return (GAME.version() == version(major, minor));
/*    */   }
/*    */   
/*    */   public static int version(int major, int minor) {
/* 27 */     return major << 16 | minor;
/*    */   }
/*    */   
/*    */   public static String versionString(int version) {
/* 31 */     int m = versionMajor(version);
/* 32 */     int n = versionMinor(version);
/*    */     
/* 34 */     return "0." + m + "." + n;
/*    */   }
/*    */   
/*    */   public static int versionMajor(int version) {
/* 38 */     return version >> 16 & 0xFFFF;
/*    */   }
/*    */   
/*    */   public static int versionMinor(int version) {
/* 42 */     return version & 0xFFFF;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\VERSION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */