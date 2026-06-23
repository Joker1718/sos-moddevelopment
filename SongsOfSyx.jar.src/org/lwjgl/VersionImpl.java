/*    */ package org.lwjgl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class VersionImpl
/*    */ {
/*    */   static String find() {
/* 16 */     Package org_lwjgl = Version.class.getPackage();
/*    */     
/* 18 */     String specVersion = org_lwjgl.getSpecificationVersion();
/* 19 */     String implVersion = org_lwjgl.getImplementationVersion();
/* 20 */     if (specVersion != null && implVersion != null) {
/* 21 */       return Version.createImplementation(specVersion, implVersion);
/*    */     }
/*    */     
/* 24 */     String version = Version.findImplementationFromManifest();
/* 25 */     if (version != null) {
/* 26 */       return version;
/*    */     }
/*    */     
/* 29 */     return "-snapshot";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\VersionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */