/*    */ package META-INF.versions.11.org.lwjgl;
/*    */ 
/*    */ import java.lang.module.ModuleDescriptor;
/*    */ import org.lwjgl.Version;
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
/* 17 */     Package org_lwjgl = Version.class.getPackage();
/*    */     
/* 19 */     String specVersion = org_lwjgl.getSpecificationVersion();
/* 20 */     String implVersion = org_lwjgl.getImplementationVersion();
/* 21 */     if (specVersion != null && implVersion != null) {
/* 22 */       return Version.createImplementation(specVersion, implVersion);
/*    */     }
/*    */     
/* 25 */     Module module = Version.class.getModule();
/* 26 */     if ("org.lwjgl".equals(module.getName())) {
/*    */ 
/*    */ 
/*    */       
/* 30 */       String moduleVersion = module.getDescriptor().version().<String>map(ModuleDescriptor.Version::toString).orElse(null);
/*    */       
/* 32 */       if (moduleVersion != null) {
/* 33 */         int plusIndex = moduleVersion.indexOf('+');
/* 34 */         if (plusIndex != -1) {
/* 35 */           return Version.createImplementation(moduleVersion
/* 36 */               .substring(0, plusIndex), moduleVersion
/* 37 */               .substring(plusIndex + 1));
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 43 */     String version = Version.findImplementationFromManifest();
/* 44 */     if (version != null) {
/* 45 */       return version;
/*    */     }
/*    */     
/* 48 */     return "-snapshot";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\11\org\lwjgl\VersionImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */